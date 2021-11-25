package inheritance;

public class SubTest extends SuperTest{ //SubTest클래스는 SuperTest클래스 상속받음. 
	private String name;
	private int age;
	
	public SubTest(String name, int age, double w, double h) { //SubTest 생성자
		System.out.println("SubTest 클래스 생성자");
		this.name = name;
		this.age = age;
		super.weight = w; //this.weight = w; //내것도 내거 부모것도 내거
		super.height = h; //this.height = h;
		//super. : 부모 인자의 주소값을 다이렉트로 갖고 오는 것
	} 
	
	public void output() { //output() 메소드
		System.out.println("SubTest 클래스의 output()");
		System.out.println("이름 = " + name);
		System.out.println("나이 = " + age);
		System.out.println("몸무게 = " + weight);
		System.out.println("키 = " + height);
	}

	public static void main(String[] args) {
		SubTest aa = new SubTest("홍길동", 25, 72.3, 185.3); //aa는 SubTest 참조
		aa.output();
		System.out.println("------------");
		aa.disp(); //우선 내 클래스(SubTest)에서 메소드를 찾고 없으면 부모 클래스(SuperTest)에서 찾는다
		System.out.println("------------");

		SuperTest bb = new SubTest("코난", 13, 25.6, 158.7); //bb는 SuperTest 참조
		//bb.output(); -error: bb의 참조값이 SuperTest에 한정되어 있기 때문에 SubTest에 있는 output()을 부를 수 없음
		bb.disp();
	}
}

/*
자식 클래스를 만들면 자식 클래스는 자기 것과 부모 것을 한꺼번에 메모리에 생성한다
자식 클래스를 new하면 자기 생성자와 부모 생성자를 2번 호출함. 부모는 기본적으로 기본 생성자를 호출

- error : 부모 클래스의 기본 생성자 내놔라
클래스 안에 생성자가 하나도 없으면 기본생성자가 자동 호출됨
--------------------------------------------------------------------
블록 지정하고 Ctrl + / 하면 주석 걸림

Ctrl + Space bar : 기본생성자 목록 맨 위에 뜸
--------------------------------------------------------------------
[실행결과]
SuperTest 클래스 기본생성자
SubTest 클래스 생성자
SubTest 클래스의 output()
이름 = 홍길동
나이 = 25
몸무게 = 72.3
키 = 185.3
------------
SuperTest클래스 disp()
몸무게 = 72.3
키 = 185.3
------------
SuperTest 클래스 기본생성자
SubTest 클래스 생성자
SuperTest클래스 disp()
몸무게 = 25.6
키 = 158.7
*/
