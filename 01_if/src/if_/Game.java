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

package if_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

class Game {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DecimalFormat df = new DecimalFormat();
		
		int com, user;
		int money = 1000;
		int batting;
		
		com = (int)(Math.random()*3)+1; //���� 0~2 -> 1~3

		System.out.print("����(1), ����(2), ��(3) �� ��ȣ�� �Է� : ");		
		user = System.in.read()-48; //0(0) '0'(48) - ������ ������ ���� int�� ����
		System.in.read(); //flush
		System.in.read(); //flush
		
		System.out.print("���� �ݾ� �Է� : ");
		batting = Integer.parseInt(br.readLine());
		
		System.out.println("����� ������ �ƹ�Ű�� ��������......");
		System.in.read();
		System.in.read();
		
		if(com==1 ) { //���� ����
			if(user==1) { 
				System.out.println("��ǻ�� : ����, �� : ����");
				System.out.println("�����ϴ�.");
			}else if(user==2) {
				System.out.println("��ǻ�� : ����, �� : ����");
				System.out.println("�̰���ϴ�.");
				money += batting; //money = money + batting
			}else {
				System.out.println("��ǻ�� : ����, �� : ��");
				System.out.println("�����ϴ�.");
				money -= batting; //money = money - batting
			}
				
		}else if(com==2) { //���� ����
			if(user==1) {
				System.out.println("��ǻ�� : ����, �� : ����");
				System.out.println("�����ϴ�.");
				money -= batting; //money = money - batting
			}else if(user==2) {
				System.out.println("��ǻ�� : ����, �� : ����");
				System.out.println("�����ϴ�.");
			}else {
				System.out.println("��ǻ�� : ����, �� : ��");
				System.out.println("�̰���ϴ�.");
				money += batting; //money = money + batting
			}
		
		}else { //���� ��
			if(user==1) {
				System.out.println("��ǻ�� : ��, �� : ����");
				System.out.println("�̰���ϴ�.");
				money += batting; //money = money + batting
			}else if(user==2) {
				System.out.println("��ǻ�� : ��, �� : ����");
				System.out.println("�����ϴ�.");
				money -= batting; //money = money - batting
			}else {
				System.out.println("��ǻ�� : ��, �� : ��");
				System.out.println("�����ϴ�.");
			}
		} //if
		
		System.out.println("���� �ݾ��� "+df.format(money)+"�� �Դϴ�.");
	}
}

/*
[������]
����(1), ����(2), ��(3) �� ��ȣ�� �Է� : 3
���� �ݾ� �Է� : 500
����� ������ �ƹ�Ű�� ��������......

��ǻ�� : ����, �� : ��
�����ϴ�.
���� �ݾ��� 500�� �Դϴ�.
*/

/*
//����: ��ǻ�Ͱ� �ұ�Ģ�ϰ� �����ϴ� �� 0 <= ���� <1
 (int)(Math.random()* b-a+1) +a; //a~b���� ����
                       ����   ���۰�
 
//��� 1 - java.lang.Math.random() - static double //Ŭ������.�޼ҵ��(��1, ��2...)
double a = Math.random(); 
System.out.println(a); //0.3428141771797262

double aa = Math.random()*10; 
System.out.println(aa); //9.550945987348612

int aaa = (int)(Math.random()*10); 
System.out.println(aaa); //0~9

int aaaa = (int)(Math.random()*3); 
System.out.println(aaaa); //0~2

int aaaaa = (int)(Math.random()*3) +1; 
System.out.println(aaaaa); //0~2 -> 1~3

//��� 2 - java.util.Random.nextInt(int bound) - int //��ü��.�޼ҵ��(��1, ��2...)
Random r = new Random();
int b = r.nextInt(3) +1; //0~2 -> 1~3
System.out.println(b);
*/

