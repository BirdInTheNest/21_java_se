/*
���� ���� �� ����
- ����(1), ����(2), ��(3)���� �ν��Ѵ�
- ��ǻ�ʹ� 1~3 ������ ������ �߻��Ѵ�.

[������]
����(1), ����(2), ��(3) �� ��ȣ�� �Է� : 2 (System.in.read() ����ϼ���)
���� �ݾ� �Է� : 200 (BufferedReader ����ϼ���)
����� ������ �ƹ�Ű�� ��������......

��ǻ�� : ����, �� : ����
�̰���ϴ�.
���� �ݾ��� 1,200�� �Դϴ�.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

class Game {
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("����(1), ����(2), ��(3) �� ��ȣ�� �Է� : ");
		int user = System.in.read(); //int user = br.read();

		System.out.print("���� �ݾ� �Է� : ");
		int money = Integer.parseInt(br.readLine());

		System.out.print("����� ������ �ƹ�Ű�� ��������......");
		System.in.read(); //flush


		int com = (int)(Math.random()*3 +1); //0~2 -> 1~3

		//Random r = new Random();
		//int com = r.nextInt(3) +1;

		if(user == 1) System.out.print("����");
		else if(user == 2) System.out.print("����");
		else System.out.print("��");

		if(com == 1) System.out.print("����");
		else if(com == 2) System.out.print("����");
		else System.out.print("��");
		
		
		System.out.println("��ǻ�� : "+com+", �� : "+user);
		
		if(user == 1) { //user�� ����
			if(com == 1) System.out.println("�����ϴ�"); //com�� ����
			else if(com == 2) System.out.println("�����ϴ�"); //com�� ����
			else System.out.println("�̰���ϴ�"); //com�� ��

		}else if(user == 2) { //user�� ����
			if(com == 1) System.out.println("�̰���ϴ�"); //com�� ����
			else if(com == 2) System.out.println("�����ϴ�"); //com�� ����
			else System.out.println("�����ϴ�"); //com�� ��

		}else { //user�� ��
			if(com == 1) System.out.println("�����ϴ�"); //com�� ����
			else if(com == 2) System.out.println("�̰���ϴ�"); //com�� ����
			else System.out.println("�����ϴ�"); //com�� ��
		}
			





		
		/*
		//����: ��ǻ�Ͱ� �ұ�Ģ�ϰ� �����ϴ� �� 0 <= ���� <1
		//��� 1 - java.lang.Math.random() - static double //Ŭ������.�޼ҵ��(��1, ��2...)

		double a = Math.random(); 
		System.out.println(a); //0.3428141771797262

		double aa = Math.random()*10; 
		System.out.println(aa); //9.550945987348612

		int aaa = (int)(Math.random()*10); 
		System.out.println(aaa); //0~9

		int aaaa = (int)(Math.random()*3); 
		System.out.println(aaaa); //0~2

		int aaaaa = (int)(Math.random()*3 +1); 
		System.out.println(aaaaa); //0~2 -> 1~3

		//��� 2 - java.util.Random.nextInt(int bound) - int //��ü��.�޼ҵ��(��1, ��2...)
		Random r = new Random();
		int b = r.nextInt(3) +1; //0~2 -> 1~3
		System.out.println(b);
		*/
   }
}