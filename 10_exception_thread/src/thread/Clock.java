package thread;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Clock extends JFrame implements Runnable {
	private JLabel timeL;

	public Clock() { //������ (�����ڳ� init() �Ѵ� �������)	
		timeL = new JLabel("", JLabel.CENTER);
		timeL.setFont(new Font("Arial", Font.BOLD, 36));
		timeL.setForeground(Color.RED);
		
		add("Center", timeL);
		
		setTitle("�ð�");
		setBounds(700,200,400,150);
		setVisible(true);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE); //���α׷� ����
		
//		this.addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				System.exit(0); //���α׷� ����
//			}
//		});
		
		Thread t = new Thread(this); //Clock�� ������ ����
		t.start(); //������ ���� -> ������ ����(run())		
	}
	
	@Override
	public void run() { //���ѷ����� ������� ������
		while(true) {	
			repaint(); //paint() ȣ��	
			try {
				Thread.sleep(1000); //���� 1/1000��
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}//while
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g); //������ �ʱ�ȭ
			
		//Calendar cal = new GregorianCalendar(); //�ڽ�Ŭ���� �̿�
		Calendar cal = Calendar.getInstance(); //�޼ҵ� �̿�
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		
		String time = String.format("%02d : %02d : %02d", hour, minute, second); 
		//%02d : ���� �� ���� �� ù��° ���� ������ 0 �ΰ� 
		//g.drawString(time, 100, 90); //drawString(String str, int x, int y)
		timeL.setText(time);
	}
	
	public static void main(String[] args) {
		new Clock();
	}
}

/*
�ý����� ��¥�� �ð�
SimpleDateFormat
Calendar

������ư�� while�� �ۿ� �־ ���� �� ��� �ȵ�
���α׷��� �������� while���� run()�� �־ 
�ð��� ���� ���� �Դٰ��� �ϴ� ���� ��Ƽ�������� ����
*/