/*
원하는 단을 입력 : 7		생성자
--------------------------
7*1=7				display()
7*2=14
...
7*9=63
 */

package class_;

import java.util.Scanner;

public class StringBufferMain {
	private int dan; //필드
	
	public StringBufferMain() { //생성자 메소드 - 입력
		Scanner scan = new Scanner(System.in); 
		System.out.print("원하는 단을 입력 : ");
		dan = scan.nextInt();		
	}

	public void display() { //display() 메소드 - 출력
		StringBuffer buffer = new StringBuffer(); //StringBuffer은 리터럴 생성할 수 없고, new로 생성해야함
		for(int i=1; i<=9; i++) {
			//System.out.println(dan+"*"+i+"="+(dan*i));
			
			buffer.append(dan); //기존문자열 끝에 추가, 앞의 문자열을 지우지 않음
			buffer.append("*");
			buffer.append(i);
			buffer.append("=");
			buffer.append(dan*i);
			
			System.out.println(buffer.toString()); //StringBuffer -> String 변환
			buffer.delete(0, buffer.length()); //buffer.delete(0,5): 0번부터 5번 이전까지 삭제
		}//for
	}
	
	public static void main(String[] args) {
		StringBufferMain main = new StringBufferMain(); //StringBufferMain 클래스의 객체 main과 생성자 생성
		main.display(); //객체 main의 display 함수 호출
	}
}

/*
★ String 
1. 문자열
2. literal("") 생성 가능
3. 문자열 편집(수정)을 할 수 없다.
4. 비교시 == 사용하면 reference(참조값)을 비교한다
   equals() 사용하면 문자열의 내용을 비교한다.

※ 문자열 자체가 reference(참조값) 이다.
※ 똑같은 내용의 문자열 리터럴은 메모리에 1번만 생성된다.
   new는 할 때마다 메모리에 생성된다
------------------------------------------------
★ StringBuffer / StringBuilder
1. 문자열
2. 문자열 편집이 가능

입출력할때는 String, 계산할 때는 StringBuffer 사용
------------------------------------------------------------
buffer ---> "7*1=7"
		 	 01234
buffer ---> ""			buffer.delete(0,5): 0번부터 5번 이전까지
						buffer.delete(0, buffer.length());
-------------------------------------------------------------
[실행결과]
원하는 단을 입력 : 7
7*1=7
7*2=14
7*3=21
7*4=28
7*5=35
7*6=42
7*7=49
7*8=56
7*9=63
*/