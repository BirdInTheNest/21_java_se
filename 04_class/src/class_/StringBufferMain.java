/*
���ϴ� ���� �Է� : 7		������
--------------------------
7*1=7				display()
7*2=14
...
7*9=63
 */

package class_;

import java.util.Scanner;

public class StringBufferMain {
	private int dan; //�ʵ�
	
	public StringBufferMain() { //������ �޼ҵ� - �Է�
		Scanner scan = new Scanner(System.in); 
		System.out.print("���ϴ� ���� �Է� : ");
		dan = scan.nextInt();		
	}

	public void display() { //display() �޼ҵ� - ���
		StringBuffer buffer = new StringBuffer(); //StringBuffer�� ���ͷ� ������ �� ����, new�� �����ؾ���
		for(int i=1; i<=9; i++) {
			//System.out.println(dan+"*"+i+"="+(dan*i));
			
			buffer.append(dan); //�������ڿ� ���� �߰�, ���� ���ڿ��� ������ ����
			buffer.append("*");
			buffer.append(i);
			buffer.append("=");
			buffer.append(dan*i);
			
			System.out.println(buffer.toString()); //StringBuffer -> String ��ȯ
			buffer.delete(0, buffer.length()); //buffer.delete(0,5): 0������ 5�� �������� ����
		}//for
	}
	
	public static void main(String[] args) {
		StringBufferMain main = new StringBufferMain(); //StringBufferMain Ŭ������ ��ü main�� ������ ����
		main.display(); //��ü main�� display �Լ� ȣ��
	}
}

/*
�� String 
1. ���ڿ�
2. literal("") ���� ����
3. ���ڿ� ����(����)�� �� �� ����.
4. �񱳽� == ����ϸ� reference(������)�� ���Ѵ�
   equals() ����ϸ� ���ڿ��� ������ ���Ѵ�.

�� ���ڿ� ��ü�� reference(������) �̴�.
�� �Ȱ��� ������ ���ڿ� ���ͷ��� �޸𸮿� 1���� �����ȴ�.
   new�� �� ������ �޸𸮿� �����ȴ�
------------------------------------------------
�� StringBuffer / StringBuilder
1. ���ڿ�
2. ���ڿ� ������ ����

������Ҷ��� String, ����� ���� StringBuffer ���
------------------------------------------------------------
buffer ---> "7*1=7"
		 	 01234
buffer ---> ""			buffer.delete(0,5): 0������ 5�� ��������
						buffer.delete(0, buffer.length());
-------------------------------------------------------------
[������]
���ϴ� ���� �Է� : 7
7*1=7
7*2=14
7*3=21
7*4=28
7*5=35
7*6=42
7*7=49
7*8=56
7*9=63
*/