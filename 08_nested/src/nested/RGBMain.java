package nested;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RGBMain extends Frame {
	private Button redBtn, greenBtn, blueBtn;
	private DrCanvas can;
	//바깥쪽 클래스는 안쪽 클래스 멤버에 접근 불가능하므로 안쪽 클래스로 객체 선언하여 안쪽 클래스 멤버에 접근
	
	public RGBMain() { //생성자
		redBtn = new Button("빨강"); //버튼 생성
		greenBtn = new Button("초록");
		blueBtn = new Button("파랑");
		
		can = new DrCanvas(); //캔버스 생성
		
		Panel p = new Panel(); //패널 생성
		p.add(redBtn);
		p.add(greenBtn);
		p.add(blueBtn);
		
		this.add("North", p);
		this.add("Center", can);		
		
		setBounds(900,150,300,400);
		setVisible(true);
		
		//이벤트
		//WindowAdapter는 추상클래스라서 절대 new 할 수 없다, 흑기사 {}가 붙음
		//WindowAdapter는 추상메소드가 1도 없다 (반드시 Override 해야 할 메소드 없음, 빈 body)
		//원하는 부분 {}안에 Override해서 써라
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { //메소드의 첫글자는 소문자
				System.exit(0);
			} 
		});	
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("마우스 클릭");
			}
		});
		
		//인터페이스는 new가 안되서 흑기사 {}붙고, {}안에 원하는 부분 Override 하면 됨
		redBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				can.setBackground(Color.RED);
			}
		}); //익명 Inner Class로 쓰면 한번 쓰고 버리는 1회용이 됨
		
		greenBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				can.setBackground(Color.GREEN);
			}
		});
		
		blueBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				can.setBackground(Color.BLUE);	
			}
		});	
		
	}//RGBMain()
	
	//Canvas는 new해서 하는 게 아니라 상속받아서 써야하지만 자바는 클래스 다중상속이 안되므로 중첩시킨다.
	class DrCanvas extends Canvas{ //DrCanvas 클래스는 Canvas 클래스 상속
		
		public DrCanvas() { //생성자
			this.setBackground(new Color(255,200,255));
		}	
	}
	
	public static void main(String[] args) {
		new RGBMain();
	}
}
