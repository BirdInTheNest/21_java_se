class Variable {
	public static void main(String[] args) {
		byte a; //정수형 - byte (1byte = 8bit) → -128 ~ +127
		a = 65;
		System.out.println("a = " + a);

		short b; //정수형 - short (2byte) → -32768 ~ +32767
		b = 65;
		System.out.println("b = " + b);

		int c; //정수형 - int (4byte)
		c = 'A';
		System.out.println("c = " + c); //65 (∵'A' - 65)

		char d; //문자형 - char (2byte = 16bit) → uni code   0 ~ 65535
		d = 'A';
		System.out.println("d = " + d);

		char e;
		e = 65;
		System.out.println("e = " + e); //A (∵'A' - 65)

		boolean f; //논리형 - boolean (1bit) - true or false
		f = 25 > 36; 
		System.out.println("f = " + f); //flase

		float g; //실수형 - float (4byte)
		//g = 43.8; - error: incompatible types: from double to float
		//(JAVA에서 실수는 double이 default값)
		g = 43.8f;
		System.out.println("g = " + g); 

		/*
		해결방법
		
		1. double g;
		   g = 43.8; - 43.8은 double형 상수 

		2. float g;
		   g = (float)43.8;
		   g = 43.8f; - 43.8f는 float형 상수 
		*/

		byte h=0; //정수형 - byte (1byte = 8bit) → -128 ~ +127
		//h = 128; - error: incompatible types: from int to byte (4byte를 1byte에 넣어서 오류)
		System.out.println("h = " + h); 

		long i; //정수형 - long (8byte)
		i = 30L; //long형 상수
		System.out.println("i = " + i);

		int j = 35;
		//long i; - error: variable i is already defined in method main(String[])
		i = j; //변수형 타입이 달라도 왼쪽이 byte가 더 크면 컴파일 가능함. 
			   //새로운 값이 들어가게 되면 이전 값은 사라지고 덮어버림
		System.out.println("i = " + i);
	}
}


/*
[실행결과]
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