package thread;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

//�� 1����
public class Racer extends Canvas implements Runnable {
	private Image img;
	private String horseName;
	private int pos=0;
	private static int rank=0; //�� 1�� �����ǰ� ��� ��ü�� �����ϴ� �������� ����
//	static���� ���� ������ new�� ������ �����ǹǷ� Racer Ŭ�������� rank ������ �־� ����� ���� �� ����
	
	public Racer(String horseName) { //������
		img = Toolkit.getDefaultToolkit().getImage("image/��.gif");
		this.horseName = horseName;
	}//Racer()
	
	@Override
	public void paint(Graphics g) {
		super.paint(g); //�θ� ��� �θ��� ����ȭ��Ű�� ȿ�� ����
		//�̹��� ��ü, x y��ǥ, �̹��� �ʺ� ����, ����?
		g.drawImage(img, pos, 0,  25, this.getSize().height,  this);
		//�� ������ x y ��ǥ, ���� x y ��ǥ
		g.drawLine(0, this.getSize().height-1, this.getSize().width, this.getSize().height-1);
//		System.out.println(horseName+", "+pos);
	}

	@Override
	public void run() {		
		for(int i=0; i<600; i+=((int)(Math.random()*10)+1)) {
			pos = i; //�������� �߻��� i��ŭ x��ǥ �̵�
			repaint();
			
			try {
				Thread.sleep(100); //0.1�� �����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//for
		
		rank++;
		
		//����� �� �̸� ���
		System.out.println(rank+"�� "+horseName);
		
	}//run()
}

//		long beforeTime = System.currentTimeMillis(); //�ڵ� ���� ���� �ð� �޾ƿ���

//		long afterTime = System.currentTimeMillis(); // �ڵ� ���� �Ŀ� �ð� �޾ƿ���
//		long secDiffTime = (afterTime - beforeTime)/1000; //�� �ð� �� ���
//		System.out.println("�ð�����(m) : "+secDiffTime);