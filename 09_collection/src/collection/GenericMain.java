package collection;

class GenericTest<T>{
	private T a;
	
	public void setA(T a) {
		this.a = a;
	}
	public T getA() {
		return a;
	}	
}
//----------------
public class GenericMain {

	public static void main(String[] args) {
		GenericTest<String> aa = new GenericTest<String>(); //클래스 생성시 타입을 명시해 준다
		aa.setA("홍길동");
		System.out.println("이름 = "+aa.getA());
		
		//aa.setA(25); - error 
		GenericTest<Integer> bb = new GenericTest<Integer>(); //<>안에는 클래스형만 가능
		bb.setA(25);
		System.out.println("나이 = "+bb.getA());	
	}
}

/*
★ Generic
: 제네릭은 동적으로 타입을 결정하지 않고 컴파일 시 타입이 결정되므로 보다 안전한 프로그래밍이 가능하다
: 실행 중에 타입 충돌 문제를 방지할 수 있다
: 프로그램 개발 시 타입 캐스팅 절차가 필요 없어지고 ClassCastException을 방지 할 수 있다
: 클래스 생성시 타입을 명시해 준다.
: <T> <E> <K> <V> 4개의 문자로 표시한다 

<T> Type(데이터형)
: 실행시 데이터 타입을 설정한다.
: ? 를 사용하면 Object로 인식한다.
: ? 를 사용하면 반드시 생성자를 통해서 데이터를 입력받는다.
<E> Element(요소, 항목)
<K> Key
<V> Value

*/