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
	
	public Login() { //�޼ҵ�
		this.setLayout(null); //Frame ���̾ƿ� ��Ʈ��
		
		//����
		idL = new JLabel("���̵�");
		pwdL = new JLabel("��й�ȣ");
		
		idT = new JTextField();
		pwdT = new JPasswordField();
		
		loginBtn = new JButton("�α���");
		resetBtn = new JButton("�ٽ��ۼ�");
		
		//��ġ
		//idL.setLocation(20,20);
		//idL.setSize(100,40);
		idL.setBounds(20,20,100,40);
		pwdL.setBounds(20,70,100,40);
		
		idT.setBounds(110,20,200,40);
		pwdT.setBounds(110,70,200,40);
		
		loginBtn.setBounds(70,130,90,50);
		resetBtn.setBounds(170,130,90,50);
		
		this.add(idL); //this ��������
		add(pwdL);
		
		add(idT);
		add(pwdT);
		
		add(loginBtn);
		add(resetBtn);
		
		setBounds(700, 100, 350, 250);
		setVisible(true); //â ���̱�
		
		//�̺�Ʈ
		resetBtn.addActionListener(this); //resetBtn���� ActionListener �̺�Ʈ �߻�, this�� ����
		loginBtn.addActionListener(this);
		this.addWindowListener(this); //Frameâ���� WindowListener �̺�Ʈ �߻�, this�� ����	
	}//Login()

	//ActionListener Override - call back �޼ҵ�, JVM�� ȣ���ϴ� �޼ҵ�
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==resetBtn) { //�̺�Ʈ �ҽ��� ������ �� resetBtn �´���
			idT.setText(""); //������ idT �ʱ�ȭ
			pwdT.setText(""); //setText�� ���� �ִ� ��
		}else if(e.getSource()==loginBtn) { //�̺�Ʈ �ҽ��� ������ �� loginBtn �´���
			String id = idT.getText(); //������ String id�� idT���� �־��
			String pwd = pwdT.getText(); //getText�� ���� �������� ��
			System.out.println(id+", "+pwd); //üũ
			
			LoginResult result = new LoginResult(id, pwd);
			//LoginResult Ŭ���� �����ϰ�, ������ ������ �� id, pwd �� �Բ� ����
		}
	}

	//WindowListener Override - call back �޼ҵ�, JVM�� ȣ���ϴ� �޼ҵ�
	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("���α׷� ����");
		System.exit(0); //��� ���α׷� ���� ����
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
