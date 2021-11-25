package com.zoo;

public class Zoo2 {

	public static void main(String[] args) {
		Zoo z = new Zoo();
		z.tiger();
		z.giraffe();
		z.elephant();
		//z.lion(); 같은 패키지면 private만 빼고 다 접근 가능
	}
}
