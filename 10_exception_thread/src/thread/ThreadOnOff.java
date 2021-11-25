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
		label = new JLabel("0", JLabel.CENTER); //�� ����, ��� ����
		label.setFont(new Font("���ü", Font.BOLD, 70));
		label.setForeground(Color.RED);
		btn = new JButton("������"); //��ư ����
		
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT)); //������ �߽� ��ġ
		p.add(btn); //�гο� ��ư ���ϱ�
		
		add("Center", label); //JFrame ����� �� ���ϱ�
		add("South", p);
		
		setBounds(700,200,300,200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//�̺�Ʈ - MouseAdapter()�� �߻�Ŭ������ Override�� �߻�޼ҵ尡 ����
		btn.addMouseListener(new MouseAdapter() { //�͸� Inner Class
			Thread t;
			
			@Override
			public void mousePressed(MouseEvent e) {
				t = new Thread(ThreadOnOff.this); //ThreadOnOff�� ������ ����
				
				//08_nested ��Ű�� OuterŬ���� ����
				//���ʿ� �ִ� Ŭ������ �ٱ��� Ŭ������ ��� ����� ���� ����
				//�ٱ��� Ŭ������ ������ Ŭ������ ����� ���� �Ұ���,�� ������ Ŭ������ ��ü�� �����ϸ� ���� ����
				
				t.start(); //������ ����
				System.out.println("������ t = "+t);
				
				onoff = true; //������ on
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				t =null; //������ ����
				System.out.println("�ն��� t = "+t);
				
				onoff = false; //������ off
			}
		});
		
	}//ThreadOnOff()

	@Override
	public void run() {
		while(true) {
			count++;
			label.setText(count+""); //int�� count�� ""�ٿ��� String������ ����, �󺧿� ǥ��
			
			if(!onoff) break; //onoff�� false�� !onoff�� true, while���� �����
			
			try {
				Thread.sleep(50); //0.05�� �����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(count>=50) count=0; //�ʱ�ȭ
			
		}//while
	}
	
	public static void main(String[] args) {
		new ThreadOnOff();
	}
}

//ActionListener (Clicked)
//MouseListener (Pressed, Released)