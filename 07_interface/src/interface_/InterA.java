package interface_;

public interface InterA { //인터페이스는 상수와 추상메소드만 존재, 변수 불가능
	public static final String NAME = "홍길동"; //상수화
	int AGE=25; // public static final는 생략가능
	
	public abstract void aa(); //추상메소드
	public void bb(); //abstract는 생략가능
	
}

/*
★ interface (is~a 관계)  (상속받은 것처럼 쓰임)
1. 표준명세서의 역활
2. 상수와 추상메소드만 존재
    public static final는 생략가능
    abstract는 생략가능
3. interface를 implements 한 클래스는 반드시 추상메소드를 Override(재구현)해주어야 한다.
4. Override(재구현) 할때 반드시 public를 붙여야 한다.
5. 다중상속이 가능
6. 상속과 같이 쓰일때는 extends, implements 순서로 쓴다.

[형식]
interface 인터페이스명 {
   .....
}
class 클래스명 implements 인터페이스명{
   ...
}
----------------------------------------------------------------------
클래스명, 인터페이스명 첫글자는 대문자
클래스 implements 인터페이스 
 */
