/*
�޸� <--BufferedReader-- ���� <--InputStreamReader-- Ű����(System.in - InputStream)

�޸� <--BufferedReader-- ���� <--FileReader-- ����
*/

package input_;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class InputTest2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//InputStreamReader ir = new InputStreamReader(System.in);
		//BufferedReader br - new BufferedReader(ir);
		
		System.out.print("���� ������ �Է� : ");
		//br.read(); //��ü br���� 1�� ���� �Է¹���
		//String a = br.readLine(); //��ü br���� 1��(���͸� ĥ ������) �Է¹��� ���ڿ��� ���� a�� ����
		int a = Integer.parseInt(br.readLine()); //String�� int�� ����ȯ
		//java.lang.Integer.parseInt(String s) - static int

		System.out.print("�Ǽ� ������ �Է� : ");
		double b = Double.parseDouble(br.readLine()); //String�� double�� ����ȯ
		//java.lang.Double.parseDouble(String s) - static double

		System.out.println(a + " + " + b + " = " + (a+b));
	}
}

/*
[������]
D:\java_se\workspace\0723>javac InputTest2.java

D:\java_se\workspace\0723>java InputTest2
���� ������ �Է� : 25
�Ǽ� ������ �Է� : 2.111
25 + 2.111 = 27.111
*/

