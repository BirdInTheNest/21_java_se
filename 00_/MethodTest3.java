import java.util.Random; //default package : java.lang ∴import할 필요 없음.
import java.util.Arrays; //따라서, 다른 package에 있는 클래스를 사용할 때는 import해야함

class MethodTest3 {
	public static void main(String[] args) {
		System.out.println("최대값 = " + Math.max(25, 36)); 
		//java.lang.Math.max(int a, int b) - static int

		//Math m = new Math(); ->static이 없을 경우 new 해야 함
		//System.out.println("최대값 = " + m.max(25, 36));

		System.out.println("최소값 = " + Math.min(25.3, 36.7));
		//java.lang.Math.min(int a, int b) - static int

		//난수 - 컴퓨터가 불규칙하게 발생하는 수 0<= 난수 < 1
		System.out.println("난수 = " + Math.random()); //static이 있으면 클래스명이 바로 온다
		//java.lang.Math.random() - static double

		Random r = new Random();
		System.out.println("난수 = " + r.nextDouble()); //static이 없으면 객체가 온다
		//java.util.Random.nextDouble() - double
		//java.lang이 아니므로 import해야함

		//정렬
		int[] ar = {25, 12, 37, 56}; //배열, 방을 여러개 생성
		System.out.println(ar[0]+", "+ar[1]+", "+ar[2]+", "+ar[3]);

		Arrays.sort(ar); 
		System.out.println(ar[0]+", "+ar[1]+", "+ar[2]+", "+ar[3]);
		//java.util.Arrays.sort(int[] a) - static void
	}
}

/*
[실행결과]
D:\java_se\workspace\0722>javac MethodTest3.java

D:\java_se\workspace\0722>java MethodTest3
최대값 = 36
최소값 = 25.3
난수 = 0.006196395637959151
난수 = 0.6849625176847827
25, 12, 37, 56
12, 25, 37, 56
*/