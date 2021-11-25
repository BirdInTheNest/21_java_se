package com.apple;

import com.zoo.Zoo;

public class Apple {
	public static void main(String[] args) {
		System.out.println("빨간 사과");
		
		Zoo z = new Zoo();
		z.tiger(); //다른 패키지면 public으로만 접근 가능
		//z.giraffe();
		//z.elephant();
		//z.lion();	
	}
}
