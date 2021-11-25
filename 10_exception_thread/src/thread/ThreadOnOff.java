package thread;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ThreadOnOff extends JFrame implements Runnable {
	private JLabel label;
	private JButton btn;
	private int count;
	private boolean onoff;
	
	public ThreadOnOff() {
		label = new JLabel("0", JLabel.CENTER); //라벨 생성, 가운데 정렬
		label.setFont(new Font("고딕체", Font.BOLD, 70));
		label.setForeground(Color.RED);
		btn = new JButton("누르기"); //버튼 생성
		
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT)); //오른쪽 중심 배치
		p.add(btn); //패널에 버튼 더하기
		
		add("Center", label); //JFrame 가운데에 라벨 더하기
		add("South", p);
		
		setBounds(700,200,300,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//이벤트 - MouseAdapter()는 추상클래스로 Override할 추상메소드가 없음
		btn.addMouseListener(new MouseAdapter() { //익명 Inner Class
			Thread t;
			
			@Override
			public void mousePressed(MouseEvent e) {
				t = new Thread(ThreadOnOff.this); //ThreadOnOff의 스레드 생성
				
				//08_nested 패키지 Outer클래스 참고
				//안쪽에 있는 클래스는 바깥쪽 클래스의 모든 멤버에 접근 가능
				//바깥쪽 클래스는 안쪽의 클래스의 멤버에 접근 불가능,단 안쪽의 클래스로 객체를 선언하면 접근 가능
				
				t.start(); //스레드 시작
				System.out.println("누르기 t = "+t);
				
				onoff = true; //스레드 on
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				t =null; //스레드 해제
				System.out.println("손떼기 t = "+t);
				
				onoff = false; //스레드 off
			}
		});
		
	}//ThreadOnOff()

	@Override
	public void run() {
		while(true) {
			count++;
			label.setText(count+""); //int형 count에 ""붙여서 String형으로 만듦, 라벨에 표시
			
			if(!onoff) break; //onoff가 false면 !onoff는 true, while문을 벗어나라
			
			try {
				Thread.sleep(50); //0.05초 쉬어라
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(count>=50) count=0; //초기화
			
		}//while
	}
	
	public static void main(String[] args) {
		new ThreadOnOff();
	}
}

//ActionListener (Clicked)
//MouseListener (Pressed, Released)