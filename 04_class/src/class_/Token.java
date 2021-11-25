package class_;

import java.util.StringTokenizer;

public class Token {

	public static void main(String[] args) {
		String str = "학원,집,,게임방";
											
		StringTokenizer st = new StringTokenizer(str, ","); //StringTokenizer 클래스의 객체 st 생성 
															//문자열 str을 ,을 기준으로 분리하라
		System.out.println("토큰 개수 = "+ st.countTokens()); //3개 - "학원","집","게임방"
		 
		while(st.hasMoreTokens()) { //hasMoreTokens() - 현재 위치에 토큰이 있으면(T), 없으면(F)
			System.out.println(st.nextToken()); //nextToken() - 토큰을 꺼내고 다음 위치로 이동
		}//while - 조건이 참인 경우 반복
		System.out.println("------------------------------");
		
		String[] ar = str.split(","); //String형 배열 생성
		for(String data : ar) {
			System.out.println(data);
		}
	}  
}

/*
★ StringTokenizer(java.util)클래스와 String클래스의 split()
1. 문자열을 분리할 때 사용 (문자열, 기준문자) - 문자열을 기준문자를 기준으로 분리하라.
2. 분리된 문자열을 Token이라고 한다.
3. StringTokenizer는 비어있는 값은 무시하고 split()는 비어있는 값도 인식한다.
---------------------------------------------------------------
StringTokenizer				String클래스의 split()
"학원"						"학원"
"집"							"집"
"게임방"						""
							"게임방"
---------------------------------------------------------------
배열.length : 명령어
문자열.length() : 메소드
---------------------------------------------------------------
hasMoreTokens() - 현재 위치에 토큰이 있으면(T), 없으면(F)		
nextToken() - 토큰을 꺼내고 다음 위치로 이동					
*/

/*
[실행결과]
토큰 개수 = 3
학원
집
게임방
------------------------------
학원
집

게임방
*/