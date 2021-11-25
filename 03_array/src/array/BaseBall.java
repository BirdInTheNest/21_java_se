/*
�߱� ���� - ���� ���߱� ����
- ũ�Ⱑ 3���� ������ �迭�� ��� 1~9������ ������ �߻��Ѵ�
- ������ �ߺ��� ������� �ʴ´�

[������]
������ �����Ͻðڽ��ϱ�(Y/N) : w
������ �����Ͻðڽ��ϱ�(Y/N) : q
������ �����Ͻðڽ��ϱ�(Y/N) : y

������ �����մϴ�

�����Է� : 123
1��Ʈ����ũ 0��

�����Է� : 182
0��Ʈ����ũ 2��

...

�����Է� : 428
3��Ʈ����ũ 0��

�����մϴ�...��x������ ���߼̽��ϴ�.
 */

package array;

import java.io.IOException;

public class BaseBall {

	public static void main(String[] args) throws IOException{
		int[] com = new int[3]; //ũ�Ⱑ 3���� ������ �迭�� ���
		int[] user = new int[3];
		int yn;
		int strike, ball;
		int count=0;
		
		do {											  //������ ���̸� �ݺ�, �����̸� ����
			System.out.print("������ �����Ͻðڽ��ϱ�(Y/N) : ");
			yn = System.in.read();
			System.in.read();
			System.in.read();//flush
		}while(yn!='Y' && yn!='y' && yn!='N' && yn!='n'); //����� Y,y,N,n�� �ƴ� ��� �ݺ�
		
		if(yn=='Y' || yn=='y') {
			System.out.println("\n������ �����մϴ�");
			
			//���� �߻�
			for(int i=0; i<com.length; i++) { 
				com[i] = (int)(Math.random()*9)+1; //1~9������ ������ �߻�
				
				//�ߺ�üũ - ������ �ߺ��� ������� �ʴ´�
				for(int j=0; j<i; j++) {
					if(com[i] == com[j]) {
						i--; //for i�� �ٽ� ���� i++�ϰ� lotto[i]�� �����ϱ� ������ i--�ʿ�(���󺹱�)
						break; //for j�� ����� > for i�� ���� �ٽ� ���� �߻�
					}//if
				}//for j
			}//for i
			System.out.println(com[0]+", "+com[1]+", "+com[2]); //üũ
			
			//���� ���߱�
			while(true) {
				System.out.print("�����Է� : ");
				
				count++; //������� ���߾����� �ݺ�Ƚ�� ���
				for(int i=0; i<user.length; i++) {
					user[i] = System.in.read()-'0';
				}//for i
				System.in.read();
				System.in.read();//flush
				System.out.println(user[0]+", "+user[1]+", "+user[2]); //üũ
				
				//��
				strike = ball = 0; //for�� ���� �ʱⰪ���� - 0���� �ٽ� �����Ͽ� ��
				for(int i=0; i<com.length; i++) {
					for(int j=0; j<user.length; j++) {
						if(com[i]==user[j]) { //�����Ͱ��� ������?
							if(i==j) //��ġ�� ������?
								strike++; //�����Ͱ��� ��ġ�� ��� ���� ���
							else
								ball++; //�����Ͱ��� ������ ��ġ�� �ٸ� ���
						}//if
					}//for j
				}//for i
				
				System.out.println(strike+"��Ʈ����ũ\t"+ball+"��");
				if(strike==3) {
					System.out.println("\n�����մϴ�..."+count+"������ ���߼̽��ϴ�.");
					break;
				}//if
			}//while
			
		}//if
		System.out.println("���α׷��� �����մϴ�");
	}
}

/*
�����Է� : 123
String input = br.readLine();
	"123"
	(012)
��� ���ڿ��� ��ġ(index)�� ������ �ִ�
user[0] = input.charAt(0)-48; //1 //���ڷ� ������ ���ڷ� ������ ���� �ƴϱ� ������ -48 �ؾ���
user[1] = input.charAt(1)-48; //2
user[2] = input.charAt(2)-48; //3
 */

/*
���� �ߺ�Ȯ�� (�� ���� ���� ���� �߿� ���� ���ڰ� �ִ��� ��)
com[0]   com[1]==com[0]   com[2]==com[0]   com[3]==com[0]   ...
								  com[1]		   com[1]   ...
										  		   com[2]   ...
for(int i=0; i<com.length; i++){
	for(int j=0; j<i; j++){

	}
}
*/

/*
�����Ͱ� ������ ��
com[0]==user[0]		com[1]==user[0]		com[2]==user[0]
		user[1]				user[1]				user[1]
		user[2]				user[2]				user[2]
 */

/*
[������]
������ �����Ͻðڽ��ϱ�(Y/N) : w
������ �����Ͻðڽ��ϱ�(Y/N) : y

������ �����մϴ�
8, 9, 7
�����Է� : 789
7, 8, 9
0��Ʈ����ũ	3��
�����Է� : 897
8, 9, 7
3��Ʈ����ũ	0��

�����մϴ�...2������ ���߼̽��ϴ�.
���α׷��� �����մϴ�
 */














