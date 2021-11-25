package interface_;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//Fame은 BorderLayout(동서남북) - 동서남북 각 방향으로 1개의 Button만 올릴 수 있다
class WindowTest extends Frame implements ActionListener, MouseListener { //import하고 add unimplemented methods
	private Button newBtn, exitBtn;
	private TextArea area;
	
	public void init() {
		newBtn = new Button("새로만들기");
		exitBtn = new Button("종료");
		area = new TextArea(); //TextArea(자유롭게 Text작성 가능), TextField(한줄만 Text작성 가능)
		
		Panel p = new Panel(); //Panel은 FlowLayout (중앙을 기준으로 순서 배치)
		p.add(newBtn); //p에 newBtn을 더하라
		p.add(exitBtn);
		
		this.add("North", p); //여기 북쪽에 p를 더하라
		this.add("Center", area);
		
		this.setBounds(900,100,300,400); //창 크기 300,400
		setVisible(true); //this 생략가능
		
		//이벤트: 내가 모든 것을 Override했으니 JVM 너는 사건에 맞게 호출해라
		this.addWindowListener(new WindowExit()); //Frame창에서 이벤트 발생, WindowListener 호출, WindowExit()에서 구현
		this.addMouseListener(this); 
		newBtn.addActionListener(this); //newBtn에서 이벤트 발생, ActionListener호출, 구현부 내가 가짐
		exitBtn.addActionListener(this);
	}//init()

	//MouseListener Override - call back 메소드, JVM이 호출하는 메소드
	@Override
	public void mouseClicked(MouseEvent e) {
			System.out.println("마우스 클릭");			
		}

	@Override
	public void mousePressed(MouseEvent e) {}


	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("마우스 IN");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("마우스 OUT");
	}

	//ActionListener Override - call back 메소드, JVM이 호출하는 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==newBtn) { //이벤트에서 소스를 가져온 게 객체 newBtn이 맞는지
			area.setText(""); //초기화
			//area.setText(" "); 만약 초기화가 안되면 " "공백으로 덮어도 됨
		}else if(e.getActionCommand()=="종료") { //이벤트의 명령을 내리는 게 타이틀이 종료인 애가 맞는지
			System.exit(0); //프로그램 강제 종료
		}
	}
}
//---------------------------------
public class WindowMain {

	public static void main(String[] args) {
		new WindowTest().init(); //클래스 만들고, 생성자 호출하고, init()처리하라
	}
}

/*
★ Event(이벤트)
1. Event Source			//누가? 어디서?
2. Event Listener		//MouseListener, KeyListener, WindowListener, ActionListener 
3. Event Handler(구현부)

[형식] EventSource.addEventListener(EventHandler의 위치)
-------------------------------------------------------------------------
* Component(도구)
Button, TextArea(자유롭게), TextField(한줄씩), Panel(Frame처럼 뜨지 않기 때문에 도구임. 단독으로 쓰이지 못함)

* Container(도구를 모아두는 도구상자)
Frame/JFrame, Dialog
*/
