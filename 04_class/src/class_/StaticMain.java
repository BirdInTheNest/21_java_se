package class_;

public class StaticMain {
	private int a; //필드(클래스 바로 밑에 있음), 인스턴스변수(static이 없음 - new해야함)
				   //new 연산자를 사용하면 메모리에 계속 생성됨
	private static int b; //필드, 클래스변수(static이 있음 - 시음식) //필드 안은 초기화 되어 있음
						  //메모리 static 영역에 1번만 생성되고 new한 클래스의 모든 객체가 공유한다
	
	static { //static의 초기화 영역
		System.out.println("초기화 영역"); 
		b=0; //static이 있는 클래스변수는 static의 초기화 영역에서 초기화해야 함
	}
	 
	public StaticMain() { //생성자 
		System.out.println("기본 생성자");
		a=3; //static이 없는 일반적인 인스턴스 변수는 생성자에서 초기화해야 함
	}
	
	public void calc() { //calc() 메소드 - 계산
		a++;
		b++;
	}
	
	public void disp() {
		System.out.println("a=" + this.a + "\t b=" + StaticMain.b);
	} //StaticMain 클래스 안에서 수행하는 것이기 때문에 StaticMain.b에서 StaticMain 생략가능
	
	public static void output() { //static 영역에는 this값이 존재하지 않음, 객체 만들어 부르는 수밖에 없음
		//System.out.println("a=" + this.a + "\t b=" + StaticMain.b); - error
		System.out.println("static method");
	}

	public static void main(String[] args) {
		StaticMain st = new StaticMain(); // StaticMain 클래스 객체 st 메모리에 생성, 기본생성자 호출
		st.calc(); //calc() 메소드 호출
		st.disp(); //a=4 b=1
		System.out.println();
		
		StaticMain st2 = new StaticMain();
		st2.calc();
		st2.disp(); //a=4 b=2
		System.out.println();
		
		StaticMain st3 = new StaticMain();
		st3.calc();
		st3.disp(); //a=4 b=3 //b는 static 영역에 1번만 생성되고 new한 클래스의 모든 객체가 공유하기 대문에 b++의 영향을 계속 받음
		System.out.println();
		
		//static 메소드 호출
		StaticMain.output(); //클래스명.메소드() 
		output(); //Class StaticMain에 있기 때문에 생략 가능
		st.output(); //객체.메소드()
	}
}//Class StaticMain

/*
★ static - 클래스변수
1. 메모리 static 영역에 1번만 생성된다. → 초기화 1번만 수행
   new한 클래스의 모든 객체가 공유한다. (공유변수) //통계치 구할 때 사용
2. static메소드에서는 static변수만 사용 가능
   static메소드에서는 this를 참조할 수 없다
3. static변수나 메소드는 호출시 클래스명으로 직접 호출 할 수 있다.
   객체로도 호출이 가능하다
4. static{ } - 초기화 영역
           - 생성자보다도 먼저 수행한다

★ import static 
: 간단하게 static 상수 또는 메소드를 호출할 때 사용
---------------------------------------------------
★ 메모리
new 연산자를 사용하면 메모리에 계속 생성됨
static 영역은 소멸이 안됨, static 영역은 메모리에 한번밖에 설정 안됨 (싱글톤은 static영역에 생성됨)
static 영역에 있는 변수 : 공유변수
stack 영역은 {} 구역이 끝나면 소멸
*/

/*
[실행결과]
초기화 영역
기본 생성자
a=4	 b=1

기본 생성자
a=4	 b=2

기본 생성자
a=4	 b=3

static method
static method
static method
*/