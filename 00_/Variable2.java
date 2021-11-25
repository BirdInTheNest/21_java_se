class Variable2 {
	int a; //필드(클래스 소속 변수), 초기화되어 있음, 인스턴스 변수(static이 없음)
	static int b; //필드, 초기화, 클래스 변수(static이 있음)

	public static void main(String[] args) {
		//int a; - error: variable a might not have been initialized
				//지역변수(함수 소속 변수), Garbage값을 가지고 있음, 따라서 반드시 초기화해야 함. 
		int a=10;
		System.out.println("지역변수 a = " + a);

		Variable2 v = new Variable2(); //인스턴스 변수는 반드시 new로 생성해야 사용가능함.
		System.out.println("필드 a = " + v.a);
		System.out.println("필드 b = " + Variable2.b);
		System.out.println("필드 b = " + b); //Variable2 클래스 안에 있기 때문에 Variable2.b를 b로생략가능함.
	}
}
