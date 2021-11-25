/*
CardLayout() 으로 홈, 회원가입, 로그인 Panel
- 홈 : 안녕하세요 (홈화면은 이미지나 글 아무거나 있어도 됨)
- 회원가입 : 회원가입 Panel (회원가입 창: 이름, 아이디, 비밀번호 등록 다시작성 - DB Insert)
- 로그인 : 로그인 Panel (로그인 창: DB 검색해서 있으면 로그인 성공 - DB Select)
(창은 바뀌지 않는다.)

- swing아니고 awt로 만들기
  비밀번호를 awt로 만들면 ... 처럼 비공개로 못 바꾼다. 
  비밀번호 다 공개하기

- 로그인 성공, 로그인 실패까지 뜨게하라.
  로그인 성공/실패 는 새 창에 뜨게 하거나 
  로그인 Panel 하단부에 text만 뜨게 해도 된다. (로그인 실패 새창이나 라벨로 frame에 뜨면 됨)

- 회원가입 insert 로그인 select

- DB와 연동, 등록할 때마다 DB로 들어가야 한다.

# 테이블 작성
create table member(
name  varchar2(15)  not  null,
id   varchar2(15), 
pwd   number
);
 */

package nested;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//Frame은 BorderLayout(동서남북) 각 방향별로 1개의 Component(도구)밖에 안 올라간다
public class MemberMain extends Frame implements ActionListener {
	private Button homeBtn, writeBtn, loginBtn;	
	private CardLayout card;
	private Panel cardP;
	
	public MemberMain() { //생성자
		homeBtn = new Button("홈"); //버튼 생성
		writeBtn = new Button("회원가입");
		loginBtn = new Button("로그인");
		
		card = new CardLayout(); //카드 레이아웃 생성
		
		//3개의 버튼을 묶은 패널
		Panel buttonP = new Panel(); //Panel은 FlowLayout(순서배치)
		buttonP.setBackground(new Color(45,180,0));
		buttonP.add(homeBtn);
		buttonP.add(writeBtn);
		buttonP.add(loginBtn);
		
		//카드레이아웃으로 설정한 패널. home, write, login 패널로 계속 바뀜
		cardP = new Panel();
		cardP.setLayout(card);
		cardP.add("home", new HomePanel()); //add(String name, Component comp)
		cardP.add("write", new WritePanel());
		cardP.add("login", new LoginPanel());

		this.add("North", buttonP);
		this.add("Center", cardP);
		
		this.setBounds(700, 100, 500, 500);
		this.setResizable(false);
		this.setVisible(true);
		
		//버튼 이벤트
		homeBtn.addActionListener(this);
		writeBtn.addActionListener(this);
		loginBtn.addActionListener(this);

		//이벤트 - 익명 Inner Class {} 사용 
		//여기서 WindowListener 이벤트 발생, WindowAdapter()가 구현부
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0); //프로그램 종료
			}
		});
	}//MemberMain()

	@Override //implements ActionListener하고 추상메소드 Override함
	public void actionPerformed(ActionEvent e) { 
		if(e.getSource()==homeBtn) {
			card.show(cardP, "home"); 
			//cardP는 생성자 안에서 선언했기 때문에 생성자 밖에서 모름. 필드에 선언해야함
		}else if(e.getSource()==writeBtn) {
			card.show(cardP, "write");
		}else if(e.getSource()==loginBtn) {
			card.show(cardP, "login");
		}	
	}//actionPerformed
	
	public static void main(String[] args) {
		new MemberMain();
	}//main()

}

/*
Component(도구) - 연필, 볼펜
Button, TextField, TextArea, Panel(Component를 묶어주는 Layer역할만 함)


Container(도구상자) - 필통
Frame, Dialog
--------------------------------------------------------------------
인터페이스 WindowListener는 Override할 추상메소드가 많아서, Override 대신 해준 클래스인
WindowAdapter를 사용하여 인터페이스 WindowListener를 생성한다. 

WindowAdapter는 추상클래스이기 때문에 절대 new할 수 없다. 
또한 WindowAdapter는 Override할 추상메소드가 없어 모든 메소드가 빈 body이며 기능이 없다.

WindowListener - WindowAdapter
MouseListener - MouseAdapter
*/