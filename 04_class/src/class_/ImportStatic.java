package class_;

//import static java.lang.Math.random; //java.lang��Ű���� MathŬ������ random�޼ҵ�
//import static java.lang.Math.pow;
import static java.lang.Math.*; // * : ���ϵ� ī��(��� ��)
import static java.lang.System.out; 

import java.util.Random;

public class ImportStatic {
 
	public static void main(String[] args) {
		System.out.println("���� = " + Math.random()); //0<=����<1
		System.out.println("���� = " + random()); //Ŭ������.�޼ҵ�()���� Ŭ�������� import static���� ����
		
		Random r = new Random();
		System.out.println("���� = " + r.nextDouble()); //static�� �ƴϹǷ� import static �� ��
		System.out.println("������ ���� = " + r.nextInt()); //-21��~21��
		System.out.println("������ ���� = " + r.nextInt(100)); //0~99
		System.out.println("������ ���� = " + (r.nextInt(100)+1)); //1~100
		
		System.out.println("2�� 5���� = " + Math.pow(2, 5)); //�Ǽ���
		out.println("2�� 5���� = " + Math.pow(2, 5)); //Ŭ������.�޼ҵ�()���� Ŭ�������� import static���� ����
		out.println("2�� 5���� = " + pow(2, 5)); //Ŭ������.�޼ҵ�()���� Ŭ�������� import static���� ����
	} 
}

/*
[������]
���� = 0.8163972710020987
���� = 0.7605310140370077
���� = 0.7053194425981104
������ ���� = -1477682089
������ ���� = 78
������ ���� = 84
2�� 5���� = 32.0
2�� 5���� = 32.0
2�� 5���� = 32.0
*/