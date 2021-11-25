package inheritance;

public class SuperTest { //부모클래스
	protected double weight, height; //부모 자식 클래스만 접근 가능. 그외 외부에서 데이터 접근 불가능
	
	public SuperTest() { //기본생성자는 그냥 만들어두는 것이 편함
		System.out.println("SuperTest 클래스 기본생성자");
	}
	
	//2개의 매개변수(인수)를 갖는 생성자 만들어주세요
	public SuperTest (double w, double h){
		System.out.println("SuperTest 클래스 생성자");
		this.weight = w;
		this.height = h;
	}
	
	public void disp() {
		System.out.println("SuperTest클래스 disp()");
		System.out.println("몸무게 = " + weight);
		System.out.println("키 = " + height);
	}
}

/*
★ 상속(inheritance)
: is~a 관계 (~이다)
: 클래스의 재구현

1. 상속받는 클래스는 상속해주는 클래스의 생성자와 private를 제외한 모든 것을 상속받는다.
2. Super class : 상속해 주는 클래스(부모) Base
   Sub  class : 상속받는 클래스(자식) Drived 
3. 접근제한자 protected는 Sub class에서 접근이 가능하다 (나와 내 자식에게 접근허가)
4. Sub class로 객체를 생성하면 Super class와 자신의 생성자를 모두 호출한다.
5. 다중상속을 할 수 없다.

[형식]
class   Sub클래스명   extends   Super클래스명{ }

private : 나만 접근 가능
protected : 나와 내 자식만 접근 (부모 자식 클래스만 접근 가능 - 상속일 때 사용)
public : 전체 공개
*/