/*
금액(money)이 5679원일때 다음과 같이 출력하시오

[실행결과]
금액 : 5679원
천원 : 5장
백원 : 6개
십원 : 7개
일원 : 9개
 */

class Money {
	public static void main(String[] args) {
		int money = 5679;
		int thousand = money / 1000; //5 (ex. 25/3 = 8 : 몫을 나타냄, 25%3 = 1 : 나머지를 나타냄)
		int hundred = money % 1000 / 100; //6, % (나머지 연산자) - 반드시 양쪽의 항이 정수형이어야 한다.
		int ten = money % 1000 % 100 / 10; //7
		int one = money % 1000 % 100 % 10; //9

		System.out.println("금액 : " + money + "원");
		System.out.println("천원 : " + thousand + "장");
		System.out.println("백원 : " + hundred + "개");
		System.out.println("십원 : " + ten + "개");
		System.out.println("일원 : " + one + "개");
	}
}