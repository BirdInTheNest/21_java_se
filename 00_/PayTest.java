/*
이름이 L(name)인 사람의 기본급(basePay)이 2500000일때 3.3% 세금(tax)과 월급(salary)을 계산하시오

세금 = 기본급 * 3.3%(0.033)
월급 = 기본급-세금
		
[실행결과]
*** L의 월급 ***
기본급 : 2500000원
세금   : 82500원
월급   : 2417500원
*/

import java.text.DecimalFormat;
//import java.lang.String; -기본형은 알아서 처리하기 때문에 import하지 않아도 됨.

class PayTest {
	public static void main(String[] args) {
		char name = 'L'; //L로 쓰면 변수로 읽기 때문에 'L'로 써야함
		//'a' : 97값을 가진 문자, "a" : 문자열, a : 변수, a() : 함수
		//String name = "L";

		int basePay = 2500000;
		//double tax = basePay * 0.033; - int * double은 double값이 나오므로 형변환 필요.
		int tax = (int)(basePay * 0.033);
		int salary = basePay - tax; 

		//숫자 3자리마다 ,를 표시
		DecimalFormat decimalFormat = new DecimalFormat();
		//클래스의 변수명은 클래스와 이름이 같되 소문자로 시작, 객체형은 new 선언해야 함
		
		System.out.println("*** " + name + "의 월급 ***");
		System.out.println("기본급 : " + decimalFormat.format(basePay) + "원");
		//System.out.println("세금   : " + (int)(tax) + "원");
		System.out.println("세금   : " + decimalFormat.format(tax) + "원");
		System.out.println("월급   : " + decimalFormat.format(salary) + "원");
	}
}
