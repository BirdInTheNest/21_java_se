package inheritance;

import java.awt.Button;
import java.awt.Frame;

public class AwtMain3 extends Frame {
	private Button newBtn, exitBtn;
	
	public void init() { //초기화 메소드
		//버튼 생성
		newBtn = new Button("새로만들기");
		exitBtn = new Button("종료");
		
		setLayout(null); //Frame의 기본 레이아웃인 BorderLayout 깨트림
		newBtn.setBounds(100,100,120,50); //버튼 위치 지정 (x값, y값, 너비, 높이)
		exitBtn.setBounds(100,160,120,50);
		
		//버튼 배치
		add(newBtn);
		add(exitBtn);
		
		setTitle("창");
		setBounds(900,200,300,400);
		setVisible(true); //호출
	}

	public static void main(String[] args) {
		new AwtMain3().init();
	}
}

/*
계산기 틀 만들기

1. Panel + GridLayout : 패널 7개
or
2. setLayout(null) + 일일이 위치 지정

private Button[] btn : 배열의 크기는 18개로 잡고 for문을 사용하여 생성한다

private Label dispL : 라벨 2개, Label에 바탕색을 입힌다
			  inputL (오른쪽에 0을 표시하시오)			  
*/