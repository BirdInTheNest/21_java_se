package inheritance;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;

//Frame은 BorderLayout(동서남북으로 배치됨) - 동서남북에는 1개의 버튼만 넣을 수 있다
public class AwtMain2 extends Frame {
	private Button newBtn, exitBtn; //계속 써야하기 때문에 필드로 선언
	
	public void init() {
		//버튼 생성
		newBtn = new Button("새로만들기");
		exitBtn = new Button("종료");
		
		//Panel은 FlowLayout(가운데를 중심으로 순서대로 배치됨)
		//패널 생성
		Panel p = new Panel(); //한번만 쓰면 되기 때문에 지역변수로 선언
		p.setLayout(new GridLayout(1,2,10,0)); //균등, 행열 배치 (행수, 열수, 수평 공백, 수직 공백)
		p.setBackground(new Color(150,100,150));
		p.add(newBtn); //Frame(창)위에 Panel(쟁반)위에 Button(버튼)
		p.add(exitBtn);
		
		add("North", p); //Frame 북쪽에 패널 위치시켜라
	
		setTitle("창");
		setBounds(900,200,300,400); //창 크기 설정
		setVisible(true); //호출
	}
	
	public static void main(String[] args) {
		new AwtMain2().init();
	}
}