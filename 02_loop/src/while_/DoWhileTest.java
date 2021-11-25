/*
 do{
   조건이 참일 때 실행(반복), 거짓이면 종료
 }while(조건);
 */

/*
1 2 3 4 5 6 7 8 9 10 출력하시오

A~Z까지 출력하시오. 단, 1줄에 7개씩 출력하시오.
	
[실행결과]
1 2 3 4 5 6 7 8 9 10

A B C D E F G
H I J K L M N
O P Q R S T U
V W X Y Z
 */	

package while_;

public class DoWhileTest {

	public static void main(String[] args) {
		
		int a=0;
		
		do {
			a++; // 1 2 3...
			System.out.print(a+" ");
		}while(a<10);
		
		System.out.println("\n");
		
		
		char ch='A';
		int count=0;
				
		do {
			System.out.print(ch+" ");
			ch++; //B C D...
			count++; //do while이 반복된 횟수
			
			if(count%7==0) System.out.println(); //1줄에 7개씩 출력
			
		}while(ch<='Z');
	}
}
