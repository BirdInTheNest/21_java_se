package inheritance;

class AAA{}
class BBB extends AAA{} //BBB클래스는 AAA클래스를 상속받음(BBB is a AAA)
//---------------
public class InstanceOf {

	public static void main(String[] args) {
		AAA aa = new AAA(); //AAA클래스를 new하는데 객체 aa에 AAA클래스 주소값 참조
		BBB bb = new BBB(); //BBB클래스를 new하는데 객체 bb에 BBB클래스 주소값 참조
		AAA aa2 = new BBB(); //BBB클래스를 new하는데 객체 aa2에 AAA클래스 주소값 참조

		AAA aa3 = aa; //객체 aa의 주소값 aa3에 전달가능(aa와 aa3은 자료형이 AAA클래스로 같음)
		if(aa instanceof AAA) System.out.println("1. TRUE"); 
		else System.out.println("1. FALSE");
		
		//부모 = 자식
		AAA aa4 = bb; //BBB클래스 주소값 참조한 객체 bb는 AAA클래스를 상속받았기 때문에, 부모클래스 AAA 참조 가능 
		if(bb instanceof AAA) System.out.println("2. TRUE"); 
		else System.out.println("2. FALSE");
		
		//자식 = (자식)부모 : 자식은 부모클래스가 바로 참조가 안되서 downcasting을 해야함
		BBB bb2 = (BBB)aa2; //AAA클래스 주소값 참조한 aa2는 BBB클래스형으로 형변환하여야 함
		if(aa2 instanceof BBB) System.out.println("3. TRUE"); 
		else System.out.println("3. FALSE");
		
		//BBB bb3 = (BBB)aa; //error - 메모리에 AAA만 있고 BBB가 없기 때문에 불가능
		//downcasting은 상속된 상태에서 사용 가능하고, 단일 클래스인 경우는 사용 불가능함
		if(aa instanceof BBB) System.out.println("4. TRUE");
		else System.out.println("4. FALSE");
	}
}

/*
★ instanceof
: casting(형 변환)이 되는지 안 되는지를 판별
: 객체에 원하는 클래스 타입이 메모리 할당되었는지 안 되었는지를 확인

if(aa instanceof AAA)
aa의 주소값을 AAA로 넘길 수 있는가?
aa의 참조값을 따라가면 메모리에 AAA 클래스가 잡히는가?
--------------------------------------------
[실행결과]
1. TRUE
2. TRUE
3. TRUE
4. FALSE
*/