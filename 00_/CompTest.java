/*
��������(score) 80~100�̸� �հ�
���� : 80 <= score <= 100		-> ���� �ϳ�, ������ �ϳ��� �и��ؾ� ��
score >= 80 && score <= 100		-> ������ �������� �;� ��.


* �������� : ������ 2�� �̻� ������ ��
&& (AND), & (AND) : ��� ������ ���� �� ����
|| (OR), | (OR)  : ���� �߿��� �ϳ��� ���̾ ����

&& (AND), || (OR) : ù ��° ���� F�϶� �� ��° ���� ������� ���� -> ó���ӵ��� ����
& (AND), | (OR) : ù ��° ���� F����, �� ��° ���� ����� -> ó���ӵ��� ����
*/

class CompTest {
	public static void main(String[] args) {
		int score = 85;
		//���� ? �� : ����;
		//score>=80 && score<=100 ? "�հ�" : "���հ�"; - error: not a statement

		/*
		[�ذ���]
		1. String result = score>=80 && score<=100 ? "�հ�" : "���հ�";
		2. System.out.printin(score>=80 && score<=100 ? "�հ�" : "���հ�";)
		*/

		String result = score>=80 && score<=100 ? "�հ�" : "���հ�";
		System.out.println("��� = " + result);
	}
}
