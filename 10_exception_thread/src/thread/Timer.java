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
	
	public Timer() { //������
		label = new JLabel("0", JLabel.CENTER); //�� ����, �ʱⰪ 0, ��� ����
		label.setFont(new Font("���ü", Font.BOLD, 80));
		label.setForeground(Color.BLACK); //�۾� ����
		
		startBtn = new JButton("����"); //��ư ����
		stopBtn = new JButton("����");
		
		JPanel p = new JPanel(new GridLayout(2,1,0,10)); //�г� ����
		p.add(startBtn); //�гο� ��ư���ϱ�
		p.add(stopBtn);
		
		add("Center", label); //�����ӿ� �󺧴��ϱ�
		add("East", p); //�����ӿ� �гδ��ϱ�
		
		setTitle("Timer");
		setBounds(700,200,300,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//�̺�Ʈ
		startBtn.addActionListener(this);
		stopBtn.addActionListener(this);
		
	}//Timer()

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread t = null; //�ʱⰪ
		
		if(e.getSource()==startBtn) {
			t = new Thread(this); //Timer�� ������ ����
			t.start(); //������ ����
			
			onoff = true; //������ on
			
			startBtn.setEnabled(false); //��ư ��Ȱ��ȭ
			stopBtn.setEnabled(true); 
			
		}else if(e.getSource()==stopBtn) {
			t = null; //������ ����
			
			onoff = false; //������ off
			
			startBtn.setEnabled(true);
			stopBtn.setEnabled(false);
		}
	}

	@Override
	public void run() {
		int i; //Ÿ�̸� ����
		
		for(i=count; i<=50; i++) { //count �ʱⰪ 0
			label.setText(i+"");
			
			if(!onoff) { //onoff�� false�� �� (stopBtn ������ ��)
				count = i; //i���� count�� ����
				break; //for���� �����
			}
			
			try {
				Thread.sleep(50); //������ 0.05�� �����
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










