class NumberTest {
	public static void main(String[] args){
		System.out.println(" 'A' + 3 = " + ('A' + 3)); //���ڴ� ���� �ְ� 'A' - 65 -> 'A' + 3 = 68
		System.out.println(" \"A\" + 3 = " + ("A" + 3)); //���ڿ��� ���� ���� "A" - 65(x) -> "A" + 3 = "A3"
		System.out.println(" \"A + 3 = " + ("A" + 3)); //"�� ǥ���ϰ��� �� ���� \"�� ǥ���ϸ� �ȴ�.
		System.out.println(" 'a' - 32 = " + ('a'-32)); //65 ('a' - 97)
		System.out.println(" 'a' - 32 = " + (char)('a'-32)); //A, ����ȯ(Casting)
		System.out.println("25 / 3 = " + (25/3)); //����/����=����
		System.out.println("25. / 3 = " + (25./3)); //�Ǽ�/����=�Ǽ�
		System.out.println("(double)25 / 3 = " + ((double)25/3)); //�Ǽ�/����=�Ǽ�
		System.out.println("25. / 3 = " + String.format("%.2f", 25./3)); //�Ҽ��� ��°�ڸ����� ǥ��
		System.out.printf("25. / 3 = %.2f\n",(25./3)); //C��� ����, f ; format, \n ; next line
	}
}

/*
�ڹٿ� C���� ������ �Ǽ��ĸ� ���� (ex.����/����=���� ->25/3=8)
(double)�� �Ǽ��� ��ȯ���ִ� ����ȯ

String.format
���� - %d
�Ǽ� - %f
���� - %c
���ڿ� - %s
*/


/*
[������]
D:\java_se\workspace\0721>javac NumberTest.java

D:\java_se\workspace\0721>java NumberTest
 'A' + 3 = 68
 "A" + 3 = A3
 "A + 3 = A3
 'a' - 32 = 65
 'a' - 32 = A
25 / 3 = 8
25. / 3 = 8.333333333333334
(double)25 / 3 = 8.333333333333334
25. / 3 = 8.33
25. / 3 = 8.33
*/