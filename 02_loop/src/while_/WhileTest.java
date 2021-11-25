/*
 while(조건){
   조건이 참일 때 실행(반복), 거짓이면 종료
 }
 */

package while_;

public class WhileTest {

	public static void main(String[] args) {
		// 1 2 3 4 5 6 7 8 9 10
		
		int a=0; //초기값 제시
		while(a<10) {
			a++;
			System.out.print(a+" ");
		}//while
		System.out.println();
		
		a=0;
		while(true) {
			a++;
			System.out.print(a+" ");
			
			if(a==10) break; //while을 벗어나라
		}//while
	}
}

/*
[실행결과]
1 2 3 4 5 6 7 8 9 10 
1 2 3 4 5 6 7 8 9 10
*/
