/*
���� �޷�
- �⵵, ���� �Է��Ͽ� �޷��� ����Ͻÿ�
- �ſ� �����ϴ� ������ ���Ͻÿ� - �޼ҵ�
- �ſ� ������ ��(30, 28, 29, 31)�� ���Ͻÿ� - �޼ҵ�
- Ŭ���� : CalendarTest
  �ʵ�  : year, month, week, lastDay
  ������ : �Է�
  �޼ҵ� : calc()
         display()

[������]
�⵵ �Է� : 2002
�� �Է� : 10

��	��	ȭ	��	��	��	��	
		1	2	3	4	5	
6	7	8	9	10	11	12	
13	14	15	16	17	18	19	
20	21	22	23	24	25	26	
27	28	29	30	31	
 */

package abstract_;

import java.util.Calendar;
import java.util.Scanner;

class CalendarTest{ 
	private int year, month, week, lastDay; //�ʵ�
	
	public CalendarTest() { //������ - �⵵, ���� �Է�
		Scanner scan = new Scanner(System.in); 
		System.out.print("�⵵ �Է� : ");
		this.year = scan.nextInt();
		System.out.print("�� �Է� : ");
		this.month = scan.nextInt();
	}//������
	
	public void calc() {
		Calendar cal = Calendar.getInstance(); //�޼ҵ带 �̿��Ͽ� �߻�Ŭ���� ����
		//������ �ý��� ��¥�� �ð� -> �⵵, ���� �Է¹��� ������ ó��, ���� �������� �����ؾ� ��	

		//cal.set(Calendar.YEAR, year); //��, static�� Ŭ������ �Ⱦ��� ��ü�� �ᵵ ��
		//cal.set(cal.MONTH, month-1); //��, cal.MONTH�� 1�� 0, 2�� 1 �̱� ������ month-1����
		//cal.set(cal.DAY_OF_MONTH, 1); //��, �ý��� ��¥�� �����̱� ������ 1�Ϸ� ����
		cal.set(year, month-1, 1);

		week = cal.get(cal.DAY_OF_WEEK); //���������� 1���� ������ �����´�. �Ͽ��� 1, ������ 2...����� 7
		lastDay = cal.getActualMaximum(cal.DAY_OF_MONTH); //28, 29, 30, 31
	}//calc()
	
	public void display() {
		System.out.print("��\t��\tȭ\t��\t��\t��\t��\t\n");
		
		for(int i=1; i<week; i++) { //1���� ����Ϸ� �����ϴ��Ŀ� ���� �޷¿��� ������ �ٸ�
			System.out.print("\t"); //���Ͽ� �°� 1�� �����ϰ� �����ִ� ��
		}
		
		for(int i=1; i<=lastDay; i++) { //1�Ϻ��� ���� ������ ������ ���
			System.out.print(i+"\t");
			
			if(week%7==0) System.out.println(); //7������ �ٹٲٱ�
			week++;	//�ܸӸ�, for�� ���ư��� Ƚ���� �̿��Ͽ� ���ٶ�⸦ �ϴµ� �̿�
			//count ������ �ʱⰪ�� 0�� �ְ� for�� ���ư� ������ count++�Ͽ� �ٹٲٱ⿡ �̿��ص� ��		
		}//for
	}//display()
}//CalendarTest()
//-----------------------
public class CalendarMain {

	public static void main(String[] args) {
		CalendarTest ct = new CalendarTest();
		ct.calc();
		ct.display();
	}
}