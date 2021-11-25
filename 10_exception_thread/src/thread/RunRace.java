package thread;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RunRace extends JFrame implements ActionListener {
	private int count; //말마리 수
	private JButton btn;
	private Racer[] racer; //Racer클래스는 말1마리
	
	public RunRace(int count) { //생성자
		Scanner scan = new Scanner(System.in);
		this.count = count;
		
		btn = new JButton("시작");
		JPanel southP = new JPanel(new FlowLayout(FlowLayout.RIGHT));//오른쪽 중심 배치
		southP.add(btn);
		
		JPanel centerP = new JPanel(new GridLayout(count,1)); //행, 열
		racer = new Racer[count]; //배열 생성
		
		String horseName = null;
		for(int i=0; i<count; i++) {
			System.out.print("말 이름 입력 : ");
			horseName = scan.next();
			
			racer[i] = new Racer(horseName); //클래스 생성
			centerP.add(racer[i]);
		}
		
		this.add("Center", centerP);
		this.add("South", southP);

		setBounds(900,200,600,400);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		
		//이벤트
		btn.addActionListener(this);
		
	}//RunRace(int count)
	
	@Override
	public void actionPerformed(ActionEvent e) {
		btn.setEnabled(false);//버튼 비활성화
		
		Thread[] t = new Thread[count]; //배열 생성
		for(int i=0; i<count; i++) {
			t[i] = new Thread(racer[i]); //스레드 생성
			
			//우선 순위 부여 1~10 (default 5)
			int num = (int)(Math.random()*10)+1; //1~10까지의 난수
			t[i].setPriority(num);

			t[i].start(); //스레드 시작
		}
	}//actionPerformed(ActionEvent e)

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("말마리 수 입력 : ");
		int count = scan.nextInt();
		
		new RunRace(count);
	}
}
