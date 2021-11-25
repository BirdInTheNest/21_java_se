/*
치환하는 프로그램을 작성하시오 - indexOf(), replace()
String 클래스의 메소드를 이용하시오
대소문자 상관없이 개수를 계산하시오

[실행결과]
문자열 입력 : aabba
현재 문자열 입력 : aa
바꿀 문자열 입력 : dd
ddbba
1번 치환
----------------
문자열 입력 : aAbbA
현재 문자열 입력 : aa
바꿀 문자열 입력 : dd
ddbba
1번 치환
----------------
문자열 입력 : aabbaa
현재 문자열 입력 : aa
바꿀 문자열 입력 : dd
ddbbdd
2번 치환
----------------
문자열 입력 : AAccaabbaaaaatt
현재 문자열 입력 : aa
바꿀 문자열 입력 : dd
ddccddbbddddatt
4개 치환
----------------
문자열 입력 : aabb
현재 문자열 입력 : aaaaa
바꿀 문자열 입력 : ddddd
입력한 문자열의 크기가 작습니다
치환 할 수 없습니다
 */

package class_;

import java.util.Scanner;

public class StringMain2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int index = 0; //0번부터 위치 찾기
		int count = 0;
		
		System.out.print("문자열 입력 : ");
		String str = scan.next().toLowerCase();
		
		System.out.print("현재 문자열 입력 : ");
		String target = scan.next().toLowerCase();
		
		System.out.print("바꿀 문자열 입력 : ");
		String replacing = scan.next();
		 
		if(str.length() < target.length())
			System.out.println("입력한 문자열의 크기가 작습니다");
		else {
			while( (index = str.indexOf(target, index)) != -1) { //-1이 되기 전까지 반복. -1이 되면 찾는 값이 없다는 뜻
				//index = 문자열 str에서 target 문자열을 index 위치에서부터 시작하여 검색한 값
				count++;
				index += target.length(); //문자열 검색 시작위치는 target 문자열의 길이만큼 더해야 함
			}//while
				
			System.out.println(str.replace(target, replacing));
			System.out.println(count+"개 치환");
		}	
	}
}

/*
str --> "aabbccaahh"	target--> "aa"	replacing --> "gg"
		 0123456789
str.indexOf(str, 0) -> 시작위치 0번 //0위치에서 찾음		str.indexOf(str, index)
str.indexOf(str, 2) -> 시작위치 2번 //6위치에서 찾음		str.indexOf(str, index+target.length())
str.indexOf(str, 8) -> 시작위치 8번
 */

