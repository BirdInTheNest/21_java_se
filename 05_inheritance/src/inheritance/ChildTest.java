package inheritance;

public class ChildTest extends SuperTest { //ChildTest는 SuperTest로부터 상속받음
	private String name;
	private int age;
	
	public ChildTest(String name, int age, double w, double h) { //생성자
		super(w, h); //자식 생성자에서 부모 생성자 호출, 첫번째 줄에 써야함
		
		System.out.println("ChildTest 클래스 생성자");
		this.name = name;
		this.age = age;
		super.weight = w; //this.weight = w; //super 는 부모클래스의 참조값을 갖고 있고
		super.height = h; //this.height = h; //this 는 자신의 클래스의 참조값을 갖고 있다
	} 
	
	public void disp() { //disp() 메소드
		System.out.println("ChildTest 클래스의 disp()");
		System.out.println("이름 = " + name);
		System.out.println("나이 = " + age);
		System.out.println("몸무게 = " + weight);
		System.out.println("키 = " + height);		
	}
	
	public static void main(String[] args) { //main() 메소드
		ChildTest aa = new ChildTest("홍길동", 25, 72.3, 185.3);
		aa.disp(); //모든 우선권은 자식클래스인 나에게 온다
		System.out.println("------------");
		
		SuperTest bb = new ChildTest("코난", 13, 25.6, 158.7); //부모 클래스 타입으로 자식객체를 참조할 수 있다
		//부모타입으로 자식객체를 참조하게 되면 부모가 가지고 있는 메소드만 사용할 수 있다.
		bb.disp(); //메소드가 Override가 되면 참조값이 부모든 자식이든 무조건 자식 메소드가 호출된다.
	}
}

/*
 * Overload
- 같은 클래스 안에서 메소드명이 똑같아야 함. 인수형이 다르거나 인수의 개수가 다름 

class AA {
	public sub(int a){}
	public sub(int a, int b){}
}
-------------------------------------------------------
★ Override 메소드
1. Super클래스와 Sub클래스에 똑같은 메소드가 존재
   부모와 자식클래스의 메소드가 같다. (한글자도 빠짐없이 다 똑같아야 함)
2. 모든 우선권은 Sub클래스가 갖는다.
3. Super, Sub 클래스의 접근제어자(Modifier)는 틀려도 되지만
   Super보다 Sub클래스의 접근제어자(Modifier)가 더 커야한다.
   접근제어자(modifier)는 달라도 됨. 단 자식 클래스가 더 커야 함
	
class AA {
	protected sub(int a){}
}

class BB extends AA {
	public sub(int a){}
}
-------------------------------------------------------
★ this 와 this()
1. this 는 자신의 클래스의 참조값을 갖고 있다
2. this()는 Overload된 다른 생성자를 호출 할 수 있다.
3. this()는 생성자의 첫줄에 써야 한다

★ super 와 super()
1. super 는 부모클래스의 참조값을 갖고 있다.
2. super() 는 부모클래스의 생성자를 호출 할 수 있다.
3. super() 는 생성자의 첫줄에 써야 한다.
-------------------------------------------------------
this()
생성자는 자동 호출 (new할 때)
생성자끼리는 호출이 가능하다
Overload된 다른 생성자를 호출

super()
자식 생성자에서 부모 생성자를 호출
첫번째 줄에 써야함
-------------------------------------------------------
[실행결과]
SuperTest 클래스 기본생성자
ChildTest 클래스 생성자
ChildTest 클래스의 disp()
이름 = 홍길동
나이 = 25
몸무게 = 72.3
키 = 185.3
------------
SuperTest 클래스 기본생성자
ChildTest 클래스 생성자
ChildTest 클래스의 disp()
이름 = 코난
나이 = 13
몸무게 = 25.6
키 = 158.7
*/