package Constructor;

import java.text.DecimalFormat;
import java.util.Scanner;

public class SalaryService {
	private SalaryDTO[] ar; //필드에 인스턴스변수로 SalaryDTO클래스의 객체배열 ar 선언
	Scanner scan = new Scanner(System.in); //IOException할 필요 없음
	DecimalFormat df = new DecimalFormat(); //java.text.DecimalFormat
	
	public SalaryService(SalaryDTO[] ar) { //3. SalaryMain에서 자료형이 SalaryDTO[]인 ar의 주소값 왔음
										   //ar은 자료형이 SalaryDTO 클래스형인 객체 배열
		this.ar = ar; //4. ar 주소값 사라지기 전에 SalaryService 클래스(this.ar)에 주소값 전달
	}

	public void menu() { //메뉴함수 구현
		int num;		
		
		while(true) { //반복
			System.out.println();
	        System.out.println("********************");
	        System.out.println("     1. 사원 등록");
	        System.out.println("     2. 전체 출력");
	        System.out.println("     3. 사원 정보 수정");
	        System.out.println("     4. 퇴사");
	        System.out.println("     5. 끝내기");
	        System.out.println("********************");
	        System.out.print("     번호 : ");
			num = scan.nextInt();
			if(num==5) break;
			
			if(num==1) insertEmp(); //1번인 경우 insertEmp() 메소드 작성
			else if(num==2) display(); //2번인 경우 display() 메소드 작성
			else if(num==3) updateEmp(); //3번인 경우 updateEmp() 메소드 작성
			else if(num==4) deleteEmp(); //4번인 경우 deleteEmp() 메소드 작성
		}//while
	}

	public void insertEmp() { //1. 사원 등록
		int i;
		for(i=0; i<ar.length; i++) {
			if(ar[i]==null) break; //빈공간을 찾아라
		}
		
		if(i==ar.length) { //for문을 다 돌았음
			System.out.println("정원 초과..");
			return; //값을 돌려주면서 함수(메소드) insertMember를 벗어나라
		}
		
		ar[i] = new SalaryDTO(); //빈공간에 클래스 객체 생성
		ar[i].calc();
		
		System.out.println();
		System.out.println("등록 완료...");
	}
	
	public void display() { //2. 전체 출력
		System.out.println();
		System.out.println("사원번호\t이름\t직급\t기본급\t\t수당\t세율\t세금\t월급");
		for(int i=0; i<ar.length; i++) {
			if(ar[i] != null) { //null이 아닌 값(등록된 회원만)만 찍어라
				System.out.println(ar[i].getEmpId()+"\t"
		                         + ar[i].getName()+"\t"
		                         + ar[i].getPosition()+"\t"
		                         + df.format(ar[i].getBasePay())+"\t"
		                         + df.format(ar[i].getBenefit())+"\t"
		                         + (int)(ar[i].getTaxRate()*100)+"%\t"
		                         + df.format(ar[i].getTax())+"\t"
		                         + df.format(ar[i].getSalary()));
			}//if
		}//for	
	}
	
	private void updateEmp() {
		System.out.print("사원번호 입력 : ");
		int empId = scan.nextInt();
		
		int i;
		for(i=0; i<ar.length; i++) {
			if(ar[i] != null) { //null이 아닌 값(등록된 회원만)만 찍어라
				if(ar[i].getEmpId() == empId) break; //ar[i]에 저장된 값과 입력한 값이 같으면 나가라
				//empId 정수형이라서 equals를 사용하지 않아도 됨. 문자열만 equals를 사용해야 함
			}//if
		}//for
		
		if(i==ar.length) { //for문을 다 돌았음
			System.out.println("찾고자 하는 사원이 없습니다");
			return; //값을 돌려주면서 함수(메소드) updateMember를 벗어나라
		}
		
		System.out.println(ar[i].getEmpId()+"\t"
		                 + ar[i].getName()+"\t"
		                 + ar[i].getPosition()+"\t"
		                 + df.format(ar[i].getBasePay())+"\t"
		                 + df.format(ar[i].getBenefit())+"\t"
		                 + (int)(ar[i].getTaxRate()*100)+"%\t"
		                 + df.format(ar[i].getTax())+"\t"
		                 + df.format(ar[i].getSalary()));
   
		System.out.println();
	    System.out.print("수정할 사원명 입력 : ");
	    ar[i].setName(scan.next());
	    System.out.print("수정할 직급 입력 : ");
	    ar[i].setPosition(scan.next());
	    System.out.print("수정할 기본급 입력 : ");
	    ar[i].setBasePay(scan.nextInt());
	    System.out.print("수정할 수당 입력 : ");
	    ar[i].setBenefit(scan.nextInt());
	   
	    ar[i].calc();
	    
	    System.out.println();
	    System.out.println("수정 완료...");
	}
	
	public void deleteEmp() { // 4. 퇴사 //메소드(함수) 구현부는 순서 상관없음
	      System.out.print("사원 번호 입력 : ");
	      int empId = scan.nextInt();
	      
	      int i;
	      for(i=0; i<ar.length; i++) {
	         if(ar[i] != null) { //데이터값이 null이 아니면 등록된 회원임
	            if(ar[i].getEmpId() == empId) break; //ar[i]에 저장된 값과 입력한 값이 같으면 나가라
	         }//if
	      }//for
	      
	      if(i==ar.length) { //i==ar.length가 되었다는 의미는 for문 반복을 끝까지 해도 찾고자 하는 값이 없었다는 뜻 
	         System.out.println("찾고자 하는 회원이 없습니다");
	         return;
	      } 
	         ar[i] = null; //구한 i값에 저장된 데이터를 초기화하라
	         System.out.println();
	         System.out.println("삭제 완료...");
	}
}
