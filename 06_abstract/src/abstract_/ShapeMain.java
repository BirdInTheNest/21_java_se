package abstract_;

import java.util.Scanner;

abstract class ShapeTest{ //�߻�Ŭ����
	protected double area;
	protected Scanner scan = new Scanner(System.in); 
	
	public ShapeTest() {
		System.out.println("ShapeTest �⺻ ������");
	}
	public abstract void calcArea(); //�߻�޼ҵ�� �޸𸮿� ���� ����, ������ Override�Ǽ� �� ���̴ϱ�
	public abstract void dispArea(); 
}
//------------------
class SamTest extends ShapeTest{ //SamTest(�ڽ�)�� ShapeTest(�θ�)�κ��� ��ӹ���
	protected int base, height;
	
	public SamTest() { //�����ڸ� ���ؼ� ������ ����
		System.out.println("SamTest �⺻������");
		System.out.print("�غ� : ");
		base = scan.nextInt();
		System.out.print("���� : ");
		height = scan.nextInt();
	}
	
	@Override //������̼� : �������� �Ǽ��� �����ֱ� ���Ͽ� ���. override �� �Ǹ� ���� ���� ��
	public void calcArea() {
		area = base*height/2.0;
	}
	
	@Override
	public void dispArea() {
		System.out.println("�ﰢ�� ���� = " +area);
	}
	//override�Ǽ� �θ� Ŭ������ ShapeTest�� calcArea()�� dispArea()�� ���õ�
}
//------------------
class SaTest extends ShapeTest{
	protected int width, height;
	
	public SaTest() { //�����ڸ� ���ؼ� ������ ����
		System.out.println("SaTest �⺻������");
		System.out.print("���� : ");
		width = scan.nextInt();
		System.out.print("���� : ");
		height = scan.nextInt();
	}
	
	@Override
	public void calcArea() {
		area = width*height;
	}
	
	@Override
	public void dispArea() {
		System.out.println("�簢�� ���� = " +area);
	}
}
//------------------
class SadariTest extends ShapeTest{
	protected int top, bottom, height;
	
	public SadariTest() { //�����ڸ� ���ؼ� ������ ����
		System.out.println("SadariTest �⺻������");
		System.out.print("���� : ");
		top = scan.nextInt();
		System.out.print("�غ� : ");
		bottom = scan.nextInt();		
		System.out.print("���� : ");
		height = scan.nextInt();
	}
	
	@Override
	public void calcArea() {
		area = (top+bottom)*height/2;
	}
	
	@Override
	public void dispArea() {
		System.out.println("��ٸ��� ���� = " +area);
	}
}
//------------------
public class ShapeMain {

	public static void main(String[] args) {
		/*
		SamTest sam = new SamTest(); //SamTestŬ������ sam ��ü 1:1����, ���յ� 100%
		sam.calcArea();
		sam.dispArea();
		System.out.println();
		
		SaTest sa = new SaTest(); //SaTestŬ������ sa ��ü 1:1����
		sa.calcArea();
		sa.dispArea();
		System.out.println();
		
		SadariTest sadari = new SadariTest(); //SadariTestŬ������ sadari ��ü 1:1����
		sadari.calcArea();
		sadari.dispArea();
		System.out.println();
		*/
		
		//���յ� ���߱�
		ShapeTest shape; //SamTest(�ڽ�)Ŭ������ ��ü shape�� ShapeTest(�θ�)�� ���������� ����
		shape = new SamTest();  //�θ� Ŭ���� Ÿ������ �ڽİ�ü�� ������ �� �ִ� (�θ�=�ڽ��� Ÿ���� �޶� �����), ������
		shape.calcArea();
		shape.dispArea();
		System.out.println();
		
		shape = new SaTest(); //SaTest(�ڽ�)Ŭ������ ��ü shape�� ShapeTest(�θ�)�� ���������� ����
		shape.calcArea();
		shape.dispArea();
		System.out.println();
		
		shape = new SadariTest(); //SadariTest(�ڽ�)Ŭ������ ��ü shape�� ShapeTest(�θ�)�� ���������� ����
		shape.calcArea();
		shape.dispArea();
		System.out.println();		
	}
}

/*
�ڹ��� �ֻ��� Ŭ���� - Object //��� Ÿ���� �ڷ����̵� �����͸� �� ���� �� ����(������)
�������� �������� : ��ӵǰ�, override�� �Ǿ�� �� (������������ ��� ���)

String a = "apple"; 
String b = a; //�����͸� �ְ���� ���� �ڷ����� �Ȱ��ƾ� ��

int c = 25;
int d = c;

Object ob = a;
			String
Object ob = c;
			int
			
MemberDTO aa = new MemberDTO();
SalaryDTO bb = new SalaryDTO();
FruitTest cc = new FruitTest();

Object[] ar = { new MemberDTO(), new SalaryDTO(), new FruitTest() };

�θ� = �ڽ� : �θ�Ŭ������ �ڽ�Ŭ������ ������ �Ǿ��� ���� ���� �� ����
�ڽ� = (�ڽ�)�θ� : �θ�� �ڽ��� �̱� �� ����. downCast(����ȯ) �θ� �ڽĿ��� ���߷��� ������
------------------------------------------
[������]
ShapeTest �⺻ ������
SamTest �⺻������
�غ� : 5
���� : 3
�ﰢ�� ���� = 7.5

ShapeTest �⺻ ������
SaTest �⺻������
���� : 1
���� : 4
�簢�� ���� = 4.0

ShapeTest �⺻ ������
SadariTest �⺻������
���� : 5
�غ� : 4
���� : 8
��ٸ��� ���� = 36.0
 */






