/*
숫자 맞추기 게임

1 ~ 100 사이의 숫자를 맞추면 종료 됩니다

[실행결과]
숫자를 발생했습니다...(75)
숫자 입력 : 50
50보다 큽니다.

숫자 입력 : 80
80보다 작습니다.

...

숫자 입력 : 75
딩동댕...xx번만에 맞추셨습니다.

1번 더 (Y/N) ? N
프로그램을 종료합니다.
 */

package while_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WhileTest2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int com, user, count; 
		int yn;
		
		while(true) { //문제 생성 반복		
			com = (int)(Math.random()*100) +1; //1부터 시작하는 100개의 난수 발생
			System.out.println("숫자를 발생했습니다..."+com);
			
			count = 0; //초기화
			
			while(true) { //숫자를 맞출 때까지 반복
				System.out.print("숫자 입력 : ");
				user = Integer.parseInt(br.readLine());
				
				count++; //count = count + 1 //while문이 반복되는 횟수 계산
				
				if(com == user) break; //숫자를 맞추면 멈춰라
				
				if(com > user) {
					System.out.println(user+"보다 큽니다.");
				}else {
					System.out.println(user+"보다 작습니다.");
				}	
			}//while

			System.out.println("딩동댕..."+count+"번만에 맞추셨습니다.");
			
			while(true){ //Y나 N로 대답할 때까지 질문 반복
				System.out.print("1번 더 (Y/N) ?");
				yn = br.read(); 	//flush 필요
				br.read(); 			//Enter(엔터) 1. 커서를 앞으로 보낸다 \r(13)
				br.read(); 			//		     2. 줄바꿈 		   \n(10)
				
				if(yn=='Y' || yn=='y' || yn=='N' || yn=='n') break;
			}//while
			
			if(yn=='N' || yn=='n') break;
		}//while
		System.out.println("프로그램을 종료합니다.");
	}
}

/*
[실행결과]
숫자를 발생했습니다...28
숫자 입력 : 30
30보다 작습니다.
숫자 입력 : 27
27보다 큽니다.
숫자 입력 : 28
딩동댕...3번만에 맞추셨습니다.
1번 더 (Y/N) ?y
숫자를 발생했습니다...82
숫자 입력 : 82
딩동댕...1번만에 맞추셨습니다.
1번 더 (Y/N) ?n
프로그램을 종료합니다.
*/