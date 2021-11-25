package basic;

class Person { //클래스는 단지 메뉴판임. new로 객체를 생성해야 함
	private String name; //private은 자신의 클래스 안에서만 접근 허용
	private int age;
	
	public void setName(String n) { //setter 데이터를 받는 메소드 구현
		name = n;
	}
	
	public void setAge(int a) {
		age = a;
	}
		
	public void setData(String n, int a) {
		name = n;
		age = a;
	}
	
	public void setData() {} //필드(클래스 안에 있음), 초기화값 가지고 있음
		
	public String getName(){ //getter 데이터를 보내는 메소드 구현
		return name;
	}
	
	public int getAge(){
		return age;
	}
}
//------------
public class PersonMain {

	public static void main(String[] args) {
		Person p = new Person(); //객체 생성
		System.out.println("객체 p = "+p); //toString() 생략가능
		System.out.println("객체 p = "+p.toString());
		p.setName("홍길동"); //호출	
		p.setAge(25);
		System.out.println("이름="+p.getName()+"\t나이="+p.getAge());
		System.out.println();
		
		Person p2 = new Person(); //객체 생성
		System.out.println("객체 p2 = "+p2);
		p2.setName("코난"); //호출
		p2.setAge(13);
		System.out.println("이름="+p2.getName()+"\t나이="+p2.getAge());	
		System.out.println();
		
		Person p3 = new Person();
		p3.setData("라이언", 35);
		System.out.println("이름="+p3.getName()+"\t나이="+p3.getAge());
		System.out.println();
		
		Person p4 = new Person();
		p4.setData();
		System.out.println("이름="+p4.getName()+"\t나이="+p4.getAge());
		System.out.println();
	}
}

/*
클래스를 new라는 연산자를 이용해서 생성하면 메모리 heap에 할당된다
heap영역에 할당된 것은 이름이 없고, 주소(클래스명@16진수)를 갖는다. (실제 메모리 주소가 아닌 참조값임)

메소드() - 명령어들의 집합 (메소드 안에서만 명령어 써야 함)

함수() 안에 있는 변수를 매개변수, 인수라고 부름

★ Overload 메소드 Overloading (쌍둥이)
하나의 클래스안에서 똑같은 이름의 메소드가 2개이상 존재 할 때
인수(매개변수) 형이 틀리거나 
인수(매개변수) 개수가 틀린 경우
 */

/*
[실행결과]
객체 p = basic.Person@7de26db8
객체 p = basic.Person@7de26db8
이름=홍길동	나이=25

객체 p2 = basic.Person@1175e2db
이름=코난	나이=13

이름=라이언	나이=35

이름=null	나이=0
*/
