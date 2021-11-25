import java.util.Random; //default package : java.lang ��import�� �ʿ� ����.
import java.util.Arrays; //����, �ٸ� package�� �ִ� Ŭ������ ����� ���� import�ؾ���

class MethodTest3 {
	public static void main(String[] args) {
		System.out.println("�ִ밪 = " + Math.max(25, 36)); 
		//java.lang.Math.max(int a, int b) - static int

		//Math m = new Math(); ->static�� ���� ��� new �ؾ� ��
		//System.out.println("�ִ밪 = " + m.max(25, 36));

		System.out.println("�ּҰ� = " + Math.min(25.3, 36.7));
		//java.lang.Math.min(int a, int b) - static int

		//���� - ��ǻ�Ͱ� �ұ�Ģ�ϰ� �߻��ϴ� �� 0<= ���� < 1
		System.out.println("���� = " + Math.random()); //static�� ������ Ŭ�������� �ٷ� �´�
		//java.lang.Math.random() - static double

		Random r = new Random();
		System.out.println("���� = " + r.nextDouble()); //static�� ������ ��ü�� �´�
		//java.util.Random.nextDouble() - double
		//java.lang�� �ƴϹǷ� import�ؾ���

		//����
		int[] ar = {25, 12, 37, 56}; //�迭, ���� ������ ����
		System.out.println(ar[0]+", "+ar[1]+", "+ar[2]+", "+ar[3]);

		Arrays.sort(ar); 
		System.out.println(ar[0]+", "+ar[1]+", "+ar[2]+", "+ar[3]);
		//java.util.Arrays.sort(int[] a) - static void
	}
}

/*
[������]
D:\java_se\workspace\0722>javac MethodTest3.java

D:\java_se\workspace\0722>java MethodTest3
�ִ밪 = 36
�ּҰ� = 25.3
���� = 0.006196395637959151
���� = 0.6849625176847827
25, 12, 37, 56
12, 25, 37, 56
*/