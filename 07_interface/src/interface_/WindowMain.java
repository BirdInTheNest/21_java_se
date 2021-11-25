package interface_;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//Fame�� BorderLayout(��������) - �������� �� �������� 1���� Button�� �ø� �� �ִ�
class WindowTest extends Frame implements ActionListener, MouseListener { //import�ϰ� add unimplemented methods
	private Button newBtn, exitBtn;
	private TextArea area;
	
	public void init() {
		newBtn = new Button("���θ����");
		exitBtn = new Button("����");
		area = new TextArea(); //TextArea(�����Ӱ� Text�ۼ� ����), TextField(���ٸ� Text�ۼ� ����)
		
		Panel p = new Panel(); //Panel�� FlowLayout (�߾��� �������� ���� ��ġ)
		p.add(newBtn); //p�� newBtn�� ���϶�
		p.add(exitBtn);
		
		this.add("North", p); //���� ���ʿ� p�� ���϶�
		this.add("Center", area);
		
		this.setBounds(900,100,300,400); //â ũ�� 300,400
		setVisible(true); //this ��������
		
		//�̺�Ʈ: ���� ��� ���� Override������ JVM �ʴ� ��ǿ� �°� ȣ���ض�
		this.addWindowListener(new WindowExit()); //Frameâ���� �̺�Ʈ �߻�, WindowListener ȣ��, WindowExit()���� ����
		this.addMouseListener(this); 
		newBtn.addActionListener(this); //newBtn���� �̺�Ʈ �߻�, ActionListenerȣ��, ������ ���� ����
		exitBtn.addActionListener(this);
	}//init()

	//MouseListener Override - call back �޼ҵ�, JVM�� ȣ���ϴ� �޼ҵ�
	@Override
	public void mouseClicked(MouseEvent e) {
			System.out.println("���콺 Ŭ��");			
		}

	@Override
	public void mousePressed(MouseEvent e) {}


	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("���콺 IN");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("���콺 OUT");
	}

	//ActionListener Override - call back �޼ҵ�, JVM�� ȣ���ϴ� �޼ҵ�
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==newBtn) { //�̺�Ʈ���� �ҽ��� ������ �� ��ü newBtn�� �´���
			area.setText(""); //�ʱ�ȭ
			//area.setText(" "); ���� �ʱ�ȭ�� �ȵǸ� " "�������� ��� ��
		}else if(e.getActionCommand()=="����") { //�̺�Ʈ�� ����� ������ �� Ÿ��Ʋ�� ������ �ְ� �´���
			System.exit(0); //���α׷� ���� ����
		}
	}
}
//---------------------------------
public class WindowMain {

	public static void main(String[] args) {
		new WindowTest().init(); //Ŭ���� �����, ������ ȣ���ϰ�, init()ó���϶�
	}
}

/*
�� Event(�̺�Ʈ)
1. Event Source			//����? ���?
2. Event Listener		//MouseListener, KeyListener, WindowListener, ActionListener 
3. Event Handler(������)

[����] EventSource.addEventListener(EventHandler�� ��ġ)
-------------------------------------------------------------------------
* Component(����)
Button, TextArea(�����Ӱ�), TextField(���پ�), Panel(Frameó�� ���� �ʱ� ������ ������. �ܵ����� ������ ����)

* Container(������ ��Ƶδ� ��������)
Frame/JFrame, Dialog
*/
