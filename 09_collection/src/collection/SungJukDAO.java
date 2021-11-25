package collection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//DB
public class SungJukDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";

	public SungJukDAO() {
		try {
			Class.forName(driver);
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void insertArticle(SungJukDTO dto) { //dto�� ����� �����͸� ������ �ͼ�
		String sql = "insert into sungjuk values(?, ?, ?, ?, ?, ?, ?)";
		getConnection(); //����

		try {
			pstmt = conn.prepareStatement(sql); //����
			pstmt.setInt(1, dto.getNo()); //?�� ����
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMath());
			pstmt.setInt(6, dto.getTot());
			pstmt.setDouble(7, dto.getAvg());

	        pstmt.executeUpdate();//���� - ���� ����

		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
	        	 if (pstmt != null) pstmt.close();
	             if (conn != null) conn.close();
			}catch (SQLException e) {
	            e.printStackTrace();
			}
		}
	}//insertArticle(SungJukDTO dto)

//	DB���� select���� rs�� ����, rs�� �ִ� ���� ������ dto�� ����, dto�� ������ Ÿ������ �ϴ� list�� ����
	public List<SungJukDTO> printArticle() {
		List<SungJukDTO> list = new ArrayList<SungJukDTO>(); //�θ� = �ڽ�
		String sql = "select * from sungjuk";
		getConnection(); //����
		
		try {
			pstmt = conn.prepareStatement(sql); //����
			rs = pstmt.executeQuery(); //����, select �� rs�� ����
			
			while(rs.next()) { //rs���� ������ ���� ���� �����ϱ� while�� ���
				SungJukDTO dto = new SungJukDTO(); //dto����
				dto.setNo(rs.getInt("no")); //rs���� ������ ���� dto�� ����
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMath(rs.getInt("math"));
				dto.setTot(rs.getInt("tot"));
				dto.setAvg(rs.getInt("avg"));
				
				list.add(dto); //dto�� list�� ����
			}//while
			
		} catch (SQLException e) {
			e.printStackTrace();
			list = null; 
			
			//list�� ������ �����߱� ������ SQLException�� �߻��ϸ� null������ ���̻� �������� ���Ѵ�
			//rs > dto > list ���� �� ���� �߻��� null�� Exception �ߵ��� ó��
			
		}finally {
	         try {
	        	 if (rs != null) rs.close();
	        	 if (pstmt != null) pstmt.close();
	             if (conn != null) conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	    }
		
		return list; //SungJukDTO�� ������ Ÿ������ �ϴ� list ��ȯ
		
	}//printArticle()

	public SungJukDTO searchArticle(int no) { //�˻��� ��ȣ �����Ͱ��� �����ͼ�
		SungJukDTO dto = null;
		String sql = "select * from sungjuk where no=?";
		getConnection(); //����
		
		try {
			pstmt = conn.prepareStatement(sql); //����
			pstmt.setInt(1, no); //?�� ����
			
			rs = pstmt.executeQuery(); //����, select �� rs�� ����
			
			if(rs.next()) { //rs���� �����̹Ƿ� if�� ���
				dto = new SungJukDTO(); //dto����
				dto.setNo(rs.getInt("no")); //rs���� ������ ���� dto�� ����
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMath(rs.getInt("math"));
				dto.setTot(rs.getInt("tot"));
				dto.setAvg(rs.getInt("avg"));	
			}//if
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
	         try {
	        	 if (rs != null) rs.close();
	        	 if (pstmt != null) pstmt.close();
	             if (conn != null) conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	    }

		return dto; //dto ��ȯ
		
	}//searchArticle(int no)

	public int deleteArticle(int no) { //������ ��ȣ �����Ͱ��� �����ͼ�
		String sql = "delete sungjuk where no=?";
		getConnection();
		int su=0;
		
		try {
			pstmt = conn.prepareStatement(sql); //����
			pstmt.setInt(1, no); //?�� ����
			
			su = pstmt.executeUpdate(); //����, ���ϵ� ������ int su�� ����
			
			//insert, update, delete���� executeUpdate() ���
			//select���� executeQuery() ���
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
	         try {
	        	 if (pstmt != null) pstmt.close();
	             if (conn != null) conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	    }	
		
		return su; //���ϰ��� int�� �޾ƿ��� ������ void�� int�� �ٲ�� ��
		
	}//deleteArticle(int no)

//	DB���� select���� rs�� ����, rs�� �ִ� ���� ������ dto�� ����, dto�� ������ Ÿ������ �ϴ� list�� ����
	public List<SungJukDTO> sortArticle(int num) { //��ȣ �����Ͱ��� �����ͼ�
		List<SungJukDTO> list = new ArrayList<SungJukDTO>(); //�θ� = �ڽ�
		String sql = null;
		
		//DB������ order by�� ���ĵǱ� ������ Comparable / Comparator �������̽� ����� �ʿ� ����
		
		if(num==1) //1. �̸����� ��������
			sql = "select * from sungjuk order by name asc";
		else //2. �������� ��������
			sql = "select * from sungjuk order by tot desc";
		
		getConnection(); //����
		
		try {
			pstmt = conn.prepareStatement(sql); //����
			rs = pstmt.executeQuery(); //����, select �� rs�� ����
			
			while(rs.next()) { //rs���� ������ ���� ���� �����ϱ� while�� ���
				SungJukDTO dto = new SungJukDTO(); //dto ����
				dto.setNo(rs.getInt("no")); //rs���� ������ ���� dto�� ����
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMath(rs.getInt("math"));
				dto.setTot(rs.getInt("tot"));
				dto.setAvg(rs.getInt("avg"));
				
				list.add(dto); //dto�� list�� ����
			}//while
	
		} catch (SQLException e) {
			e.printStackTrace();
			list = null; 
			
			//list�� ������ �����߱� ������ SQLException�� �߻��ϸ� null������ ���̻� �������� ���Ѵ�
			//rs > dto > list ���� �� ���� �߻��� null�� Exception �ߵ��� ó��
			
		} finally {
	         try {
	        	 if (rs != null) rs.close();
	        	 if (pstmt != null) pstmt.close();
	             if (conn != null) conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	    }	

		return list; //SungJukDTO�� ������ Ÿ������ �ϴ� list ��ȯ
	}
}

//����Ŭ 1�� ���� - ���Ἲ ���� ���� : �ߺ��Ұ�
//��ü�������α׷� OOP
//���յ��� ����� �Ѵ�
//�ߺ��Ǵ� �ڵ带 ���־��Ѵ�. �޼ҵ带 ���� ���
