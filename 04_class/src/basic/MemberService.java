package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MemberService {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	MemberDTO[] ar = new MemberDTO[5]; //객체배열 생성. 나중에 클래스를 객체로 생성해야함
	
	public void menu() throws IOException{ //메뉴함수 구현
		int num;		
		
		while(true) { //반복
			System.out.println();
	        System.out.println("********************");
	        System.out.println("     1. 가입");
	        System.out.println("     2. 출력");
	        System.out.println("     3. 수정");
	        System.out.println("     4. 탈퇴");
	        System.out.println("     5. 끝내기");
	        System.out.println("********************");
	        System.out.print("     번호 : ");
			num = Integer.parseInt(br.readLine());
			if(num==5) break;
			
			if(num==1) insertMember();
			else if(num==2) list();
			else if(num==3) updateMember();
			else if(num==4) deleteMember();
		}//while
	}
	
	public void insertMember() throws IOException { //1. 가입
		int i;
		for(i=0; i<ar.length; i++) {
			if(ar[i]==null) break; //빈공간을 찾아라
		}
		
		if(i==ar.length) { //for문을 다 돌았음
			System.out.println("정원 초과..");
			return; //값을 돌려주면서 함수(메소드) insertMember를 벗어나라
		}
		
		ar[i] = new MemberDTO(); //빈공간에 클래스 객체 생성
		
		System.out.print("이름 입력 : ");
		ar[i].setName(br.readLine());
		System.out.print("나이 입력 : ");
		ar[i].setAge(Integer.parseInt(br.readLine()));
		System.out.print("핸드폰 입력 : ");
		ar[i].setPhone(br.readLine());
		System.out.print("주소 입력 : ");
		ar[i].setAddress(br.readLine());
		
		int count=0;
		for(i=0; i<ar.length; i++) {
			if(ar[i] == null) count++;
		}
		System.out.println();
		System.out.println("등록 완료...");
		System.out.println(count+"자리가 남았습니다");
	}
	
	public void list() { //2. 출력 -> 총 5명중에서 등록된 회원만 보여준다
		System.out.println();
		System.out.println("이름\t나이\t핸드폰\t\t주소");
		for(int i=0; i<ar.length; i++) {
			if(ar[i] != null) { //null이 아닌 값(등록된 회원만)만 찍어라
				System.out.println(ar[i].getName()+"\t"
                        + ar[i].getAge()+"\t"
                        + ar[i].getPhone()+"\t"
                        + ar[i].getAddress());
			}
		}	
	}
	
	public void updateMember() throws IOException{ //3. 수정
		System.out.print("팬드폰 번호 입력 : ");
		String phone = br.readLine();
		
		int i;
		for(i=0; i<ar.length; i++) {
			if(ar[i] != null) { //null이 아닌 값(등록된 회원만)만 찍어라
				if(ar[i].getPhone().equals(phone)) break; //ar[i]에 저장된 값과 입력한 값이 같으면 나가라
			}//if
		}//for
		
		if(i==ar.length) { //for문을 다 돌았음
			System.out.println("찾고자 하는 회원이 없습니다");
			return; //값을 돌려주면서 함수(메소드) updateMember를 벗어나라
		}
		
		System.out.println(ar[i].getName()+"\t"
                + ar[i].getAge()+"\t"
                + ar[i].getPhone()+"\t"
                + ar[i].getAddress());
   
	    System.out.print("수정할 이름 입력 : ");
	    ar[i].setName(br.readLine());
	    System.out.print("수정할 나이 입력 : ");
	    ar[i].setAge(Integer.parseInt(br.readLine()));
	    System.out.print("수정할 핸드폰 입력 : ");
	    ar[i].setPhone(br.readLine());
	    System.out.print("수정할 주소 입력 : ");
	    ar[i].setAddress(br.readLine());
	   
	    System.out.println();
	    System.out.println("수정 완료...");
	}
	
	public void deleteMember() throws IOException { // 4. 탈퇴 //메소드(함수) 구현부는 순서 상관없음
	      System.out.print("핸드폰 번호 입력 : ");
	      String phone = br.readLine();
	      
	      int i;
	      for(i=0; i<ar.length; i++) {
	         if(ar[i] != null) { //데이터값이 null이 아니면 등록된 회원임
	            if(ar[i].getPhone().equals(phone)) break; //ar[i]에 저장된 값과 입력한 값이 같으면 나가라
	         }//if
	      }//for
	      
	      if(i==ar.length) { //i==ar.length가 되었다는 의미는 for문 반복을 끝까지 해도 찾고자 하는 값이 없었다는 뜻 
	         System.out.println("찾고자 하는 회원이 없습니다");
	         
	      }else { //구한 i값에 저장된 데이터를 초기화하라
	         ar[i] = null;
	         System.out.println("탈퇴 완료...");
	      }
	}
}