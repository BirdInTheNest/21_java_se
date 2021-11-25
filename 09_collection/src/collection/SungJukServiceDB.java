package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SungJukServiceDB {
	Scanner scan = new Scanner(System.in);
	private List<SungJukDTO> list;
	
	public SungJukServiceDB() { //생성자
		list = new ArrayList<SungJukDTO>(); //부모 = 자식
	}
	
	public void menu() {
	      int num;
	      while(true) {
	         System.out.println();
	         System.out.println("****************");
	         System.out.println("   1. 입력");
	         System.out.println("   2. 출력");
	         System.out.println("   3. 검색");
	         System.out.println("   4. 삭제");
	         System.out.println("   5. 정렬");
	         System.out.println("   6. 끝");
	         System.out.println("****************");
	         System.out.print(" 번호 : ");
	         num = scan.nextInt();
	           
	         if(num==6) break;
	         if(num==1) insertArticle();
	         else if(num==2) printArticle();
	         else if(num==3) searchArticle(); //번호 검색
	         else if(num==4) deleteArticle(); //번호 검색 후 sql - delete
	         else if(num==5) sortArticle(); //sql
	         else System.out.println("1~6중에 선택하세요");
	      }//while
	   }//menu()
	
	private void insertArticle() { //입력
		//데이터
		System.out.println();
		System.out.print("번호 입력 :");
		int no = scan.nextInt();
		System.out.print("이름 입력 :");
		String name = scan.next();
		System.out.print("국어 입력 :");
		int kor = scan.nextInt();
		System.out.print("영어 입력 :");
		int eng = scan.nextInt();
		System.out.print("수학 입력 :");
		int math = scan.nextInt();
		
		//데이터값이 여러개니까 dto를 생성하면서 데이터를 dto의 생성자 또는 setter에 저장하자
		SungJukDTO dto = new SungJukDTO();
		dto.setNo(no);
		dto.setName(name);
		dto.setKor(kor);
		dto.setEng(eng);
		dto.setMath(math);
		
		dto.calc(); //총점, 평균 계산
		
		//DB
		SungJukDAO dao = new SungJukDAO();
		dao.insertArticle(dto); //dto를 DB의 insertArticle()에 전달
		
		System.out.println("등록 완료");
		
	}//insertArticle()
	
	private void printArticle() { //출력
		//DB에서 select값을 rs에 저장, rs에 있는 값을 꺼내서 dto에 저장, dto를 데이터 타입으로 하는 list에 저장
		SungJukDAO dao = new SungJukDAO();
		List<SungJukDTO> list = dao.printArticle(); 
		
		System.out.println();
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		for(SungJukDTO dto : list) {
			System.out.println(dto);
		}
	}//printArticle()
	
	private void searchArticle() { //검색
		System.out.println();
		System.out.print("검색 할 번호 입력 : ");
		int no = scan.nextInt(); //검색할 번호를 입력받아서
		
		//DB
		SungJukDAO dao = new SungJukDAO();
		SungJukDTO dto = dao.searchArticle(no); //그 값을 DB의 searchArticle에 전달하고 리턴값 dto에 저장
		
		//printArticle은 rs에 받은 select 결과값이 여러줄이기 때문에 1인분씩 dto에 담아 list에 넣어서 가져왔지만
		//searchArticle은 select 결과값이 한 줄이기 때문에 1인분인 dto에 담아서 가져오면 된다
			
		if(dto==null) { 
			System.out.println("찾고자 하는 번호가 없습니다.");
		}else {
			System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
			System.out.println(dto);			
		}
		
	}//searchArticle()
	
	private void deleteArticle() { //삭제
		System.out.println();
		System.out.print("삭제 할 번호 입력 : ");
		int no = scan.nextInt(); //삭제할 번호를 입력받아서
		
		//DB
		SungJukDAO dao = new SungJukDAO();
		int su = dao.deleteArticle(no); //그 값을 DB의 deleteArticle에 전달하고 리턴값 su에 저장
		
		if(su==0)
			System.out.println("찾고자 하는 번호가 없습니다.");
		else
			System.out.println("삭제 완료");
		
	}//deleteArticle()

	private void sortArticle() { //정렬
		System.out.println();
		int num;
		
		//DB
		SungJukDAO dao = new SungJukDAO();
		
		while(true) {
			System.out.println();
			System.out.println("*****************");
			System.out.println("	1. 이름으로 오름차순");
			System.out.println("	2. 총점으로 내림차순");
			System.out.println("	3. 이전메뉴");
			System.out.println("*****************");
			System.out.print("번호");
			num = scan.nextInt(); //번호를 입력하고 
			if(num==3) break;

			List<SungJukDTO> list = dao.sortArticle(num); //그 값을 DB의 sortArticle에 전달
			//sort하면 rs에 받은 select 결과값이 여러줄이기 때문에, 1인분씩 dto에 담아 list에 넣어서 가져온다.

			System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
			for(SungJukDTO dto : list) {
				System.out.println(dto);
			}
		}//while	
	}//sortArticle()
}