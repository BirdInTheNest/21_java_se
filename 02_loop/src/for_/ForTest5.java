/*
[실행결과]
시작값 입력 : 5
끝값 입력 : 20
5 ~ 20까지의 합 = xx
*/

package for_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ForTest5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int start, end;
		int sum=0;
		int count=0;
		
		System.out.print("시작값 입력 : ");
		start = Integer.parseInt(br.readLine());
		System.out.print("끝값 입력 : ");
		end = Integer.parseInt(br.readLine());
		
		for(int i=start; i<=end; i++) {
			sum += i;
			System.out.print(i+" ");
			count++; //for문이 반복되는 횟수 1 2 3 4 5 6 7 ...
			if(count%5==0) System.out.println(); //5의 배수당 한줄 띄기
		}//for
		
		System.out.println();
		System.out.print(start+" ~ "+end+"까지의 합 = "+sum);
	}
}

/*
[실행결과]
시작값 입력 : 5
끝값 입력 : 20
5 6 7 8 9 
10 11 12 13 14 
15 16 17 18 19 
20 
5 ~ 20까지의 합 = 200
*/
