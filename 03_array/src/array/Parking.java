/*
주차장 관리 프로그램

[실행결과]
**************
1. 입차      
2. 출차      
3. 리스트      
4. 종료
**************
메뉴 : 8
1~4번까지만 입력하세요.

1번인 경우
위치 입력 : 3
3위치에 입차 / 이미 주차되어 있습니다

2번인 경우
위치 입력 : 4
4위치에서 출차 / 주차되어 있지 않습니다

3번인 경우
1위치 : false
2위치 : false
3위치 : false
4위치 : false
5위치 : false

4번인 경우
프로그램을 종료합니다.
 */

package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parking {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num, index; 
		boolean[] ar = new boolean[5]; //boolean 배열의 경우 garbage값이 flase가 들어있음
		
		while(true) {
			System.out.println();
			System.out.println("**************");
			System.out.println("   1. 입차");
			System.out.println("   2. 출차");
			System.out.println("   3. 리스트");
			System.out.println("   4. 종료");
			System.out.println("**************");
			System.out.print(" 메뉴 : ");
			num = Integer.parseInt(br.readLine());
			if(num==4) break; //4번인 경우(종료) 종료
			
			if(num==1) { //1번인 경우(입차)
				System.out.print("위치 입력 : ");
				index = Integer.parseInt(br.readLine());
				
				//if(ar[index-1]==true) //false: 차가 없음, true: 차가 있음
				if(ar[index-1]) 
					System.out.println("이미 주차되어 있습니다");
				else {
					System.out.println(index+"위치에 입차");
					ar[index-1] = true;
				}
				
			}else if(num==2) { //2번인 경우(출차)
				System.out.println("위치 입력 : ");
				index = Integer.parseInt(br.readLine());
				
				if(ar[index-1]) {
					System.out.println(index+"위치에서 출차");
					ar[index-1] = false;
				}else {
					System.out.println("주차되어 있지 않습니다");
				}
				
			}else if(num==3) { //3번인 경우(리스트)
				for(int i=0; i<ar.length; i++) {
					System.out.println((i+1)+"위치 : "+ar[i]);
				}//for				
			}else System.out.println("1~4번까지만 입력하세요.");
			
		}//while
		System.out.println("프로그램을 종료합니다.");
	}
}

/*
컴퓨터가 인식하는 방의 위치 순서 : 0 1 2 3 4 ... 
사람이 인식하는 방의 위치 순서 : 1 2 3 4 ... 

이 문제의 경우 index는 사람이 보는 관점이므로 
boolean ar [i] = boolean ar [index-1]
 */

/*
[실행결과]

**************
   1. 입차
   2. 출차
   3. 리스트
   4. 종료
**************
 메뉴 : 3
1위치 : false
2위치 : false
3위치 : false
4위치 : false
5위치 : false

**************
   1. 입차
   2. 출차
   3. 리스트
   4. 종료
**************
 메뉴 : 1
위치 입력 : 1
1위치에 입차

**************
   1. 입차
   2. 출차
   3. 리스트
   4. 종료
**************
 메뉴 : 1
위치 입력 : 2
2위치에 입차

**************
   1. 입차
   2. 출차
   3. 리스트
   4. 종료
**************
 메뉴 : 3
1위치 : true
2위치 : true
3위치 : false
4위치 : false
5위치 : false

**************
   1. 입차
   2. 출차
   3. 리스트
   4. 종료
**************
 메뉴 : 1
위치 입력 : 1
이미 주차되어 있습니다

**************
   1. 입차
   2. 출차
   3. 리스트
   4. 종료
**************
 메뉴 : 2
위치 입력 : 
1
1위치에서 출차

**************
   1. 입차
   2. 출차
   3. 리스트
   4. 종료
**************
 메뉴 : 2
위치 입력 : 
4
주차되어 있지 않습니다

**************
   1. 입차
   2. 출차
   3. 리스트
   4. 종료
**************
 메뉴 : 3
1위치 : false
2위치 : true
3위치 : false
4위치 : false
5위치 : false

**************
   1. 입차
   2. 출차
   3. 리스트
   4. 종료
**************
 메뉴 : 4
프로그램을 종료합니다.
*/

