/*
수학점수(score) 80~100이면 합격
조건 : 80 <= score <= 100		-> 변수 하나, 연산자 하나로 분리해야 함
score >= 80 && score <= 100		-> 변수가 왼쪽으로 와야 함.


* 논리연산자 : 조건이 2개 이상 존재할 때
&& (AND), & (AND) : 모든 조건이 참일 때 성립
|| (OR), | (OR)  : 조건 중에서 하나만 참이어도 성립

&& (AND), || (OR) : 첫 번째 값이 F일때 두 번째 값을 계산하지 않음 -> 처리속도가 빠름
& (AND), | (OR) : 첫 번째 값이 F여도, 두 번째 값을 계산함 -> 처리속도가 느림
*/

class CompTest {
	public static void main(String[] args) {
		int score = 85;
		//조건 ? 참 : 거짓;
		//score>=80 && score<=100 ? "합격" : "불합격"; - error: not a statement

		/*
		[해결방법]
		1. String result = score>=80 && score<=100 ? "합격" : "불합격";
		2. System.out.printin(score>=80 && score<=100 ? "합격" : "불합격";)
		*/

		String result = score>=80 && score<=100 ? "합격" : "불합격";
		System.out.println("결과 = " + result);
	}
}
