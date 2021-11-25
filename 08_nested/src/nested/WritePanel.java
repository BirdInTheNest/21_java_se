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

public class WritePanel extends Panel {
	private Label nameL, idL, pwdL;
	private TextField nameT, idT, pwdT;
	private Button writeBtn, resetBtn;

	public WritePanel() { //생성자
		this.setBackground(Color.CYAN);
		setLayout(null);
		
		//생성
		nameL = new Label("이름");
		idL = new Label("아이디");
		pwdL = new Label("비밀번호");
		
		nameT = new TextField();
		idT = new TextField();
		pwdT = new TextField();
		
		writeBtn = new Button("등록");
		resetBtn = new Button("다시 작성");
		
		//글꼴 크기 지정
		Font labelF = new Font("맑은고딕", 1, 15);
		Font textF = new Font("맑은고딕", 1, 25);
		
		nameL.setFont(labelF);
		nameT.setFont(textF);
		idL.setFont(labelF);
		idT.setFont(textF);
        pwdL.setFont(labelF);
        pwdT.setFont(textF);
        writeBtn.setFont(labelF);
        resetBtn.setFont(labelF);
		
		//배치
		nameL.setBounds(20,30,70,30);
		nameT.setBounds(20,60,450,50);
		
		idL.setBounds(20,120,70,30);
		idT.setBounds(20,150,450,50);

		pwdL.setBounds(20,210,70,30);
		pwdT.setBounds(20,240,450,50);
		
		writeBtn.setBounds(20,350,220,50);
		resetBtn.setBounds(250,350,220,50);
		
		this.add(nameL);
		this.add(nameT);
		this.add(idL);
		this.add(idT);
		this.add(pwdL);
		this.add(pwdT);
		this.add(writeBtn);
		this.add(resetBtn);
		
		//이벤트 - 익명 Inner Class {} 사용
		writeBtn.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				//데이터 가져오기
				String name = nameT.getText();
				String id = idT.getText();
				String pwd = pwdT.getText();
				
				//dto를 생성하여 데이터를 한 곳에 모아 놓는다
				MemberDTO dto = new MemberDTO(); 
				dto.setName(name);
				dto.setId(id);
				dto.setPwd(pwd);
				
				//DB
				MemberDAO dao = new MemberDAO();
				int su = dao.insertMember(dto); 
				//insertMember에 데이터 dto를 보내고, 리턴값을 int su에 저장한다
				
				JOptionPane.showMessageDialog(null, "회원가입 되었습니다");
				//Dialog는 단독으로 사용할 수 있다
			}
		});
		
		resetBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nameT.setText("");
				idT.setText("");
				pwdT.setText("");
			}
		});
	}
}