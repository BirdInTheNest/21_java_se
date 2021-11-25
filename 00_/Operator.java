class Operator {
	public static void main(String[] args) {
		int a=5;
		a+=2; //a=a+2 -> a=7
		a*=3; //a=a*3 -> a=21
		System.out.println("a = " + a); //21

		a++; //a+=1, a=a+1 -> a=22
		System.out.println("a = " + a); //22

		int b = a++;
		//1. int b = a; //b=22
		//2. a++; //a=23
		System.out.println("a = " + a + "\t b = " + b); //a=23 b=22

		System.out.println("a++ = " + a++); //23
		//1. System.out.println("a++ = " + a); (a값을 찍어라) //23
		//2. a++; //a=24

		System.out.println("a = " + a); //24

		int c = a++ - --b; //3
		//1. --b; //b=21
		//2. int c = a - b; //c=3
		//3. a++; //a=25
		System.out.println("a = " + a + "\t b = " + b + "\t c = " + c);
	}
}
		
/*
연산자의 우선 순위 : () -> ++, --

선행						후행
++a(먼저 더해라)			a++(마지막에 더해라)

int a = 10;

int b = a++;			int c = ++a;
//1. int b = a;			//1. ++a;
//2. a++;				//2. int c = a;

int d = ++a * b--		//a=3, b=2. d=?
//1. ++a; //a=4
//2. int d = a * b //d=8
//3. b--; //b=1
*/

/*
[실행결과]
D:\java_se\workspace\0722>javac Operator.java

D:\java_se\workspace\0722>java Operator
a = 21
a = 22
a = 23   b = 22
a++ = 23
a = 24
a = 25   b = 21  c = 3
*/