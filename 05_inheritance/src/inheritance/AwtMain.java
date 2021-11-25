package inheritance;

import java.awt.Button;
import java.awt.Frame;

//Frame은 BorderLayout(동서남북으로 배치 되어 있음) - 동서남북에는 1개의 버튼만 넣을 수 있다
public class AwtMain extends Frame {
	private Button northBtn, southBtn, eastBtn, westBtn, centerBtn; //클래스형 필드는 초기값 null 가짐
	
	public void init() { //init() 초기화 메소드
		//버튼 생성 - 크기가 정해지지 않음
		northBtn = new Button("북쪽");
		southBtn = new Button("남쪽");
		eastBtn = new Button("동쪽");
		westBtn = new Button("서쪽");
		centerBtn = new Button("중앙");
		
		//배치
		add("North", northBtn);
		add("South", southBtn);
		add("East", eastBtn);
		add("West", westBtn);
		add("Center", centerBtn);
		
		setBounds(900,200,300,400); //창 크기 설정
		setVisible(true); //호출
	}

	public static void main(String[] args) {
		//AwtMain am = new AwtMain();
		//am.init();
		new AwtMain().init(); //1회성, AwtMain클래스 생성하고, 생성자 메소드 호출하고, init() 부르고
	}
}

/*
★ Exception 예외처리

IOException
컴파일할 때 발생, 보험들어라

NullPointerException : null값만 갖고 있다. new안했으니 new해달라
실행할 때 발생, 개발자 코드 잘못
*/
