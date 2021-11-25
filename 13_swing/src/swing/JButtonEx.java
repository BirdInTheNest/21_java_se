package swing;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton; 

// JFrame은 4개의 층으로 구성되어 있다 
// JFrame > JRootPane > layeredPane (윗부분은 JMenuBar, 아랫부분은 contentPane) > glassPane
// JMenuBar에 JMenu, JmenuItem을 올릴 수 있다. setJMenuBar()
// contentPane에 Component들을 올릴 수 있다. getcontentPane()

// JRadioButton : 여러 항목 중에서 하나의 항목만 선택할 수 있도록 만든 Component
// ButtonGroup 클래스를 이용하여 여러 개의 항목을 그룹으로 묶어준다

public class JButtonEx extends JFrame {
	private Icon icon1 = new ImageIcon("image/aa.png"); //이미지 아이콘 생성
	private Icon icon2 = new ImageIcon("image/bb.png");
	private Icon icon3 = new ImageIcon("image/cc.png");
	private Icon icon4 = new ImageIcon("image/dd.png");
	private JRadioButton[] jb = new JRadioButton[4]; //방 4개짜리 JRadioButton 배열 생성
	private ButtonGroup bg = new ButtonGroup(); //ButtonGroup 생성
	
	public JButtonEx() { //생성자
		super("Test"); //JFrame 타이틀
		Container con = this.getContentPane(); //JFrame에서 ContentPane을 가져와라
		con.setLayout(new GridLayout(2,2)); //2행 2열
		
		for(int i=0; i<jb.length; i++) {
			jb[i] = new JRadioButton(i+1+"번 버튼", icon1); //JRadioButton 생성, 텍스트, 아이콘
			con.add(jb[i]); //JRadioButton을 ContentPane에 붙여라
			jb[i].setToolTipText(i+1+"번째 버튼이다. 눌러!!"); //커서가 있을 때 뜨는 텍스트
			jb[i].setMnemonic(i+49); // ALT와 조합하여 단축키 지정
			jb[i].setRolloverIcon(icon2);
			jb[i].setPressedIcon(icon3); 
			jb[i].setSelectedIcon(icon4);
			bg.add(jb[i]); //ButtonGroup에 JRadioButton 묶기
		}
		pack(); //컨테이너의 크기를 구성 요소 들의 크기로 설정
		setVisible(true);
	}//JButtonEx()

	public static void main(String[] args) {
		new JButtonEx();
	}
}



















