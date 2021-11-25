package class_;

public class StringMain {

	public static void main(String[] args) {
		String a = "apple"; //String은 문자열 리터럴 생성이 가능하다. new로 생성하지 않아도 됨. 
		String b = "apple"; //똑같은 문자열 리터럴은 메모리에 1번만 생성된다
		if(a == b) System.out.println("a와 b의 참조값은 같다"); //주소값 비교
		else System.out.println("a와 b의 참조값은 다르다");
		
		if(a.equals(b)) System.out.println("a와 b의 문자열은 같다");
		else System.out.println("a와 b의 문자열은 다르다");
		System.out.println(); 
		
		String c = new String("apple"); //new로 생성하면 메모리에 매번 잡음, 주소값 다름
		String d = new String("apple");
		if(c == d) System.out.println("c와 d의 참조값은 같다"); //주소값 비교
		else System.out.println("c와 d의 참조값은 다르다");
		
		if(c.equals(d)) System.out.println("c와 d의 문자열은 같다");
		else System.out.println("c와 d의 문자열은 다르다");
		System.out.println();
		
		String e = "오늘 날짜는 " + 1991 + 7 + 16; //문자열은 수정이 불가능
		System.out.println("e = "+e);
		System.out.println("문자열 크기 = " + e.length()); //14
		
		System.out.println("첫번째 문자 = " + e.charAt(0));
		System.out.println("두번째 문자 = " + e.charAt(1));
		System.out.println("마지막 문자 = " + e.charAt(13));
		
		System.out.println("부분 문자열 추출=" + e.substring(7));
		System.out.println("부분 문자열 추출=" + e.substring(7,11)); //1991	-7번 위치부터 11번 이전까지
		
		System.out.println("대문자 변경 = " + "Hello".toUpperCase());
		System.out.println("소문자 변경 = " + "Hello".toLowerCase());
		
		System.out.println("문자열 검색 = " + e.indexOf("짜")); //4 이 문자열은 4번째 위치에 있다
		System.out.println("문자열 검색 = " + e.indexOf("날짜")); //3
		System.out.println("문자열 검색 = " + e.indexOf("개바부")); //-1 이 문자열은 없다
		System.out.println("문자열 검색 = " + e.indexOf("1")); //7
		System.out.println("문자열 검색 = " + e.indexOf("1",0));
		System.out.println("문자열 검색 = " + e.indexOf("1",8));
		
		System.out.println("문자열 치환 = " + e.replace("날짜", "일자"));
		
	}
}

/*
문자열은 편집이 안되므로 메모리 4번 생성된다
JVM에 의해서 삭제 시 Garbage Collector로 보낸다
Garbage Collector가 실행(휴지통 비우기)되면 컴퓨터는 멈춘다

"오늘 날짜는 "
"오늘 날짜는 1991"
"오늘 날짜는 19917"
        012      789 //문자열에는 index값이 있다
e ---> "오늘 날짜는 1991716"
 */

/*
* 상수(Constant) - 변하지 않는 값
 숫자 상수 : 25
 문자 상수 : 'A'(65), 'a'(97), '0'(48)
 
* 리터럴(Literal) - 데이터 종류
1. 정수형 리터럴 : 25, 16, -125
2. 실수형 리터럴 : 25.6, -43.8
3. 문자형 리터럴 : 'A', 'a', '0'
4. 문자열 리터럴 : "A", "a", "0"

new 연산자를 쓰면 무조건 메모리에 계속 생성된다.
싱글톤 : 한번 만들어놓고 계속 사용하겠다. -DB
 */

/*
[실행결과]
a와 b의 참조값은 같다
a와 b의 문자열은 같다

c와 d의 참조값은 다르다
c와 d의 문자열은 같다

e = 오늘 날짜는 1991716
문자열 크기 = 14
첫번째 문자 = 오
두번째 문자 = 늘
마지막 문자 = 6
부분 문자열 추출=1991716
부분 문자열 추출=1991
대문자 변경 = HELLO
소문자 변경 = hello
문자열 검색 = 4
문자열 검색 = 3
문자열 검색 = -1
문자열 검색 = 7
문자열 검색 = 7
문자열 검색 = 10
문자열 치환 = 오늘 일자는 1991716

*/