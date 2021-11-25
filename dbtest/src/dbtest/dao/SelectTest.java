package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest { 
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs; //ResultSet 인터페이스는 select의 결과값 받음
	
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
		this.getConnection(); //접속
		
		try {
			pstmt = conn.prepareStatement(sql); //생성
			rs = pstmt.executeQuery(); //실행, executeQuery()는 ResultSet을 리턴한다
			
			while(rs.next()) { //레코드에 초점(position)을 맞추고, 레코드가 있으면 T 없으면 F
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
- 레코드에 초점(position)을 맞추고, 레코드가 있으면 T 없으면 F  
- 다음 레코드로 이동
- 오라클과 관련되어 있으므로 컬럼은 1부터 시작

	NAME	AGE		HEIGHT		LOGTIME
→	홍		25		185.3		xxxx
→	코		13		152.7		xxxx

rs.getString("name")	/rs.getString(1)
rs.getInt("age")		/rs.getInt(2)
rs.getDouble("height")  /rs.getDouble(3)
rs.getString("logtime") /rs.getString(4) --> rs.getDate("logtime")/rs.getDate(4)

찍기만 하겠다 하면 String으로, 계산을 목적으로 하면 date로
*/
