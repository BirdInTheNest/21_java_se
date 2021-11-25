package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest { 
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs; //ResultSet �������̽��� select�� ����� ����
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	
	public SelectTest() { //Driver Loading
		try {
			Class.forName(driver);		
		}catch(ClassNotFoundException e) {
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
	
	public void selectArticle() { //Statement
		String sql = "select * from dbtest";
		this.getConnection(); //����
		
		try {
			pstmt = conn.prepareStatement(sql); //����
			rs = pstmt.executeQuery(); //����, executeQuery()�� ResultSet�� �����Ѵ�
			
			while(rs.next()) { //���ڵ忡 ����(position)�� ���߰�, ���ڵ尡 ������ T ������ F
				System.out.println(rs.getString("name")+"\t"+
								   rs.getInt("age")+"\t"+
								   rs.getDouble("height")+"\t"+
								   rs.getString("logtime"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		SelectTest st = new SelectTest();
		st.selectArticle();
	}
}

/*
rs.next()
- ���ڵ忡 ����(position)�� ���߰�, ���ڵ尡 ������ T ������ F  
- ���� ���ڵ�� �̵�
- ����Ŭ�� ���õǾ� �����Ƿ� �÷��� 1���� ����

	NAME	AGE		HEIGHT		LOGTIME
��	ȫ		25		185.3		xxxx
��	��		13		152.7		xxxx

rs.getString("name")	/rs.getString(1)
rs.getInt("age")		/rs.getInt(2)
rs.getDouble("height")  /rs.getDouble(3)
rs.getString("logtime") /rs.getString(4) --> rs.getDate("logtime")/rs.getDate(4)

��⸸ �ϰڴ� �ϸ� String����, ����� �������� �ϸ� date��
*/
