/*
CardLayout() ���� Ȩ, ȸ������, �α��� Panel
- Ȩ : �ȳ��ϼ��� (Ȩȭ���� �̹����� �� �ƹ��ų� �־ ��)
- ȸ������ : ȸ������ Panel (ȸ������ â: �̸�, ���̵�, ��й�ȣ ��� �ٽ��ۼ� - DB Insert)
- �α��� : �α��� Panel (�α��� â: DB �˻��ؼ� ������ �α��� ���� - DB Select)
(â�� �ٲ��� �ʴ´�.)

- swing�ƴϰ� awt�� �����
  ��й�ȣ�� awt�� ����� ... ó�� ������� �� �ٲ۴�. 
  ��й�ȣ �� �����ϱ�

- �α��� ����, �α��� ���б��� �߰��϶�.
  �α��� ����/���� �� �� â�� �߰� �ϰų� 
  �α��� Panel �ϴܺο� text�� �߰� �ص� �ȴ�. (�α��� ���� ��â�̳� �󺧷� frame�� �߸� ��)

- ȸ������ insert �α��� select

- DB�� ����, ����� ������ DB�� ���� �Ѵ�.

# ���̺� �ۼ�
create table member(
name  varchar2(15)  not  null,
id   varchar2(15), 
pwd   number
);
 */

package nested;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//Frame�� BorderLayout(��������) �� ���⺰�� 1���� Component(����)�ۿ� �� �ö󰣴�
public class MemberMain extends Frame implements ActionListener {
	private Button homeBtn, writeBtn, loginBtn;	
	private CardLayout card;
	private Panel cardP;
	
	public MemberMain() { //������
		homeBtn = new Button("Ȩ"); //��ư ����
		writeBtn = new Button("ȸ������");
		loginBtn = new Button("�α���");
		
		card = new CardLayout(); //ī�� ���̾ƿ� ����
		
		//3���� ��ư�� ���� �г�
		Panel buttonP = new Panel(); //Panel�� FlowLayout(������ġ)
		buttonP.setBackground(new Color(45,180,0));
		buttonP.add(homeBtn);
		buttonP.add(writeBtn);
		buttonP.add(loginBtn);
		
		//ī�巹�̾ƿ����� ������ �г�. home, write, login �гη� ��� �ٲ�
		cardP = new Panel();
		cardP.setLayout(card);
		cardP.add("home", new HomePanel()); //add(String name, Component comp)
		cardP.add("write", new WritePanel());
		cardP.add("login", new LoginPanel());

		this.add("North", buttonP);
		this.add("Center", cardP);
		
		this.setBounds(700, 100, 500, 500);
		this.setResizable(false);
		this.setVisible(true);
		
		//��ư �̺�Ʈ
		homeBtn.addActionListener(this);
		writeBtn.addActionListener(this);
		loginBtn.addActionListener(this);

		//�̺�Ʈ - �͸� Inner Class {} ��� 
		//���⼭ WindowListener �̺�Ʈ �߻�, WindowAdapter()�� ������
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0); //���α׷� ����
			}
		});
	}//MemberMain()

	@Override //implements ActionListener�ϰ� �߻�޼ҵ� Override��
	public void actionPerformed(ActionEvent e) { 
		if(e.getSource()==homeBtn) {
			card.show(cardP, "home"); 
			//cardP�� ������ �ȿ��� �����߱� ������ ������ �ۿ��� ��. �ʵ忡 �����ؾ���
		}else if(e.getSource()==writeBtn) {
			card.show(cardP, "write");
		}else if(e.getSource()==loginBtn) {
			card.show(cardP, "login");
		}	
	}//actionPerformed
	
	public static void main(String[] args) {
		new MemberMain();
	}//main()

}

/*
Component(����) - ����, ����
Button, TextField, TextArea, Panel(Component�� �����ִ� Layer���Ҹ� ��)


Container(��������) - ����
Frame, Dialog
--------------------------------------------------------------------
�������̽� WindowListener�� Override�� �߻�޼ҵ尡 ���Ƽ�, Override ��� ���� Ŭ������
WindowAdapter�� ����Ͽ� �������̽� WindowListener�� �����Ѵ�. 

WindowAdapter�� �߻�Ŭ�����̱� ������ ���� new�� �� ����. 
���� WindowAdapter�� Override�� �߻�޼ҵ尡 ���� ��� �޼ҵ尡 �� body�̸� ����� ����.

WindowListener - WindowAdapter
MouseListener - MouseAdapter
*/