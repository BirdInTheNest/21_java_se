/*
[문제] CompTest2
int a=85, b=100; 또는 int a=35, b=20;

[실행결과]
큰값 = 100 또는 큰값 = 35
*/

class CompTest2 {
	public static void main(String[] args) {
		int a=250, b=63;
		//가설: 만약 a가 b보다 크다면 ? a : b;
		int result = a > b ? a : b;
		
		System.out.println("큰값 = " + result);	
	}
}

/*
[실행결과]
D:\java_se\workspace\0722>javac CompTest2.java

D:\java_se\workspace\0722>java CompTest2
큰값 = 250
*/