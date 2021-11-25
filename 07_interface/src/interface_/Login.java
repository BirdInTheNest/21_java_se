package interface_;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener, WindowListener {
	private JLabel idL, pwdL;
	private JTextField idT;
	private JPasswordField pwdT;
	private JButton loginBtn, resetBtn;
	
	public Login() { //메소드
		this.setLayout(null); //Frame 레이아웃 깨트림
		
		//생성
		idL = new JLabel("아이디");
		pwdL = new JLabel("비밀번호");
		
		idT = new JTextField();
		pwdT = new JPasswordField();
		
		loginBtn = new JButton("로그인");
		resetBtn = new JButton("다시작성");
		
		//배치
		//idL.setLocation(20,20);
		//idL.setSize(100,40);
		idL.setBounds(20,20,100,40);
		pwdL.setBounds(20,70,100,40);
		
		idT.setBounds(110,20,200,40);
		pwdT.setBounds(110,70,200,40);
		
		loginBtn.setBounds(70,130,90,50);
		resetBtn.setBounds(170,130,90,50);
		
		this.add(idL); //this 생략가능
		add(pwdL);
		
		add(idT);
		add(pwdT);
		
		add(loginBtn);
		add(resetBtn);
		
		setBounds(700, 100, 350, 250);
		setVisible(true); //창 보이기
		
		//이벤트
		resetBtn.addActionListener(this); //resetBtn에서 ActionListener 이벤트 발생, this에 구현
		loginBtn.addActionListener(this);
		this.addWindowListener(this); //Frame창에서 WindowListener 이벤트 발생, this에 구현	
	}//Login()

	//ActionListener Override - call back 메소드, JVM이 호출하는 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==resetBtn) { //이벤트 소스를 가져온 게 resetBtn 맞는지
			idT.setText(""); //맞으면 idT 초기화
			pwdT.setText(""); //setText는 값을 주는 거
		}else if(e.getSource()==loginBtn) { //이벤트 소스를 가져온 게 loginBtn 맞는지
			String id = idT.getText(); //맞으면 String id에 idT값을 주어라
			String pwd = pwdT.getText(); //getText는 값을 가져오는 거
			System.out.println(id+", "+pwd); //체크
			
			LoginResult result = new LoginResult(id, pwd);
			//LoginResult 클래스 생성하고, 생성자 실행할 때 id, pwd 값 함께 전달
		}
	}

	//WindowListener Override - call back 메소드, JVM이 호출하는 메소드
	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("프로그램 종료");
		System.exit(0); //모든 프로그램 강제 종료
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

	public static void main(String[] args) {
		new Login();
	}
}
