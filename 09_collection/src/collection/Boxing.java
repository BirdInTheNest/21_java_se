package collection;

public class Boxing {

	public static void main(String[] args) {
		int a = 25;
		double b = (double)a/3; //���� ����ȯ(int->double) / �ڵ� ����ȯ(3->3.0)

		String c = "25";
		//int d = (int)c; - error :��ü���� �⺻������ ����ȯ �Ұ�
		int d = Integer.parseInt(c); //�⺻���� �⺻������, ��ü���� ��ü������ ����ȯ
		
		int e=5;
		Integer f = e; //AutoBoxing �⺻���� ��ü������ ����(��üȭ), ���� �迭�̶� ����
		//Integer f = new Integer(e); - JDK 5.0 �������� ���
		
		Integer g=5;
		int h = g; //AutoUnBoxing ��ü���� �⺻������ ����(��üȭ�� Ǭ��), ���� �迭�̶� ����
		//int h = g.intValue(); - JDK 5.0 �������� ���		
	}
}
