class Test {
	int a, b; //�ʵ�(��������), �ʱ�ȭ - 0�� ���� ����

	public void sum(){
		//int a=100; //sum()�� a, b���� �������� �ʾ����Ƿ� class Test�� a, b���� �����´�
		System.out.println(a + " + " + b + " = " + (a+b)); //����
	}

	public void mul(){
		System.out.println(a + " * " + b + " = " + (a*b)); //����
	}
}
//-----------------------------------------------------------------------------------
class MethodTest4 {
	public static void main(String[] args) {
		Test t = new Test(); //static�� ���� ������ new�ؾ���
		System.out.println("a = "+ t.a +"\t b = " + t.b);
		System.out.println();

		t.a = 50;
		t.b = 60;
		t.sum(); //ȣ��, return�� ����, ȣ���� �޼ҵ�� �ݵ�� ȣ���� ������ �ǵ��ƿ´� 
		t.mul(); //ȣ��, return�� ����
		System.out.println();

		Test t2 = new Test(); //Ŭ���� Test(�޴���)�� �ϳ����� ��ü t, t2(����)�� ������ ���� �� ����.
		t2.a = 70;
		t2.b = 80;
		t2.sum(); //ȣ��, return�� ����
		t2.mul(); //ȣ��, return�� ����
	}
}

//�� class �� main()�� ���� class MethodTest4�� java ���ϸ��� �ؾ��ϰ�, MethodTest4.java�� �������ϴ� ����
//MethodTest4.class�� Test.class�� ������. �̶� Test.class�� MethodTest4.class�� �����ϴµ� ���� �� �� ����
//main()�� ���� class�� �����ϰ� ������ �ǰ�, �� �� Ŭ������ main()�� ���� class�� �������� �� ���� Ŭ���� ���ϸ� ����


/*
[������]
D:\java_se\workspace\0723>javac MethodTest4.java

D:\java_se\workspace\0723>java MethodTest4
a = 0    b = 0

50 + 60 = 110
50 * 60 = 3000

70 + 80 = 150
70 * 80 = 5600
*/