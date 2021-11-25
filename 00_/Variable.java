class Variable {
	public static void main(String[] args) {
		byte a; //������ - byte (1byte = 8bit) �� -128 ~ +127
		a = 65;
		System.out.println("a = " + a);

		short b; //������ - short (2byte) �� -32768 ~ +32767
		b = 65;
		System.out.println("b = " + b);

		int c; //������ - int (4byte)
		c = 'A';
		System.out.println("c = " + c); //65 (��'A' - 65)

		char d; //������ - char (2byte = 16bit) �� uni code   0 ~ 65535
		d = 'A';
		System.out.println("d = " + d);

		char e;
		e = 65;
		System.out.println("e = " + e); //A (��'A' - 65)

		boolean f; //���� - boolean (1bit) - true or false
		f = 25 > 36; 
		System.out.println("f = " + f); //flase

		float g; //�Ǽ��� - float (4byte)
		//g = 43.8; - error: incompatible types: from double to float
		//(JAVA���� �Ǽ��� double�� default��)
		g = 43.8f;
		System.out.println("g = " + g); 

		/*
		�ذ���
		
		1. double g;
		   g = 43.8; - 43.8�� double�� ��� 

		2. float g;
		   g = (float)43.8;
		   g = 43.8f; - 43.8f�� float�� ��� 
		*/

		byte h=0; //������ - byte (1byte = 8bit) �� -128 ~ +127
		//h = 128; - error: incompatible types: from int to byte (4byte�� 1byte�� �־ ����)
		System.out.println("h = " + h); 

		long i; //������ - long (8byte)
		i = 30L; //long�� ���
		System.out.println("i = " + i);

		int j = 35;
		//long i; - error: variable i is already defined in method main(String[])
		i = j; //������ Ÿ���� �޶� ������ byte�� �� ũ�� ������ ������. 
			   //���ο� ���� ���� �Ǹ� ���� ���� ������� �������
		System.out.println("i = " + i);
	}
}


/*
[������]
D:\java_se\workspace\0720>javac Variable.java

D:\java_se\workspace\0720>java Variable
a = 65
b = 65
c = 65
d = A
e = A
f = false
g = 43.8
h = 0
i = 30
i = 35
*/