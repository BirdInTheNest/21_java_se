class Operator2 {
	public static void main(String[] args) {
		boolean a = 25>36; //False
		System.out.println("a = " + a); //False
		System.out.println("!a = " + !a); //True, ! - 부정연산자
		System.out.println();

		String b = "apple"; //객체형 변수인 String은 new를 선언하지 않고도 생성가능
		String c = new String("apple");

		System.out.println("b == c : " + (b==c)); //false 주소값 비교, 주소가 다름
		System.out.println("b.equals(c) : " + (b.equals(c))); //True 문자열 비교
		System.out.println("!b.equals(c) : " + (!b.equals(c))); //false

		//C는 절대주소(실제주소)를 갖고, JAVA는 상대주소, 참조값(캐시값)을 가짐.
	}
}

/*
[실행결과]
D:\java_se\workspace\0722>javac Operator2.java

D:\java_se\workspace\0722>java Operator2
a = false
!a = true

b == c : false
b.equals(c) : true
!b.equals(c) : false
*/