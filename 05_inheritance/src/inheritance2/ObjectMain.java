package inheritance2;

class Test extends Object { //클래스는 최상위 클래스 Object를 상속받음(default), extends Object 생략가능
	@Override //부모클래스와 자식클래스가 Override된 메소드가 있다면, 부모 거 무시되고 자식 거로 처리됨 
	public String toString() {
		return getClass() + "@개바부"; //Override 상속받았기 때문에 부모 거 무시되고 자식 거로 처리됨 
	}
}
//---------------
class Sample extends Object { 
	
}
//---------------
public class ObjectMain {

	public static void main(String[] args) { //main 메소드
		Test t = new Test();
		System.out.println("객체 t = " + t); //주소값 찍힘
		System.out.println("객체 t = " + t.toString()); //객체를 문자열로 반환
		System.out.println();
		
		Sample s = new Sample();
		System.out.println("객체 s = " + s.toString()); //객체를 문자열로 반환: 클래스@16진수
		System.out.println("객체 s = " + s.hashCode()); //객체를 10진수로 반환: 10진수
		System.out.println();
		
		String str = "apple";
		System.out.println("객체 str = " + str.toString()); //객체를 문자열로 반환: 문자열
		System.out.println("객체 str = " + str.hashCode()); //객체를 10진수로 반환: 10진수
		//문자열은 무한대로 생성할 수 있기 때문에, 어느순간 문자열을 10진수로 다 표현하지 못한다.
		System.out.println();
		
		String aa = new String("apple");
		String bb = new String("apple");
		System.out.println("aa==bb : " + (aa == bb)); //주소비교 false
		System.out.println("aa.equals(bb) : " + (aa.equals(bb))); //문자열비교 true
		System.out.println();
		
		Object cc = new Object();
		Object dd = new Object();
		System.out.println("cc==dd : " + (cc == dd)); //주소비교 false
		System.out.println("cc.equals(dd) : " + (cc.equals(dd))); //주소비교 false
		System.out.println(); //Object타입이기 때문에 equals로 물어도 주소비교하는 것임
		
		Object ee = new String("apple");
		Object ff = new String("apple");
		System.out.println("ee==ff : " + (ee == ff)); //주소비교 false
		System.out.println("ee.equals(ff) : " + (ee.equals(ff))); //문자열비교 true
		//Override가 되면 자식거 수행하기 때문에, String의 equals를 수행하기 때문에 문자열비교가 되는 것임
		//문자열에서는 오버라이딩 시켰기 때문에 클래스@16진수 가 아니라 문자열으로 표현됨
		
		
	}

}

/*
class Object {
	public String toString() 		//클래스@16진수
	public int hashCode() 			//10진수
	public boolean equals(Object)	//주소 비교
}

final class String { 				//final class 밑으로는 자식이 생기지 않음
	public String toString() 		//문자열 - String 클래스는 유별나게 오버라이딩해서 부모거 무시하고 내거 처리해서 문자열이 나옴
	public int hashCode() 			//10진수(무한대로 생성될 수 있는 문자열을 다 표현해주지 못한다)
	public boolean equals(Object) 	//문자열 비교
}

int는 40억 정도밖에 표현안됨.
(문자열은 무한대로 생성될 수 있음)


주소의 표현방식 중 하나 : Collection -> ArrayList [~~~]
--------------------------------------
[실행결과]
객체 t = class inheritance2.Test@개바부
객체 t = class inheritance2.Test@개바부

객체 s = inheritance2.Sample@1175e2db
객체 s = 292938459

객체 str = apple
객체 str = 93029210

aa==bb : false
aa.equals(bb) : true

cc==dd : false
cc.equals(dd) : false

ee==ff : false
ee.equals(ff) : true
*/