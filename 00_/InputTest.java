/*
* �ܼ� (�ܼ��� �������ִ� Ŭ����: System)
- �Է� : Ű����� �Է�(System.in) -> ���������� ����
- ��� : ����� ȭ������ ���(System.out)

error - IOException ����ó�� : ����ġ�� ���� �Ͽ� ����϶� (�������� �� �߻� - ���� �ʿ� : throws IOException)		
error - ArrayIndexOutOfBoundsException (������ �� �߻� - �����ڰ� �Ǽ����� �� �߻�)

* ����(�ΰ��� ����) : �����ٷ� �������� \n 13, �� ������ �̵� \r 10 
*/

import java.io.IOException;

class InputTest {
	public static void main(String[] args) throws IOException { 
		System.out.print("������ : ");
		int a = System.in.read(); //1�� ���ڸ� �Է¹���

		System.in.read(); //flush ���ۿ� ���� ���Ͱ�(13) ����
		System.in.read(); //flush ���ۿ� ���� ���Ͱ�(10) ����

		System.out.print("������ : ");
		int b = System.in.read(); //1�� ���ڸ� �Է¹���

		System.out.println("��� = " + a + ", " + b);
	}
}

/*
[������]
D:\java_se\workspace\0723>javac InputTest.java

D:\java_se\workspace\0723>java InputTest
������ : a
������ : A
��� = 97, 65

D:\java_se\workspace\0723>java InputTest
������ : 0
������ : abc
��� = 48, 97
*/