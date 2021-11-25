package inheritance;

class AA {
	public int a = 3;
	
	public void disp() {
		a += 5;
		System.out.print("AA : " + a + " ");
	}
}
//--------------------
class BB extends AA { //BB클래스는 AA클래스를 상속받음
	public int a = 8;
	
	public void disp() { //Override(메소드에만 적용, 필드에 적용 x)일때 우선권은 자식클래스가 가지고 있음
		this.a += 5; //this.a = this.a + 5 //13
		System.out.print("BB : " + a + " ");
	}
}
//--------------------
public class TestMain2 {

	public static void main(String[] args) {
		BB aa = new BB(); //BB클래스를 new하는데 객체 aa에 BB클래스 주소값을 참조
		aa.disp(); //a=8 -> a=13
		System.out.println("aa : " + aa.a); //a=13
		System.out.println();
		
		AA bb = new BB(); //BB클래스를 new하는데 객체 bb에 AA클래스 주소값을 참조 (부모=자식 : 다형성)
		bb.disp(); //메소드가 Override되면 무조건 자식 클래스의 메소드를 수행 //a=8 -> a=13
		System.out.println("bb : " + bb.a); //a=3
		System.out.println();
		
		AA cc = new AA(); //AA클래스를 new하는데 객체 cc에 AA클래스 주소값을 참조
		cc.disp(); //a=3 -> a=8
		System.out.println("cc : " + cc.a); //a=8
		System.out.println();
		
		//자식 = (자식)부모 : Casting(형변환) //클래스끼리도 형변환이 가능, 클래스의 자료형은 객체형
		BB dd = (BB)bb; //AA클래스 주소값을 참조한 객체 bb를 형변환하여 객체 dd에 BB클래스 주소값을 참조 
		dd.disp(); //a=13 -> a=18
		System.out.println("dd : " + dd.a); //a=18
		System.out.println();
	}
}
//필드(멤버변수)는 Override 개념이 없다. Override 개념은 메소드에만 있음

/*
[실행결과]
BB : 13 aa : 13

BB : 13 bb : 3

AA : 8 cc : 8

BB : 18 dd : 18
*/









