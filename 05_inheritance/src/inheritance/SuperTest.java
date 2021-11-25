package inheritance;

public class SuperTest { //�θ�Ŭ����
	protected double weight, height; //�θ� �ڽ� Ŭ������ ���� ����. �׿� �ܺο��� ������ ���� �Ұ���
	
	public SuperTest() { //�⺻�����ڴ� �׳� �����δ� ���� ����
		System.out.println("SuperTest Ŭ���� �⺻������");
	}
	
	//2���� �Ű�����(�μ�)�� ���� ������ ������ּ���
	public SuperTest (double w, double h){
		System.out.println("SuperTest Ŭ���� ������");
		this.weight = w;
		this.height = h;
	}
	
	public void disp() {
		System.out.println("SuperTestŬ���� disp()");
		System.out.println("������ = " + weight);
		System.out.println("Ű = " + height);
	}
}

/*
�� ���(inheritance)
: is~a ���� (~�̴�)
: Ŭ������ �籸��

1. ��ӹ޴� Ŭ������ ������ִ� Ŭ������ �����ڿ� private�� ������ ��� ���� ��ӹ޴´�.
2. Super class : ����� �ִ� Ŭ����(�θ�) Base
   Sub  class : ��ӹ޴� Ŭ����(�ڽ�) Drived 
3. ���������� protected�� Sub class���� ������ �����ϴ� (���� �� �ڽĿ��� �����㰡)
4. Sub class�� ��ü�� �����ϸ� Super class�� �ڽ��� �����ڸ� ��� ȣ���Ѵ�.
5. ���߻���� �� �� ����.

[����]
class   SubŬ������   extends   SuperŬ������{ }

private : ���� ���� ����
protected : ���� �� �ڽĸ� ���� (�θ� �ڽ� Ŭ������ ���� ���� - ����� �� ���)
public : ��ü ����
*/