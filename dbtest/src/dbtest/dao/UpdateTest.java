package dbtest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateTest { 
	private Connection conn;
	private PreparedStatement pstmt;
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String username = "c##java";
	private String password = "bit";
	
	public UpdateTest() { //Driver Loading
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
	
	public void UpdateArticle() { //Statement
		Scanner scan = new Scanner(System.in);
		System.out.println("수정할 이름 입력 : ");
		String name = scan.next();
		
		String sql = "update dbtest set age=age+1, height=height-1 where name like ?"; //%와 ?같이 못씀
		//위의 sql 오라클 문장에서만 오라클 문법을 지키면 되고, 나머지는 다 자바 문법을 지키면 됨
		this.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql); //sql 가이드인 pstmt를 메소드를 통해 생성
			pstmt.setString(1, "%"+name+"%");

			int su = pstmt.executeUpdate(); //실행
			System.out.println(su+"개의 행을 수정하였습니다");
		}catch(SQLException e) {
			e.printStackTrace();
		}finally { //finally하지 않으면 메모리가 계속 쌓여서 뻗음
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}		
	}

	public static void main(String[] args) {
		UpdateTest ut = new UpdateTest();
		ut.UpdateArticle();
	}
}

/*
Ctrl space bar : 생성자 나옴

insert는 한번에 1개씩밖에 생성 못 함
update, delete는 한번에 여러개 수정, 삭제 가능
 */

