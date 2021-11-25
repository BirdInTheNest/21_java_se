package nested;

public class Outer {
	private String name; //private�� �� Ŭ������ ��� ����. ��ø��Ű�� ������, setter, getter �� �ᵵ ��
	
	public void output() {
		System.out.println("�̸� = "+this.name+"\t ���� = "+new Inner().age);
		//�ٱ��� Ŭ������ ������ Ŭ������ ����� ���� �Ұ���,�� ������ Ŭ������ ��ü�� �����ϸ� ���� ����
	}
	
	class Inner { //��� ���� Ŭ����(member inner class)
		private int age;
		
		public void disp() {
			System.out.println("�̸� = "+Outer.this.name+"\t ���� = "+this.age);
			//���ʿ� �ִ� Ŭ������ �ٱ��� Ŭ������ ��� ����� ���� ����
		}
	}
	
	public static void main(String[] args) {
		Outer out = new Outer();
		out.name = "ȫ�浿";
		out.output();

		Outer.Inner in = out.new Inner(); //Outer�ȿ� �ִ� Ŭ�������� �˷��ش�
		in.age = 25;
		in.disp();
		
		Outer.Inner in2 = out.new Inner();
		in2.age = 30;
		in2.disp();
		
		Outer.Inner in3 = new Outer().new Inner();
		
		//in3.name = "�ڳ�"; //- error : Inner()�ȿ��� age�� �ְ�, name�� Outer()�� ����
		in3.age = 35;
		in3.disp();
	}
}
/*
[������]
�̸� = ȫ�浿	 ���� = 0
�̸� = ȫ�浿	 ���� = 25
�̸� = ȫ�浿	 ���� = 30
�̸� = null	 ���� = 35
 */


/*
�� ��øŬ���� 
has~a ����
�ٸ� Ŭ���� ���ο� ���� �Ǵ� Ŭ������ ��øŬ����(nested class)��� �Ѵ�.

1. ��øŬ������ ���������� ������Ʈ�� ������� �� �ִ� ����ƽ Ŭ����(static class)�� 
2. �ڽ��� ���ǵ� Ŭ������ ������Ʈ �ȿ����� ������� �� �ִ� ���� Ŭ����(inner class)�� ���еȴ�.

����Ŭ������ �ٽ� ������ ���� �� ������ ���еȴ�.
1. ����ʵ�ó�� ������Ʈ ������ ���ǵǴ� ��� ���� Ŭ����(member inner class)�� 
2. �޼ҵ� �������� ���ú����� �����Ͽ� ����ϵ� 
   ����� �޼ҵ� �������� ��� ������ ���� ���� Ŭ����(local inner class), 
3. �׸��� �̸��� ���� �ʴ� �͸� ���� Ŭ����(anonymous inner class)��.
   �ȵ���̵�� ��κ� �͸� ���� Ŭ������

Member Inner Class
���ʿ� �ִ� Ŭ������ �ٱ��� Ŭ������ ��� ����� ���� ����
������ �ٱ��� Ŭ������ ������ Ŭ������ ����� ���� �Ұ���
�� ������ Ŭ������ ��ü�� �����ϸ� ���� �����ϴ�.

class Ŭ {
	static class Ŭ2 {}	- ����ƽ Ŭ����(static class)
	class Ŭ2 {} 		- ��� ���� Ŭ����(member inner class)
	�޼ҵ�() {
		class Ŭ3 {} 	- ���� ���� Ŭ����(local inner class)
	}
	{} 					- �͸� ���� Ŭ����(anonymous inner class)
}
-------------------------------------------------------------
Ŭ����
class Ŭ {
	�ʵ�; 
	�޼ҵ�() { //������ ���� �� �ִ� �� Ŭ�����ۿ� ����
	}

	class Ŭ2 {}
}
-------------------------------------------------------------
����� �ڽ��� �θ�ű��� �޸𸮿� ����������, ��øŬ������ �������� ����.
*/