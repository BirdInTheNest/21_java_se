package thread;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Packman extends JFrame implements Runnable { //�����尡 �ǰ� �ʹ�
	private Image img, foodImg;
	private int select=2;
	private int x=225, y=225, mx, my;
	private int[] foodX, foodY;
	
	public Packman() { //������
		//Toolkit Ŭ���� �޼ҵ�� ����, �̹��� �ҷ�����
		img = Toolkit.getDefaultToolkit().getImage("image/packman.png"); 
		foodImg = Toolkit.getDefaultToolkit().getImage("image/cherry.gif");
		
		//����
		foodX = new int[5];
		foodY = new int[5];
		
		for(int i=0; i<foodX.length; i++) {
			foodX[i] = (int)(Math.random()*461)+20; //20~480 ���� �߻�
			foodY[i] = (int)(Math.random()*461)+20; //20~480 ���� �߻�
		}
		
		setBounds(900,200,500,500);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//�̺�Ʈ
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ESCAPE) {
					System.exit(0); 
					
				}else if(e.getKeyCode()==KeyEvent.VK_LEFT) {
					select=0; //0,0,50,50	select*50,0,select*50+50,50
					mx=-10; my=0;
					 
				}else if(e.getKeyCode()==KeyEvent.VK_UP) {
					select=4; //200,0,250,50
					mx=0; my=-10;
					
				}else if(e.getKeyCode()==KeyEvent.VK_DOWN) {
					select=6; //300,0,350,50
					mx=0; my=10;
					
				}else if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
					select=2; //100,0,150,50
					mx=10; my=0;
				}
			}
		});
		
		Thread t = new Thread(this); //������ ���� - ���� ������� ������ּ���
		t.start(); //������ ���� - ������ ����(run())
	} //Packman()

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//System.out.println(x+" , "+y);
		//�̹��� ũ�� ���� (�̹��� ��ü, ȭ�� ũ�� ��ǥ, �̹��� ũ�� ��ǥ, ����?)		
		g.drawImage(img, 
					x, y, x+50, y+50, 
					select*50, 0, select*50+50, 50, 
					this); 

		//����
		for(int i=0; i<foodX.length; i++) {
			g.drawImage(foodImg, foodX[i], foodY[i], this);			
		}
	}

	@Override
	public void run() { //Ű���带 ���� �� �׸��� �׸��� �� �ƴ϶� �ϰ� �˾Ƽ� ��� �׸��� �׷���
		while(true) {
			repaint();
			
			if(select%2==0) select++; //select�� ¦�����̸� Ȧ�������� ���� ���� �ٹ��� �ϰ�
			else select--; //select�� Ȧ���� ¦�������� ���� ���� ������ �ϰ�
			
			//��ǥ �̵�
			x = x + mx;
			y = y + my;
			
			if(x>500) x=0;
			else if(x<0) x=500;
			else if(y>500) y=0;
			else if(y<0) y=500;
			
			try { 
				Thread.sleep(100); //���� : 1/1000��  0.1�� �����
			} catch (InterruptedException e) {
				e.printStackTrace();
			} //@Override �޼ҵ�� throws�� ����ó�� �Ұ���
			
			//���� ����
			for(int i=0; i<foodX.length; i++) {
				if(x+25 >= foodX[i]-10 && y+25 >= foodY[i]-10 
					&& x+25 <= foodX[i]+30 && y+25 <= foodY[i]+30) 
					foodX[i] = foodY[i] = -20;
//				System.out.println(foodX[i]+" , "+foodY[i]);
			}//for	
//			System.out.println("-------------------");
		}//while
	}
	
	public static void main(String[] args) {
		new Packman();
	}
}

























