package thread;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Timer extends JFrame implements Runnable, ActionListener{
	private JLabel label;
	private JButton startBtn, stopBtn;
	private boolean onoff;
	private int count=0;
	
	public Timer() { //생성자
		label = new JLabel("0", JLabel.CENTER); //라벨 생성, 초기값 0, 가운데 정렬
		label.setFont(new Font("고딕체", Font.BOLD, 80));
		label.setForeground(Color.BLACK); //글씨 색상
		
		startBtn = new JButton("시작"); //버튼 생성
		stopBtn = new JButton("멈춤");
		
		JPanel p = new JPanel(new GridLayout(2,1,0,10)); //패널 생성
		p.add(startBtn); //패널에 버튼더하기
		p.add(stopBtn);
		
		add("Center", label); //프레임에 라벨더하기
		add("East", p); //프레임에 패널더하기
		
		setTitle("Timer");
		setBounds(700,200,300,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//이벤트
		startBtn.addActionListener(this);
		stopBtn.addActionListener(this);
		
	}//Timer()

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread t = null; //초기값
		
		if(e.getSource()==startBtn) {
			t = new Thread(this); //Timer로 스레드 생성
			t.start(); //스레드 시작
			
			onoff = true; //스레드 on
			
			startBtn.setEnabled(false); //버튼 비활성화
			stopBtn.setEnabled(true); 
			
		}else if(e.getSource()==stopBtn) {
			t = null; //스레드 해제
			
			onoff = false; //스레드 off
			
			startBtn.setEnabled(true);
			stopBtn.setEnabled(false);
		}
	}

	@Override
	public void run() {
		int i; //타이머 숫자
		
		for(i=count; i<=50; i++) { //count 초기값 0
			label.setText(i+"");
			
			if(!onoff) { //onoff가 false일 때 (stopBtn 눌렸을 때)
				count = i; //i값을 count에 저장
				break; //for문을 벗어나라
			}
			
			try {
				Thread.sleep(50); //스레드 0.05초 쉬어라
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}//for
		
		if(i>=50) {
			count=0;
			
			startBtn.setEnabled(true);
			stopBtn.setEnabled(false);
		}

	}//run()

	public static void main(String[] args) {
		new Timer();	
	}
}










