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
		System.out.println("���� ��¥ : " + date);
		System.out.println(); //���� ��¥ : Mon Aug 09 19:34:06 KST 2021
		
		SimpleDateFormat sdf = new SimpleDateFormat("y�� MM�� dd�� E���� HH:mm:ss");//Oracle mm�� mi��
		System.out.println("���� ��¥ : " + sdf.format(date));
		System.out.println(); //���� ��¥ : 2021�� 08�� 09�� ������ 19:34:06
				
		//�Է�
		SimpleDateFormat input = new SimpleDateFormat("yyyyMMddHHmmss");
		Date birth = input.parse("19910716091527"); //String�� Date�� ����ȯ(�޼ҵ� �̿�)
		System.out.println("������ : " + birth);
		System.out.println("������ : " + sdf.format(birth));
		System.out.println();
		
		//----------------------------------------------------------------------
		
		//������ �ý��� ��¥�� �ð�
		//Calendar cal = new Calendar(); - error: �߻�Ŭ������ new���� ����
		//Calendar cal = new GregorianCalendar(); //�ڽ� Ŭ���� �̿��Ͽ� ����
		Calendar cal = Calendar.getInstance(); //�޼ҵ带 �̿��Ͽ� ����
		
		//Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Canada/Pacific"));
		
		int year = cal.get(Calendar.YEAR); //���ȭ
		//int year = cal.get(1);
		int month = cal.get(Calendar.MONTH) +1; //1�� 0, 2�� 1, 3�� 2...
		//int month = cal.get(2);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		int week = cal.get(Calendar.DAY_OF_WEEK); //�Ͽ��� 1, ������ 2
		
		String dayOfWeek = null;
		
		switch(week) {
		case 1 : dayOfWeek = "�Ͽ���"; break;
		case 2 : dayOfWeek = "������"; break;
		case 3 : dayOfWeek = "ȭ����"; break;
		case 4 : dayOfWeek = "������"; break;
		case 5 : dayOfWeek = "�����"; break;
		case 6 : dayOfWeek = "�ݿ���"; break;
		case 7 : dayOfWeek = "�����"; break;
		}//switch
		
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		System.out.println("���� ��¥ : " + year + "�� "
										+ month + "�� "
										+ day + "�� "
										+ dayOfWeek + " "
										+ hour + "�� "
										+ minute + "�� "
										+ second + "��");
	}
}

/*
public class SimpleDateFormat

java.lang.Object
	java.text.Format
		java.text.DateFormat
			java.text.SimpleDateFormat
-------------------------------------------
[������]
���� ��¥ : Fri Aug 06 15:26:08 KST 2021

���� ��¥ : 2021�� 08�� 06�� �ݿ��� 15:26:08

������ : Tue Jul 16 09:15:27 KST 1991
������ : 1991�� 07�� 16�� ȭ���� 09:15:27

���� ��¥ : 2021�� 8�� 6�� �ݿ��� 15�� 26�� 8��


*/