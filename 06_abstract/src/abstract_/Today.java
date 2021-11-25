package abstract_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Today {

	public static void main(String[] args) throws ParseException {
		Date date = new Date();
		System.out.println("오늘 날짜 : " + date);
		System.out.println(); //오늘 날짜 : Mon Aug 09 19:34:06 KST 2021
		
		SimpleDateFormat sdf = new SimpleDateFormat("y년 MM월 dd일 E요일 HH:mm:ss");//Oracle mm월 mi분
		System.out.println("오늘 날짜 : " + sdf.format(date));
		System.out.println(); //오늘 날짜 : 2021년 08월 09일 월요일 19:34:06
				
		//입력
		SimpleDateFormat input = new SimpleDateFormat("yyyyMMddHHmmss");
		Date birth = input.parse("19910716091527"); //String을 Date로 형변환(메소드 이용)
		System.out.println("내생일 : " + birth);
		System.out.println("내생일 : " + sdf.format(birth));
		System.out.println();
		
		//----------------------------------------------------------------------
		
		//기준은 시스템 날짜와 시간
		//Calendar cal = new Calendar(); - error: 추상클래스는 new하지 못함
		//Calendar cal = new GregorianCalendar(); //자식 클래스 이용하여 생성
		Calendar cal = Calendar.getInstance(); //메소드를 이용하여 생성
		
		//Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Canada/Pacific"));
		
		int year = cal.get(Calendar.YEAR); //상수화
		//int year = cal.get(1);
		int month = cal.get(Calendar.MONTH) +1; //1월 0, 2월 1, 3월 2...
		//int month = cal.get(2);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		int week = cal.get(Calendar.DAY_OF_WEEK); //일요일 1, 월요일 2
		
		String dayOfWeek = null;
		
		switch(week) {
		case 1 : dayOfWeek = "일요일"; break;
		case 2 : dayOfWeek = "월요일"; break;
		case 3 : dayOfWeek = "화요일"; break;
		case 4 : dayOfWeek = "수요일"; break;
		case 5 : dayOfWeek = "목요일"; break;
		case 6 : dayOfWeek = "금요일"; break;
		case 7 : dayOfWeek = "토요일"; break;
		}//switch
		
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		System.out.println("오늘 날짜 : " + year + "년 "
										+ month + "월 "
										+ day + "일 "
										+ dayOfWeek + " "
										+ hour + "시 "
										+ minute + "분 "
										+ second + "초");
	}
}

/*
public class SimpleDateFormat

java.lang.Object
	java.text.Format
		java.text.DateFormat
			java.text.SimpleDateFormat
-------------------------------------------
[실행결과]
오늘 날짜 : Fri Aug 06 15:26:08 KST 2021

오늘 날짜 : 2021년 08월 06일 금요일 15:26:08

내생일 : Tue Jul 16 09:15:27 KST 1991
내생일 : 1991년 07월 16일 화요일 09:15:27

오늘 날짜 : 2021년 8월 6일 금요일 15시 26분 8초


*/