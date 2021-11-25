/*
배열의 크기를 입력받아서 정수형 배열을 생성하고 데이터 입력 후 출력하시오
합, 최대값을 구하시오

배열 크기 입력 : 7
ar[0] 입력 : 6
ar[1] 입력 : 8
ar[2] 입력 : 9
ar[3] 입력 : 3
ar[4] 입력 : 2
ar[5] 입력 : 4
ar[6] 입력 : 5

6  8  9  3  2  4  5  
합 = xxx
최대값 = xx
최소값 = xx
 */

package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayTest3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("배열 크기 입력 : "); 
		int size = Integer.parseInt(br.readLine());	//배열의 크기를 입력받아서 
		int[] ar = new int[size]; //정수형 배열을 생성 - 메모리에 정수형 배열의 방이 size개 생김
	
		int sum = 0; //초기값
		int max, min;
		
		for(int i=0; i<ar.length; i++) { //방의 개수 4: ar[0], ar[1] ar[2] ar[3]
			System.out.print("ar["+i+"] 입력 : ");
			ar[i] = Integer.parseInt(br.readLine()); //ar[i]에 데이터 입력
		
			sum += ar[i]; //데이터값들의 합
		}//for
		
		max = min = ar[0]; //초기값
		for(int i=1; i<ar.length; i++) {
			if(ar[i] > max) max = ar[i]; //max 값 바꿔치기
			if(ar[i] < min) min = ar[i]; //min 값 바꿔치기
		}//for
		
		for(int a : ar) { //ar 주소에 있는 데이터값을 int a에 넣어주는 거 반복, 새로운 값이 덮어버림
			System.out.print(a+"  ");
		}//for
		
		System.out.println();
		System.out.println("합 = "+sum);
		System.out.println("최대값 = "+max);
		System.out.println("최소값 = "+min);	
	}
}

/*
만약 max의 초기값이 0인 경우 모든 데이터값이 -값일 때 최대값이 안 나옴
따라서 max는 초기값으로 데이터 중 하나를 갖는다 ar[0]
ar[1] > max이면 max = ar[1]
ar[2] > max이면 max = ar[2]
...
 */



/*
[실행결과]
배열 크기 입력 : 5
ar[0] 입력 : -12
ar[1] 입력 : -58
ar[2] 입력 : -35
ar[3] 입력 : -42
ar[4] 입력 : -55
-12  -58  -35  -42  -55  
합 = -202
최대값 = -12
최소값 = -58
*/