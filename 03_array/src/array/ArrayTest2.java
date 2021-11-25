package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayTest2 {

	public static void main(String[] args) throws IOException {
		
		for(int i=0; i<args.length; i++) { 
			System.out.println("args["+i+"] = "+args[i]); //args[i] 생성
			System.out.println("args["+i+"] 문자열 크기 = "+args[i].length());	//String의 유니코드 수	
			System.out.println("args["+i+"] 첫번째 문자 = "+args[i].charAt(0));	
			System.out.println("args["+i+"] 두번째 문자 = "+args[i].charAt(1));	
			System.out.println();
		}//for i
		System.out.println();
		
		System.out.println("확장 for");
		for(String data : args) {
			System.out.println(data);
			System.out.println("문자열 크기 = "+data.length());		
			System.out.println("첫번째 문자 = "+data.charAt(0));	
			System.out.println();
		}//for data
		System.out.println();
		
		/*
		문자열을 입력받아서 가운데 위치한 문자를 출력하시오
		
		[실행결과]
		문자열 입력 : 코끼리		문자열 입력 : 바다코끼리		문자열 입력 : 나무늘보
		가운데 문자 = 끼		가운데 문자 = 코			가운데 문자 = 늘
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("문자열 입력 : ");
		String str = br.readLine();
		
		int index = str.length()/2; //세글자 3/2=1 : args[1], 다섯글자 5/2=2 : args[2] -> 가운데 문자
		
		System.out.println("가운데 문자 = "+str.charAt(index));
	}
}

/*
javac ArrayTest2.java
java ArraTest2 호랑이 사자

Eclipse에서 데이터 입력부분 하는 법:
우클릭 - Rus As - Run Configurations - Arguments
Name이 클래스명이 맞는지 확인 후 Program arguments에 입력

[실행결과]
args[0] = 바다코끼리
args[0] 문자열 크기 = 5
args[0] 첫번째 문자 = 바
args[0] 두번째 문자 = 다

args[1] = 사자
args[1] 문자열 크기 = 2
args[1] 첫번째 문자 = 사
args[1] 두번째 문자 = 자

args[2] = 개미핥기
args[2] 문자열 크기 = 4
args[2] 첫번째 문자 = 개
args[2] 두번째 문자 = 미


확장 for
바다코끼리
문자열 크기 = 5
첫번째 문자 = 바

사자
문자열 크기 = 2
첫번째 문자 = 사

개미핥기
문자열 크기 = 4
첫번째 문자 = 개


문자열 입력 : 나무늘보
가운데 문자 = 늘
*/