class _MethodTest {
	int a; //�ʵ�, �޸� ����(����) ���� 
	int b=10; 

	//int c; 
	//c=10; - error �ּҰ� ������ �� ��
	//����� ���ÿ� ���� �����ϴ� int b=10;�� ����, �̹� ������ ���� �����ϴ� c=10;�� �Ұ���

	public static void main(String[] args) { 
		System.out.println("args[0] = " + args[0]);
		System.out.println("args[1] = " + args[1]);
	}
}

/*
[������]
D:\java_se\workspace>javac _MethodTest.java

D:\java_se\workspace>java _MethodTest ��� ����
args[0] = ���
args[1] = ����
*/