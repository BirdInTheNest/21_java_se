/*
������� �Է��Ͽ� ä���ϴ� ���α׷��� �ۼ��Ͻÿ�
�̸��� 5���� ���� �Է��Ͽ� OX�� ä���Ͻÿ�
- �� �������� 5�����̴�
- ������ 1������ 20���Դϴ�

[������]
�̸� �Է� : ȫ�浿
�� �Է� : 14123

�̸�      1 2 3 4 5   ����
ȫ�浿   O X O X X   40

Ŭ���� : Examination
�ʵ�  : name, dap, ox[], score
�޼ҵ� :  ������ - Scanner
        compare() - ��, ���� ���
        getter
        
[������]
�ο��� �Է� : 3

�̸� �Է� : ȫ�浿
�� �Է� : 13211

�̸� �Է� : �ڳ�
�� �Է� : 11111

�̸� �Է� : ��ġ
�� �Է� : 13242

�̸�      1 2 3 4 5   ����
ȫ�浿     O X X O O   60
�ڳ�      O O O O O   100
��ġ      O X X X X   20
 */

package inheritance;

import java.util.Scanner;

public class ExaminationMain {

	public static void main(String[] args) {
		Examination aa = new Examination(); //Ŭ���� �޸𸮿� ����, ������ ȣ��
		aa.compare(); //�޼ҵ� ȣ��
		
		//���
		System.out.print(aa.getName() + "\t");
		for(int i=0; i<aa.getOx().length; i++)
			System.out.print(aa.getOx()[i] + " ");
		System.out.println("\t" + aa.getScore());
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("�ο��� �Է� : ");
		int size = scan.nextInt();
		
		Examination[] ar = new Examination[size]; //�ڷ����� Ŭ�������� ��ü �迭 size�� ����
		//Object[] ar = new Examination[size]; //�ֻ��� Ŭ������ Object�� �ڷ����� �޾Ƶ� ��
		
		for(int i=0; i<size; i++) {
			ar[i] = new Examination(); //Ŭ���� ����
			ar[i].compare(); //�޼ҵ� ȣ��
			System.out.println();
		}//for
		
		//���
		for(int k=0; k<size; k++) {
			System.out.print(ar[k].getName() + "\t");
			
			for(int i=0; i<ar[k].getOx().length; i++)
				System.out.print(ar[k].getOx()[i] + " ");
			
			System.out.println("\t" + ar[k].getScore());
		}//for k
	}
}

/*
[������]
�̸� �Է� : ��罺
�� �Է� : 11111
��罺	O O O O O 	100
�ο��� �Է� : 3
�̸� �Է� : Ŭ��
�� �Է� : 11212

�̸� �Է� : �踮
�� �Է� : 11211

�̸� �Է� : ��
�� �Է� : 22111

Ŭ��	O O X O X 	60
�踮	O O X O O 	80
��	X X O O O 	60
*/
