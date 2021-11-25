/*
★ switch (switch는 조건이 아니라, 값을 나열한 것임)
: 실수형 타입은 쓸 수 없다
: break 는 switch를 벗어나라 -> break;가 없으면 순서대로 수행함

[형식]					
 switch(정수 or 문자 or 문자열 or 식) {
 case 값1: break;
 case 값2: break;
 case 값3: break;
 default :
 }
*/

package switch_;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SwitchTest {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("월 입력 : ");
		int month = Integer.parseInt(br.readLine());
		int days=0;

		switch(month){
			case 1 : 
			case 3 : 
			case 5 : 
			case 7 : 
			case 8 : 
			case 10 : 
			case 12 : days=31; break;
			
			case 2 : days=28; break;
			
			case 4 :
			case 6 : 
			case 9 :
			case 11 : days=30; break;
		}

		System.out.println(month+"월은 "+days+"일 입니다");
	}
}

/*
[실행결과]
D:\java_se\workspace\0723>javac SwitchTest.java

D:\java_se\workspace\0723>java SwitchTest
월 입력 : 2
2월은 28일 입니다

D:\java_se\workspace\0723>java SwitchTest
월 입력 : 5
5월은 31일 입니다

D:\java_se\workspace\0723>java SwitchTest
월 입력 : 11
11월은 30일 입니다
*/