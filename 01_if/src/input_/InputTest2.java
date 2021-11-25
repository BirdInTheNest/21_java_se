/*
메모리 <--BufferedReader-- 버퍼 <--InputStreamReader-- 키보드(System.in - InputStream)

메모리 <--BufferedReader-- 버퍼 <--FileReader-- 파일
*/

package input_;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class InputTest2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		//InputStreamReader ir = new InputStreamReader(System.in);
		//BufferedReader br - new BufferedReader(ir);
		
		System.out.print("정수 데이터 입력 : ");
		//br.read(); //객체 br에서 1개 문자 입력받음
		//String a = br.readLine(); //객체 br에서 1줄(엔터를 칠 때까지) 입력받은 문자열을 변수 a에 저장
		int a = Integer.parseInt(br.readLine()); //String을 int로 형변환
		//java.lang.Integer.parseInt(String s) - static int

		System.out.print("실수 데이터 입력 : ");
		double b = Double.parseDouble(br.readLine()); //String을 double로 형변환
		//java.lang.Double.parseDouble(String s) - static double

		System.out.println(a + " + " + b + " = " + (a+b));
	}
}

/*
[실행결과]
D:\java_se\workspace\0723>javac InputTest2.java

D:\java_se\workspace\0723>java InputTest2
정수 데이터 입력 : 25
실수 데이터 입력 : 2.111
25 + 2.111 = 27.111
*/

