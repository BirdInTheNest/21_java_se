package interface_;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class LoginResult extends JFrame implements WindowListener {
	private String id, pwd;
	
	public LoginResult(String id, String pwd) { //������ �����ϸ鼭 LoginŬ�������� id, pwd �� ���޹���
		this.id = id; //������ ���� �� id�� LoginResult Ŭ������ �ʵ� id�� ����
		this.pwd = pwd;
		
		setFont(new Font("����ü", Font.BOLD, 20));
		this.setBounds(900,120,200,200);
		this.setVisible(true);
		
		//�̺�Ʈ
		this.addWindowListener(this);
	}
	
	@Override
	public void paint(Graphics g) { //call back �޼ҵ�, JVM�� ȣ���ϴ� �޼ҵ�
		super.paint(g); //â�� ���� ����

		if(id.equals("hong") && pwd.equals("1111")) { //���ڿ��̱� ������ equals ���
			g.setColor(Color.BLUE);
			g.drawString("�α��� ����", 35, 100);
		}else {
			g.setColor(Color.RED);
			g.drawString("�α��� ����", 35, 100);
		}
	}
	
	//WindowListener Override - call back �޼ҵ�, JVM�� ȣ���ϴ� �޼ҵ�
	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		setVisible(false); //â �������
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

}
