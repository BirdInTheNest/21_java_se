package inheritance;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame; //확장패키지 javax

public class SwingMain extends JFrame {
	private JButton northBtn, southBtn, eastBtn, westBtn, centerBtn; //클래스형 필드는 초기값 null
	
	public void init() { //init() 초기화 메소드
		//버튼 생성 - 크기가 정해지지 않음
		northBtn = new JButton("북쪽");
		southBtn = new JButton("남쪽");
		eastBtn = new JButton("동쪽");
		westBtn = new JButton("서쪽");
		centerBtn = new JButton(new ImageIcon("게.gif")); //이미지 파일은 src에 저장하면 안됨
		
		//배치
		add("North", northBtn);
		add("South", southBtn);
		add("East", eastBtn);
		add("West", westBtn);
		add("Center", centerBtn);
		
		setBounds(900,200,300,400);
		setVisible(true); //호출
	}

	public static void main(String[] args) {
		new SwingMain().init(); //1회성, SwingMain클래스 생성, 생성자, init() 호출
	}
}