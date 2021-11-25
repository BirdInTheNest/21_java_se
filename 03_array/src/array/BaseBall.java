/*
야구 게임 - 숫자 맞추기 게임
- 크기가 3개인 정수형 배열을 잡고 1~9사이의 난수를 발생한다
- 난수는 중복을 허용하지 않는다

[실행결과]
게임을 실행하시겠습니까(Y/N) : w
게임을 실행하시겠습니까(Y/N) : q
게임을 실행하시겠습니까(Y/N) : y

게임을 시작합니다

숫자입력 : 123
1스트라이크 0볼

숫자입력 : 182
0스트라이크 2볼

...

숫자입력 : 428
3스트라이크 0볼

축하합니다...몇x번만에 맞추셨습니다.
 */

package array;

import java.io.IOException;

public class BaseBall {

	public static void main(String[] args) throws IOException{
		int[] com = new int[3]; //크기가 3개인 정수형 배열을 잡고
		int[] user = new int[3];
		int yn;
		int strike, ball;
		int count=0;
		
		do {											  //조건이 참이면 반복, 거짓이면 종료
			System.out.print("게임을 실행하시겠습니까(Y/N) : ");
			yn = System.in.read();
			System.in.read();
			System.in.read();//flush
		}while(yn!='Y' && yn!='y' && yn!='N' && yn!='n'); //대답이 Y,y,N,n이 아닌 경우 반복
		
		if(yn=='Y' || yn=='y') {
			System.out.println("\n게임을 시작합니다");
			
			//난수 발생
			for(int i=0; i<com.length; i++) { 
				com[i] = (int)(Math.random()*9)+1; //1~9사이의 난수를 발생
				
				//중복체크 - 난수는 중복을 허용하지 않는다
				for(int j=0; j<i; j++) {
					if(com[i] == com[j]) {
						i--; //for i로 다시 가서 i++하고 lotto[i]를 생성하기 때문에 i--필요(원상복귀)
						break; //for j를 벗어나라 > for i로 가서 다시 난수 발생
					}//if
				}//for j
			}//for i
			System.out.println(com[0]+", "+com[1]+", "+com[2]); //체크
			
			//숫자 맞추기
			while(true) {
				System.out.print("숫자입력 : ");
				
				count++; //몇번만에 맞추었는지 반복횟수 계산
				for(int i=0; i<user.length; i++) {
					user[i] = System.in.read()-'0';
				}//for i
				System.in.read();
				System.in.read();//flush
				System.out.println(user[0]+", "+user[1]+", "+user[2]); //체크
				
				//비교
				strike = ball = 0; //for문 전에 초기값제시 - 0부터 다시 시작하여 비교
				for(int i=0; i<com.length; i++) {
					for(int j=0; j<user.length; j++) {
						if(com[i]==user[j]) { //데이터값이 같은가?
							if(i==j) //위치도 같은가?
								strike++; //데이터값과 위치가 모두 같은 경우
							else
								ball++; //데이터값이 같은데 위치가 다른 경우
						}//if
					}//for j
				}//for i
				
				System.out.println(strike+"스트라이크\t"+ball+"볼");
				if(strike==3) {
					System.out.println("\n축하합니다..."+count+"번만에 맞추셨습니다.");
					break;
				}//if
			}//while
			
		}//if
		System.out.println("프로그램을 종료합니다");
	}
}

/*
숫자입력 : 123
String input = br.readLine();
	"123"
	(012)
모든 문자열은 위치(index)를 가지고 있다
user[0] = input.charAt(0)-48; //1 //문자로 들어오지 숫자로 들어오는 것이 아니기 때문에 -48 해야함
user[1] = input.charAt(1)-48; //2
user[2] = input.charAt(2)-48; //3
 */

/*
숫자 중복확인 (그 전에 뽑은 숫자 중에 같은 숫자가 있는지 비교)
com[0]   com[1]==com[0]   com[2]==com[0]   com[3]==com[0]   ...
								  com[1]		   com[1]   ...
										  		   com[2]   ...
for(int i=0; i<com.length; i++){
	for(int j=0; j<i; j++){

	}
}
*/

/*
데이터값 같은지 비교
com[0]==user[0]		com[1]==user[0]		com[2]==user[0]
		user[1]				user[1]				user[1]
		user[2]				user[2]				user[2]
 */

/*
[실행결과]
게임을 실행하시겠습니까(Y/N) : w
게임을 실행하시겠습니까(Y/N) : y

게임을 시작합니다
8, 9, 7
숫자입력 : 789
7, 8, 9
0스트라이크	3볼
숫자입력 : 897
8, 9, 7
3스트라이크	0볼

축하합니다...2번만에 맞추셨습니다.
프로그램을 종료합니다
 */














