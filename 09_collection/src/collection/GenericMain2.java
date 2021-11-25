package collection;

class GenericTest2<T>{ //Generic: 무슨타입일지 모르니까 클래스 생성시 <T> Type(데이터형)으로 설정해둠
	private T a;
	
	public GenericTest2(T a) { //생성자는 new 할때 1번 호출, 생성자와 setter는 하는 일이 같다
		this.a = a;
	} 
	
	public void setA(T a) { //setter는 주로 수정할때 사용
		this.a = a;
	}
	
	public T getA() {
		return a;
	}	
}
//----------------
public class GenericMain2 {

	public static void main(String[] args) {
		GenericTest2<?> aa = new GenericTest2<String>("홍길동"); //? 를 사용하면 Object로 인식
		//aa.setA("홍길동"); - error, ? 를 사용하면 반드시 생성자를 통해서 데이터를 입력받는다
		String name = (String)aa.getA(); //aa.getA()는 오브젝트화 돼서 캐스팅 필요
		System.out.println("이름 = "+name);
		
		GenericTest2<?> bb = new GenericTest2<Integer>(25);
		int age = (Integer)bb.getA(); //bb.getA()는 오브젝트화 돼서 캐스팅 필요
		//AutoUnBoxing 객체형 Integer가 기본형 int로 간다
		System.out.println("나이 = "+age);
	}
}

/*
자료형
1. 기본형
2. 객체형

AutoBoxing 기본형이 객체형으로 간다(객체화)
AutoUnBoxing 객체형이 기본형으로 간다(객체화를 푼다)
*/