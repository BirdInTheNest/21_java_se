/*
★ VarArgs(Variable Argument)
: JDK 5.0에서 추가
: 통일된 인수의 자료형에 인수(매개변수)의 개수를 자유롭게 구현
: 내부적으로 배열화 작업으로 처리해 준다.
 */

package Constructor;

public class VarArgs {
	public int sum(int...ar) { //함수의 int형 인수 개수 자유롭게 받아라, 내부적으로는 배열로 처리
		int hab=0;
		for(int i=0; i<ar.length; i++) {
			hab += ar[i];
		}
		return hab;
	}
	
	/*
	public int sum(int a, int b) {
		return a+b;
	}
	public int sum(int a, int b, int c) {
		return a+b+c;
	}
	public int sum(int a, int b, int c, int d) { //인수가 다른 똑같은 함수가 여러개: Overload
		return a+b+c+d;
	}
	*/
	
	public static void main(String[] args) {
		VarArgs va = new VarArgs();
		
		System.out.println("합=" + va.sum(10,20));
		System.out.println("합=" + va.sum(10,20,30));
		System.out.println("합=" + va.sum(10,20,30,40));
	}
}
/*
[실행결과]
합=30
합=60
합=100
*/
