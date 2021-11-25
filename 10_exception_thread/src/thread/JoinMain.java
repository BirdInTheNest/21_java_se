package thread;

class JoinTest implements Runnable{ //JoinTest는 스레드가 되고 싶다

	@Override //인터페이스 Runnable의 추상메소드 run() Override 하기
	public void run() {
		for(int i=1; i<=5; i++) {
			System.out.println("i = "+i);
		}
	}	
}
//-------------
public class JoinMain {

	public static void main(String[] args) {
		JoinTest jt = new JoinTest(); //스레드 생성한 거 아님
		Thread t = new Thread(jt); //jt(JoinTest)를 스레드로 생성
		
		System.out.println("스레드 시작");
		t.start(); //스레드 시작 - 스레드 실행(run()) 운영체제가 알아서 실행
		try {
			t.join(); //스레드가 죽고 절차식이 됨. 한 절차를 다 끝내야 다음 절차로 넘어감
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("스레드 종료");
	}
}

/*
JOIN
join()메소드는 스레드가 멈출 때까지 기다리게 한다.
메인이 끝나면 모든 것이 종료 되는 걸로 알고 있는데 스레드는 그렇지 않다. 
메인이 종료되어도 관성처럼 백그라운드에서 스레드는 돌아간다.
그래서 join를 사용하면 해당 스레드가 종료되기까지 기다렸다가 다음으로 넘어간다.
*/