class NumberTest {
	public static void main(String[] args){
		System.out.println(" 'A' + 3 = " + ('A' + 3)); //문자는 값이 있고 'A' - 65 -> 'A' + 3 = 68
		System.out.println(" \"A\" + 3 = " + ("A" + 3)); //문자열은 값이 없다 "A" - 65(x) -> "A" + 3 = "A3"
		System.out.println(" \"A + 3 = " + ("A" + 3)); //"를 표시하고자 할 때는 \"로 표시하면 된다.
		System.out.println(" 'a' - 32 = " + ('a'-32)); //65 ('a' - 97)
		System.out.println(" 'a' - 32 = " + (char)('a'-32)); //A, 형변환(Casting)
		System.out.println("25 / 3 = " + (25/3)); //정수/정수=정수
		System.out.println("25. / 3 = " + (25./3)); //실수/정수=실수
		System.out.println("(double)25 / 3 = " + ((double)25/3)); //실수/정수=실수
		System.out.println("25. / 3 = " + String.format("%.2f", 25./3)); //소수점 둘째자리까지 표시
		System.out.printf("25. / 3 = %.2f\n",(25./3)); //C언어 문법, f ; format, \n ; next line
	}
}

/*
자바와 C언어는 정수나 실수냐를 따짐 (ex.정수/정수=정수 ->25/3=8)
(double)은 실수로 변환해주는 형변환

String.format
정수 - %d
실수 - %f
문자 - %c
문자열 - %s
*/


/*
[실행결과]
D:\java_se\workspace\0721>javac NumberTest.java

D:\java_se\workspace\0721>java NumberTest
 'A' + 3 = 68
 "A" + 3 = A3
 "A + 3 = A3
 'a' - 32 = 65
 'a' - 32 = A
25 / 3 = 8
25. / 3 = 8.333333333333334
(double)25 / 3 = 8.333333333333334
25. / 3 = 8.33
25. / 3 = 8.33
*/