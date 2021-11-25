package nested;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO { //Data Access Object - DB�� ����
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
	
	public int insertMember(MemberDTO dto) { //dto�� �޼��� �μ��� �޾� �����͸� ��������
		String sql = "insert into member(name,id,pwd) values(?,?,?)";
		this.getConnection(); //����
		int su=0;
		
		try {
			pstmt = conn.prepareStatement(sql); //����
			pstmt.setString(1, dto.getName()); //?�� ����
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getPwd());
			
			su = pstmt.executeUpdate(); //�����ϸ� ������ ���ϵǹǷ�, �� ���� ì���
			
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
		
		return su; //���ϰ��� int�ϱ� public void���� public int�� ����	
	}
	
	public String loginMember(String id, String pwd) { //boolean������ �����ص� ��
		String name = null;
		String sql = "select * from member where id=? and pwd=?"; 
		//���̵� ��й�ȣ �Ѵ� �¾ƾ��ϱ� ������ and ���, �� �� ������ ����, �ϳ��� �� ������ �� ��
		getConnection(); //����
		
		try {
			pstmt = conn.prepareStatement(sql); //����
			pstmt.setString(1,id); //?�� ����
			pstmt.setString(2, pwd);
			
			rs = pstmt.executeQuery(); //����, select���� rs�� �޴´�
			
			if(rs.next()) //���ڵ尡 ������ T ������ F 
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