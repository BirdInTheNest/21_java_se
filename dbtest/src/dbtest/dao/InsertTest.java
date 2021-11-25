package dbtest.dao;

import java.sql.Connection; //interface
import java.sql.DriverManager; //class
import java.sql.PreparedStatement; //interface
import java.sql.SQLException; //exception
import java.util.Scanner;

public class InsertTest {
	private Connection conn; //필드를 걸면 같은 클래스 안에서 다 사용가능
	private PreparedStatement pstmt; //선언만 하고 생성하지 않아서 null값 가지고 있음
	
	private String driver = "oracle.jdbc.driver.OracleDriver"; //ojdbc8.jar 안에 있음
	private String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
	private String username = "c##java";
	private String password = "bit";

	//Driver Loading (driver 설치) - 딱 1번만 하면 되므로 생성자에서 수행
	public InsertTest() { //생성자 
		try {
			Class.forName(driver); //파일명을 풀네임(패키지명.파일명) 주면 Class 타입으로 생성해주겠다, 패키지명은 소문자
			System.out.println("드라이버 로딩 성공"); //체크
		}catch(ClassNotFoundException e) {
			e.printStackTrace(); //에러발생시 에러 내용을 출력
		}
	}
	
	//Connection (오라클에 접속)
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password); //메소드로 Connection 인터페이스 생성
			//java.sql Class DriverManager의 getConnection 메소드로 인터페이스 생성
			System.out.println("접속 성공"); //체크	
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Statement - SQL(insert, delete, update, select...)문장 명령 처리 
	public void insertArticle() { 
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("나이 입력 : ");
		int age = scan.nextInt();
		System.out.print("키 입력 : ");
		double height = scan.nextDouble();
		
		String sql = "insert into dbtest values(?, ?, ?, sysdate)";
		this.getConnection(); //DB에 접속, getConnection()은 sql문장에서 insert가 필요할때만 잡으면 됨
			
		try {
			pstmt = conn.prepareStatement(sql); 
			//java.sql Interface Connection의 prepareStatement 메소드로 인터페이스 생성
			//가지고 있는 데이터를 보안을 위해 ? 표시, ?에 데이터 매핑 (오라클은 1번째 방부터 시작)
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setDouble(3, height);
			
			int su = pstmt.executeUpdate(); //insert를 실행하면 개수를 리턴함
			System.out.println(su+"개의 행이 만들어졌습니다");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally { //에러가 있든 없든 무조건 실행한다
			try {
				if(pstmt != null) pstmt.close(); //DB에 접속했으면 반드시 끊어줘야 함
				if(conn != null) conn.close(); //Connection하고 prepareStatement해서 접속했으므로 끊을 땐 반대로 함
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		InsertTest it = new InsertTest();
		it.insertArticle();
	}
}

/*
JDBC (Java DataBase Connectivity) : 데이터베이스와 자바 연결하기
- java에서 db로 데이터를 넣고 빼기 위해 해야 할 일

[1]. Driver Loading (driver 설치) - *.jar 필요 , 1번만 하면 되므로 생성자에서 Driver Loading 함

오라클		myBatis		Spring
-JAR		-JAR		-JAR

오라클은 ojdbc8.jar 다운, 다운받은 ojdbc8.jar은 필요한 Project의 lib에 넣기
1. www.oracle.com
2. sqldeveloper

ojdbc8.jar의 oracle.jdbc.driver.OracleDriver.class 파일이 클래스? 추상클래스? 인터페이스? 
어떤 것인지 정확하게 알아야 메모리에 생성을 하는데, 모르니까 자바의 몽타주인 Class 클래스를 만들어서 생성한다.


[2]. Connection (오라클에 접속) - URL, USER, PASSWORD
- Connection은 내 마음대로 접속할 수 있어야 하기 때문에 생성자로 할 수 없음
- java.sql Interface Connection
- java.sql Interface PreparedStatement (C,R,U,D 명령어 치려면 필요)

클래스 - new로 생성
추상클래스 - 자식클래스나 메소드로 생성
인터페이스 - implements로 생성

인터페이스는 상수와 추상메소드만 가지고 있는 틀이므로 new 못 함
1. 인터페이스를 클래스에 implements 하면 모든 추상메소드를 Override(재구현)해야 한다.
   그러나, Override 해야하는 추상메소드가 너무 많은 인터페이스는 implements로 해결하지 못함
   ActionListener - 1개 Override
   MouseListener - 5개 Override
   WindowListener - 7개 Override
2. 대신 implements 해준 클래스가 존재 (다 Override해줬음)
3. 메소드 (DriverManager.getConnection( );, conn.prepareStatement();)


[3]. Statement(SQL문장 쓸 때 필요한 것) - SQL(insert, delete, update, select...)
- PreparedStatement (요즘은 Statement 많이 안쓰고 자식 인터페이스인 PreparedStatement 사용)
--------------------------------------------------------------------
throws는 JVM에게 오류 해결하라고 던지는 것 - 생성자에서 throws걸면 main에서도 throw걸어야 함
내가 오류를 해결하고 싶으면 try and catch 사용

try{
	A(에러가 나올 수 있는 구역)
}catch(Exception) {
	B(에러 내용 출력)
}finally{ 
	C
}
	D
	
A에서 error x : A -> C -> D
A에서 error o : A -> B-> C-> D

C는 무조건 실행되니까 finally을 건다
--------------------------------------------------------------------
JAVA 코드에서는 자동 commit됨
*/