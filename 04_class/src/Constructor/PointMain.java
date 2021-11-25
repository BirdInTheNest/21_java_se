package Constructor;

public class PointMain {
	private int x, y;
	
	public PointMain(){ //생성자에 void쓰면 안됨
		x = y = 10;
	}
	public PointMain(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void calcPlus() { //메소드 구현
		x += 10;
	}
	
	public void calcPlus(int x, int y) { //Overload //기본형을 받은 것
		this.x += x;
		this.y += y;
	}
	
	public PointMain(PointMain aa, PointMain bb) { //객체형 클래스형을 받은 것
		this.x = aa.x + bb.x;
		this.y = aa.y * bb.y;
	}

	public static void main(String[] args) {
		PointMain aa = new PointMain();
		System.out.println("x = "+aa.x + "\t y = "+aa.y);
		
		System.out.println("\n x의 값을 +10 증가하는 메소드를 작성하시오 - calcPlus()");
		aa.calcPlus(); //메소드 호출
		System.out.println("x = "+aa.x + "\t y = "+aa.y);
		System.out.println();
		
		PointMain bb = new PointMain(100, 200);
		System.out.println("x = "+bb.x + "\t y = "+bb.y);
		
		System.out.println("\n 3, -8을 인수로 받아서 x는 증가, y는 감소하는 메소드를 작성하시오 - calcPlus()");
		bb.calcPlus(3, -8);
		System.out.println("x = "+bb.x + "\t y = "+bb.y);
		System.out.println();
		
		System.out.println("\n x는 aa의 x값과 bb의 x값을 더하고, y끼리는 곱하기");
		PointMain cc = new PointMain(aa, bb);
		System.out.println("x = "+cc.x + "\t y = "+cc.y);
		System.out.println();
		
	}

}//class PointMain

/*
[실행결과]
x = 10	 y = 10

 x의 값을 +10 증가하는 메소드를 작성하시오 - calcPlus()
x = 20	 y = 10

x = 100	 y = 200

 3, -8을 인수로 받아서 x는 증가, y는 감소하는 메소드를 작성하시오 - calcPlus()
x = 103	 y = 192


 x는 aa의 x값과 bb의 x값을 더하고, y끼리는 곱하기
x = 123	 y = 1920
 */


/*
생성자와 setter가 같은 역할을 함

생성자				setter
- 클래스명
- 자동호출 (1번 처리)	- 강제호출 (계속 수정을 요할때)
 */
