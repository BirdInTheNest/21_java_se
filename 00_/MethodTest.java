class MethodTest {
	int a; //�ʵ�, �޸� ����(����) ���� 
	int b=10; 
	//int c; 
	//c=10; - error �ּҰ� ������ �� ��
	//����� ���ÿ� ���� �����ϴ� int b=10;�� ����, �̹� ������ ���� c=10; �̷��� �ϴ°͸� �ȵȴ�

	public static void main(String[] args) { //void - ������� �ƹ��͵� ������ ����
		//System.out.println("args[0] = " + args[0]);
		//System.out.println("args[1] = " + args[1]);

		//ȣ�� (�޸� �����Ǿ�� �Լ� ȣ�� ����)
		//static�� ����� ���ÿ� �޸𸮿� �ڵ����� �����ȴ�. (�ýĿ�)
		MethodTest.output(); //.�� �Ҽ��� ��Ÿ��, ȣ���� ������ ������.

		MethodTest mt = new MethodTest();
		mt.disp(); //.�� �Ҽ��� ��Ÿ��, ȣ���� ������ ������.
	}

	public void disp() { //����
		System.out.println("non-static method");
	}

	public static void output() {
		System.out.println("static method");
	}
}

/*
[������]
D:\java_se\workspace\0722>javac MethodTest.java

D:\java_se\workspace\0722>java MethodTest
static method
non-static method
*/