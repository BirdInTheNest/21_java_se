package nested;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class LoginPanel extends Panel {
	private Label idL, pwdL;
	private TextField idT, pwdT;
	private Button loginBtn, resetBtn;

	public LoginPanel() {
		this.setBackground(Color.PINK);
		setLayout(null);
		
		//생성
		idL = new Label("아이디");
		pwdL = new Label("비밀번호");
		
		idT = new TextField();
		pwdT = new TextField();
		
		loginBtn = new Button("로그인");
		resetBtn = new Button("다시 작성");
		
		//글꼴 크기 지정
		Font labelF = new Font("맑은고딕", 1, 15);
		Font textF = new Font("맑은고딕", 1, 25);
		
		idL.setFont(labelF);
		idT.setFont(textF);
        pwdL.setFont(labelF);
        pwdT.setFont(textF);
        loginBtn.setFont(labelF);
        resetBtn.setFont(labelF);
		
		//배치	
		idL.setBounds(20,120,70,30);
		idT.setBounds(20,150,450,50);

		pwdL.setBounds(20,210,70,30);
		pwdT.setBounds(20,240,450,50);
		
		loginBtn.setBounds(20,350,220,50);
		resetBtn.setBounds(250,350,220,50);

		this.add(idL);
		this.add(idT);
		this.add(pwdL);
		this.add(pwdT);
		this.add(loginBtn);
		this.add(resetBtn);
		
		//이벤트 - 익명 Inner Class {} 사용
		loginBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//데이터 가져오기 - 로그인은 데이터가 2개밖에 없어서 dto로 데이터 모을 필요 없음
				String id = idT.getText();
				String pwd = pwdT.getText();
				
				//DB
				MemberDAO dao = new MemberDAO();
				String name = dao.loginMember(id, pwd); 
				//loginMember에 데이터 id, pwd를 보내고, 리턴값을 String name에 저장한다
				
				if(name==null) {
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호가 틀립니다");
				}else {
					JOptionPane.showMessageDialog(null, name+"님 로그인 되었습니다");
				} //Dialog는 단독으로 뜰 수 있다. setFont지정하면 글씨 크게 할 수 있다	
			}
		});
		
		resetBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				idT.setText("");
				pwdT.setText("");
			}
		});
	}
}
/* DB에서 select하면 데이터값이 떨어진다.
레코드가 있으면 T 없으면 F값 떨어지는 rs.next() 이용하여 
boolean으로 로그인성공, 로그인실패 뜨게 처리할 수도 있다. */