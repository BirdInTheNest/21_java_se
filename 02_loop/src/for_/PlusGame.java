/*
��������
- 2�ڸ��� ���ڷ� �����Ѵ� (10 ~ 99 ������ ���� �߻�)
- �������� �� 5������ �����Ѵ�
- 1������ 20���� �����ȴ�
- Ʋ���� 1�� �� ��ȸ�� �ش�...(for)
  2��°���� �� Ʋ���� �׶� ������ �˷��ش�.

[������]
[���� 1] 12 + 95 = ���� �Է�
Ʋ�ȴ�...
[���� 1] 12 + 95 = ���� �Է�
Ʋ�ȴ�...���� : 107

[���� 5] 10 + 90 = ���� �Է�
������...�� ���߾��

����� �� x������ ���߾ xx�� �Դϴ�

1�� �� (Y/N) ? N
���α׷��� �����մϴ�.
*/

package for_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlusGame {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a, b, answer, count;
		String yn;
		
		while(true) { //�ݺ�
			count=0; //�ʱⰪ ����
			for(int i=1; i<=5; i++) {//5���� �ݺ�
				a = (int)(Math.random()*90) +10; //10���� �����ϴ� 90���� ���� 
				b = (int)(Math.random()*90) +10; //0~89 -> 10~99
				
				for(int j=1; j<=2; j++) { //Ʋ���� ��ȸ�� 1�� �� ����
					System.out.print("[���� "+i+"] "+a+" + "+b+" = ");
					answer = Integer.parseInt(br.readLine());
					
					if(answer == a+b) {
						System.out.println("������...�� ���߾��");
						count++; //������ ���� ����� ���� ���
						break; //for j�� �����
					}else {
						if(j==1) //1�� Ʋ���� �� 
							System.out.println("Ʋ�ȴ�...");
						else if(j==2) //2�� Ʋ���� ��
							System.out.println("Ʋ�ȴ�...���� : "+(a+b));
					}
				}//for j
				System.out.println();
			}//for i
	
		System.out.println();
		System.out.println("����� �� "+count+"������ ���߾ "+count*20+"�� �Դϴ�");

		System.out.print("1�� �� (Y/N) ?");
		yn = br.readLine();
		
		//if(yn=="N" || yn=="n") break; //== �ּҰ� ��
		if(yn.equals("N") || yn.equals("n")) break;
		}//while
		
		System.out.println("���α׷��� �����մϴ�.");
	}
}

//��� �����ؼ� ���̵��ϱ�
//Shift tab : �������� ���̵�
//tab : ���������� ���̵�

/*
[������]
[���� 1] 38 + 94 = 132
������...�� ���߾��

[���� 2] 24 + 88 = 112
������...�� ���߾��

[���� 3] 99 + 74 = 173
������...�� ���߾��

[���� 4] 46 + 26 = 72
������...�� ���߾��

[���� 5] 31 + 58 = 100
Ʋ�ȴ�...
[���� 5] 31 + 58 = 89
������...�� ���߾��


����� �� 5������ ���߾ 100�� �Դϴ�
1�� �� (Y/N) ?n
���α׷��� �����մϴ�.
*/