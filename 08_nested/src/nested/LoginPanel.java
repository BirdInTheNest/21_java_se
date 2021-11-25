package nested;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class LoginPanel extends Panel {
	private Label idL, pwdL;
	private TextField idT, pwdT;
	private Button loginBtn, resetBtn;

	public LoginPanel() {
		this.setBackground(Color.PINK);
		setLayout(null);
		
		//����
		idL = new Label("���̵�");
		pwdL = new Label("��й�ȣ");
		
		idT = new TextField();
		pwdT = new TextField();
		
		loginBtn = new Button("�α���");
		resetBtn = new Button("�ٽ� �ۼ�");
		
		//�۲� ũ�� ����
		Font labelF = new Font("�������", 1, 15);
		Font textF = new Font("�������", 1, 25);
		
		idL.setFont(labelF);
		idT.setFont(textF);
        pwdL.setFont(labelF);
        pwdT.setFont(textF);
        loginBtn.setFont(labelF);
        resetBtn.setFont(labelF);
		
		//��ġ	
		idL.setBounds(20,120,70,30);
		idT.setBounds(20,150,450,50);

		pwdL.setBounds(20,210,70,30);
		pwdT.setBounds(20,240,450,50);
		
		loginBtn.setBounds(20,350,220,50);
		resetBtn.setBounds(250,350,220,50);

		this.add(idL);
		this.add(idT);
		this.add(pwdL);
		this.add(pwdT);
		this.add(loginBtn);
		this.add(resetBtn);
		
		//�̺�Ʈ - �͸� Inner Class {} ���
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//������ �������� - �α����� �����Ͱ� 2���ۿ� ��� dto�� ������ ���� �ʿ� ����
				String id = idT.getText();
				String pwd = pwdT.getText();
				
				//DB
				MemberDAO dao = new MemberDAO();
				String name = dao.loginMember(id, pwd); 
				//loginMember�� ������ id, pwd�� ������, ���ϰ��� String name�� �����Ѵ�
				
				if(name==null) {
					JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� Ʋ���ϴ�");
				}else {
					JOptionPane.showMessageDialog(null, name+"�� �α��� �Ǿ����ϴ�");
				} //Dialog�� �ܵ����� �� �� �ִ�. setFont�����ϸ� �۾� ũ�� �� �� �ִ�	
			}
		});
		
		resetBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				idT.setText("");
				pwdT.setText("");
			}
		});
	}
}
/* DB���� select�ϸ� �����Ͱ��� ��������.
���ڵ尡 ������ T ������ F�� �������� rs.next() �̿��Ͽ� 
boolean���� �α��μ���, �α��ν��� �߰� ó���� ���� �ִ�. */