/*
★ 동기화 처리
여러 개의 객체가 동시에 하나의 메소드에 접근하려고 할 때 심각한 부하가 발생 된다
이를 방지하기 위해 Lock를 건다.
이것을 동기화 처리라고 한다.

[형식] 
1)    public synchronized returnType 메소드명(인수형 인수, ...){
      }


2)    public   returnType   메소드명(인수형 인수, ...){ 
      	     synchronized(this){
             }
       }

3)    public   returnType   메소드명(인수형 인수, ...){ 
               synchronized(*.class){
               }
       }
*/

package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class ATMTest implements Runnable {
	private long depositMoney=100000; //잔액
	private long balance; //찾고자 하는 금액

	public static void main(String[] args) { //static영역에는 this가 없음
		ATMTest atm = new ATMTest(); //클래스 생성
		Thread mom = new Thread(atm, "엄마"); //스레드 생성 (ATMTest를 스레드로)
		Thread son = new Thread(atm, "아들"); //스레드 생성
		
//		mom.setName("엄마");
//		son.setName("아들");
		
		mom.start(); //스레드 시작
		son.start(); //스레드 시작
	}

	@Override
	public synchronized void run() { //synchronized : 한 사람이 끝날 때까지 못 들어옴
		System.out.println(Thread.currentThread().getName()+"님 안녕하세요");
		//현재 실행하고 있는 스레드에서 그 이름 출력
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.print("찾고자 하는 금액 입력 : ");
			balance = Long.parseLong(br.readLine()); //long형이라 Long.parseLong
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//잔액 계산
		if(depositMoney >= balance) { //잔액이 찾고자 하는 금액보다 크거나 같을 때
			if(balance%10000 == 0) {
				depositMoney -= balance;
				System.out.println("잔액은 "+
				new DecimalFormat().format(depositMoney)+"원 입니다");	
			}else{ //balance%10000 != 0
				System.out.println("만원 단위로 입력하세요");				
			}
		}else { //depositMoney < balance
			System.out.println("잔액이 부족합니다");
		}
	}//run()
}