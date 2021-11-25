package thread;

//싱글톤 : static 메모리 영역, 메모리에 딱 1개 생성해서 계속 불러다 사용하겠다
public class SingleTon {
	private int num=3;
	private static SingleTon instance=null; //초기값, 처음 단 1번만 null이고 그 다음부턴 아님
	
	public static SingleTon getInstance() { //메소드 이름을 getInstance로 만듦
		synchronized(SingleTon.class) { //한번에 하나만 통과
			if(instance == null)
					instance = new SingleTon();//처음 단 1번만 수행						
		}
		
		return instance; //SingleTon 클래스를 반환하니까 SingleTon getInstance()로 바꿈
	}//getInstance()

	public static void main(String[] args) {
		SingleTon aa = new SingleTon();
		aa.num++;
		System.out.println("aa = " + aa); //클래스명@16진수
		System.out.println("num = " + aa.num); //4
		System.out.println();
		
		SingleTon bb = new SingleTon();  //new할 때마다 메모리에 계속 만들어짐
		bb.num++;
		System.out.println("bb = " + bb); //클래스명@16진수
		System.out.println("num = " + bb.num); //4
		System.out.println();
		
		System.out.println("--- 싱글톤 ---");
		SingleTon cc = SingleTon.getInstance(); //같은 객체를 가리킨다
		cc.num++;
		System.out.println("cc = "+cc);//클래스명@16진수
		System.out.println("num = " + cc.num); //4
		System.out.println();
		
		SingleTon dd = SingleTon.getInstance();
		dd.num++;
		System.out.println("dd = "+dd);//클래스명@16진수 - 같은 객체를 가리킨다
		System.out.println("num = " + dd.num); //5
		System.out.println();
	}
}

