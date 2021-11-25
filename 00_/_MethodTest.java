class _MethodTest {
	int a; //필드, 메모리 생성(선언) 가능 
	int b=10; 

	//int c; 
	//c=10; - error 주소값 대입은 안 됨
	//선언과 동시에 값을 대입하는 int b=10;은 가능, 이미 생성된 값에 대입하는 c=10;는 불가능

	public static void main(String[] args) { 
		System.out.println("args[0] = " + args[0]);
		System.out.println("args[1] = " + args[1]);
	}
}

/*
[실행결과]
D:\java_se\workspace>javac _MethodTest.java

D:\java_se\workspace>java _MethodTest 사과 딸기
args[0] = 사과
args[1] = 딸기
*/