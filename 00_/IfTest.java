/*
★ if
1. if(조건) A;			- if(조건)이 true일 때 A -> B -> C (프로그램은 절차식이므로 밑으로 내려간다.)
   B;					- if(조건)이 false일 때 B -> C
   C;

2. if(조건) A;			- if(조건)이 true일 때 A -> C
   else B;				- if(조건)이 false일 때 B -> C
   C;

3. if(조건1) A;			- if(조건1)이 true일 때 A
   else if(조건2) B;		- if(조건2)이 true일 때 B
   else if(조건3) C;		- if(조건3)이 true일 때 C
   else if(조건4) D;		- if(조건4)이 true일 때 D
   else E;				- fals일 때 E
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class IfTest {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("데이터 입력 : ");
		int a = Integer.parseInt(br.readLine());
      
		if(a>=50) System.out.println(a + "는 50보다 크거나 같다"); 
		System.out.println(a + "는 50보다 작다");
		System.out.println();	

		if(false) //if 조건이 거짓이면 다음값 수행
			if(false) System.out.println("A");
			else System.out.println("B");
		System.out.println("C"); //C
		System.out.println();

		if(true) //if 조건이 참이면 ;(세미콜론)앞의 값을 수행하고 다음값 수행
			if(true) System.out.println("A"); //if 조건이 참이면 ;(세미콜론)앞의 값을 수행하고 다음값 수행
			else System.out.println("B");
		System.out.println("C"); //A C
		System.out.println();

		if(true) //if 조건이 참이면 ;(세미콜론)앞의 값을 수행하고 다음값 수행
			if(false) System.out.println("A"); //if 조건이 거짓이면 else 뒤의 값을 수행하고 다음값 수행
			else System.out.println("B");
		System.out.println("C"); //B C
		System.out.println();

		if(a%2!=0) System.out.println(a+"는 홀수"); //!= 같지 않다
		else System.out.println(a+"는 짝수");
		System.out.println();

		if(a>='A' && a<='Z')
			System.out.println((char)a+"는 대문자"); //65~90
		else if(a>='a' && a<='z')
			System.out.println((char)a+"는 소문자"); //97~122
		else
			System.out.println((char)a+"는 숫자이거나 특수문자");
   }
}

/*
[실행결과]
D:\java_se\workspace\0723>javac IfTest.java

D:\java_se\workspace\0723>java IfTest
데이터 입력 : 43
43는 50보다 작다

C

A
C

B
C

43는 홀수

+는 숫자이거나 특수문자
*/