/*
���� ��� ���α׷�
�̸�, ����, �⺻��, ������ �Է��Ͽ� �޿�, ����, ������ ����Ͻÿ�
������ �޿��� 4,000,000 ���� �̻��̸� 3% �ƴϸ� 2%�� �Ѵ� (���ǿ����� - ���� ? �� : ����)

�޿� = �⺻�� + ����
���� = �޿� * ����
���� = �޿� - ����

������ calcTax() �޼ҵ� ���Ͽ� �����´� (return)
������ calcSalary()  �޼ҵ� ���Ͽ� �����´� (return)

[������]
�̸� �Է�  : ȫ�浿
���� �Է�  : ����
�⺻�� �Է� : 4500000
���� �Է� : 200000

         *** ȫ�浿 ���� ���� ***
���� : ����
�⺻��          ����         �޿�         ����      ����      ����
4,500,000     200,000     4,700,000   3%      xxxxx   xxxxxxx
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Salary {
   public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		Salary s = new Salary(); //Ŭ������ ��ü�� = new Ŭ������(); - ��ü ����

		System.out.print("�̸� �Է�  : ");
		String name = br.readLine();

		System.out.print("���� �Է�  : ");
		String position = br.readLine();
		
		System.out.print("�⺻�� �Է� : ");
		int basePay = Integer.parseInt(br.readLine());

		System.out.print("���� �Է� : ");
		int allowance = Integer.parseInt(br.readLine());

		int pay = basePay + allowance; //�޿� = �⺻�� + ����

		double taxRate = pay >=4000000 ? 0.03 : 0.02;
		//������ �޿��� 4,000,000 ���� �̻��̸� 3% �ƴϸ� 2%�� �Ѵ� (���ǿ����� - ���� ? �� : ����)





		int tax = Integer.parseInt(s.calcTax(pay, taxRate)); //���� = �޿� * ����

		//int salary = s.calcSalary(pay, tax); //���� = �޿� - ���� -error String cannot be converted to int
		int salary = Integer.parseInt(s.calcSalary(pay, tax));


		System.out.println("\t\t"+"*** "+name+" ���� ���� ***");
		System.out.println("���� : "+position);
		System.out.println("�⺻��\t\t����\t\t�޿�\t\t����\t\t����\t\t����");
		System.out.println(basePay+"\t\t"+allowance+"\t\t"+pay+"\t\t"+taxRate+"\t\t"+tax+"\t\t"+salary);
   }
	
	public String calcTax(int pay, double taxRate){
		return String.format("%d", pay * taxRate);
   }

   	public String calcSalary(int pay, int tax){
		return String.format("%d", pay - tax);
   }
}