class MethodTest2 {
	/*
	int a, b; //필드 - 클래스 안에 있음
	public static void main(String[] args) {
		int a, b; //지역변수 - 함수 영역 안에 있음
	}

	public void sum(int a){ //인수(argument) 매개변수(parameter) -함수 ()안에 있음
	}
	*/

	public static void main(String[] args){	//호출하려면 static 있는지 확인 -> 없음

		MethodTest2 mt = new MethodTest2(); //메모리에 생성
		
		System.out.println("합 = " + mt.sum(320, 258)); //호출, 결과값 산출 순서는 호출부에서 정해짐
		System.out.println("차 = " + mt.sub(320, 258));
		System.out.println("곱 = " + mt.mul(320, 258));
		System.out.println("몫 = " + String.format("%.2f", mt.div(320, 258)));
	}

	public double div(int a, int b){ //구현
		return (double)a/b;
	}

	public int mul(int a, int b){ //구현
		return a*b;
	}

	public int sub(int a, int b){ //구현
		return a-b;
	}
		
	public int sum(int a, int b){ //구현
		return a+b;
	}	
}

/*
[실행결과]
D:\java_se\workspace\0722>javac MethodTest2.java

D:\java_se\workspace\0722>java MethodTest2
합 = 578
차 = 62
곱 = 82560
몫 = 1.24
*/