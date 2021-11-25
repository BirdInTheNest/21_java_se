/*
3개의 숫자(a,b,c)를 입력받아서 순서대로 출력하시오. 단) if만 쓰세요

[실행결과]
첫번째 입력 : 85			첫번째 입력 : 62
두번째 입력 : 80			두번째 입력 : 60
세번째 입력 : 65			세번째 입력 : 80
65  80  85				60  62  80
 */

package if_;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class IfTest3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("첫번째 입력 : ");
		int a = Integer.parseInt(br.readLine());
		System.out.print("두번째 입력 : ");
		int b = Integer.parseInt(br.readLine());
		System.out.print("세번째 입력 : ");
		int c = Integer.parseInt(br.readLine());

		if(a<b && a<c) { //만약 a가 제일 작다면?
			if(b<c) System.out.println(a+", "+b+", "+c);
			else System.out.println(a+", "+c+", "+b);

		}else if(b<c) { //만약 b가 제일 작다면?
			if(a<c) System.out.println(b+", "+a+", "+c);
			else System.out.println(b+", "+c+", "+a);

		}else{
			if(a<b) System.out.println(c+", "+a+", "+b);
			else System.out.println(c+", "+b+", "+a);
		}	
	}
}

/*
[실행결과]
D:\java_se\workspace\0723>javac IfTest3.java

D:\java_se\workspace\0723>java IfTest3
첫번째 입력 : 62
두번째 입력 : 60
세번째 입력 : 80
60, 62, 80
*/