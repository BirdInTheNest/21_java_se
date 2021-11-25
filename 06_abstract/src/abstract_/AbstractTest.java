package abstract_;

//POJO형식 (Plain Old Java Object: 단순한 형식의 클래스)
public abstract class AbstractTest {
	String name;

	public abstract void setName(String name); //추상메소드
	
	public String getName() {
		return name;
	}
}

/*
상속 : 클래스의 재구현, 원본은 놔두고 좀 더 크게 업그레이드해서 가져다 쓰는 것

자식 클래스를 제어하기 위하여 추상 클래스 사용
강제성 부여

추상메소드는 추상클래스에 만들어야 함
AbstractTest must be an abstract class to define abstract methods

추상클래스는 메모리에 생성이 안됨. new 추상클래스() 불가능
해결방법
1. 자식클래스 : 추상메소드는 반드시 Sub Class에서 Override(재구현) 꼭 구현해야 한다.
2. 메소드
3. 익명 Inner 클래스 

클래스는 기본적으로 Object에게 상속받음 (extends Object 생략가능)
---------------------------------------------------------------
class AA {
	public final void sub(){} //자식이 Override하면 안된다
	
	public abstract void sub(){} //자식클래스가 반드시 Override해주길 원하면 추상메소드로 걸음
}

class BB extends AA { 
	public void sub(){}
}

*/