package thread;

public class Synchronized extends Thread {
	private static int count; //클래스 객체 각각에 부여되는 것이 아니라 공유변수이기 때문에 count값 공유

	public Synchronized() {
		System.out.println("this = "+this); //주소값이 다 다르기 때문에 synchronized(this)로 동기화 x
	}
	
	public static void main(String[] args) {
		Synchronized aa = new Synchronized(); //클래스 생성, 스레드 생성, 메모리에 각각 잡힘
		Synchronized bb = new Synchronized(); //클래스 생성, 스레드 생성
		Synchronized cc = new Synchronized(); //클래스 생성, 스레드 생성
		
		aa.setName("aa"); //스레드 이름 부여
		bb.setName("bb"); //스레드 이름 부여
		cc.setName("cc"); //스레드 이름 부여
		
		aa.start(); //스레드 시작
		bb.start(); //스레드 시작
		cc.start(); //스레드 시작
	
	}

	@Override //스레드 실행시 run()
	//public synchronized void run() { - 동기화 x, aa, bb, cc는 클래스가 다르기 때문에 공통분모 필요
	public void run() {	
		//synchronized(this) { - 동기화 x
		synchronized(Synchronized.class) { //공통분모로 동기화하라, 한번에 하나씩
			for(int i=1; i<=5; i++) {
				count++;
				System.out.println(Thread.currentThread().getName()+" : count="+count);
				
			}//for
		}
	}	
}
