package inheritance;

public class SubTest extends SuperTest{ //SubTestŬ������ SuperTestŬ���� ��ӹ���. 
	private String name;
	private int age;
	
	public SubTest(String name, int age, double w, double h) { //SubTest ������
		System.out.println("SubTest Ŭ���� ������");
		this.name = name;
		this.age = age;
		super.weight = w; //this.weight = w; //���͵� ���� �θ�͵� ����
		super.height = h; //this.height = h;
		//super. : �θ� ������ �ּҰ��� ���̷�Ʈ�� ���� ���� ��
	} 
	
	public void output() { //output() �޼ҵ�
		System.out.println("SubTest Ŭ������ output()");
		System.out.println("�̸� = " + name);
		System.out.println("���� = " + age);
		System.out.println("������ = " + weight);
		System.out.println("Ű = " + height);
	}

	public static void main(String[] args) {
		SubTest aa = new SubTest("ȫ�浿", 25, 72.3, 185.3); //aa�� SubTest ����
		aa.output();
		System.out.println("------------");
		aa.disp(); //�켱 �� Ŭ����(SubTest)���� �޼ҵ带 ã�� ������ �θ� Ŭ����(SuperTest)���� ã�´�
		System.out.println("------------");

		SuperTest bb = new SubTest("�ڳ�", 13, 25.6, 158.7); //bb�� SuperTest ����
		//bb.output(); -error: bb�� �������� SuperTest�� �����Ǿ� �ֱ� ������ SubTest�� �ִ� output()�� �θ� �� ����
		bb.disp();
	}
}

/*
�ڽ� Ŭ������ ����� �ڽ� Ŭ������ �ڱ� �Ͱ� �θ� ���� �Ѳ����� �޸𸮿� �����Ѵ�
�ڽ� Ŭ������ new�ϸ� �ڱ� �����ڿ� �θ� �����ڸ� 2�� ȣ����. �θ�� �⺻������ �⺻ �����ڸ� ȣ��

- error : �θ� Ŭ������ �⺻ ������ ������
Ŭ���� �ȿ� �����ڰ� �ϳ��� ������ �⺻�����ڰ� �ڵ� ȣ���
--------------------------------------------------------------------
��� �����ϰ� Ctrl + / �ϸ� �ּ� �ɸ�

Ctrl + Space bar : �⺻������ ��� �� ���� ��
--------------------------------------------------------------------
[������]
SuperTest Ŭ���� �⺻������
SubTest Ŭ���� ������
SubTest Ŭ������ output()
�̸� = ȫ�浿
���� = 25
������ = 72.3
Ű = 185.3
------------
SuperTestŬ���� disp()
������ = 72.3
Ű = 185.3
------------
SuperTest Ŭ���� �⺻������
SubTest Ŭ���� ������
SuperTestŬ���� disp()
������ = 25.6
Ű = 158.7
*/
