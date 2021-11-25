package interface_;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class LoginResult extends JFrame implements WindowListener {
	private String id, pwd;
	
	public LoginResult(String id, String pwd) { //생성자 실행하면서 Login클래스에서 id, pwd 값 전달받음
		this.id = id; //생성자 안의 값 id를 LoginResult 클래스의 필드 id에 전달
		this.pwd = pwd;
		
		setFont(new Font("돋움체", Font.BOLD, 20));
		this.setBounds(900,120,200,200);
		this.setVisible(true);
		
		//이벤트
		this.addWindowListener(this);
	}
	
	@Override
	public void paint(Graphics g) { //call back 메소드, JVM이 호출하는 메소드
		super.paint(g); //창의 투과 방지

		if(id.equals("hong") && pwd.equals("1111")) { //문자열이기 때문에 equals 사용
			g.setColor(Color.BLUE);
			g.drawString("로그인 성공", 35, 100);
		}else {
			g.setColor(Color.RED);
			g.drawString("로그인 실패", 35, 100);
		}
	}
	
	//WindowListener Override - call back 메소드, JVM이 호출하는 메소드
	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		setVisible(false); //창 사라지기
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
