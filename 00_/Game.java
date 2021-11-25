/*
가위 바위 보 게임
- 가위(1), 바위(2), 보(3)으로 인식한다
- 컴퓨터는 1~3 사이의 난수를 발생한다.

[실행결과]
가위(1), 바위(2), 보(3) 중 번호를 입력 : 2 (System.in.read() 사용하세요)
배팅 금액 입력 : 200 (BufferedReader 사용하세요)
결과를 보려면 아무키나 누르세요......

컴퓨터 : 가위, 나 : 바위
이겼습니다.
현재 금액은 1,200원 입니다.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

class Game {
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("가위(1), 바위(2), 보(3) 중 번호를 입력 : ");
		int user = System.in.read(); //int user = br.read();

		System.out.print("배팅 금액 입력 : ");
		int money = Integer.parseInt(br.readLine());

		System.out.print("결과를 보려면 아무키나 누르세요......");
		System.in.read(); //flush


		int com = (int)(Math.random()*3 +1); //0~2 -> 1~3

		//Random r = new Random();
		//int com = r.nextInt(3) +1;

		if(user == 1) System.out.print("가위");
		else if(user == 2) System.out.print("바위");
		else System.out.print("보");

		if(com == 1) System.out.print("가위");
		else if(com == 2) System.out.print("바위");
		else System.out.print("보");
		
		
		System.out.println("컴퓨터 : "+com+", 나 : "+user);
		
		if(user == 1) { //user가 가위
			if(com == 1) System.out.println("비겼습니다"); //com이 가위
			else if(com == 2) System.out.println("졌습니다"); //com이 바위
			else System.out.println("이겼습니다"); //com이 보

		}else if(user == 2) { //user가 바위
			if(com == 1) System.out.println("이겼습니다"); //com이 가위
			else if(com == 2) System.out.println("비겼습니다"); //com이 바위
			else System.out.println("졌습니다"); //com이 보

		}else { //user가 보
			if(com == 1) System.out.println("졌습니다"); //com이 가위
			else if(com == 2) System.out.println("이겼습니다"); //com이 바위
			else System.out.println("비겼습니다"); //com이 보
		}
			





		
		/*
		//난수: 컴퓨터가 불규칙하게 생성하는 수 0 <= 난수 <1
		//방법 1 - java.lang.Math.random() - static double //클래스명.메소드명(값1, 값2...)

		double a = Math.random(); 
		System.out.println(a); //0.3428141771797262

		double aa = Math.random()*10; 
		System.out.println(aa); //9.550945987348612

		int aaa = (int)(Math.random()*10); 
		System.out.println(aaa); //0~9

		int aaaa = (int)(Math.random()*3); 
		System.out.println(aaaa); //0~2

		int aaaaa = (int)(Math.random()*3 +1); 
		System.out.println(aaaaa); //0~2 -> 1~3

		//방법 2 - java.util.Random.nextInt(int bound) - int //객체명.메소드명(값1, 값2...)
		Random r = new Random();
		int b = r.nextInt(3) +1; //0~2 -> 1~3
		System.out.println(b);
		*/
   }
}