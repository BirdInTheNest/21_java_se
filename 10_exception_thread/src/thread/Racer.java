package thread;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

//말 1마리
public class Racer extends Canvas implements Runnable {
	private Image img;
	private String horseName;
	private int pos=0;
	private static int rank=0; //단 1번 생성되고 모든 객체가 공유하는 공유변수 선언
//	static으로 하지 않으면 new할 때마다 생성되므로 Racer 클래스마다 rank 변수가 있어 등수를 가릴 수 없음
	
	public Racer(String horseName) { //생성자
		img = Toolkit.getDefaultToolkit().getImage("image/말.gif");
		this.horseName = horseName;
	}//Racer()
	
	@Override
	public void paint(Graphics g) {
		super.paint(g); //부모를 계속 부르면 백지화시키는 효과 있음
		//이미지 객체, x y좌표, 이미지 너비 높이, 어디다?
		g.drawImage(img, pos, 0,  25, this.getSize().height,  this);
		//선 시작점 x y 좌표, 끝점 x y 좌표
		g.drawLine(0, this.getSize().height-1, this.getSize().width, this.getSize().height-1);
//		System.out.println(horseName+", "+pos);
	}

	@Override
	public void run() {		
		for(int i=0; i<600; i+=((int)(Math.random()*10)+1)) {
			pos = i; //랜덤으로 발생한 i만큼 x좌표 이동
			repaint();
			
			try {
				Thread.sleep(100); //0.1초 쉬어라
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}//for
		
		rank++;
		
		//등수와 말 이름 출력
		System.out.println(rank+"등 "+horseName);
		
	}//run()
}

//		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기

//		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
//		long secDiffTime = (afterTime - beforeTime)/1000; //두 시간 차 계산
//		System.out.println("시간차이(m) : "+secDiffTime);