package class_;

//import static java.lang.Math.random; //java.lang패키지의 Math클래스의 random메소드
//import static java.lang.Math.pow;
import static java.lang.Math.*; // * : 와일드 카드(모든 것)
import static java.lang.System.out; 

import java.util.Random;

public class ImportStatic {
 
	public static void main(String[] args) {
		System.out.println("난수 = " + Math.random()); //0<=난수<1
		System.out.println("난수 = " + random()); //클래스명.메소드()에서 클래스명을 import static으로 빼기
		
		Random r = new Random();
		System.out.println("난수 = " + r.nextDouble()); //static이 아니므로 import static 못 씀
		System.out.println("정수형 난수 = " + r.nextInt()); //-21억~21억
		System.out.println("정수형 난수 = " + r.nextInt(100)); //0~99
		System.out.println("정수형 난수 = " + (r.nextInt(100)+1)); //1~100
		
		System.out.println("2의 5제곱 = " + Math.pow(2, 5)); //실수형
		out.println("2의 5제곱 = " + Math.pow(2, 5)); //클래스명.메소드()에서 클래스명을 import static으로 빼기
		out.println("2의 5제곱 = " + pow(2, 5)); //클래스명.메소드()에서 클래스명을 import static으로 빼기
	} 
}

/*
[실행결과]
난수 = 0.8163972710020987
난수 = 0.7605310140370077
난수 = 0.7053194425981104
정수형 난수 = -1477682089
정수형 난수 = 78
정수형 난수 = 84
2의 5제곱 = 32.0
2의 5제곱 = 32.0
2의 5제곱 = 32.0
*/