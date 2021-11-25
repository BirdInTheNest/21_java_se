/*
 for(변수명=초기치; 조건치; 증감치){
        조건이 참일 때 실행(반복), 거짓이면 종료
 }
 */

/*
[실행결과]
-1+2-3+4-5+6-7+8-9+10 = 5
*/

package for_;

public class ForTest7 {

	public static void main(String[] args) {
		int sum=0; //초기값 부여
		
		for(int i=1; i<=10; i++) { 
			
			if(i%2==0) { //2로 나눈 나머지가 0 = 2의 배수 = 짝수 ?
				sum += i;
				System.out.print("+"+i);			
			}else {
				sum -= i;
				System.out.print("-"+i);
			}//if
			
		}//for i

		System.out.println(" = "+sum);
	}
}
