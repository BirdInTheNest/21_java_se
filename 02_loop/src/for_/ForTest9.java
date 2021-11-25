/*
[문제] ForTest9.java
팩토리얼 계산 (System.in.read())

[실행결과]
x값 입력 : 2		x값 입력 : 7

2! = 1*2 =2		7! = 1*2*3*4*5*6*7=5040
 */

package for_;

import java.io.IOException;

public class ForTest9 {

	public static void main(String[] args) throws IOException{
		System.out.print("x값 입력 : ");
		int x = System.in.read()-'0'; //'0'(48) - 0(0) 주의
		System.out.println();
		
		//7! = 1*2*3*4*5*6*7=5040
		int mul=1; //초기값
		System.out.print(x+"! = ");
		for(int i=1; i<=x; i++) { //x! = 1*2*3...*x (x번 반복) 
			mul *= i;
			
			if(i<x) 
				System.out.print(i+"*"); //1*2*...(x-1)*
			else 
				System.out.print(i+"="); //x=
		}//for
		
		System.out.println(mul);
	}
}
