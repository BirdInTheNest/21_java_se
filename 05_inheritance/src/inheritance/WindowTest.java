package inheritance;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;

public class WindowTest extends Frame { 
	
	public WindowTest() { //�⺻������ ��
		super("���� ���� �׸���"); //�θ������ ȣ��(Frame(String title)), ������ �޼ҵ� �ȿ��� �ٸ� �����ڸ� ȣ���� �� ����
		//setTitle("���� ���� �׸���");
		
		setFont(new Font("����ü", Font.BOLD, 32)); //���ڿ�,��Ÿ��,������
		
		//�������� ���, ���ڻ��� ������ �⺻
		setBackground(new Color(71,199,135)); //ColorŬ������ �����ڸ� 1ȸ ȣ���Ͽ� RGB ���� �Է�	
		setForeground(Color.YELLOW);
		
		//setSize(300,400);	//�ʺ�,����
		setBounds(900,200,300,400);	//x��ǥ,y��ǥ,�ʺ�,����
		setVisible(true); //�� ȣ�� - Frame â�� ȭ�鿡 �� �� �ڵ����� paint�� ��(�ݹ� �޼ҵ�)

		//SystemŬ������ �ܼ�â�� ����, System.in(Ű���� �Է�), System.out(ȭ�� ���)
		System.out.println("������"); //�ܼ�â�� ���� ��µ�
	}
	
	//Frame â�� ����ϰ� ������ paint() �޼ҵ� ���
	//paint() �޼ҵ��, setVisible(true);�� �� JVM(�ڹٰ���ӽ�)�� ȣ���ϴ� �ݹ� �޼ҵ���
	@Override
	public void paint(Graphics g) { //���� ��
		g.drawString("����",100,80); //���ڿ�,x��ǥ,y��ǥ
		g.drawLine(100,100,200,200); //x1��ǥ,y1��ǥ,x2��ǥ,y2��ǥ
		g.drawRect(150, 250, 120, 80); //x��ǥ,y��ǥ,�ʺ�,����
		g.drawOval(200,100,50,50); //x��ǥ,y��ǥ,�ʺ�,���� - �������� �׸�
		g.fillOval(50, 250, 80, 80); //x��ǥ,y��ǥ,�ʺ�,���� - ������ �׸��� ��ä���
	}
	
	public static void main(String[] args) {
		//WindowTest wt = new WindowTest(); //Ŭ������ new�� �� ������ �ڵ�ȣ��
		new WindowTest(); //Ŭ������ ��ü�� �������� �ʰ� 1ȸ������ ������ ȣ�� ��
	}
}

/*
java.lang.Object
	java.awt.Component
		java.awt.Container
			java.awt.Window			
				java.awt.Frame		
					WindowTest
---------------------------------------------
java.lang.Object
	java.awt.Color - static�� �����Ƿ� new�� �ʿ� ����
	java.awt.Graphics
---------------------------------------------



���� �߰� - buffer.append ���, string����ϸ� �ȵ�

ù���ڰ� �빮�ڸ� Ŭ������
Ŭ������ ���� : �ʵ�
---------------------------------------------
���� 3��� - R(0~255) G(0~255) B(0~255)
���� ���� �������� ����� ��
255,255,255 - ���
0,0,0 - ������

�׸��� - �� ���� - RGB �� �� ����
*/