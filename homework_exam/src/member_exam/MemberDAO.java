package member_exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//DB�� �����ϴ� ��, jar ���� �����ؾ� ��
public class MemberDAO { 
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	
//	MemberDAO Ŭ������ ������ ���� MemberDAO.class�� ����Ǵ� �ֵ��� �ѹ��� �ϳ��� ����ǵ��� synchronized
//	static�̱� ������ null�� ���� 1���ۿ� ����. MemberDAO�� DB�� �ϳ��� �����ؼ� �����ؾ� �Ѵ�.
//	���� System.out.println("instance = "+instance); �ּҰ� ������ �ϳ��� �����ϰ� ����
	
	private static MemberDAO instance;
	
	public static MemberDAO getInstance(){
		synchronized (MemberDAO.class) { 
			if(instance==null) 
				instance = new MemberDAO(); 
		}
		
		return instance; //���ϰ��� MemberDAO�̱� ������ MemberDAO getInstance()�� ����
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
		boolean exist = false; //�ʱⰪ
		String sql = "select * from memberexam where id=?";
		getConnection(); //����
		
		try {
			pstmt = conn.prepareStatement(sql); //����
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); //����
			//id�� unique�� �ߺ��� �ȵǴϱ� select ���� ������ rs ����, ������ �� ��
			
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
	
	public void writeMember(MemberDTO dto) { //dto�� ����� ������ �����ͼ� DB ����
		String sql = "insert into memberexam values(?, ?, ?, ?)";
		getConnection(); //����
		
		try {
			pstmt = conn.prepareStatement(sql); //����
			pstmt.setString(1, dto.getName()); //?�� ����
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getPwd());
			pstmt.setString(4, dto.getEmail());
			
			pstmt.executeUpdate(); //����
			
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

	public String loginMember(String id, String pwd) { //�α����� ���̵�, ��й�ȣ �����ͼ� DB ����
		String name = null; //�ʱⰪ
		String sql = "select * from memberexam where id=? and pwd=?";
		getConnection(); //����
		
		try {
			pstmt = conn.prepareStatement(sql); //����
			pstmt.setString(1, id); //?�� ����
			pstmt.setString(2, pwd);
			
			rs = pstmt.executeQuery(); //����, select�� rs�� ����
			
			if(rs.next()) { //rs ���� ������
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
		String sql = "select * from memberexam order by name asc"; //�̸����� ��������
		getConnection(); //����
		
		try {
			pstmt = conn.prepareStatement(sql); //����
			rs = pstmt.executeQuery(); //����, select �� rs�� ����
			
			while(rs.next()) { //rs���� �������ϱ� while�� ���
				MemberDTO dto = new MemberDTO(); //rs���� ���� ��ŭ dto ����
				dto.setName(rs.getString("name")); //rs �� dto�� ����
				dto.setId(rs.getString("id"));
				dto.setPwd(rs.getString("pwd"));
				dto.setEmail(rs.getString("email"));
				
				list.add(dto); //dto �� list�� ����
			}//while
			
		}catch(SQLException e) {
			e.printStackTrace();
			list = null; 
			//SQLException ���� �߻��� ���ϵǴ� list�� ����, Service���� for�� �� �� ����
			
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


















