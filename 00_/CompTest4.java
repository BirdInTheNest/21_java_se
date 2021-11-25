/*
[문제] CompTest4
char ch = 'T';  또는 char ch = 'e';

ch에 들어있는 값이 대문자(A~Z)이면 소문자로 바꾸어서 출력
대문자가 아니면(소문자 인식, a~z) 대문자로 바꾸어서 출력

[실행결과]
T → t         또는    e → E
*/

class CompTest4 {
	public static void main(String[] args) {
		char ch = 'T'; 

		//ch변수에 들어온 데이터가 대문자인가?
		//A ~ Z (65 ~ 90), a ~ z (97 ~ 122)

		//ch>=65 && ch<=90 ? - 가능하지만, 알아보기 쉽게 처리하는 게 좋다.
		int result = ch>='A' && ch<='Z' ? ch+32 : ch-32; //정수로 출력되기 때문에 형변환 필요
		System.out.println(ch + " → " + (char)result); 
	}
}

/*
[실행결과]
D:\java_se\workspace\0722>javac CompTest4.java

D:\java_se\workspace\0722>java CompTest4
T → t
*/