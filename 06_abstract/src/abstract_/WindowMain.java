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
	
	
	public WindowMain() { //기본생성자
		super("이미지"); //setTitle("이미지"); //창의 제목
		
		//버튼 생성
		newBtn = new Button("초기화");
		leftBtn = new Button("왼쪽");
		upBtn = new Button("위");
		downBtn = new Button("아래");
		rightBtn = new Button("오른쪽");
		
		//패널 생성
		Panel p = new Panel();
		p.setLayout(new GridLayout(1,5,5,5));
		p.add(newBtn);
		p.add(leftBtn);
		p.add(upBtn);
		p.add(downBtn);
		p.add(rightBtn);
		
		add("North", p);		
		
		setBounds(900,200,400,400); //창의 크기 400,400
		setVisible(true); //창을 띄우세요 //false면 창을 닫으세요(다음창으로 넘어가며 더이상 안쓰는 창을 닫을 때)
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawString("카카오 이미지",50,80); //창의 50,80에 "카카오 이미지" 글자를 출력
		
		Toolkit t = Toolkit.getDefaultToolkit(); //클래스 생성
		Image img = t.getImage("study.gif"); //이미지 불러오기
		//g.drawImage(img,30,120,this); //이미지 그리기 (이미지 객체, x좌표, y좌표, 어디다?)
		
		//이미지 크기 조절 (이미지 객체, 화면 크기 좌표, 이미지 크기 좌표, 어디다?)
		g.drawImage(img,30,120,200,300,
					0,0,426,332,this); 

		//이미지 거꾸로 (이미지크기좌표의 시작점과 끝점을 바꾸면 뒤집힘)
		g.drawImage(img,30,120,200,300,
					426,332,0,0,this);
	}
	
	public static void main(String[] args) {
		new WindowMain();
	}
}
