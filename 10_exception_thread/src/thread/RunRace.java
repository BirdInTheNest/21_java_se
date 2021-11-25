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
	private int count; //������ ��
	private JButton btn;
	private Racer[] racer; //RacerŬ������ ��1����
	
	public RunRace(int count) { //������
		Scanner scan = new Scanner(System.in);
		this.count = count;
		
		btn = new JButton("����");
		JPanel southP = new JPanel(new FlowLayout(FlowLayout.RIGHT));//������ �߽� ��ġ
		southP.add(btn);
		
		JPanel centerP = new JPanel(new GridLayout(count,1)); //��, ��
		racer = new Racer[count]; //�迭 ����
		
		String horseName = null;
		for(int i=0; i<count; i++) {
			System.out.print("�� �̸� �Է� : ");
			horseName = scan.next();
			
			racer[i] = new Racer(horseName); //Ŭ���� ����
			centerP.add(racer[i]);
		}
		
		this.add("Center", centerP);
		this.add("South", southP);

		setBounds(900,200,600,400);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		
		//�̺�Ʈ
		btn.addActionListener(this);
		
	}//RunRace(int count)
	
	@Override
	public void actionPerformed(ActionEvent e) {
		btn.setEnabled(false);//��ư ��Ȱ��ȭ
		
		Thread[] t = new Thread[count]; //�迭 ����
		for(int i=0; i<count; i++) {
			t[i] = new Thread(racer[i]); //������ ����
			
			//�켱 ���� �ο� 1~10 (default 5)
			int num = (int)(Math.random()*10)+1; //1~10������ ����
			t[i].setPriority(num);

			t[i].start(); //������ ����
		}
	}//actionPerformed(ActionEvent e)

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("������ �� �Է� : ");
		int count = scan.nextInt();
		
		new RunRace(count);
	}
}
