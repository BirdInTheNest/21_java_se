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

	public void insertArticle(SungJukDTO dto) { //dto에 저장된 데이터를 가지고 와서
		String sql = "insert into sungjuk values(?, ?, ?, ?, ?, ?, ?)";
		getConnection(); //접속

		try {
			pstmt = conn.prepareStatement(sql); //생성
			pstmt.setInt(1, dto.getNo()); //?에 맵핑
			pstmt.setString(2, dto.getName());
			pstmt.setInt(3, dto.getKor());
			pstmt.setInt(4, dto.getEng());
			pstmt.setInt(5, dto.getMath());
			pstmt.setInt(6, dto.getTot());
			pstmt.setDouble(7, dto.getAvg());

	        pstmt.executeUpdate();//실행 - 개수 리턴

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

//	DB에서 select값을 rs에 저장, rs에 있는 값을 꺼내서 dto에 저장, dto를 데이터 타입으로 하는 list에 저장
	public List<SungJukDTO> printArticle() {
		List<SungJukDTO> list = new ArrayList<SungJukDTO>(); //부모 = 자식
		String sql = "select * from sungjuk";
		getConnection(); //접속
		
		try {
			pstmt = conn.prepareStatement(sql); //생성
			rs = pstmt.executeQuery(); //실행, select 값 rs에 저장
			
			while(rs.next()) { //rs값이 여러줄 있을 수도 있으니까 while문 사용
				SungJukDTO dto = new SungJukDTO(); //dto생성
				dto.setNo(rs.getInt("no")); //rs에서 가져온 값을 dto에 저장
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMath(rs.getInt("math"));
				dto.setTot(rs.getInt("tot"));
				dto.setAvg(rs.getInt("avg"));
				
				list.add(dto); //dto를 list에 저장
			}//while
			
		} catch (SQLException e) {
			e.printStackTrace();
			list = null; 
			
			//list를 위에서 생성했기 때문에 SQLException이 발생하면 null값으로 더이상 진행하지 못한다
			//rs > dto > list 과정 중 에러 발생시 null값 Exception 뜨도록 처리
			
		}finally {
	         try {
	        	 if (rs != null) rs.close();
	        	 if (pstmt != null) pstmt.close();
	             if (conn != null) conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	    }
		
		return list; //SungJukDTO를 데이터 타입으로 하는 list 반환
		
	}//printArticle()

	public SungJukDTO searchArticle(int no) { //검색할 번호 데이터값을 가져와서
		SungJukDTO dto = null;
		String sql = "select * from sungjuk where no=?";
		getConnection(); //접속
		
		try {
			pstmt = conn.prepareStatement(sql); //생성
			pstmt.setInt(1, no); //?에 맵핑
			
			rs = pstmt.executeQuery(); //실행, select 값 rs에 저장
			
			if(rs.next()) { //rs값이 한줄이므로 if문 사용
				dto = new SungJukDTO(); //dto생성
				dto.setNo(rs.getInt("no")); //rs에서 가져온 값을 dto에 저장
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

		return dto; //dto 반환
		
	}//searchArticle(int no)

	public int deleteArticle(int no) { //삭제할 번호 데이터값을 가져와서
		String sql = "delete sungjuk where no=?";
		getConnection();
		int su=0;
		
		try {
			pstmt = conn.prepareStatement(sql); //생성
			pstmt.setInt(1, no); //?에 맵핑
			
			su = pstmt.executeUpdate(); //실행, 리턴된 개수를 int su에 저장
			
			//insert, update, delete에서 executeUpdate() 사용
			//select에서 executeQuery() 사용
			
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
		
		return su; //리턴값을 int로 받아오기 때문에 void를 int로 바꿔야 함
		
	}//deleteArticle(int no)

//	DB에서 select값을 rs에 저장, rs에 있는 값을 꺼내서 dto에 저장, dto를 데이터 타입으로 하는 list에 저장
	public List<SungJukDTO> sortArticle(int num) { //번호 데이터값을 가져와서
		List<SungJukDTO> list = new ArrayList<SungJukDTO>(); //부모 = 자식
		String sql = null;
		
		//DB에서는 order by로 정렬되기 때문에 Comparable / Comparator 인터페이스 사용할 필요 없음
		
		if(num==1) //1. 이름으로 오름차순
			sql = "select * from sungjuk order by name asc";
		else //2. 총점으로 내림차순
			sql = "select * from sungjuk order by tot desc";
		
		getConnection(); //접속
		
		try {
			pstmt = conn.prepareStatement(sql); //생성
			rs = pstmt.executeQuery(); //실행, select 값 rs에 저장
			
			while(rs.next()) { //rs값이 여러줄 있을 수도 있으니까 while문 사용
				SungJukDTO dto = new SungJukDTO(); //dto 생성
				dto.setNo(rs.getInt("no")); //rs에서 가져온 값을 dto에 저장
				dto.setName(rs.getString("name"));
				dto.setKor(rs.getInt("kor"));
				dto.setEng(rs.getInt("eng"));
				dto.setMath(rs.getInt("math"));
				dto.setTot(rs.getInt("tot"));
				dto.setAvg(rs.getInt("avg"));
				
				list.add(dto); //dto를 list에 저장
			}//while
	
		} catch (SQLException e) {
			e.printStackTrace();
			list = null; 
			
			//list를 위에서 생성했기 때문에 SQLException이 발생하면 null값으로 더이상 진행하지 못한다
			//rs > dto > list 과정 중 에러 발생시 null값 Exception 뜨도록 처리
			
		} finally {
	         try {
	        	 if (rs != null) rs.close();
	        	 if (pstmt != null) pstmt.close();
	             if (conn != null) conn.close();
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	    }	

		return list; //SungJukDTO를 데이터 타입으로 하는 list 반환
	}
}

//오라클 1번 에러 - 무결성 제약 조건 : 중복불가
//객체지향프로그램 OOP
//결합도를 낮춰야 한다
//중복되는 코드를 없애야한다. 메소드를 많이 사용
