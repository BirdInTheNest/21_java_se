/*
★ 반복문
1. for
[형식]
 for(변수명=초기치; 조건치; 증감치){			 
     조건이 참일 때 실행						
 }									 	 

for(A; B; C) {
	D
}	    
[실행순서]
A B(참일 때) D {C B(참일 때) D} {C B(참일 때) D} {C B(참일 때) D}
*/

//자바의 변수가 살아있는 생존기간 : 구역 {}

package for_;
public class ForTest {
	public static void main(String[] args) {
		int i;
		for(i=1; i<=10; i++) {
			System.out.println("안녕하세요 "+i);
		} //for
		
		System.out.println("탈출 i = "+i);
		System.out.println();
		
		//10 9 8 7 6 5 4 3 2 1
		for(i=10; i>=1; i--) {
			System.out.print(i+" ");
		} //for
		System.out.println(); 
		
		//A(65) B C D E F G... X Y Z(90)
		for(i='A'; i<='Z'; i++) {
			System.out.print((char)i+" ");
		} //for	
	}
}

/*
[실행결과]
안녕하세요 1
안녕하세요 2
안녕하세요 3
안녕하세요 4
안녕하세요 5
안녕하세요 6
안녕하세요 7
안녕하세요 8
안녕하세요 9
안녕하세요 10
탈출 i = 11

10 9 8 7 6 5 4 3 2 1 
A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 
*/