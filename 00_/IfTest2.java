/*
3����(a,b,c)�� ������ �Է¹޾Ƽ� �հ����� ���հ����� ����Ͻÿ�
�հ��� ����� 60�� �̻��̾�� �ϰ� �� ����� 40�� �̻��̾�� �Ѵ�

[������]
ù��° ���� ���� : 85		ù��° ���� ���� : 100		ù��° ���� ���� : 62
�ι�° ���� ���� : 80		�ι�° ���� ���� : 90		�ι�° ���� ���� : 60
����° ���� ���� : 65		����° ���� ���� : 35		����° ���� ���� : 45
�հ�						�������� ���հ�				���հ�
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class IfTest2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("ù��° ���� ���� : ");
		int a = Integer.parseInt(br.readLine());
		System.out.print("�ι�° ���� ���� : ");
		int b = Integer.parseInt(br.readLine());
		System.out.print("����° ���� ���� : ");
		int c = Integer.parseInt(br.readLine());

		double avg = (double)(a+b+c)/3; // �Ǽ�/����=�Ǽ�
		
		if(avg>=60) //����� 60�� �̻�?
			if(a>=40 && b>=40 && c>=40) System.out.println("�հ�"); //����� 40�� �̻�?
			else System.out.println("�������� ���հ�");
		else System.out.println("���հ�");
	}
}

/*
[������]
D:\java_se\workspace\0723>javac IfTest2.java

D:\java_se\workspace\0723>java IfTest2
ù��° ���� ���� �Է� : 100
�ι�° ���� ���� �Է� : 90
����° ���� ���� �Է� : 35
�������� ���հ�
*/