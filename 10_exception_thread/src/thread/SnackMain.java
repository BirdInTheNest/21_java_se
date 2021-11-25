package thread;

class SnackTest extends Thread { //Thread 클래스로 상속
	private String str;
	
	public SnackTest(String str) { //생성자
		this.str = str;
	}
	
	public void run() {
		for(int i=1; i<=5; i++) {
			System.out.println(str+"\t i = "+i+"\t"+Thread.currentThread());
			//Thread.currentThread() : 현재 실행중인 스레드 출력
		}
	}
}
//------------
public class SnackMain { 

	public static void main(String[] args) {
		SnackTest aa = new SnackTest("새우깡"); //스레드 생성
		SnackTest bb = new SnackTest("포카칩");
		SnackTest cc = new SnackTest("홈런볼");
		
		//스레드 이름 부여
		aa.setName("새우깡"); //Thread-0 -> 새우깡
		bb.setName("포카칩"); //Thread-1 -> 포카칩
		cc.setName("홈런볼"); //Thread-2 -> 홈런볼
		
		//우선순위(default : 5, 1~10 숫자 부여, 높을수록 우선순위 높음, but 운영체제 마음대로임)
		//aa.setPriority(10);	//aa.setPriority(Thread.MAX_PRIORITY); //10
		//bb.setPriority(Thread.MIN_PRIORITY); //1
		//cc.setPriority(Thread.NORM_PRIORITY); //normal, 5
		
		aa.start(); //스레드 시작 -> 스레드 실행 run() (스레드는 운영체제에 의해 실행됨)
		
		try {
			aa.join(); //스레드 죽이기 -> aa가 끝날 때까지 bb와 cc는 block상태
		} catch (InterruptedException e) { //Interrupted : 외부 자극
			e.printStackTrace();
		} 
		
		bb.start();
		cc.start();
	}
}

/*
★ 프로세스(process)
: 현재 실행중인 프로그램

★ 멀티프로세스(멀티태스킹)
: 하나의 cpu에 여러개의 응용프로그램을 동시에 실행
: 시분할시스템

★ Thread
1. 단위 프로그램 (조각난 프로그램)
2. main 메소드도 하나의 스레드이다
3. 스레드 종료하려면 run()를 벗어나면 된다

★ 멀티스레드
하나의 프로그램에서 여러 개의 스레드(단위프로그램)을 동시에 수행하는 것을 의미한다.
(스레드를 짧은 시간동안 실행하고 또 다른 스레드를 짧은 시간동안 실행한다)

1. 생성방법
① Thread 클래스로 상속
② Runnable 인터페이스를 이용  (Runnable : 실행가능상태)

2. 처리 
스레드 생성 -> 스레드 시작(start()) -> 스레드 실행(run())은 운영체제가 알아서 (Running : 실행 상태)
--------------------------------------------------------------------------------
우선순위
시스템이 busy할 때 우선순위가 높은 스레드에게 먼저 CPU를 할당해 준다
멀티스레드의 순서를 정하는 것을 스레드 스케줄링(thread scheduling)이라고 한다
스레드 스케줄링 방식에는 두 가지 방식이 있는데 우선순위(priority)방식과 순환 할당(Round-Robin)방식 있다
순환 할당방식은 스레드가 사용할 시간할당량을 정하고 할당량의 시간만큼 스레드를 실행시키고 또 다른 스레드를 실행시키는 방식 
순환 할당방식은 JVM(자바 가상 기계)에 의해 결정되기 때문에 개발자의 임의로 수정할 수 없다.
개발자가 사용할 수 있는 우선순위 방식은 말 그대로 어떤 스레드를 우선적으로 처리할지 우선순위를 부여하는 방식이다.
우선순위는 1에서 10까지 부여할 수 있고 1이 가장 낮고 10이 가장 높다. 
우선순위는 Thread 클래스의 setPriority() 메소드로 간단히 부여할 수 있다.

//키오스크 프로그램, pc방 관리 프로그램 등은 스레드로 따로 돌아야 함
--------------------------------------------------------------------------------
[실행결과]
새우깡	 i = 1	Thread[Thread-0,5,main]
포카칩	 i = 1	Thread[Thread-1,5,main]
새우깡	 i = 2	Thread[Thread-0,5,main]
새우깡	 i = 3	Thread[Thread-0,5,main]
홈런볼	 i = 1	Thread[Thread-2,5,main]
새우깡	 i = 4	Thread[Thread-0,5,main]
홈런볼	 i = 2	Thread[Thread-2,5,main]
새우깡	 i = 5	Thread[Thread-0,5,main]
홈런볼	 i = 3	Thread[Thread-2,5,main]
포카칩	 i = 2	Thread[Thread-1,5,main]
홈런볼	 i = 4	Thread[Thread-2,5,main]
포카칩	 i = 3	Thread[Thread-1,5,main]
포카칩	 i = 4	Thread[Thread-1,5,main]
포카칩	 i = 5	Thread[Thread-1,5,main]
홈런볼	 i = 5	Thread[Thread-2,5,main]
*/