package Constructor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InputMain {
	private int x;
	private double y;
	
	public InputMain() throws FileNotFoundException { //기본생성자
		/*
		Scanner scan = new Scanner(System.in); //scan은 IOException처리 안해도 됨
		
		System.out.print("정수 입력 : ");
		x = scan.nextInt();
		System.out.print("실수 입력 : ");
		y = scan.nextDouble();
		*/
		
		Scanner scan = new Scanner(new File("data.txt"));
		x = scan.nextInt();
		y = scan.nextDouble();
	}
	
	public void output() {
		System.out.println("x=" + this.x + "\t y=" + this.y);
	}

	public static void main(String[] args) throws FileNotFoundException {
		InputMain aa = new InputMain();
		aa.output();
	}
}
/*
[실행결과]
정수 입력 : 25
실수 입력 : 43.8
x=25	 y=43.8
*/

//src에는 자바파일만 저장, txt는 src밖에서 저장해야함