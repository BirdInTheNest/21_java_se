/*
[1차숙제]
  private Button[] btn; 
 - 배열의 크기는 18개로 잡고 for 문을 사용하여 생성한다.
private Label dispL
                  inputL
- inputL에 0은 오른쪽에 표시한다.
- Label에 바탕색을 입힌다

[2차숙제]

1.숫자를 누르면 이벤트 발생 -ActionListener
   1,2,3,4,5,6,7,8,9,0

2.StringBuffer buffer --> "7" append로 추가
버퍼로들어온 7을 라벨에 뿌려준다!
 - 7을 누르면 7이 StringBuffer에 추가된다. -append()
 - 추가된 StringBuffer의 내용을 Label에 덮어쓴다 -setText()
 - 숫자중에서 0이 맨 처음에는 추가가 안된다. 앞에 숫자가 있을경우에는 0이 추가된다. -if문

3.C를 누르면 Label, StringBuffer 모두 초기화된다. setText("0")

[3차 숙제]
만약에 점이 없으면 추가되고
	 점이 있으면 그냥 통과
	 
<- 누르면 한글자씩 지워진다
   마지막까지 다 지우면 다시 0으로 된다 - delete() 사용
*/

package calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculator extends JFrame implements ActionListener, WindowListener {
	private JLabel dispL, inputL;
	private JButton[] btn;
	private String[] num = {"7", "8", "9", "/", //자료형이 String 클래스형인 객체 배열 num 생성
						   "4", "5", "6", "*", 
						   "1", "2", "3", "-", 
						   ".", "0", "=", "+" , 
						   "C", "←"};
	
	private StringBuffer dispBuffer = new StringBuffer();
	private StringBuffer inputBuffer = new StringBuffer();
	
	private double result; //처음의 값, 중간 결과
	private char op; //연산자 '+':43, '-':45, '*':42, '/':47 
	private DecimalFormat df = new DecimalFormat("#,###.#######");
	
	public void init() { //초기화 메소드
		dispL = new JLabel("", JLabel.RIGHT); //오른쪽 정렬
		dispL.setOpaque(true); //JLable의 배경색이 기본적으로 투명이기 때문에 불투명하게 만들어줘야 배경색 적용된다
		dispL.setBackground(new Color(254,254,241));
		dispL.setFont(new Font("맑은고딕", Font.BOLD, 20));
		
		inputL = new JLabel("0", JLabel.RIGHT); //(String text, int horizontalAlignment)
		inputL.setOpaque(true);
		inputL.setBackground(new Color(254,254,241));
		inputL.setFont(new Font("맑은고딕", Font.BOLD, 20));
		
		btn = new JButton[18]; //자료형이 JButton 클래스형인 객체 배열 btn 생성, 방 18개
		for(int i=0; i<btn.length; i++) { 
			btn[i] = new JButton(num[i]); //객체 배열 btn의 빈 방에 각각 num[i]값을 지닌 JButton 생성
		} //버튼 생성
		
		//패널 생성 - 전체패널 center에 하나 잡고 그 안에 패널 7줄 넣기
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(7,1,5,5));
		p.setBackground(new Color(252,251,214));

		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(1,4,5,5));
		p1.setBackground(new Color(252,251,214));
		for(int i=0; i<4; i++) {
			p1.add(btn[i]);
			btn[i].setBackground(new Color(249,247,164));
			btn[i].setFont(new Font("맑은고딕", Font.BOLD, 20));
		}
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(1,4,5,5));
		p2.setBackground(new Color(252,251,214));
		for(int i=4; i<8; i++) {
			p2.add(btn[i]);
			btn[i].setBackground(new Color(249,247,164));
			btn[i].setFont(new Font("맑은고딕", Font.BOLD, 20));
		}
		
		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(1,4,5,5));
		p3.setBackground(new Color(252,251,214));
		for(int i=8; i<12; i++) {
			p3.add(btn[i]);
			btn[i].setBackground(new Color(249,247,164));
			btn[i].setFont(new Font("맑은고딕", Font.BOLD, 20));
		}
		
		JPanel p4 = new JPanel();
		p4.setLayout(new GridLayout(1,4,5,5));
		p4.setBackground(new Color(252,251,214));
		for(int i=12; i<16; i++) {
			p4.add(btn[i]);
			btn[i].setBackground(new Color(249,247,164));
			btn[i].setFont(new Font("맑은고딕", Font.BOLD, 20));
		}
		
		JPanel p5 = new JPanel();
		p5.setLayout(new GridLayout(1,2,5,5));
		p5.setBackground(new Color(252,251,214));
		for(int i=16; i<btn.length; i++) {
			p5.add(btn[i]);
			btn[i].setBackground(new Color(249,247,164));
			btn[i].setFont(new Font("맑은고딕", Font.BOLD, 20));
		}
	
		add("Center", p);
		p.add(dispL); //라벨은 바로 전체패널에 붙이기
		p.add(inputL);
		p.add(p5);
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
	
		setTitle("Calculator");
		//setDefaultCloseOperation(DISPOSE_ON_CLOSE); //x눌러서 종료
		setBounds(900,300,300,400); //창이 처음 뜨는 위치, 창 크기
		setResizable(false); //창 크기조절 안되게 막아둠
		setVisible(true);
		
		//이벤트
		this.addWindowListener(this);
		
		for(int i=0; i<btn.length; i++) {
			btn[i].addActionListener(this);
		}
	}//init()

	//ActionListener Override
	@Override
	public void actionPerformed(ActionEvent e) {
		//숫자
		if(e.getActionCommand()=="1" || //이벤트에 액션을 명령한 게 숫자이면
		   e.getActionCommand()=="2" ||
		   e.getActionCommand()=="3" ||
		   e.getActionCommand()=="4" ||
		   e.getActionCommand()=="5" ||
		   e.getActionCommand()=="6" ||
		   e.getActionCommand()=="7" ||
		   e.getActionCommand()=="8" ||
		   e.getActionCommand()=="9" ||
		   e.getActionCommand()=="0") {
			
			//맨 처음에 inputL에 0을 표시하고 있지만 buffer에 입력된 숫자는 없다(buffer.length()==0)
			//StringBuffer delete(int start, int end) : start번째 문자부터 end번째 문자 이전까지 지운다
				
			if(inputBuffer.length()==1 && inputBuffer.toString().equals("0")) {
				inputBuffer.delete(0,1); //0번부터 1번 이전까지 삭제
			} //inputBuffer에 입력된 값이 하나고, inputBuffer의 값을 문자열로 반환한 것이 0과 같을 때
			
			inputBuffer.append(e.getActionCommand()); //이벤트에 액션을 명령한 숫자를 inputBuffer에 추가
			inputL.setText(inputBuffer+""); //inputBuffer에 입력된 값을 +""로 문자열로 만들고 inputL에 덮기
			
		}else if(e.getActionCommand() == "C") { //이벤트에 액션을 명령한 게 C이면
			dispBuffer.delete(0, dispBuffer.length()); //0번부터 dispBuffer.length() 이전까지 삭제
			inputBuffer.delete(0, inputBuffer.length()); //0번부터 inputBuffer.length() 이전까지 삭제
			
			dispL.setText(""); //dispL에 문자열 "" 덮기, 초기화
			inputL.setText("0"); //inputL에 문자열 0 덮기, 초기화
			
			result = op = 0; //중간결과값, 연산자 모두 초기화
			
		}else if(e.getActionCommand()== ".") { //이벤트에 액션을 명령한 게 .이면
			if(inputBuffer.indexOf(".") == -1){ //indexOf는 찾는 값이 없으면 결과값이 -1임 
				inputBuffer.append("."); //inputBuffer에 .이 없으면 .추가
			}
			inputL.setText(inputBuffer+""); //inputBuffer에 입력된 값을 +""로 문자열로 만들고 inputL에 덮기
			
		}else if(e.getActionCommand() == "←") { //이벤트에 액션을 명령한 게 ←이면
			inputBuffer.delete(inputBuffer.length()-1, inputBuffer.length()); //마지막 글자 삭제
			if(inputBuffer.length() == 0) //inputBuffer에 입력된 값이 없으면
				inputBuffer.append("0"); //inputBuffer에 0 넣기, 초기화
			
			inputL.setText(inputBuffer+"");

		}else if(e.getActionCommand() == "+") {
			calc(); //계산
			op='+'; //연산자 op에 + 집어넣고
			
			dispBuffer.append(inputBuffer+" + "); //dispBuffer에 inputBuffer 내용 + 넣고
			
			//setText는 String값을 뿌린다
			dispL.setText(dispBuffer+""); //dispBuffer에 입력된 값을 +""로 문자열로 만들고 dispL에 덮기
			inputL.setText(df.format(result)); //중간값 result를 inputL에 덮기
			
			inputBuffer.delete(0, inputBuffer.length()); //0번부터 inputBuffer.length() 이전까지 삭제
			
		}else if(e.getActionCommand() == "-") {
			calc(); //계산
			op='-';
			
			dispBuffer.append(inputBuffer+" - ");
			
			dispL.setText(dispBuffer+""); 
			inputL.setText(df.format(result));
			
			inputBuffer.delete(0, inputBuffer.length());
			
		}else if(e.getActionCommand() == "*") {
			calc(); //계산
			op='*';
			
			dispBuffer.append(inputBuffer+" * ");
			
			dispL.setText(dispBuffer+""); 
			inputL.setText(df.format(result));
			
			inputBuffer.delete(0, inputBuffer.length());
			
		}else if(e.getActionCommand() == "/") {
			calc(); //계산
			op='/';
			
			dispBuffer.append(inputBuffer+" / ");
			
			dispL.setText(dispBuffer+""); 
			inputL.setText(df.format(result));
			
			inputBuffer.delete(0, inputBuffer.length());
			
		}else if(e.getActionCommand() == "=") {
			calc(); //계산
			op=0; //연산자 초기화
			
			dispBuffer.append(inputBuffer+"");
			
			dispL.setText(dispBuffer+""); 
			inputL.setText(df.format(result));
			
			dispBuffer.delete(0, dispBuffer.length());
			inputBuffer.delete(0, inputBuffer.length());	
		}
	}//actionPerformed(ActionEvent e)
	
//	계산기에 숫자가 눌리다가 연산자가 눌리면 더이상 숫자가 들어오지 않으므로 계산할지 물어본다
//	만약 연산자가 없으면 계산을 하지 못함. 숫자를 result에 저장, 연산자를 op에 저장
//	만약 연산자가 있으면 계산을 해서 result에 저장, 새로운 연산자를 op에 저장
	public void calc() {
		//계산 -  result에는 처음 값과 중간 결과
		if(op==0) result = Double.parseDouble(inputBuffer+""); //연산자가 없으면 result에 처음 값
		else if(op=='+') result += Double.parseDouble(inputBuffer+""); //연산자가 있으면 result에 중간값
		else if(op=='-') result -= Double.parseDouble(inputBuffer+"");
		else if(op=='*') result *= Double.parseDouble(inputBuffer+"");
		else if(op=='/') result /= Double.parseDouble(inputBuffer+"");
	}

	//WindowListener Override
	@Override
	public void windowOpened(WindowEvent e) {}
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0); //프로그램 종료
	}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowDeactivated(WindowEvent e) {}

	public static void main(String[] args) {
		new Calculator().init();
	}
}

//StringBuffer deleteCharAt(int index) : 매개변수로 받은 수치값번째 문자를 지운다
