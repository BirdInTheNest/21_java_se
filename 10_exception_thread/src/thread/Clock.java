package thread;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Clock extends JFrame implements Runnable {
	private JLabel timeL;

	public Clock() { //생성자 (생성자나 init() 둘다 상관없음)	
		timeL = new JLabel("", JLabel.CENTER);
		timeL.setFont(new Font("Arial", Font.BOLD, 36));
		timeL.setForeground(Color.RED);
		
		add("Center", timeL);
		
		setTitle("시계");
		setBounds(700,200,400,150);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE); //프로그램 종료
		
//		this.addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				System.exit(0); //프로그램 종료
//			}
//		});
		
		Thread t = new Thread(this); //Clock을 스레로 생성
		t.start(); //스레드 시작 -> 스레드 실행(run())		
	}
	
	@Override
	public void run() { //무한루프는 스레드로 돌리기
		while(true) {	
			repaint(); //paint() 호출	
			try {
				Thread.sleep(1000); //단위 1/1000초
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}//while
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g); //백지로 초기화
			
		//Calendar cal = new GregorianCalendar(); //자식클래스 이용
		Calendar cal = Calendar.getInstance(); //메소드 이용
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		String time = String.format("%02d : %02d : %02d", hour, minute, second); 
		//%02d : 정수 두 글자 중 첫번째 글자 강제로 0 부과 
		//g.drawString(time, 100, 90); //drawString(String str, int x, int y)
		timeL.setText(time);
	}
	
	public static void main(String[] args) {
		new Clock();
	}
}

/*
시스템의 날짜와 시간
SimpleDateFormat
Calendar

정지버튼이 while문 밖에 있어서 끝낼 수 없어서 안됨
프로그램을 조각내서 while문을 run()을 넣어서 
시간을 나눠 놓고 왔다갔다 하는 것을 멀티스레드라고 말함
*/