/*
������ �̿��Ͽ� 320, 258�� ��,��,��,���� ���Ͻÿ�

[������]
320 + 258 = 578 (sum)
320 - 258 = 62 (sub)
320 * 258 = 82560 (mul)
320 / 258 = 1.24 (div)
*/

class CalcTest {
	public static void main(String[] args) {
		short a = 320; //������ - short (2byte) �� -32768 ~ +32767
		short b = 258;
		//short sum = a + b; //�ڹٴ� char, byte, short ���� ����� ������� �׻� int�� ������
		
		int sum = a + b; //������ - int (4byte) 
		int sub = a - b;
		int mul = a * b;
		//int div = String.format("%.2f",(a / b)); - ����
		double div = (double)a / b; //������ double 8byte�� �Ǹ� int 4byte�� ������� ����.

		System.out.println(a + " + " + b + " = " + sum);
		System.out.println(a + " - " + b + " = " + sub);
		System.out.println(a + " * " + b + " = " + mul);
		System.out.println(a + " / " + b + " = " + String.format("%.2f", div));
		System.out.printf("%d / %d = %.2f\n", a, b, div);
	}
}

/*
[������]
D:\java_se\workspace\0720>javac CalcTest.java

D:\java_se\workspace\0720>java CalcTest
320 + 258 = 578
320 - 258 = 62
320 * 258 = 82560
320 / 258 = 1.24
320 / 258 = 1.24
*/