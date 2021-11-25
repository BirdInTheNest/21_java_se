package abstract_;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

public class WindowMain extends Frame {
	private Button newBtn, leftBtn, upBtn, downBtn, rightBtn;
	
	
	public WindowMain() { //�⺻������
		super("�̹���"); //setTitle("�̹���"); //â�� ����
		
		//��ư ����
		newBtn = new Button("�ʱ�ȭ");
		leftBtn = new Button("����");
		upBtn = new Button("��");
		downBtn = new Button("�Ʒ�");
		rightBtn = new Button("������");
		
		//�г� ����
		Panel p = new Panel();
		p.setLayout(new GridLayout(1,5,5,5));
		p.add(newBtn);
		p.add(leftBtn);
		p.add(upBtn);
		p.add(downBtn);
		p.add(rightBtn);
		
		add("North", p);		
		
		setBounds(900,200,400,400); //â�� ũ�� 400,400
		setVisible(true); //â�� ��켼�� //false�� â�� ��������(����â���� �Ѿ�� ���̻� �Ⱦ��� â�� ���� ��)
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawString("īī�� �̹���",50,80); //â�� 50,80�� "īī�� �̹���" ���ڸ� ���
		
		Toolkit t = Toolkit.getDefaultToolkit(); //Ŭ���� ����
		Image img = t.getImage("study.gif"); //�̹��� �ҷ�����
		//g.drawImage(img,30,120,this); //�̹��� �׸��� (�̹��� ��ü, x��ǥ, y��ǥ, ����?)
		
		//�̹��� ũ�� ���� (�̹��� ��ü, ȭ�� ũ�� ��ǥ, �̹��� ũ�� ��ǥ, ����?)
		g.drawImage(img,30,120,200,300,
					0,0,426,332,this); 

		//�̹��� �Ųٷ� (�̹���ũ����ǥ�� �������� ������ �ٲٸ� ������)
		g.drawImage(img,30,120,200,300,
					426,332,0,0,this);
	}
	
	public static void main(String[] args) {
		new WindowMain();
	}
}
