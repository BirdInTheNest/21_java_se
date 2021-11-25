/*
* 콘솔 (콘솔을 관리해주는 클래스: System)
- 입력 : 키보드로 입력(System.in) -> 정수형으로 받음
- 출력 : 모니터 화면으로 출력(System.out)

error - IOException 예외처리 : 생각치도 않은 일에 대비하라 (컴파일할 때 발생 - 보험 필요 : throws IOException)		
error - ArrayIndexOutOfBoundsException (실행할 때 발생 - 개발자가 실수했을 때 발생)

* 엔터(두가지 동작) : 다음줄로 내려간다 \n 13, 맨 앞으로 이동 \r 10 
*/

import java.io.IOException;

class InputTest {
	public static void main(String[] args) throws IOException { 
		System.out.print("데이터 : ");
		int a = System.in.read(); //1개 문자만 입력받음

		System.in.read(); //flush 버퍼에 남는 엔터값(13) 제거
		System.in.read(); //flush 버퍼에 남는 엔터값(10) 제거

		System.out.print("데이터 : ");
		int b = System.in.read(); //1개 문자만 입력받음

		System.out.println("결과 = " + a + ", " + b);
	}
}

/*
[실행결과]
D:\java_se\workspace\0723>javac InputTest.java

D:\java_se\workspace\0723>java InputTest
데이터 : a
데이터 : A
결과 = 97, 65

D:\java_se\workspace\0723>java InputTest
데이터 : 0
데이터 : abc
결과 = 48, 97
*/