class Variable2 {
	int a; //�ʵ�(Ŭ���� �Ҽ� ����), �ʱ�ȭ�Ǿ� ����, �ν��Ͻ� ����(static�� ����)
	static int b; //�ʵ�, �ʱ�ȭ, Ŭ���� ����(static�� ����)

	public static void main(String[] args) {
		//int a; - error: variable a might not have been initialized
				//��������(�Լ� �Ҽ� ����), Garbage���� ������ ����, ���� �ݵ�� �ʱ�ȭ�ؾ� ��. 
		int a=10;
		System.out.println("�������� a = " + a);

		Variable2 v = new Variable2(); //�ν��Ͻ� ������ �ݵ�� new�� �����ؾ� ��밡����.
		System.out.println("�ʵ� a = " + v.a);
		System.out.println("�ʵ� b = " + Variable2.b);
		System.out.println("�ʵ� b = " + b); //Variable2 Ŭ���� �ȿ� �ֱ� ������ Variable2.b�� b�λ���������.
	}
}
