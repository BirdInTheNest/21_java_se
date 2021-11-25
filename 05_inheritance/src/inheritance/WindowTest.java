package inheritance;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;

public class WindowTest extends Frame { 
	
	public WindowTest() { //기본생성자 ②
		super("내가 만든 그림판"); //부모생성자 호출(Frame(String title)), 생성자 메소드 안에서 다른 생성자를 호출할 수 있음
		//setTitle("내가 만든 그림판");
		
		setFont(new Font("바탕체", Font.BOLD, 32)); //문자열,스타일,사이즈
		
		//바탕색은 흰색, 글자색은 검정이 기본
		setBackground(new Color(71,199,135)); //Color클래스의 생성자를 1회 호출하여 RGB 숫자 입력	
		setForeground(Color.YELLOW);
		
		//setSize(300,400);	//너비,높이
		setBounds(900,200,300,400);	//x좌표,y좌표,너비,높이
		setVisible(true); //③ 호출 - Frame 창이 화면에 뜰 때 자동으로 paint가 뜸(콜백 메소드)

		//System클래스는 콘솔창을 관리, System.in(키보드 입력), System.out(화면 출력)
		System.out.println("도형임"); //콘솔창에 도형 출력됨
	}
	
	//Frame 창에 출력하고 싶으면 paint() 메소드 사용
	//paint() 메소드는, setVisible(true);할 때 JVM(자바가상머신)이 호출하는 콜백 메소드임
	@Override
	public void paint(Graphics g) { //구현 ④
		g.drawString("도형",100,80); //문자열,x좌표,y좌표
		g.drawLine(100,100,200,200); //x1좌표,y1좌표,x2좌표,y2좌표
		g.drawRect(150, 250, 120, 80); //x좌표,y좌표,너비,높이
		g.drawOval(200,100,50,50); //x좌표,y좌표,너비,높이 - 내접원을 그림
		g.fillOval(50, 250, 80, 80); //x좌표,y좌표,너비,높이 - 내접원 그리고 색채우기
	}
	
	public static void main(String[] args) {
		//WindowTest wt = new WindowTest(); //클래스를 new할 때 생성자 자동호출
		new WindowTest(); //클래스를 객체에 저장하지 않고 1회성으로 생성자 호출 ①
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
	java.awt.Color - static이 있으므로 new할 필요 없음
	java.awt.Graphics
---------------------------------------------



계산기 추가 - buffer.append 사용, string사용하면 안됨

첫글자가 대문자면 클래스임
클래스의 변수 : 필드
---------------------------------------------
빛의 3요소 - R(0~255) G(0~255) B(0~255)
빛은 색을 섞을수록 흰색이 됨
255,255,255 - 흰색
0,0,0 - 검정색

그림판 - 색 편집 - RGB 볼 수 있음
*/