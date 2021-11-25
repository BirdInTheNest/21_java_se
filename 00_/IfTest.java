/*
�� if
1. if(����) A;			- if(����)�� true�� �� A -> B -> C (���α׷��� �������̹Ƿ� ������ ��������.)
   B;					- if(����)�� false�� �� B -> C
   C;

2. if(����) A;			- if(����)�� true�� �� A -> C
   else B;				- if(����)�� false�� �� B -> C
   C;

3. if(����1) A;			- if(����1)�� true�� �� A
   else if(����2) B;		- if(����2)�� true�� �� B
   else if(����3) C;		- if(����3)�� true�� �� C
   else if(����4) D;		- if(����4)�� true�� �� D
   else E;				- fals�� �� E
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class IfTest {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("������ �Է� : ");
		int a = Integer.parseInt(br.readLine());
      
		if(a>=50) System.out.println(a + "�� 50���� ũ�ų� ����"); 
		System.out.println(a + "�� 50���� �۴�");
		System.out.println();	

		if(false) //if ������ �����̸� ������ ����
			if(false) System.out.println("A");
			else System.out.println("B");
		System.out.println("C"); //C
		System.out.println();

		if(true) //if ������ ���̸� ;(�����ݷ�)���� ���� �����ϰ� ������ ����
			if(true) System.out.println("A"); //if ������ ���̸� ;(�����ݷ�)���� ���� �����ϰ� ������ ����
			else System.out.println("B");
		System.out.println("C"); //A C
		System.out.println();

		if(true) //if ������ ���̸� ;(�����ݷ�)���� ���� �����ϰ� ������ ����
			if(false) System.out.println("A"); //if ������ �����̸� else ���� ���� �����ϰ� ������ ����
			else System.out.println("B");
		System.out.println("C"); //B C
		System.out.println();

		if(a%2!=0) System.out.println(a+"�� Ȧ��"); //!= ���� �ʴ�
		else System.out.println(a+"�� ¦��");
		System.out.println();

		if(a>='A' && a<='Z')
			System.out.println((char)a+"�� �빮��"); //65~90
		else if(a>='a' && a<='z')
			System.out.println((char)a+"�� �ҹ���"); //97~122
		else
			System.out.println((char)a+"�� �����̰ų� Ư������");
   }
}

/*
[������]
D:\java_se\workspace\0723>javac IfTest.java

D:\java_se\workspace\0723>java IfTest
������ �Է� : 43
43�� 50���� �۴�

C

A
C

B
C

43�� Ȧ��

+�� �����̰ų� Ư������
*/