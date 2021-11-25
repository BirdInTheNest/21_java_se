class Operator2 {
	public static void main(String[] args) {
		boolean a = 25>36; //False
		System.out.println("a = " + a); //False
		System.out.println("!a = " + !a); //True, ! - ����������
		System.out.println();

		String b = "apple"; //��ü�� ������ String�� new�� �������� �ʰ� ��������
		String c = new String("apple");

		System.out.println("b == c : " + (b==c)); //false �ּҰ� ��, �ּҰ� �ٸ�
		System.out.println("b.equals(c) : " + (b.equals(c))); //True ���ڿ� ��
		System.out.println("!b.equals(c) : " + (!b.equals(c))); //false

		//C�� �����ּ�(�����ּ�)�� ����, JAVA�� ����ּ�, ������(ĳ�ð�)�� ����.
	}
}

/*
[������]
D:\java_se\workspace\0722>javac Operator2.java

D:\java_se\workspace\0722>java Operator2
a = false
!a = true

b == c : false
b.equals(c) : true
!b.equals(c) : false
*/