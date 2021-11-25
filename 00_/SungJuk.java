/*
�� ����(variable) - �޸� �Ҵ�(instance) //(�޸𸮿� ���� ��� ��, instance : �޸𸮿� ���������� ��� ��)
: ���ϴ� ��, �����͸� �����ϴ� ��

Ŭ�������� ù ���ڴ� �빮�ڷ� �����ϰ�, ������ �޼ҵ��� ù ���ڴ� �ҹ��ڷ� ������

1. �⺻��
�ڷ��� ������;
int a;

2. ��ü�� (Ŭ���������� ��� ��)
Ŭ������ ��ü�� = new Ŭ������(); //�̷��� �ؾ� �޸𸮿� ������ ������ ��
DecimalFormat decimalFormat = new DecimalFormat();

3. �迭��
�ڷ���[] �迭�� = {��1, ��2, ��3, ��}	[] - �迭�̶�� ��, 0�� ����� ������ (cf. ����Ŭ�� 1���� ������)
int[] ar = new int[����]
*/

/*
�� �޼ҵ�()
: ��ɾ���� ����
: �⺻������ public static void main(String[] ) ����
: ȣ���� �޼ҵ�� �ݵ�� ȣ���� ������ �ǵ��ƿ´� (����ð��� �������, �����԰� ���ÿ� �Լ��� �ִ� ��� �޸𸮴� �Ҹ�)
: return(�����, ��ȯ��)�� �ݵ�� 1�����̴� (cf. ���̽��� return�� ���� �� ���� �� �ִ�.)
: return�� ������ void�� �����Ѵ� (������� �ƹ��͵� ������ ����)

1. ����
returnType �޼ҵ��(�μ��� �μ�, �μ��� �μ�,...) {
	�޼ҵ�body
}

2. ȣ��
��ü��.�޼ҵ��(��1, ��2,...)
Ŭ������.�޼ҵ��(��1, ��2,...) �� �޼ҵ尡 static �� ���

�⺻��		Wrapper Class (�⺻���� Ŭ����ȭ��Ų ��)
--------------------------------
boolean		Boolean
char		Character
byte		Byte
short		Short
int			Integer
long		Long
float		Float
double		Double
*/

/*
����� �̸�, ����, ����, ���� ������ �Է¹޾Ƽ� ������ ����� ���Ͻÿ� //�޼ҵ带 ���� ������ ����� ���Ѵ�
��) ����, ����, ������ ���ڿ��̹Ƿ� ���������� ��ȯ�ؾ� �Ѵ�.- Integer Ŭ������ �޼ҵ带 �̿�
//java.lang.Integer.parseInt(String s) - static int //static�̱� ������ new ���ص� ��

[������]
javac SungJuk.java
java  SungJuk  ȫ�浿  95  97  100 

   *** ȫ�浿 ����ǥ ***
����   ����   ����    ����   ���
95    97    100   xxx   xx.xx
*/

class SungJuk {
	public static void main(String[] args) {
		SungJuk sj = new SungJuk(); //Ŭ������ ��ü�� = new Ŭ������(); //�̷��� �ؾ� �޸𸮿� ����(��ü)�� ������ ��

		String name = args[0]; //�迭 args ù��°��(���ڿ���)�� name������ ����
		int kor = Integer.parseInt(args[1]); //�迭 args �ι�°��(���ڿ���)�� ���������� ��ȯ�Ͽ� kor������ ����
		int eng = Integer.parseInt(args[2]); //�迭 args ����°��(���ڿ���)�� ���������� ��ȯ�Ͽ� eng������ ����
		int math = Integer.parseInt(args[3]); //�迭 args �׹�°��(���ڿ���)�� ���������� ��ȯ�Ͽ� math������ ����

		int tot = sj.total(kor, eng, math); //���� �޼ҵ� ����- ��ü��sj.�޼ҵ��total(��kor, eng, math)�� �޼ҵ带 ������ tot������ ����
											  
		//double avg = sj.average(tot); -error : String cannot be converted to double
		String avg = sj.average(tot); //��� �޼ҵ� ����- ��ü��sj.�޼ҵ��average(��tot)�� �޼ҵ带 ���ڿ��� avg������ ����

		System.out.println("\t *** " + name + " ����ǥ ***");
		System.out.println("����\t����\t����\t����\t���");
		System.out.println(kor +"\t"+ eng +"\t"+ math +"\t"+ tot +"\t"+ avg);
	}

	public int total(int kor, int eng, int math){
		return kor + eng + math; 		
	}

	//public double avgerage(int tot){
	//	return tot/3.0;		
	//}
	public String average(int tot){
		return String.format("%.2f", tot/3.0);		
	}
}

/*
[������]
D:\java_se\workspace\0722>javac SungJuk.java

D:\java_se\workspace\0722>java SungJuk ȫ�浿  95  97  100
         *** ȫ�浿 ����ǥ ***
����    ����    ����    ����    ���
95      97      100     292     97.33
*/