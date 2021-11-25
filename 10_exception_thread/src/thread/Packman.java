package thread;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Packman extends JFrame implements Runnable { //스레드가 되고 싶다
	private Image img, foodImg;
	private int select=2;
	private int x=225, y=225, mx, my;
	private int[] foodX, foodY;
	
	public Packman() { //생성자
		//Toolkit 클래스 메소드로 생성, 이미지 불러오기
		img = Toolkit.getDefaultToolkit().getImage("image/packman.png"); 
		foodImg = Toolkit.getDefaultToolkit().getImage("image/cherry.gif");
		
		//먹이
		foodX = new int[5];
		foodY = new int[5];
		
		for(int i=0; i<foodX.length; i++) {
			foodX[i] = (int)(Math.random()*461)+20; //20~480 난수 발생
			foodY[i] = (int)(Math.random()*461)+20; //20~480 난수 발생
		}
		
		setBounds(900,200,500,500);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//이벤트
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
		
		Thread t = new Thread(this); //스레드 생성 - 나를 스레드롬 만들어주세요
		t.start(); //스레드 시작 - 스레드 실행(run())
	} //Packman()

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		//System.out.println(x+" , "+y);
		//이미지 크기 조절 (이미지 객체, 화면 크기 좌표, 이미지 크기 좌표, 어디다?)		
		g.drawImage(img, 
					x, y, x+50, y+50, 
					select*50, 0, select*50+50, 50, 
					this); 

		//먹이
		for(int i=0; i<foodX.length; i++) {
			g.drawImage(foodImg, foodX[i], foodY[i], this);			
		}
	}

	@Override
	public void run() { //키보드를 누를 때 그림을 그리는 게 아니라 니가 알아서 계속 그림을 그려라
		while(true) {
			repaint();
			
			if(select%2==0) select++; //select가 짝수값이면 홀수값으로 만들어서 입을 다물게 하고
			else select--; //select가 홀수면 짝수값으로 만들어서 입을 벌리게 하고
			
			//좌표 이동
			x = x + mx;
			y = y + my;
			
			if(x>500) x=0;
			else if(x<0) x=500;
			else if(y>500) y=0;
			else if(y<0) y=500;
			
			try { 
				Thread.sleep(100); //단위 : 1/1000초  0.1초 쉬어라
			} catch (InterruptedException e) {
				e.printStackTrace();
			} //@Override 메소드는 throws로 예외처리 불가능
			
			//먹이 먹자
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

























