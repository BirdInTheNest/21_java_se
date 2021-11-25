package nested;

public class Outer {
	private String name; //private은 내 클래스만 사용 가능. 중첩시키면 생성자, setter, getter 안 써도 됨
	
	public void output() {
		System.out.println("이름 = "+this.name+"\t 나이 = "+new Inner().age);
		//바깥쪽 클래스는 안쪽의 클래스의 멤버에 접근 불가능,단 안쪽의 클래스로 객체를 선언하면 접근 가능
	}
	
	class Inner { //멤버 내부 클래스(member inner class)
		private int age;
		
		public void disp() {
			System.out.println("이름 = "+Outer.this.name+"\t 나이 = "+this.age);
			//안쪽에 있는 클래스는 바깥쪽 클래스의 모든 멤버에 접근 가능
		}
	}
	
	public static void main(String[] args) {
		Outer out = new Outer();
		out.name = "홍길동";
		out.output();

		Outer.Inner in = out.new Inner(); //Outer안에 있는 클래스임을 알려준다
		in.age = 25;
		in.disp();
		
		Outer.Inner in2 = out.new Inner();
		in2.age = 30;
		in2.disp();
		
		Outer.Inner in3 = new Outer().new Inner();
		
		//in3.name = "코난"; //- error : Inner()안에는 age만 있고, name은 Outer()에 있음
		in3.age = 35;
		in3.disp();
	}
}
/*
[실행결과]
이름 = 홍길동	 나이 = 0
이름 = 홍길동	 나이 = 25
이름 = 홍길동	 나이 = 30
이름 = null	 나이 = 35
 */


/*
★ 중첩클래스 
has~a 관계
다른 클래스 내부에 정의 되는 클래스를 중첩클래스(nested class)라고 한다.

1. 중첩클래스는 독립적으로 오브젝트로 만들어질 수 있는 스태틱 클래스(static class)와 
2. 자신이 정의된 클래스의 오브젝트 안에서만 만들어질 수 있는 내부 클래스(inner class)로 구분된다.

내부클래스는 다시 범위에 따라 세 가지로 구분된다.
1. 멤버필드처럼 오브젝트 레벨에 정의되는 멤버 내부 클래스(member inner class)와 
2. 메소드 레벨에서 로컬변수를 선언하여 사용하듯 
   선언된 메소드 내에서만 사용 가능한 로컬 내부 클래스(local inner class), 
3. 그리고 이름을 갖지 않는 익명 내부 클래스(anonymous inner class)다.
   안드로이드는 대부분 익명 내부 클래스임

Member Inner Class
안쪽에 있는 클래스는 바깥쪽 클래스의 모든 멤버에 접근 가능
하지만 바깥쪽 클래스는 안쪽의 클래스의 멤버에 접근 불가능
단 안쪽의 클래스로 객체를 선언하면 접근 가능하다.

class 클 {
	static class 클2 {}	- 스태틱 클래스(static class)
	class 클2 {} 		- 멤버 내부 클래스(member inner class)
	메소드() {
		class 클3 {} 	- 로컬 내부 클래스(local inner class)
	}
	{} 					- 익명 내부 클래스(anonymous inner class)
}
-------------------------------------------------------------
클래스
class 클 {
	필드; 
	메소드() { //구현을 가질 수 있는 건 클래스밖에 없다
	}

	class 클2 {}
}
-------------------------------------------------------------
상속은 자식이 부모거까지 메모리에 생성하지만, 중첩클래스는 생성하지 않음.
*/