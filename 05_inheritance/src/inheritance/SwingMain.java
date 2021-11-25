package inheritance;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame; //Ȯ����Ű�� javax

public class SwingMain extends JFrame {
	private JButton northBtn, southBtn, eastBtn, westBtn, centerBtn; //Ŭ������ �ʵ�� �ʱⰪ null
	
	public void init() { //init() �ʱ�ȭ �޼ҵ�
		//��ư ���� - ũ�Ⱑ �������� ����
		northBtn = new JButton("����");
		southBtn = new JButton("����");
		eastBtn = new JButton("����");
		westBtn = new JButton("����");
		centerBtn = new JButton(new ImageIcon("��.gif")); //�̹��� ������ src�� �����ϸ� �ȵ�
		
		//��ġ
		add("North", northBtn);
		add("South", southBtn);
		add("East", eastBtn);
		add("West", westBtn);
		add("Center", centerBtn);
		
		setBounds(900,200,300,400);
		setVisible(true); //ȣ��
	}

	public static void main(String[] args) {
		new SwingMain().init(); //1ȸ��, SwingMainŬ���� ����, ������, init() ȣ��
	}
}