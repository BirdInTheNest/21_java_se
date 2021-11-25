/*
변수를 이용하여 320, 258의 합,차,곱,몫을 구하시오

[실행결과]
320 + 258 = 578 (sum)
320 - 258 = 62 (sub)
320 * 258 = 82560 (mul)
320 / 258 = 1.24 (div)
*/

class CalcTest {
	public static void main(String[] args) {
		short a = 320; //정수형 - short (2byte) → -32768 ~ +32767
		short b = 258;
		//short sum = a + b; //자바는 char, byte, short 끼리 계산한 결과값을 항상 int로 내보냄
		
		int sum = a + b; //정수형 - int (4byte) 
		int sub = a - b;
		int mul = a * b;
		//int div = String.format("%.2f",(a / b)); - 오답
		double div = (double)a / b; //한쪽이 double 8byte가 되면 int 4byte를 사용하지 못함.

		System.out.println(a + " + " + b + " = " + sum);
		System.out.println(a + " - " + b + " = " + sub);
		System.out.println(a + " * " + b + " = " + mul);
		System.out.println(a + " / " + b + " = " + String.format("%.2f", div));
		System.out.printf("%d / %d = %.2f\n", a, b, div);
	}
}

/*
[실행결과]
D:\java_se\workspace\0720>javac CalcTest.java

D:\java_se\workspace\0720>java CalcTest
320 + 258 = 578
320 - 258 = 62
320 * 258 = 82560
320 / 258 = 1.24
320 / 258 = 1.24
*/