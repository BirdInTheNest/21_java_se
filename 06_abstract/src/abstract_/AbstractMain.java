package abstract_;

public class AbstractMain extends AbstractTest {
	
	@Override //반드시 Override해야한다. 강제성 부여
	public void setName(String name) {
		this.name = name;
	}
	

	public static void main(String[] args) {
		//AbstractTest at = new AbstractTest(); //추상이라서 new할 수 없음
		//부모 = 자식
		AbstractTest at = new AbstractMain(); //자식클래스로 생성한다
		at.setName("홍길동");
		System.out.println(at.getName());

	}

}

/*
★ 추상클래스 - Sub class 제어
1. 추상화 작업
2. 메소드에 body {} 가 없는 메소드를 추상메소드라고 한다.
    추상메소드에는 abstract 라는 키워드를 써야 한다
    추상메소드는 {} body 없이 ;를 써야한다
3. 추상메소드가 있는 클래스는 반드시 추상클래스이어야 한다.
4. 추상메소드가 없는 추상클래스를 의미상의 추상클래스라고 한다.
    의미상의 추상클래스의 메소드는 모두 빈body로 되어 있다.
5. 추상클래스는 자신의 클래스로 메모리 생성을 할 수 없다
    => 생성하려면
     가. Sub Class를 이용(반드시 Sub Class가 추상메소드를 Override 해야 한다)
     나. 메소드를 이용
6. 추상메소드는 반드시 Sub Class에서 Override 꼭 구현해야 한다.
    Override를 안하면 Sub Class 마저도 abstract 가 되어야 한다.
    
    
    
    //아무리 주소값을 부모클래스로 참조해도 오버라이드되면 자식클래스로 메소드를 실행하게 됨
*/




