/*
10진수를 입력하여 2진수로 변환하시오
- 0이 입력되면 프로그램을 종료하시오
- 음수가 입력되면 재입력하시오
- 4개씩 끊어서 보여주기
- Integer.toBinaryString() 사용 X

10진수 입력 : -5

10진수 입력 : 12
1100

10진수 입력 : 250
1111 1010

10진수 입력 : -8

10진수 입력 : 0
프로그램을 종료합니다
 */

package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Binary {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int dec; //int는 4byte - 32bit
		int[] binary = new int[32];
		
		while(true) {
			System.out.print("10진수 입력 : ");
			dec = Integer.parseInt(br.readLine());
			if(dec==0) break; //0이 입력되면 프로그램을 종료하시오
			if(dec<0) continue; //음수가 입력되면 재입력하시오 //while문 맨 처음으로 가서 다시 
			
			//만약에 5를 2진수로 변환: 10진수를 몫이 0이 될때까지 2로 나누고, 나온 나머지를 거꾸로 출력
			//i=0일때 5/2=2..1, i=1일때 2/2=1..0, i=2일때 1/2=0..1
			int i;
			for(i=0; dec!=0; i++) { //몫이 0이 되면 반복하지 않는다
				//System.out.println("i="+i); //디버그
				binary[i] = dec%2;
				dec = dec/2; //몫
				//몫이 0이 되어 반복하지 않아도 i++이 있기 때문에 이미 i=3이 되어있음
				//따라서 거꾸로 출력할 때 필요한 k=i-1이 되어야 함
			}//for
			//System.out.println("탈출 i="+i); //디버그
			
			//거꾸로 출력
			for(int k=i-1; k>=0; k--) {
				System.out.print(binary[k]);
				if(k%4==0) System.out.print(" "); //4개씩 끊어서 보여주기
			}
			System.out.println("\n");
		}//while
		
		System.out.println("프로그램을 종료합니다");
	}
}













