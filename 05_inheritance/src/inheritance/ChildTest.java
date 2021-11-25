package inheritance;

public class ChildTest extends SuperTest { //ChildTest�� SuperTest�κ��� ��ӹ���
	private String name;
	private int age;
	
	public ChildTest(String name, int age, double w, double h) { //������
		super(w, h); //�ڽ� �����ڿ��� �θ� ������ ȣ��, ù��° �ٿ� �����
		
		System.out.println("ChildTest Ŭ���� ������");
		this.name = name;
		this.age = age;
		super.weight = w; //this.weight = w; //super �� �θ�Ŭ������ �������� ���� �ְ�
		super.height = h; //this.height = h; //this �� �ڽ��� Ŭ������ �������� ���� �ִ�
	} 
	
	public void disp() { //disp() �޼ҵ�
		System.out.println("ChildTest Ŭ������ disp()");
		System.out.println("�̸� = " + name);
		System.out.println("���� = " + age);
		System.out.println("������ = " + weight);
		System.out.println("Ű = " + height);		
	}
	
	public static void main(String[] args) { //main() �޼ҵ�
		ChildTest aa = new ChildTest("ȫ�浿", 25, 72.3, 185.3);
		aa.disp(); //��� �켱���� �ڽ�Ŭ������ ������ �´�
		System.out.println("------------");
		
		SuperTest bb = new ChildTest("�ڳ�", 13, 25.6, 158.7); //�θ� Ŭ���� Ÿ������ �ڽİ�ü�� ������ �� �ִ�
		//�θ�Ÿ������ �ڽİ�ü�� �����ϰ� �Ǹ� �θ� ������ �ִ� �޼ҵ常 ����� �� �ִ�.
		bb.disp(); //�޼ҵ尡 Override�� �Ǹ� �������� �θ�� �ڽ��̵� ������ �ڽ� �޼ҵ尡 ȣ��ȴ�.
	}
}

/*
 * Overload
- ���� Ŭ���� �ȿ��� �޼ҵ���� �Ȱ��ƾ� ��. �μ����� �ٸ��ų� �μ��� ������ �ٸ� 

class AA {
	public sub(int a){}
	public sub(int a, int b){}
}
-------------------------------------------------------
�� Override �޼ҵ�
1. SuperŬ������ SubŬ������ �Ȱ��� �޼ҵ尡 ����
   �θ�� �ڽ�Ŭ������ �޼ҵ尡 ����. (�ѱ��ڵ� �������� �� �Ȱ��ƾ� ��)
2. ��� �켱���� SubŬ������ ���´�.
3. Super, Sub Ŭ������ ����������(Modifier)�� Ʋ���� ������
   Super���� SubŬ������ ����������(Modifier)�� �� Ŀ���Ѵ�.
   ����������(modifier)�� �޶� ��. �� �ڽ� Ŭ������ �� Ŀ�� ��
	
class AA {
	protected sub(int a){}
}

class BB extends AA {
	public sub(int a){}
}
-------------------------------------------------------
�� this �� this()
1. this �� �ڽ��� Ŭ������ �������� ���� �ִ�
2. this()�� Overload�� �ٸ� �����ڸ� ȣ�� �� �� �ִ�.
3. this()�� �������� ù�ٿ� ��� �Ѵ�

�� super �� super()
1. super �� �θ�Ŭ������ �������� ���� �ִ�.
2. super() �� �θ�Ŭ������ �����ڸ� ȣ�� �� �� �ִ�.
3. super() �� �������� ù�ٿ� ��� �Ѵ�.
-------------------------------------------------------
this()
�����ڴ� �ڵ� ȣ�� (new�� ��)
�����ڳ����� ȣ���� �����ϴ�
Overload�� �ٸ� �����ڸ� ȣ��

super()
�ڽ� �����ڿ��� �θ� �����ڸ� ȣ��
ù��° �ٿ� �����
-------------------------------------------------------
[������]
SuperTest Ŭ���� �⺻������
ChildTest Ŭ���� ������
ChildTest Ŭ������ disp()
�̸� = ȫ�浿
���� = 25
������ = 72.3
Ű = 185.3
------------
SuperTest Ŭ���� �⺻������
ChildTest Ŭ���� ������
ChildTest Ŭ������ disp()
�̸� = �ڳ�
���� = 13
������ = 25.6
Ű = 158.7
*/