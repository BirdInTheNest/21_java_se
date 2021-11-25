package nested;

public class AbstractMain {

	public static void main(String[] args) {
		//AbstractTest at = new AbstractTest(); - error: 추상클래스는 new 할 수 없다
		AbstractTest at = new AbstractTest() { //익명 Inner Class(흑기사)
			@Override
			public void setName(String name) { //메소드의 구현부를 가질 수 있는 건 클래스

			}
		}; //익명 Inner Class
		
		//인터페이스를 new한 거 x, 익명 Inner Class를 new하여 인터페이스 생성
		InterA in = new InterA() { 
			@Override
			public void aa() {}
			@Override
			public void bb() {}
		}; 
		
		//AbstractExam ae = new AbstractExam(); -error: 추상클래스라 메모리 생성 불가
		AbstractExam ae = new AbstractExam() { //익명 Inner Class(흑기사)
			//Override 해도 되고 안 해도 되고 
		};
	}
}

/*
추상클래스
1. 자식 클래스 이용하여 생성
2. 메소드 이용하여 생성
3. 익명 Inner 클래스 이용하여 생성 - new 클래스(){}; - 익명 Inner Class(흑기사)

AbstractMain.java
AbstractMain.class
AbstractMain$1.class - 첫번째 익명입니다
--------------------------------------------------
인터페이스
1. implements - 모든 추상메소드는 Override 해야함
2. 대신 implements해주는 클래스 이용하여 생성
3. 메소드 이용하여 생성
4. 익명 Inner 클래스 이용하여 생성 - new 인터페이스(){}; - 익명 Inner Class(흑기사)
*/