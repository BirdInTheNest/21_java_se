/*
[문제] CompTest3
int num = 25;  또는 int num = 80;

[실행결과]
25는 홀수이다     또는 80는 짝수이다
*/

class CompTest3{
	public static void main(String[] args) {
		int num = 83;
		//num에 들어있는 데이터가 짝수인가?
		//num에 들어있는 데이터가 2의 배수?
		//num에 들어있는 데이터가 2로 나누었을 때 나머지가 0이냐?
		
		String result = num%2 == 0 ? "짝수이다" : "홀수이다"; //== 같다, 문자열 - String
		System.out.println(num + "는 " + result);
	}
}

/*
[실행결과]
D:\java_se\workspace\0722>javac CompTest3.java

D:\java_se\workspace\0722>java CompTest3
83는 홀수이다
*/