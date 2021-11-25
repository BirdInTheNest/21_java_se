/*
★ 변수(variable) - 메모리 할당(instance)

1. 기본형		2. 객체형						3. 배열형

자료형 변수명;	클래스명 객체명	= new 클래스명();	자료형[] 배열명 = {값1, 값2,...};
boolean a;	String a = new String();	int[] ar = {값, 값, 값};   
char a;		String a = "hello";			int[] ar = {1, 2, 3};
int	a;										
double a;								자료형[] 배열명 = new 자료형[개수];
										int[] ar = new int[개수];
 										int[] ar = new int[3];
 										ar[0]=1;
										ar[1]=2;
										ar[2]=3;
										
										자료형[] 배열명 = new int[]{값1, 값2,...};
										int [] ar = new int[]{1, 2, 3};

										String[] ar = {"apple", "banana", "orange"};
										String[] ar = new String[3]; //객체배열(클래스타입을 여러개 만듦)
 */

/*
★ Array (배열)
1. 동일한 자료형의 모임
2. 연속적인 메모리 할당
3. 첨자가 0부터 시작
4. 한번 잡은 배열의 크기는 수정할 수 없다 (추가 삭제가 안 됨)
 */


package array;

public class ArrayTest {

	public static void main(String[] args) {
		int[] ar; 
		ar = new int[5];
		ar[0]=27; 
		ar[1]=36;
		ar[2]=25;
		ar[3]=78;
		ar[4]=62;
		
		System.out.println("배열명 ar = "+ar); //ar에 주소값(클래스명@16진수) 존재
		
		System.out.println("배열 크기 = "+ar.length); //배열 크기: 배열 방의 개수
		for(int i=0; i<ar.length; i++) {
			System.out.println("ar["+i+"] = "+ar[i]);	
		}//for i
		System.out.println();
		
		System.out.println("거꾸로 출력");
		for(int i=ar.length-1; i>=0; i--) {
			System.out.println("ar["+i+"] = "+ar[i]);	
		}//for i
		System.out.println();
		
		System.out.println("짝수 데이터만 출력");	 //ar[i]에 데이터값 존재	
		for(int i=0; i<ar.length; i++) {
			if(ar[i]%2 == 0) System.out.println("ar["+i+"] = "+ar[i]);
		}//for i
		System.out.println();
		
		System.out.println("확장 for"); //ar 주소에 있는 데이터값을 int data에 넣어주는 것 반복, 새로운 값이 덮어버림
		for(int data : ar) {
			System.out.println(data);
		}//for data	
	}
}

/*
[실행결과]
배열명 ar = [I@123a439b
배열 크기 = 5
ar[0] = 27
ar[1] = 36
ar[2] = 25
ar[3] = 78
ar[4] = 62

거꾸로 출력
ar[4] = 62
ar[3] = 78
ar[2] = 25
ar[1] = 36
ar[0] = 27

짝수 데이터만 출력
ar[1] = 36
ar[3] = 78
ar[4] = 62

확장 for
27
36
25
78
62
*/