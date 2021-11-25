package inheritance;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

//Frame�� BorderLayout(������������ ��ġ��) - �������Ͽ��� 1���� ��ư�� ���� �� �ִ�
public class AwtMain2 extends Frame {
	private Button newBtn, exitBtn; //��� ����ϱ� ������ �ʵ�� ����
	
	public void init() {
		//��ư ����
		newBtn = new Button("���θ����");
		exitBtn = new Button("����");
		
		//Panel�� FlowLayout(����� �߽����� ������� ��ġ��)
		//�г� ����
		Panel p = new Panel(); //�ѹ��� ���� �Ǳ� ������ ���������� ����
		p.setLayout(new GridLayout(1,2,10,0)); //�յ�, �࿭ ��ġ (���, ����, ���� ����, ���� ����)
		p.setBackground(new Color(150,100,150));
		p.add(newBtn); //Frame(â)���� Panel(���)���� Button(��ư)
		p.add(exitBtn);
		
		add("North", p); //Frame ���ʿ� �г� ��ġ���Ѷ�
	
		setTitle("â");
		setBounds(900,200,300,400); //â ũ�� ����
		setVisible(true); //ȣ��
	}
	
	public static void main(String[] args) {
		new AwtMain2().init();
	}
}