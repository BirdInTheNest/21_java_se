/*
무한루프
while(true) {
	
}

for(;true;) {
	
}
	
for(;;) {
	
}
 */

/*
[문제] ForTest8.java
x의 y제곱을 구하시오
단, x의 값이 0이 입력되면 프로그램을 종료하시오

[실행결과]
x값 입력 : 2
y값 입력 : 5

2의 5제곱은 32

x값 입력 : 3
y값 입력 : 4

3의 4제곱은 81

x값 입력 : 0
프로그램을 종료합니다.
 */

package for_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ForTest8 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x, y;
		int mul;
		
		for(;;) { //무한루프
			mul = 1; //초기값
			
			System.out.print("x값 입력 : ");
			x = Integer.parseInt(br.readLine());
			if(x==0) break; //x의 값이 0이 입력되면 프로그램을 종료하시오
			
			System.out.print("y값 입력 : ");
			y = Integer.parseInt(br.readLine());
			System.out.println();
			
			//x의 y제곱 - x를 y번 곱한다 (ex.2의 3제곱 = 2*2*2)
			for(int i=1; i<=y; i++) { //y번 반복
				mul *= x;
			}
			System.out.println(x+"의 "+y+"제곱은 "+mul);
			System.out.println();
		}//for
		
		System.out.println("프로그램을 종료합니다.");
	}
}

/*
[실행결과]
x값 입력 : 2
y값 입력 : 5

2의 5제곱은 32

x값 입력 : 3
y값 입력 : 4

3의 4제곱은 81

x값 입력 : 0
프로그램을 종료합니다.
 */


