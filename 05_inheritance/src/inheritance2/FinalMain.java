package inheritance2;

public class FinalMain {
	public final String FRUIT = "사과"; //final 변수는 대문자로만 기술하며, 값을 변경할 수 없고, 반드시 초기값을 주어야 함
	public final String FRUIT2; //클래스의 final 필드에서 초기값을 잡지 않았을 때는 생성자를 통해서 객체 초기화

	public static final String ANIMAL = "호랑이"; //상수화는 거의 public static final 이렇게 쓰임
	public static final String ANIMAL2; //클래스의 static final 필드에서 초기값을 잡지 않았을 때는 static영역에서 초기화
	
	static { //static final 필드는 static 구역에서 초기값을 주어야 함
		ANIMAL2 = "기린";
	}
	
	public FinalMain() { //final 필드는 생성자에서 초기값을 주어야 함
		FRUIT2 = "딸기"; //초기화
	}
	
	public static void main(String[] args) {
		final int AGE = 25;
		//AGE = 30; - error: final이기 때문에 변경할 수 없음
		System.out.println("AGE = " + AGE);

		final int AGE2; //C에서는 final 변수에 초기화값 없으면 error 뜸
		AGE2 = 30; //JAVA는 final 변수에 초기값을 줄 기회를 한번 더 줌
		System.out.println("AGE2 = " + AGE2);
		
		FinalMain aa = new FinalMain();
		System.out.println("FRUIT = " + aa.FRUIT);
		System.out.println("FRUIT2 = " + aa.FRUIT2);
		
		System.out.println("ANIMAL = " + FinalMain.ANIMAL);
		System.out.println("ANIMAL2 = " + FinalMain.ANIMAL2);
	}
}

/*
★ 상수(Constant)
: 변하지 않는 값
: 전부 대문자로 기술한다.
-------------------------------------------------------
★ final (상수화)
1. final 변수는 값을 변경할 수 없다.
2. final 변수는 반드시 초기값을 주어야 한다.
   final 필드는 생성자에서 초기값을 주어야 한다
   static final 필드는 static 구역에서 초기값을 주어야 한다
3. final 변수는 대문자로만 기술
4. final 메소드는 Override를 할 수 없다.
5. final 클래스는 자식클래스를 가질 수 없다.- 상속이 안된다
-------------------------------------------------------
class AA {
	public final void sub(){}
}

class BB extends AA {
	public void sub(){} - error: Override 안 됨
}
-------------------------------------------------------
final class String { //class 앞에 final이 있기 때문에 상속 안됨

}

class Test extends String {

}
-------------------------------------------------------
[실행결과]
AGE = 25
AGE2 = 30
FRUIT = 사과
FRUIT2 = 딸기
ANIMAL = 호랑이
ANIMAL2 = 기린
*/