/*
�� switch (switch�� ������ �ƴ϶�, ���� ������ ����)
: �Ǽ��� Ÿ���� �� �� ����
: break �� switch�� ����� -> break;�� ������ ������� ������

[����]					
 switch(���� or ���� or ���ڿ� or ��) {
 case ��1: break;
 case ��2: break;
 case ��3: break;
 default :
 }
*/

package switch_;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SwitchTest {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("�� �Է� : ");
		int month = Integer.parseInt(br.readLine());
		int days=0;

		switch(month){
			case 1 : 
			case 3 : 
			case 5 : 
			case 7 : 
			case 8 : 
			case 10 : 
			case 12 : days=31; break;
			
			case 2 : days=28; break;
			
			case 4 :
			case 6 : 
			case 9 :
			case 11 : days=30; break;
		}

		System.out.println(month+"���� "+days+"�� �Դϴ�");
	}
}

/*
[������]
D:\java_se\workspace\0723>javac SwitchTest.java

D:\java_se\workspace\0723>java SwitchTest
�� �Է� : 2
2���� 28�� �Դϴ�

D:\java_se\workspace\0723>java SwitchTest
�� �Է� : 5
5���� 31�� �Դϴ�

D:\java_se\workspace\0723>java SwitchTest
�� �Է� : 11
11���� 30�� �Դϴ�
*/