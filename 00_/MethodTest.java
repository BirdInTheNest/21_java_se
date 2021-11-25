class MethodTest {
	int a; //필드, 메모리 생성(선언) 가능 
	int b=10; 
	//int c; 
	//c=10; - error 주소값 대입은 안 됨
	//선언과 동시에 값을 대입하는 int b=10;은 가능, 이미 생성된 값에 c=10; 이렇게 하는것만 안된다

	public static void main(String[] args) { //void - 결과물이 아무것도 나오지 않음
		//System.out.println("args[0] = " + args[0]);
		//System.out.println("args[1] = " + args[1]);

		//호출 (메모리 생성되어야 함수 호출 가능)
		//static은 실행과 동시에 메모리에 자동으로 생성된다. (시식용)
		MethodTest.output(); //.은 소속을 나타냄, 호출이 끝나면 복귀함.

		MethodTest mt = new MethodTest();
		mt.disp(); //.은 소속을 나타냄, 호출이 끝나면 복귀함.
	}

	public void disp() { //구현
		System.out.println("non-static method");
	}

	public static void output() {
		System.out.println("static method");
	}
}

/*
[실행결과]
D:\java_se\workspace\0722>javac MethodTest.java

D:\java_se\workspace\0722>java MethodTest
static method
non-static method
*/