package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

//	ArrayList<SungJukDTO> list = new ArrayList<SungJukDTO>(); ArrayList의 부모는 List이므로
//	List<SungJukDTO> list = new ArrayList<SungJukDTO>(); 부모 = 자식으로 생성하는 것이 더 좋음
//	Generic은 클래스 생성시 데이터 타입을 명시해 준다.
//	ArrayList 클래스를 생성하는데, 데이터 타입을 <SungJukDTO>로 명시하여, <SungJukDTO> 데이터만 들어간다

public class SungJukService {
	Scanner scan = new Scanner(System.in);
	private List<SungJukDTO> list;
	
	public SungJukService() { //생성자
		list = new ArrayList<SungJukDTO>(); //부모 = 자식(다형성)
	}

	public void menu() {
		int num;		
		while(true) {
			System.out.println();
			System.out.println("****************");
			System.out.println("	1. 입력");
			System.out.println("	2. 출력");
			System.out.println("	3. 검색");
			System.out.println("	4. 삭제");
			System.out.println("	5. 정렬");
			System.out.println("	6. 끝");
			System.out.println("****************");
			System.out.print("번호 : ");
			num = scan.nextInt();
		      
			if(num==6) break;
			if(num==1) insertArticle();
			else if(num==2) printArticle();
			else if(num==3) searchArticle();
			else if(num==4) deleteArticle();
			else if(num==5) sortArticle();
			else System.out.println("1~6 중에 선택하세요");
		}//while
	}//menu()
	
	private void insertArticle() { //입력
		System.out.println();
		System.out.print("번호 입력 :");
		int num = scan.nextInt();
		System.out.print("이름 입력 :");
		String name = scan.next();
		System.out.print("국어 입력 :");
		int kor = scan.nextInt();
		System.out.print("영어 입력 :");
		int eng = scan.nextInt();
		System.out.print("수학 입력 :");
		int math = scan.nextInt();

		//데이터값이 여러개니까 dto를 생성하면서 데이터를 받자
		SungJukDTO dto = new SungJukDTO(num, name, kor, eng, math); 
		dto.calc(); //총점, 평균 계산
		
		//1인분의 데이터를 저장한 dto가 여러개니까 ArrayList를 만들어 저장, 값을 저장하는 게 아니라 주소값만 저장함
		//list를 클리어하기 전까지는 SungJukDTO는 메모리에서 삭제되지 않음

		list.add(dto); 
		//System.out.println(list); //list는 toString()를 Override해서 클@16진수 --> [~,~,] 바꿈

		System.out.println("등록 완료");
		
	}//insertArticle()
	
	private void printArticle() { //출력
		System.out.println();
		System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
		for(SungJukDTO dto : list) { 
			System.out.println(dto);
		}	

//		리스트 크기만큼 for문 돌려서 list의 i번째 주소값으로 가서 SungJukDTO의 이름을 가져와도 되지만, 
//		확장형 for문으로 값을 가져오는 것이 더 좋음
		
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i).getName());
//		} 		
	}//printArticle()
	
	private void searchArticle() { //검색
		System.out.println();
		System.out.print("검색 할 이름 입력 : ");
		String findName = scan.next();
		int sw=0; //switch 변수 설정
		
		for(SungJukDTO dto : list) {
			if(findName.equals(dto.getName())) { //findName의 문자열이 dto에서 가져온 이름과 같은지
				if(sw==0) System.out.println("번호\t이름\t국어\t영어\t수학\t총점\t평균");
				System.out.println(dto);
				sw=1; //dto 데이터를 찍으면 값을 1로
			}
		}//for	
		
		if(sw==0)
			System.out.println("찾고자 하는 이름이 없습니다.");
		
	}//searchArticle()
	
	private void deleteArticle() { //삭제
		System.out.println();
		System.out.print("삭제할 이름 입력 : ");
		String name = scan.next();
		int sw=0; //switch 변수 설정
		
		Iterator<SungJukDTO> it = list.iterator(); //생성, Iterator는 인터페이스라서 new로 생성 못 함.
		while(it.hasNext()) { //it의 값이 있는지, 항목이 있으면 T 없으면 F
			SungJukDTO dto = it.next(); //현재 항목을 꺼내고 다음으로 이동, 데이터를 꺼내서 dto에 보관
			
			if(dto.getName().equals(name)) { //dto에서 가져온 이름과 삭제할 이름이 같은지
				it.remove(); //it가 가리키는 현재 위치를 지우는 게 아니라, 아까 dto에 넣어놓은 값을 지우는 것임
				sw=1; //dto에 있는 데이터를 삭제하면 값을 1로
			}
		}//while
		
		if(sw==0) 
			System.out.println("찾고자 하는 이름이 없습니다.");
		else			
			System.out.println("데이터를 삭제하였습니다.");

//		list.size(리스트의 크기)로 for문을 돌려서 list 안의 데이터를 삭제하면 안 된다
//		리스트는 데이터를 삭제하면 리스트의 크기도 같이 줄기 때문에, 리스트 안에 있는 항목들의 인덱스가 갱신된다. 
//		따라서 Iterator를 사용하여 리스트에 있는 항목들을 꺼내 dto에 저장하고, 그 저장한 dto를 삭제해야 한다. 

//		for(int i=0; i<list.size(); i++) { 
//			if(list.get(i).getName().equals(name)) { 
//				list.remove(list.get(i));
//				sw=1; 
//			}
//		} //error 발생
		
	}//deleteArticle()

	private void sortArticle() { //정렬
		System.out.println();
		int num;
		
		while(true) {
			System.out.println();
			System.out.println("*****************");
			System.out.println("	1. 이름으로 오름차순");
			System.out.println("	2. 총점으로 내림차순");
			System.out.println("	3. 이전메뉴");
			System.out.println("*****************");
			System.out.print("번호");
			num = scan.nextInt();
			if(num==3) break;
			
//			Comparable / Comparator 인터페이스라 new가 안됨, 익명 이너 클래스 {} 이용하여 생성
//			Comparable은 기본 정렬기준을 구현하는데 사용하며, 기본적으로 오름차순으로 정렬되도록 구현되어 있다
//			Comparator는 기본 정렬기준 외에 다른 기준으로 정렬하고자할 때 사용한다
//			비교대상자가 더 크면(<) -1, 같다면(==) 0, 작으면(>) 1을 반환한다
			
			if(num==1) { 
//				Comparator<SungJukDTO> com = new Comparator<SungJukDTO>() { 
//					@Override
//					public int compare(SungJukDTO s1, SungJukDTO s2) {
//						return s1.getName().compareTo(s2.getName());
//					}
//				};
//				
//				Collections.sort(list, com); //Comparator로 정렬
//				printArticle();
				
//				SungJukDTO 클래스에서 Comparable<SungJukDTO> 구현해놓아서 Comparable 정렬 사용 가능			
				Collections.sort(list); //Comparable로 정렬
				printArticle(); //출력

			}else if(num==2) {
				Comparator<SungJukDTO> com = new Comparator<SungJukDTO>() {
					@Override
					public int compare(SungJukDTO s1, SungJukDTO s2) {
						//조건연산자 : 조건 ? 참 : 거짓;
						//return s1.getTot() > s2.getTot() ? 1 : -1; //숫자니까 직접 비교 가능, 오름차순
						return s1.getTot() > s2.getTot() ? -1 : 1; //내림차순
					}
				};
				
				Collections.sort(list, com); //Comparator로 정렬
				printArticle(); //출력
			}
		}//while
	}//sortArticle()
}