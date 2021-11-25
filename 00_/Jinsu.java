/*
10������ 2����, 8����, 16������ ��ȯ�Ͻÿ�
��, java.lang.Integer Ŭ���� ���� �޼ҵ带 ����Ͻÿ�
*/

class Jinsu {
	public static void main(String[] args) {
		int dec = 250;

		//Interger���� 2������ ��ȯ�ϴ� �޼ҵ带 �̿��Ͽ� 2������ ��ȯ�� �� binary ������ �����Ѵ�.

		String binary = Integer.toBinaryString(dec);
		//java.lang.Integer.toBinaryString(int i) - static String
		String octal = Integer.toOctalString(dec);
		//java.lang.Integer.toOctalString(int i) - static String
		String hexa = Integer.toHexString(dec);
		//java.lang.Integer.toHexString(int i) - static String

		System.out.println("10���� = " + dec);
		System.out.println("2���� = " + binary);
		System.out.println("8���� = " + octal);
		System.out.println("16���� = " + hexa);
	}
}

/*
[������]
D:\java_se\workspace\0722>javac Jinsu.java

D:\java_se\workspace\0722>java Jinsu
10���� = 250
2���� = 11111010
8���� = 372
16���� = fa
*/