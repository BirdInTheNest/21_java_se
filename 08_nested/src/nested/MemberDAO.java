package nested;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO { //Data Access Object - DB와 연동
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs; //for select
	   
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	
	public MemberDAO() { //Driver Loading
		try {
	         Class.forName(driver);
	    } catch (ClassNotFoundException e) {
	         e.printStackTrace();
	    }
	}
	
	public void getConnection() { //Connection
		try {   
			conn = DriverManager.getConnection(url, username, password);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int insertMember(MemberDTO dto) { //dto를 메서드 인수로 받아 데이터를 가져오자
		String sql = "insert into member(name,id,pwd) values(?,?,?)";
		this.getConnection(); //접속
		int su=0;
		
		try {
			pstmt = conn.prepareStatement(sql); //생성
			pstmt.setString(1, dto.getName()); //?에 맵핑
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getPwd());
			
			su = pstmt.executeUpdate(); //실행하면 개수가 리턴되므로, 그 값을 챙긴다
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
	            if(conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
		
		return su; //리턴값이 int니까 public void에서 public int로 변경	
	}
	
	public String loginMember(String id, String pwd) { //boolean값으로 변경해도 됨
		String name = null;
		String sql = "select * from member where id=? and pwd=?"; 
		//아이디 비밀번호 둘다 맞아야하기 때문에 and 사용, 둘 다 맞으면 한줄, 하나라도 안 맞으면 안 뜸
		getConnection(); //접속
		
		try {
			pstmt = conn.prepareStatement(sql); //생성
			pstmt.setString(1,id); //?에 맵핑
			pstmt.setString(2, pwd);
			
			rs = pstmt.executeQuery(); //실행, select값은 rs로 받는다
			
			if(rs.next()) //레코드가 있으면 T 없으면 F 
				name = rs.getString("name");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
	            if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
	            if(conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}

		return name;
	}
}