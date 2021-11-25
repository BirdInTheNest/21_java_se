package dbtest.dao;

import java.sql.Connection; //interface
import java.sql.DriverManager; //class
import java.sql.PreparedStatement; //interface
import java.sql.SQLException; //exception
import java.util.Scanner;

public class InsertTest {
	private Connection conn; //�ʵ带 �ɸ� ���� Ŭ���� �ȿ��� �� ��밡��
	private PreparedStatement pstmt; //���� �ϰ� �������� �ʾƼ� null�� ������ ����
	
	private String driver = "oracle.jdbc.driver.OracleDriver"; //ojdbc8.jar �ȿ� ����
	private String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
	private String username = "c##java";
	private String password = "bit";

	//Driver Loading (driver ��ġ) - �� 1���� �ϸ� �ǹǷ� �����ڿ��� ����
	public InsertTest() { //������ 
		try {
			Class.forName(driver); //���ϸ��� Ǯ����(��Ű����.���ϸ�) �ָ� Class Ÿ������ �������ְڴ�, ��Ű������ �ҹ���
			System.out.println("����̹� �ε� ����"); //üũ
		}catch(ClassNotFoundException e) {
			e.printStackTrace(); //�����߻��� ���� ������ ���
		}
	}
	
	//Connection (����Ŭ�� ����)
	public void getConnection() {
		try {
			conn = DriverManager.getConnection(url, username, password); //�޼ҵ�� Connection �������̽� ����
			//java.sql Class DriverManager�� getConnection �޼ҵ�� �������̽� ����
			System.out.println("���� ����"); //üũ	
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Statement - SQL(insert, delete, update, select...)���� ��� ó�� 
	public void insertArticle() { 
		Scanner scan = new Scanner(System.in);
		System.out.print("�̸� �Է� : ");
		String name = scan.next();
		System.out.print("���� �Է� : ");
		int age = scan.nextInt();
		System.out.print("Ű �Է� : ");
		double height = scan.nextDouble();
		
		String sql = "insert into dbtest values(?, ?, ?, sysdate)";
		this.getConnection(); //DB�� ����, getConnection()�� sql���忡�� insert�� �ʿ��Ҷ��� ������ ��
			
		try {
			pstmt = conn.prepareStatement(sql); 
			//java.sql Interface Connection�� prepareStatement �޼ҵ�� �������̽� ����
			//������ �ִ� �����͸� ������ ���� ? ǥ��, ?�� ������ ���� (����Ŭ�� 1��° ����� ����)
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setDouble(3, height);
			
			int su = pstmt.executeUpdate(); //insert�� �����ϸ� ������ ������
			System.out.println(su+"���� ���� ����������ϴ�");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally { //������ �ֵ� ���� ������ �����Ѵ�
			try {
				if(pstmt != null) pstmt.close(); //DB�� ���������� �ݵ�� ������� ��
				if(conn != null) conn.close(); //Connection�ϰ� prepareStatement�ؼ� ���������Ƿ� ���� �� �ݴ�� ��
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
JDBC (Java DataBase Connectivity) : �����ͺ��̽��� �ڹ� �����ϱ�
- java���� db�� �����͸� �ְ� ���� ���� �ؾ� �� ��

[1]. Driver Loading (driver ��ġ) - *.jar �ʿ� , 1���� �ϸ� �ǹǷ� �����ڿ��� Driver Loading ��

����Ŭ		myBatis		Spring
-JAR		-JAR		-JAR

����Ŭ�� ojdbc8.jar �ٿ�, �ٿ���� ojdbc8.jar�� �ʿ��� Project�� lib�� �ֱ�
1. www.oracle.com
2. sqldeveloper

ojdbc8.jar�� oracle.jdbc.driver.OracleDriver.class ������ Ŭ����? �߻�Ŭ����? �������̽�? 
� ������ ��Ȯ�ϰ� �˾ƾ� �޸𸮿� ������ �ϴµ�, �𸣴ϱ� �ڹ��� ��Ÿ���� Class Ŭ������ ���� �����Ѵ�.


[2]. Connection (����Ŭ�� ����) - URL, USER, PASSWORD
- Connection�� �� ������� ������ �� �־�� �ϱ� ������ �����ڷ� �� �� ����
- java.sql Interface Connection
- java.sql Interface PreparedStatement (C,R,U,D ��ɾ� ġ���� �ʿ�)

Ŭ���� - new�� ����
�߻�Ŭ���� - �ڽ�Ŭ������ �޼ҵ�� ����
�������̽� - implements�� ����

�������̽��� ����� �߻�޼ҵ常 ������ �ִ� Ʋ�̹Ƿ� new �� ��
1. �������̽��� Ŭ������ implements �ϸ� ��� �߻�޼ҵ带 Override(�籸��)�ؾ� �Ѵ�.
   �׷���, Override �ؾ��ϴ� �߻�޼ҵ尡 �ʹ� ���� �������̽��� implements�� �ذ����� ����
   ActionListener - 1�� Override
   MouseListener - 5�� Override
   WindowListener - 7�� Override
2. ��� implements ���� Ŭ������ ���� (�� Override������)
3. �޼ҵ� (DriverManager.getConnection( );, conn.prepareStatement();)


[3]. Statement(SQL���� �� �� �ʿ��� ��) - SQL(insert, delete, update, select...)
- PreparedStatement (������ Statement ���� �Ⱦ��� �ڽ� �������̽��� PreparedStatement ���)
--------------------------------------------------------------------
throws�� JVM���� ���� �ذ��϶�� ������ �� - �����ڿ��� throws�ɸ� main������ throw�ɾ�� ��
���� ������ �ذ��ϰ� ������ try and catch ���

try{
	A(������ ���� �� �ִ� ����)
}catch(Exception) {
	B(���� ���� ���)
}finally{ 
	C
}
	D
	
A���� error x : A -> C -> D
A���� error o : A -> B-> C-> D

C�� ������ ����Ǵϱ� finally�� �Ǵ�
--------------------------------------------------------------------
JAVA �ڵ忡���� �ڵ� commit��
*/