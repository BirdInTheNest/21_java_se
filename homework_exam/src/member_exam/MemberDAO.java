package member_exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//DB와 연동하는 애, jar 파일 연결해야 함
public class MemberDAO { 
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	
//	MemberDAO 클래스를 여러개 만들어도 MemberDAO.class로 저장되는 애들은 한번에 하나씩 수행되도록 synchronized
//	static이기 때문에 null인 경우는 1번밖에 없다. MemberDAO인 DB는 하나만 생성해서 공유해야 한다.
//	따라서 System.out.println("instance = "+instance); 주소값 찍으면 하나로 동일하게 나옴
	
	private static MemberDAO instance;
	
	public static MemberDAO getInstance(){
		synchronized (MemberDAO.class) { 
			if(instance==null) 
				instance = new MemberDAO(); 
		}
		
		return instance; //리턴값이 MemberDAO이기 때문에 MemberDAO getInstance()로 수정
	}
	
	public MemberDAO() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isExistId(String id) {
		boolean exist = false; //초기값
		String sql = "select * from memberexam where id=?";
		getConnection(); //접속
		
		try {
			pstmt = conn.prepareStatement(sql); //생성
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); //실행
			//id는 unique로 중복이 안되니까 select 값이 있으면 rs 한줄, 없으면 안 뜸
			
			if(rs.next()) exist = true;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();				
			}
		}
		
		return exist;
	}
	
	public void writeMember(MemberDTO dto) { //dto에 저장된 데이터 가져와서 DB 접속
		String sql = "insert into memberexam values(?, ?, ?, ?)";
		getConnection(); //접속
		
		try {
			pstmt = conn.prepareStatement(sql); //생성
			pstmt.setString(1, dto.getName()); //?에 맵핑
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getPwd());
			pstmt.setString(4, dto.getEmail());
			
			pstmt.executeUpdate(); //실행
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();				
			}
		}
	}//writeMember(MemberDTO dto)

	public String loginMember(String id, String pwd) { //로그인할 아이디, 비밀번호 가져와서 DB 접속
		String name = null; //초기값
		String sql = "select * from memberexam where id=? and pwd=?";
		getConnection(); //접속
		
		try {
			pstmt = conn.prepareStatement(sql); //생성
			pstmt.setString(1, id); //?에 맵핑
			pstmt.setString(2, pwd);
			
			rs = pstmt.executeQuery(); //실행, select값 rs에 저장
			
			if(rs.next()) { //rs 값이 있으면
				name = rs.getString("name");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();				
			}
		}		
		
		return name;
	}

	public List<MemberDTO> listMember() {
		List<MemberDTO> list = new ArrayList<MemberDTO>();
		String sql = "select * from memberexam order by name asc"; //이름으로 오름차순
		getConnection(); //접속
		
		try {
			pstmt = conn.prepareStatement(sql); //생성
			rs = pstmt.executeQuery(); //실행, select 값 rs에 저장
			
			while(rs.next()) { //rs값이 여러개니까 while문 사용
				MemberDTO dto = new MemberDTO(); //rs값이 도는 만큼 dto 생성
				dto.setName(rs.getString("name")); //rs 값 dto에 저장
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setEmail(rs.getString("email"));
				
				list.add(dto); //dto 값 list에 저장
			}//while
			
		}catch(SQLException e) {
			e.printStackTrace();
			list = null; 
			//SQLException 에러 발생시 리턴되는 list값 없게, Service에서 for문 돌 수 없게
			
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();				
			}
		}
		
		return list;	
	}
}


















