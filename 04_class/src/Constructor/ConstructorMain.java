package Constructor;

class ConstructorTest{
	String name; //기본적으로 String은 null, int는 0으로 초기값 있음
	int age;
	
	//생성자 Overload
	public ConstructorTest() { //생성자는 클래스명과 같다, 생성자는 앞에 void 같은 return형 쓰면 안됨
		System.out.println("default 생성자");
		System.out.println("this = "+this);
	}
	public ConstructorTest(String name) { 
		this();
		this.name = name;
		System.out.println("this = "+this);
	}
	public ConstructorTest(int age) {
		this("코난"); //Overload된 다른 생성자 호출 (같은 생성자끼리는 호출 가능)
		this.age = age;
		System.out.println("this = "+this);
	}
}
//------------------------------------------------
public class ConstructorMain {

	public static void main(String[] args) {
		ConstructorTest aa = new ConstructorTest(); //생성자는 new할 때 한번밖에 호출못함, 자동호출, 강제호출 안됨
		System.out.println("aa = "+aa);
		System.out.println("이름 = "+aa.name+"\t나이 = "+aa.age);
		System.out.println();
		
		ConstructorTest bb = new ConstructorTest("홍길동"); 
		System.out.println("bb = "+bb);
		System.out.println("이름 = "+bb.name+"\t나이 = "+bb.age);
		System.out.println();
		
		ConstructorTest cc = new ConstructorTest(25); 
		System.out.println("bb = "+cc);
		System.out.println("이름 = "+cc.name+"\t나이 = "+cc.age);
		System.out.println();
	}
}

/*
[실행결과]
default 생성자
this = Constructor.ConstructorTest@7de26db8
aa = Constructor.ConstructorTest@7de26db8
이름 = null	나이 = 0

default 생성자
this = Constructor.ConstructorTest@1175e2db
this = Constructor.ConstructorTest@1175e2db
bb = Constructor.ConstructorTest@1175e2db
이름 = 홍길동	나이 = 0

default 생성자
this = Constructor.ConstructorTest@36aa7bc2
this = Constructor.ConstructorTest@36aa7bc2
this = Constructor.ConstructorTest@36aa7bc2
bb = Constructor.ConstructorTest@36aa7bc2
이름 = 코난	나이 = 25
 */

/*
★ 생성자 (Constructor) 메소드
: 객체 초기화 //자바는 자동호출 때문에 생성자를 알아야 함.
1. 생성자명은 반드시 클래스명과 동일하다.
2. 자동호출 - 클래스를 메모리에 생성 시(new 할때) 생성자는 자동으로 호출됨
3. returnType(결과형)이 없다.
4. 클래스 안에 생성자가 하나도 없을 시에는 자동으로 기본(default) 생성자 호출 //생성자가 하나라도 만들어지면 다음부터 직접 만들어줘야 함
   기본생성자 - 인수가 없는 메소드 //()안에 아무것도 없음
----------------------------------------------------------
C++ //클래스는 쓰레기값을 가지고 있음. 생성자는 객체를 초기화하려고 만들어짐.

class Test {
	int a; //멤버변수, 쓰레기
	
	생성자
}
----------------------------------------------------------
Java

class Test {
	int a; //필드, 초기화 //자바는 이미 쓰레기값이 없음
}
----------------------------------------------------------
class Test {
	private int a;
	
	public void setA(int a){
		this.a = a;
	}
	
	public Test() {} //생성자
}
----------------------------------------------------------
class TestMain {
	public static void main(~~~){
		Test t = new Test(); //클래스 생성, 생성자 자동 호출
		t.setA(25); //setter 호출
----------------------------------------------------------
* 메소드
1. 구현
public return형 메소드명(인수형 인수, 인수형 인수,...){
}

public int sub(int a, int b){
	return 32;
}

public String sub(int a, int b){
	return "32";
}

public void sub(int a, int b){ //return형이 void임
}
----------------------------------------------------------
* 생성자 //생성자 안에 메소드 호출 가능
public 클래스명(){ //생성자는 앞에 return형이 없음
}
----------------------------------------------------------
★ this
1. 생략가능
2. 자기 자신 클래스의 정보(reference-참조값)를 갖고 있다.

★ this()
1. Overload 된 다른 생성자를 호출할 때
2. 생성자에서 반드시 첫줄에 써야 한다.
 */