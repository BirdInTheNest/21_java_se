package Constructor;

class ConstructorTest{
	String name; //�⺻������ String�� null, int�� 0���� �ʱⰪ ����
	int age;
	
	//������ Overload
	public ConstructorTest() { //�����ڴ� Ŭ������� ����, �����ڴ� �տ� void ���� return�� ���� �ȵ�
		System.out.println("default ������");
		System.out.println("this = "+this);
	}
	public ConstructorTest(String name) { 
		this();
		this.name = name;
		System.out.println("this = "+this);
	}
	public ConstructorTest(int age) {
		this("�ڳ�"); //Overload�� �ٸ� ������ ȣ�� (���� �����ڳ����� ȣ�� ����)
		this.age = age;
		System.out.println("this = "+this);
	}
}
//------------------------------------------------
public class ConstructorMain {

	public static void main(String[] args) {
		ConstructorTest aa = new ConstructorTest(); //�����ڴ� new�� �� �ѹ��ۿ� ȣ�����, �ڵ�ȣ��, ����ȣ�� �ȵ�
		System.out.println("aa = "+aa);
		System.out.println("�̸� = "+aa.name+"\t���� = "+aa.age);
		System.out.println();
		
		ConstructorTest bb = new ConstructorTest("ȫ�浿"); 
		System.out.println("bb = "+bb);
		System.out.println("�̸� = "+bb.name+"\t���� = "+bb.age);
		System.out.println();
		
		ConstructorTest cc = new ConstructorTest(25); 
		System.out.println("bb = "+cc);
		System.out.println("�̸� = "+cc.name+"\t���� = "+cc.age);
		System.out.println();
	}
}

/*
[������]
default ������
this = Constructor.ConstructorTest@7de26db8
aa = Constructor.ConstructorTest@7de26db8
�̸� = null	���� = 0

default ������
this = Constructor.ConstructorTest@1175e2db
this = Constructor.ConstructorTest@1175e2db
bb = Constructor.ConstructorTest@1175e2db
�̸� = ȫ�浿	���� = 0

default ������
this = Constructor.ConstructorTest@36aa7bc2
this = Constructor.ConstructorTest@36aa7bc2
this = Constructor.ConstructorTest@36aa7bc2
bb = Constructor.ConstructorTest@36aa7bc2
�̸� = �ڳ�	���� = 25
 */

/*
�� ������ (Constructor) �޼ҵ�
: ��ü �ʱ�ȭ //�ڹٴ� �ڵ�ȣ�� ������ �����ڸ� �˾ƾ� ��.
1. �����ڸ��� �ݵ�� Ŭ������� �����ϴ�.
2. �ڵ�ȣ�� - Ŭ������ �޸𸮿� ���� ��(new �Ҷ�) �����ڴ� �ڵ����� ȣ���
3. returnType(�����)�� ����.
4. Ŭ���� �ȿ� �����ڰ� �ϳ��� ���� �ÿ��� �ڵ����� �⺻(default) ������ ȣ�� //�����ڰ� �ϳ��� ��������� �������� ���� �������� ��
   �⺻������ - �μ��� ���� �޼ҵ� //()�ȿ� �ƹ��͵� ����
----------------------------------------------------------
C++ //Ŭ������ �����Ⱚ�� ������ ����. �����ڴ� ��ü�� �ʱ�ȭ�Ϸ��� �������.

class Test {
	int a; //�������, ������
	
	������
}
----------------------------------------------------------
Java

class Test {
	int a; //�ʵ�, �ʱ�ȭ //�ڹٴ� �̹� �����Ⱚ�� ����
}
----------------------------------------------------------
class Test {
	private int a;
	
	public void setA(int a){
		this.a = a;
	}
	
	public Test() {} //������
}
----------------------------------------------------------
class TestMain {
	public static void main(~~~){
		Test t = new Test(); //Ŭ���� ����, ������ �ڵ� ȣ��
		t.setA(25); //setter ȣ��
----------------------------------------------------------
* �޼ҵ�
1. ����
public return�� �޼ҵ��(�μ��� �μ�, �μ��� �μ�,...){
}

public int sub(int a, int b){
	return 32;
}

public String sub(int a, int b){
	return "32";
}

public void sub(int a, int b){ //return���� void��
}
----------------------------------------------------------
* ������ //������ �ȿ� �޼ҵ� ȣ�� ����
public Ŭ������(){ //�����ڴ� �տ� return���� ����
}
----------------------------------------------------------
�� this
1. ��������
2. �ڱ� �ڽ� Ŭ������ ����(reference-������)�� ���� �ִ�.

�� this()
1. Overload �� �ٸ� �����ڸ� ȣ���� ��
2. �����ڿ��� �ݵ�� ù�ٿ� ��� �Ѵ�.
 */