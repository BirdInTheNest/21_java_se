/*
[����] ForTest9.java
���丮�� ��� (System.in.read())

[������]
x�� �Է� : 2		x�� �Է� : 7

2! = 1*2 =2		7! = 1*2*3*4*5*6*7=5040
 */

package for_;

import java.io.IOException;

public class ForTest9 {

	public static void main(String[] args) throws IOException{
		System.out.print("x�� �Է� : ");
		int x = System.in.read()-'0'; //'0'(48) - 0(0) ����
		System.out.println();
		
		//7! = 1*2*3*4*5*6*7=5040
		int mul=1; //�ʱⰪ
		System.out.print(x+"! = ");
		for(int i=1; i<=x; i++) { //x! = 1*2*3...*x (x�� �ݺ�) 
			mul *= i;
			
			if(i<x) 
				System.out.print(i+"*"); //1*2*...(x-1)*
			else 
				System.out.print(i+"="); //x=
		}//for
		
		System.out.println(mul);
	}
}
