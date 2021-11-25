/*
약수를 구하기

[실행결과]
숫자 입력 : 12      숫자 입력 : 11
1 2 3 4 6 12      1 11
12는 소수가 아니다.   11는 소수이다.
*/

package for_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ForTest6 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num, count=0;
		
		System.out.print("숫자 입력 : ");
		num = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=num; i++) {
			if(num%i ==0) { //num을 1~num의 숫자로 나누었을 때 나머지가 0이면 약수
				System.out.print(i+" ");
				count++; //for문 중에서 if(조건)이 참인 경우의 개수
			}
		}//for
		
		System.out.println();
		
		if(count==2) System.out.println(num+"는 소수이다."); //소수 : 1과 자신만 약수인 수
		else System.out.println(num+"는 소수가 아니다.");	
	}
}
