/*
덧셈문제
- 2자리의 숫자로 제공한다 (10 ~ 99 사이의 난수 발생)
- 문제수는 총 5문제를 제공한다
- 1문제당 20점씩 누적된다
- 틀리면 1번 더 기회를 준다...(for)
  2번째까지 다 틀리면 그때 정답을 알려준다.

[실행결과]
[문제 1] 12 + 95 = 직접 입력
틀렸다...
[문제 1] 12 + 95 = 직접 입력
틀렸다...정답 : 107

[문제 5] 10 + 90 = 직접 입력
딩동댕...참 잘했어요

당신은 총 x문제를 맞추어서 xx점 입니다

1번 더 (Y/N) ? N
프로그램을 종료합니다.
*/

package for_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlusGame {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a, b, answer, count;
		String yn;
		
		while(true) { //반복
			count=0; //초기값 제시
			for(int i=1; i<=5; i++) {//5문제 반복
				a = (int)(Math.random()*90) +10; //10부터 시작하는 90개의 난수 
				b = (int)(Math.random()*90) +10; //0~89 -> 10~99
				
				for(int j=1; j<=2; j++) { //틀리면 기회를 1번 더 제공
					System.out.print("[문제 "+i+"] "+a+" + "+b+" = ");
					answer = Integer.parseInt(br.readLine());
					
					if(answer == a+b) {
						System.out.println("딩동댕...참 잘했어요");
						count++; //정답을 맞춘 경우의 개수 계산
						break; //for j를 벗어나라
					}else {
						if(j==1) //1번 틀렸을 때 
							System.out.println("틀렸다...");
						else if(j==2) //2번 틀렸을 때
							System.out.println("틀렸다...정답 : "+(a+b));
					}
				}//for j
				System.out.println();
			}//for i
	
		System.out.println();
		System.out.println("당신은 총 "+count+"문제를 맞추어서 "+count*20+"점 입니다");

		System.out.print("1번 더 (Y/N) ?");
		yn = br.readLine();
		
		//if(yn=="N" || yn=="n") break; //== 주소값 비교
		if(yn.equals("N") || yn.equals("n")) break;
		}//while
		
		System.out.println("프로그램을 종료합니다.");
	}
}

//블록 지정해서 탭이동하기
//Shift tab : 왼쪽으로 탭이동
//tab : 오른쪽으로 탭이동

/*
[실행결과]
[문제 1] 38 + 94 = 132
딩동댕...참 잘했어요

[문제 2] 24 + 88 = 112
딩동댕...참 잘했어요

[문제 3] 99 + 74 = 173
딩동댕...참 잘했어요

[문제 4] 46 + 26 = 72
딩동댕...참 잘했어요

[문제 5] 31 + 58 = 100
틀렸다...
[문제 5] 31 + 58 = 89
딩동댕...참 잘했어요


당신은 총 5문제를 맞추어서 100점 입니다
1번 더 (Y/N) ?n
프로그램을 종료합니다.
*/