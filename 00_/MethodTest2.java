class MethodTest2 {
	/*
	int a, b; //�ʵ� - Ŭ���� �ȿ� ����
	public static void main(String[] args) {
		int a, b; //�������� - �Լ� ���� �ȿ� ����
	}

	public void sum(int a){ //�μ�(argument) �Ű�����(parameter) -�Լ� ()�ȿ� ����
	}
	*/

	public static void main(String[] args){	//ȣ���Ϸ��� static �ִ��� Ȯ�� -> ����

		MethodTest2 mt = new MethodTest2(); //�޸𸮿� ����
		
		System.out.println("�� = " + mt.sum(320, 258)); //ȣ��, ����� ���� ������ ȣ��ο��� ������
		System.out.println("�� = " + mt.sub(320, 258));
		System.out.println("�� = " + mt.mul(320, 258));
		System.out.println("�� = " + String.format("%.2f", mt.div(320, 258)));
	}

	public double div(int a, int b){ //����
		return (double)a/b;
	}

	public int mul(int a, int b){ //����
		return a*b;
	}

	public int sub(int a, int b){ //����
		return a-b;
	}
		
	public int sum(int a, int b){ //����
		return a+b;
	}	
}

/*
[������]
D:\java_se\workspace\0722>javac MethodTest2.java

D:\java_se\workspace\0722>java MethodTest2
�� = 578
�� = 62
�� = 82560
�� = 1.24
*/