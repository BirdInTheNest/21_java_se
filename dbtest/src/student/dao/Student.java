/*
[����]
Project  : student
Package : student.dao
Class    : Student.java

# ���̺� �ۼ�
create table student(
name  varchar2(15)  not  null, -- �̸�
value   varchar2(15), -- �й� or ���� or �μ�
code   number   -- 1�̸� �л�, 2�̸� ����, 3�̸� ������
);

menu()
****************
   ����
****************
  1. �Է�
  2. �˻�
  3. ����
  4. ����
****************
  ��ȣ���� : 4
���α׷� �����մϴ�


1���� ���
insertArticle()
****************
   1. �л�
   2. ����
   3. ������
   4. �����޴�
****************
   ��ȣ���� : 

1�� �л��� ���
�̸��Է� : 
�й��Է� : 

2�� ������ ���
�̸��Է� : 
�����Է� : 

3�� �������� ���
�̸��Է� : 
�μ��Է� : 

2���� ���
selectArticle()
****************
   1. �̸� �˻� (1�� ���ڰ� ���Ե� �̸��� ��� �˻�)
   2. ��ü �˻�
   3. �����޴�
****************
   ��ȣ���� : 1

1�� ���
�˻��� �̸� �Է� : ��
�̸�=����	�й�=2015
�̸�=�̱���	����=JAVA

3���� ���
deleteArticle()
������ ���ϴ� �̸� �Է� : (��Ȯ�ϰ� 3���� ���ڰ� ��� �Էµ� ����)
-------------------------------------------------------
Project student�� lib���� ���� �� ojdbc8.jar ���� �ٿ��ְ�,
��Ŭ��-Build Path-Add to Build Path
 */

package student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Student {
   private Connection conn;
   private PreparedStatement pstmt;
   private ResultSet rs; //for select
   
   private String driver = "oracle.jdbc.driver.OracleDriver";
   private String url = "jdbc:oracle:thin:@localhost:1521:xe";
   private String username = "c##java";
   private String password = "bit";
   
   Scanner scan = new Scanner(System.in);
   
   public Student() { //������ - Driver Loading
      try {
         Class.forName(driver);
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      }
   }//Student()
   
   public void getConnection() { //Connection
      try {   
         conn = DriverManager.getConnection(url, username, password);
      }catch(SQLException e) {
         e.printStackTrace();
      }
   }//getConnection()
   
   public void menu() {
      int num=0;
      
      while(true) {
         System.out.println();
         System.out.println("***************");
         System.out.println("   ����");
         System.out.println("***************");
         System.out.println("   1. �Է�");
         System.out.println("   2. �˻�");
         System.out.println("   3. ����");
         System.out.println("   4. ����");
         System.out.println("***************");
         System.out.print("��ȣ ���� : ");
         num = scan.nextInt();
         
         if(num==4) break;
         if(num==1) insertArticle();
         else if(num==2) selectArticle();
         else if(num==3) deleteArticle();
      }//while
   }//menu()
   
   public void insertArticle() {
	      int num;
	      String name;
	      String value=null;
	      int code=0;
	      
	      while(true) {
	         System.out.println();
	         System.out.println("****************");
	         System.out.println("   1. �л�");
	         System.out.println("   2. ����");
	         System.out.println("   3. ������");
	         System.out.println("   4. �����޴�");
	         System.out.println("****************");
	         System.out.print("��ȣ ���� : ");
	         num = scan.nextInt();
	         if(num==4) break;
	         
	         //������ �Է�
	         System.out.print("�̸� �Է� : ");
	         name = scan.next();
	         if(num==1) {
	            System.out.print("�й� �Է� : ");
	            value = scan.next();
	            code=1;
	         }
	         else if(num==2) {
	            System.out.print("���� �Է� : ");
	            value = scan.next();
	            code=2;
	         }
	         else if(num==3) {
	            System.out.print("�μ� �Է� : ");
	            value = scan.next();
	            code=3;
	         }
	         
	         //DB
	         String sql = "insert into student values(?, ?, ?)";
	         this.getConnection();//����
	         try {
	            pstmt = conn.prepareStatement(sql); //����
	            pstmt.setString(1, name);
	            pstmt.setString(2, value);
	            pstmt.setInt(3, code);
	            
	            int su = pstmt.executeUpdate();//����
	            System.out.println(su+"���� ���� ����������ϴ�");
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }finally {
	            try {
	               if(pstmt!=null)pstmt.close();
	               if(conn!=null)conn.close();
	            } catch (SQLException e) {
	               e.printStackTrace();
	            }
	         }
	      }//while
	   }//insertArticle()
 
   private void selectArticle() {
      int num;
      String name=null;
      
      while(true) {
         System.out.println();
         System.out.println("*************");
         System.out.println("1. �̸��˻�");
         System.out.println("2. ��ü�˻�");
         System.out.println("3. �����޴�");
         System.out.println("*************");
         System.out.print("��ȣ ���� : ");
         num = scan.nextInt();
         if(num==3) break; //3. �����޴�
         
         if(num==1) { //1. �̸��˻�
            System.out.print("�˻��� �̸� �Է� : ");
            name = scan.next();
         }
         
         //DB
         String sql=null;
         if(num==1) { //1. �̸��˻�
            sql = "select * from student where name like ?";
         }else if(num==2) { //2. ��ü�˻�
            sql = "select * from student";
         }
         
         this.getConnection(); //����
         
         try {
            pstmt = conn.prepareStatement(sql); //����
            if(num==1) pstmt.setString(1, "%"+name+"%");
            
            rs = pstmt.executeQuery(); //����
            
            while(rs.next()) {
               System.out.print("�̸� = " + rs.getString("name")+"\t\t");
               if(rs.getInt("code") == 1)
                  System.out.println("�й� = " + rs.getString("value"));
               else if(rs.getInt("code") == 2)
                  System.out.println("���� = " + rs.getString("value"));
               else if(rs.getInt("code") == 3)
                  System.out.println("�μ� = " + rs.getString("value"));
            }//while
         } catch (SQLException e) {
            e.printStackTrace();
         }finally {
               try {
                     if(rs != null) rs.close();
                     if(pstmt != null) pstmt.close();
                     if(conn != null) conn.close();
                  } catch (SQLException e) {
                     e.printStackTrace();
                  }
         }
      }//while   
   }//selectArticle()

   private void deleteArticle() {
	      System.out.print("���� �� �̸� �Է� : ");
	      String name = scan.next();
	      
	      //DB
	      String sql = "delete student where name=?";
	      this.getConnection();
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, name);
	         
	         int su = pstmt.executeUpdate();
	         System.out.println(su+"���� ���� �����Ǿ����ϴ�");
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	         try {
	            if(pstmt!=null) pstmt.close();
	            if(conn!=null) conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	   }//deleteArticle()

   public static void main(String[] args) {
      Student sd = new Student(); //������ ȣ��
      sd.menu();
      System.out.println("���α׷��� �����մϴ�.");
   }
}
