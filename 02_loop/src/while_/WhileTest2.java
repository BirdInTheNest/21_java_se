/*
���� ���߱� ����

1 ~ 100 ������ ���ڸ� ���߸� ���� �˴ϴ�

[������]
���ڸ� �߻��߽��ϴ�...(75)
���� �Է� : 50
50���� Ů�ϴ�.

���� �Է� : 80
80���� �۽��ϴ�.

...

���� �Է� : 75
������...xx������ ���߼̽��ϴ�.

1�� �� (Y/N) ? N
���α׷��� �����մϴ�.
 */

package while_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WhileTest2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int com, user, count; 
		int yn;
		
		while(true) { //���� ���� �ݺ�		
			com = (int)(Math.random()*100) +1; //1���� �����ϴ� 100���� ���� �߻�
			System.out.println("���ڸ� �߻��߽��ϴ�..."+com);
			
			count = 0; //�ʱ�ȭ
			
			while(true) { //���ڸ� ���� ������ �ݺ�
				System.out.print("���� �Է� : ");
				user = Integer.parseInt(br.readLine());
				
				count++; //count = count + 1 //while���� �ݺ��Ǵ� Ƚ�� ���
				
				if(com == user) break; //���ڸ� ���߸� �����
				
				if(com > user) {
					System.out.println(user+"���� Ů�ϴ�.");
				}else {
					System.out.println(user+"���� �۽��ϴ�.");
				}	
			}//while

			System.out.println("������..."+count+"������ ���߼̽��ϴ�.");
			
			while(true){ //Y�� N�� ����� ������ ���� �ݺ�
				System.out.print("1�� �� (Y/N) ?");
				yn = br.read(); 	//flush �ʿ�
				br.read(); 			//Enter(����) 1. Ŀ���� ������ ������ \r(13)
				br.read(); 			//		     2. �ٹٲ� 		   \n(10)
				
				if(yn=='Y' || yn=='y' || yn=='N' || yn=='n') break;
			}//while
			
			if(yn=='N' || yn=='n') break;
		}//while
		System.out.println("���α׷��� �����մϴ�.");
	}
}

/*
[������]
���ڸ� �߻��߽��ϴ�...28
���� �Է� : 30
30���� �۽��ϴ�.
���� �Է� : 27
27���� Ů�ϴ�.
���� �Է� : 28
������...3������ ���߼̽��ϴ�.
1�� �� (Y/N) ?y
���ڸ� �߻��߽��ϴ�...82
���� �Է� : 82
������...1������ ���߼̽��ϴ�.
1�� �� (Y/N) ?n
���α׷��� �����մϴ�.
*/