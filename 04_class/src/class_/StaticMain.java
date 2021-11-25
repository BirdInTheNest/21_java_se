package class_;

public class StaticMain {
	private int a; //�ʵ�(Ŭ���� �ٷ� �ؿ� ����), �ν��Ͻ�����(static�� ���� - new�ؾ���)
				   //new �����ڸ� ����ϸ� �޸𸮿� ��� ������
	private static int b; //�ʵ�, Ŭ��������(static�� ���� - ������) //�ʵ� ���� �ʱ�ȭ �Ǿ� ����
						  //�޸� static ������ 1���� �����ǰ� new�� Ŭ������ ��� ��ü�� �����Ѵ�
	
	static { //static�� �ʱ�ȭ ����
		System.out.println("�ʱ�ȭ ����"); 
		b=0; //static�� �ִ� Ŭ���������� static�� �ʱ�ȭ �������� �ʱ�ȭ�ؾ� ��
	}
	 
	public StaticMain() { //������ 
		System.out.println("�⺻ ������");
		a=3; //static�� ���� �Ϲ����� �ν��Ͻ� ������ �����ڿ��� �ʱ�ȭ�ؾ� ��
	}
	
	public void calc() { //calc() �޼ҵ� - ���
		a++;
		b++;
	}
	
	public void disp() {
		System.out.println("a=" + this.a + "\t b=" + StaticMain.b);
	} //StaticMain Ŭ���� �ȿ��� �����ϴ� ���̱� ������ StaticMain.b���� StaticMain ��������
	
	public static void output() { //static �������� this���� �������� ����, ��ü ����� �θ��� ���ۿ� ����
		//System.out.println("a=" + this.a + "\t b=" + StaticMain.b); - error
		System.out.println("static method");
	}

	public static void main(String[] args) {
		StaticMain st = new StaticMain(); // StaticMain Ŭ���� ��ü st �޸𸮿� ����, �⺻������ ȣ��
		st.calc(); //calc() �޼ҵ� ȣ��
		st.disp(); //a=4 b=1
		System.out.println();
		
		StaticMain st2 = new StaticMain();
		st2.calc();
		st2.disp(); //a=4 b=2
		System.out.println();
		
		StaticMain st3 = new StaticMain();
		st3.calc();
		st3.disp(); //a=4 b=3 //b�� static ������ 1���� �����ǰ� new�� Ŭ������ ��� ��ü�� �����ϱ� �빮�� b++�� ������ ��� ����
		System.out.println();
		
		//static �޼ҵ� ȣ��
		StaticMain.output(); //Ŭ������.�޼ҵ�() 
		output(); //Class StaticMain�� �ֱ� ������ ���� ����
		st.output(); //��ü.�޼ҵ�()
	}
}//Class StaticMain

/*
�� static - Ŭ��������
1. �޸� static ������ 1���� �����ȴ�. �� �ʱ�ȭ 1���� ����
   new�� Ŭ������ ��� ��ü�� �����Ѵ�. (��������) //���ġ ���� �� ���
2. static�޼ҵ忡���� static������ ��� ����
   static�޼ҵ忡���� this�� ������ �� ����
3. static������ �޼ҵ�� ȣ��� Ŭ���������� ���� ȣ�� �� �� �ִ�.
   ��ü�ε� ȣ���� �����ϴ�
4. static{ } - �ʱ�ȭ ����
           - �����ں��ٵ� ���� �����Ѵ�

�� import static 
: �����ϰ� static ��� �Ǵ� �޼ҵ带 ȣ���� �� ���
---------------------------------------------------
�� �޸�
new �����ڸ� ����ϸ� �޸𸮿� ��� ������
static ������ �Ҹ��� �ȵ�, static ������ �޸𸮿� �ѹ��ۿ� ���� �ȵ� (�̱����� static������ ������)
static ������ �ִ� ���� : ��������
stack ������ {} ������ ������ �Ҹ�
*/

/*
[������]
�ʱ�ȭ ����
�⺻ ������
a=4	 b=1

�⺻ ������
a=4	 b=2

�⺻ ������
a=4	 b=3

static method
static method
static method
*/