/*
10진수를 2진수, 8진수, 16진수로 변환하시오
단, java.lang.Integer 클래스 안의 메소드를 사용하시오
*/

class Jinsu {
	public static void main(String[] args) {
		int dec = 250;

		//Interger에서 2진수로 변환하는 메소드를 이용하여 2진수로 변환한 뒤 binary 변수로 저장한다.

		String binary = Integer.toBinaryString(dec);
		//java.lang.Integer.toBinaryString(int i) - static String
		String octal = Integer.toOctalString(dec);
		//java.lang.Integer.toOctalString(int i) - static String
		String hexa = Integer.toHexString(dec);
		//java.lang.Integer.toHexString(int i) - static String

		System.out.println("10진수 = " + dec);
		System.out.println("2진수 = " + binary);
		System.out.println("8진수 = " + octal);
		System.out.println("16진수 = " + hexa);
	}
}

/*
[실행결과]
D:\java_se\workspace\0722>javac Jinsu.java

D:\java_se\workspace\0722>java Jinsu
10진수 = 250
2진수 = 11111010
8진수 = 372
16진수 = fa
*/