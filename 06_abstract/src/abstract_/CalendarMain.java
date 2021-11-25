/*
만년 달력
- 년도, 월을 입력하여 달력을 출력하시오
- 매월 시작하는 요일을 구하시오 - 메소드
- 매월 끝나는 일(30, 28, 29, 31)을 구하시오 - 메소드
- 클래스 : CalendarTest
  필드  : year, month, week, lastDay
  생성자 : 입력
  메소드 : calc()
         display()

[실행결과]
년도 입력 : 2002
월 입력 : 10

일	월	화	수	목	금	토	
		1	2	3	4	5	
6	7	8	9	10	11	12	
13	14	15	16	17	18	19	
20	21	22	23	24	25	26	
27	28	29	30	31	
 */

package abstract_;

import java.util.Calendar;
import java.util.Scanner;

class CalendarTest{ 
	private int year, month, week, lastDay; //필드
	
	public CalendarTest() { //생성자 - 년도, 월을 입력
		Scanner scan = new Scanner(System.in); 
		System.out.print("년도 입력 : ");
		this.year = scan.nextInt();
		System.out.print("월 입력 : ");
		this.month = scan.nextInt();
	}//생성자
	
	public void calc() {
		Calendar cal = Calendar.getInstance(); //메소드를 이용하여 추상클래스 생성
		//기준은 시스템 날짜와 시간 -> 년도, 월은 입력받은 값으로 처리, 일은 기준일자 변경해야 함	

		//cal.set(Calendar.YEAR, year); //년, static은 클래스명 안쓰고 객체명 써도 됨
		//cal.set(cal.MONTH, month-1); //월, cal.MONTH는 1월 0, 2월 1 이기 때문에 month-1해줌
		//cal.set(cal.DAY_OF_MONTH, 1); //일, 시스템 날짜가 기준이기 때문에 1일로 변경
		cal.set(year, month-1, 1);

		week = cal.get(cal.DAY_OF_WEEK); //기준일자인 1일의 요일을 가져온다. 일요일 1, 월요일 2...토요일 7
		lastDay = cal.getActualMaximum(cal.DAY_OF_MONTH); //28, 29, 30, 31
	}//calc()
	
	public void display() {
		System.out.print("일\t월\t화\t수\t목\t금\t토\t\n");
		
		for(int i=1; i<week; i++) { //1일이 몇요일로 시작하느냐에 따라 달력에서 공백이 다름
			System.out.print("\t"); //요일에 맞게 1일 시작하게 공백주는 것
		}
		
		for(int i=1; i<=lastDay; i++) { //1일부터 달의 마지막 날까지 찍기
			System.out.print(i+"\t");
			
			if(week%7==0) System.out.println(); //7개마다 줄바꾸기
			week++;	//잔머리, for문 돌아가는 횟수를 이용하여 한줄띄기를 하는데 이용
			//count 변수를 초기값을 0을 주고 for문 돌아갈 때마다 count++하여 줄바꾸기에 이용해도 됨		
		}//for
	}//display()
}//CalendarTest()
//-----------------------
public class CalendarMain {

	public static void main(String[] args) {
		CalendarTest ct = new CalendarTest();
		ct.calc();
		ct.display();
	}
}