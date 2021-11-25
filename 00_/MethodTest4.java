class Test {
	int a, b; //필드(전역변수), 초기화 - 0의 값을 가짐

	public void sum(){
		//int a=100; //sum()의 a, b값이 지정되지 않았으므로 class Test의 a, b값을 가져온다
		System.out.println(a + " + " + b + " = " + (a+b)); //구현
	}

	public void mul(){
		System.out.println(a + " * " + b + " = " + (a*b)); //구현
	}
}
//-----------------------------------------------------------------------------------
class MethodTest4 {
	public static void main(String[] args) {
		Test t = new Test(); //static이 없기 때문에 new해야함
		System.out.println("a = "+ t.a +"\t b = " + t.b);
		System.out.println();

		t.a = 50;
		t.b = 60;
		t.sum(); //호출, return값 없음, 호출한 메소드는 반드시 호출한 곳으로 되돌아온다 
		t.mul(); //호출, return값 없음
		System.out.println();

		Test t2 = new Test(); //클래스 Test(메뉴판)는 하나지만 객체 t, t2(음식)는 여러개 만들 수 있음.
		t2.a = 70;
		t2.b = 80;
		t2.sum(); //호출, return값 없음
		t2.mul(); //호출, return값 없음
	}
}

//두 class 중 main()을 가진 class MethodTest4로 java 파일명을 해야하고, MethodTest4.java를 컴파일하는 순간
//MethodTest4.class와 Test.class가 생성됨. 이때 Test.class는 MethodTest4.class를 실행하는데 도움만 줄 수 있음
//main()을 가진 class만 컴파일과 실행이 되고, 그 외 클래스는 main()을 가진 class를 컴파일할 때 같이 클래스 파일만 생김


/*
[실행결과]
D:\java_se\workspace\0723>javac MethodTest4.java

D:\java_se\workspace\0723>java MethodTest4
a = 0    b = 0

50 + 60 = 110
50 * 60 = 3000

70 + 80 = 150
70 * 80 = 5600
*/