package abstract_;

import java.util.Scanner;

abstract class ShapeTest{ //추상클래스
	protected double area;
	protected Scanner scan = new Scanner(System.in); 
	
	public ShapeTest() {
		System.out.println("ShapeTest 기본 생성자");
	}
	public abstract void calcArea(); //추상메소드는 메모리에 잡지 않음, 어차피 Override되서 안 쓰이니까
	public abstract void dispArea(); 
}
//------------------
class SamTest extends ShapeTest{ //SamTest(자식)는 ShapeTest(부모)로부터 상속받음
	protected int base, height;
	
	public SamTest() { //생성자를 통해서 데이터 받음
		System.out.println("SamTest 기본생성자");
		System.out.print("밑변 : ");
		base = scan.nextInt();
		System.out.print("높이 : ");
		height = scan.nextInt();
	}
	
	@Override //어노테이션 : 개발자의 실수를 막아주기 위하여 사용. override 안 되면 빨간 밑줄 뜸
	public void calcArea() {
		area = base*height/2.0;
	}
	
	@Override
	public void dispArea() {
		System.out.println("삼각형 넓이 = " +area);
	}
	//override되서 부모 클래스인 ShapeTest의 calcArea()와 dispArea()는 무시됨
}
//------------------
class SaTest extends ShapeTest{
	protected int width, height;
	
	public SaTest() { //생성자를 통해서 데이터 받음
		System.out.println("SaTest 기본생성자");
		System.out.print("가로 : ");
		width = scan.nextInt();
		System.out.print("세로 : ");
		height = scan.nextInt();
	}
	
	@Override
	public void calcArea() {
		area = width*height;
	}
	
	@Override
	public void dispArea() {
		System.out.println("사각형 넓이 = " +area);
	}
}
//------------------
class SadariTest extends ShapeTest{
	protected int top, bottom, height;
	
	public SadariTest() { //생성자를 통해서 데이터 받음
		System.out.println("SadariTest 기본생성자");
		System.out.print("윗변 : ");
		top = scan.nextInt();
		System.out.print("밑변 : ");
		bottom = scan.nextInt();		
		System.out.print("높이 : ");
		height = scan.nextInt();
	}
	
	@Override
	public void calcArea() {
		area = (top+bottom)*height/2;
	}
	
	@Override
	public void dispArea() {
		System.out.println("사다리꼴 넓이 = " +area);
	}
}
//------------------
public class ShapeMain {

	public static void main(String[] args) {
		/*
		SamTest sam = new SamTest(); //SamTest클래스와 sam 객체 1:1관계, 결합도 100%
		sam.calcArea();
		sam.dispArea();
		System.out.println();
		
		SaTest sa = new SaTest(); //SaTest클래스와 sa 객체 1:1관계
		sa.calcArea();
		sa.dispArea();
		System.out.println();
		
		SadariTest sadari = new SadariTest(); //SadariTest클래스와 sadari 객체 1:1관계
		sadari.calcArea();
		sadari.dispArea();
		System.out.println();
		*/
		
		//결합도 낮추기
		ShapeTest shape; //SamTest(자식)클래스의 객체 shape은 ShapeTest(부모)을 참조값으로 가짐
		shape = new SamTest();  //부모 클래스 타입으로 자식객체를 참조할 수 있다 (부모=자식의 타입이 달라도 연결됨), 다형성
		shape.calcArea();
		shape.dispArea();
		System.out.println();
		
		shape = new SaTest(); //SaTest(자식)클래스의 객체 shape은 ShapeTest(부모)을 참조값으로 가짐
		shape.calcArea();
		shape.dispArea();
		System.out.println();
		
		shape = new SadariTest(); //SadariTest(자식)클래스의 객체 shape은 ShapeTest(부모)을 참조값으로 가짐
		shape.calcArea();
		shape.dispArea();
		System.out.println();		
	}
}

/*
자바의 최상위 클래스 - Object //어느 타입의 자료형이든 데이터를 다 받을 수 있음(다형성)
다형성의 전제조건 : 상속되고, override가 되어야 함 (다형성때문에 상속 사용)

String a = "apple"; 
String b = a; //데이터를 주고받을 때는 자료형이 똑같아야 함

int c = 25;
int d = c;

Object ob = a;
			String
Object ob = c;
			int
			
MemberDTO aa = new MemberDTO();
SalaryDTO bb = new SalaryDTO();
FruitTest cc = new FruitTest();

Object[] ar = { new MemberDTO(), new SalaryDTO(), new FruitTest() };

부모 = 자식 : 부모클래스는 자식클래스가 무엇이 되었든 간에 받을 수 있음
자식 = (자식)부모 : 부모는 자식을 이길 수 없음. downCast(형변환) 부모가 자식에게 맞추려고 내려옴
------------------------------------------
[실행결과]
ShapeTest 기본 생성자
SamTest 기본생성자
밑변 : 5
높이 : 3
삼각형 넓이 = 7.5

ShapeTest 기본 생성자
SaTest 기본생성자
가로 : 1
세로 : 4
사각형 넓이 = 4.0

ShapeTest 기본 생성자
SadariTest 기본생성자
윗변 : 5
밑변 : 4
높이 : 8
사다리꼴 넓이 = 36.0
 */






