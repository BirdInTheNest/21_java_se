/*
�ݾ�(money)�� 5679���϶� ������ ���� ����Ͻÿ�

[������]
�ݾ� : 5679��
õ�� : 5��
��� : 6��
�ʿ� : 7��
�Ͽ� : 9��
 */

class Money {
	public static void main(String[] args) {
		int money = 5679;
		int thousand = money / 1000; //5 (ex. 25/3 = 8 : ���� ��Ÿ��, 25%3 = 1 : �������� ��Ÿ��)
		int hundred = money % 1000 / 100; //6, % (������ ������) - �ݵ�� ������ ���� �������̾�� �Ѵ�.
		int ten = money % 1000 % 100 / 10; //7
		int one = money % 1000 % 100 % 10; //9

		System.out.println("�ݾ� : " + money + "��");
		System.out.println("õ�� : " + thousand + "��");
		System.out.println("��� : " + hundred + "��");
		System.out.println("�ʿ� : " + ten + "��");
		System.out.println("�Ͽ� : " + one + "��");
	}
}