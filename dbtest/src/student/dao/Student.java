/*
[문제]
Project  : student
Package : student.dao
Class    : Student.java

# 테이블 작성
create table student(
name  varchar2(15)  not  null, -- 이름
value   varchar2(15), -- 학번 or 과목 or 부서
code   number   -- 1이면 학생, 2이면 교수, 3이면 관리자
);

menu()
****************
   관리
****************
  1. 입력
  2. 검색
  3. 삭제
  4. 종료
****************
  번호선택 : 4
프로그램 종료합니다


1번인 경우
insertArticle()
****************
   1. 학생
   2. 교수
   3. 관리자
   4. 이전메뉴
****************
   번호선택 : 

1번 학생인 경우
이름입력 : 
학번입력 : 

2번 교수인 경우
이름입력 : 
과목입력 : 

3번 관리자인 경우
이름입력 : 
부서입력 : 

2번인 경우
selectArticle()
****************
   1. 이름 검색 (1개 글자가 포함된 이름은 모두 검색)
   2. 전체 검색
   3. 이전메뉴
****************
   번호선택 : 1

1번 경우
검색할 이름 입력 : 이
이름=희동이	학번=2015
이름=이교수	과목=JAVA

3번인 경우
deleteArticle()
삭제를 원하는 이름 입력 : (정확하게 3개의 글자가 모두 입력된 상태)
-------------------------------------------------------
Project student에 lib폴더 생성 후 ojdbc8.jar 파일 붙여넣고,
우클릭-Build Path-Add to Build Path
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
   
   public Student() { //생성자 - Driver Loading
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
         System.out.println("   관리");
         System.out.println("***************");
         System.out.println("   1. 입력");
         System.out.println("   2. 검색");
         System.out.println("   3. 삭제");
         System.out.println("   4. 종료");
         System.out.println("***************");
         System.out.print("번호 선택 : ");
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
	         System.out.println("   1. 학생");
	         System.out.println("   2. 교수");
	         System.out.println("   3. 관리자");
	         System.out.println("   4. 이전메뉴");
	         System.out.println("****************");
	         System.out.print("번호 선택 : ");
	         num = scan.nextInt();
	         if(num==4) break;
	         
	         //데이터 입력
	         System.out.print("이름 입력 : ");
	         name = scan.next();
	         if(num==1) {
	            System.out.print("학번 입력 : ");
	            value = scan.next();
	            code=1;
	         }
	         else if(num==2) {
	            System.out.print("과목 입력 : ");
	            value = scan.next();
	            code=2;
	         }
	         else if(num==3) {
	            System.out.print("부서 입력 : ");
	            value = scan.next();
	            code=3;
	         }
	         
	         //DB
	         String sql = "insert into student values(?, ?, ?)";
	         this.getConnection();//접속
	         try {
	            pstmt = conn.prepareStatement(sql); //생성
	            pstmt.setString(1, name);
	            pstmt.setString(2, value);
	            pstmt.setInt(3, code);
	            
	            int su = pstmt.executeUpdate();//실행
	            System.out.println(su+"개의 행이 만들어졌습니다");
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
         System.out.println("1. 이름검색");
         System.out.println("2. 전체검색");
         System.out.println("3. 이전메뉴");
         System.out.println("*************");
         System.out.print("번호 선택 : ");
         num = scan.nextInt();
         if(num==3) break; //3. 이전메뉴
         
         if(num==1) { //1. 이름검색
            System.out.print("검색할 이름 입력 : ");
            name = scan.next();
         }
         
         //DB
         String sql=null;
         if(num==1) { //1. 이름검색
            sql = "select * from student where name like ?";
         }else if(num==2) { //2. 전체검색
            sql = "select * from student";
         }
         
         this.getConnection(); //접속
         
         try {
            pstmt = conn.prepareStatement(sql); //생성
            if(num==1) pstmt.setString(1, "%"+name+"%");
            
            rs = pstmt.executeQuery(); //실행
            
            while(rs.next()) {
               System.out.print("이름 = " + rs.getString("name")+"\t\t");
               if(rs.getInt("code") == 1)
                  System.out.println("학번 = " + rs.getString("value"));
               else if(rs.getInt("code") == 2)
                  System.out.println("과목 = " + rs.getString("value"));
               else if(rs.getInt("code") == 3)
                  System.out.println("부서 = " + rs.getString("value"));
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
	      System.out.print("삭제 할 이름 입력 : ");
	      String name = scan.next();
	      
	      //DB
	      String sql = "delete student where name=?";
	      this.getConnection();
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, name);
	         
	         int su = pstmt.executeUpdate();
	         System.out.println(su+"개의 행이 삭제되었습니다");
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
      Student sd = new Student(); //생성자 호출
      sd.menu();
      System.out.println("프로그램을 종료합니다.");
   }
}
