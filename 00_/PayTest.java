/*
�̸��� L(name)�� ����� �⺻��(basePay)�� 2500000�϶� 3.3% ����(tax)�� ����(salary)�� ����Ͻÿ�

���� = �⺻�� * 3.3%(0.033)
���� = �⺻��-����
		
[������]
*** L�� ���� ***
�⺻�� : 2500000��
����   : 82500��
����   : 2417500��
*/

import java.text.DecimalFormat;
//import java.lang.String; -�⺻���� �˾Ƽ� ó���ϱ� ������ import���� �ʾƵ� ��.

class PayTest {
	public static void main(String[] args) {
		char name = 'L'; //L�� ���� ������ �б� ������ 'L'�� �����
		//'a' : 97���� ���� ����, "a" : ���ڿ�, a : ����, a() : �Լ�
		//String name = "L";

		int basePay = 2500000;
		//double tax = basePay * 0.033; - int * double�� double���� �����Ƿ� ����ȯ �ʿ�.
		int tax = (int)(basePay * 0.033);
		int salary = basePay - tax; 

		//���� 3�ڸ����� ,�� ǥ��
		DecimalFormat decimalFormat = new DecimalFormat();
		//Ŭ������ �������� Ŭ������ �̸��� ���� �ҹ��ڷ� ����, ��ü���� new �����ؾ� ��
		
		System.out.println("*** " + name + "�� ���� ***");
		System.out.println("�⺻�� : " + decimalFormat.format(basePay) + "��");
		//System.out.println("����   : " + (int)(tax) + "��");
		System.out.println("����   : " + decimalFormat.format(tax) + "��");
		System.out.println("����   : " + decimalFormat.format(salary) + "��");
	}
}
