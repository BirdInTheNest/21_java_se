package io;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

//Ctrl + Shift + f : 탭 정리

//Swing 틀
public class ScoreForm extends JFrame implements ActionListener{
	private JLabel hakL, nameL, korL, engL, mathL;
	private JTextField hakT, nameT, korT, engT, mathT;
	private JButton inputBtn, printBtn, searchBtn, rankBtn, saveBtn, loadBtn;
	private DefaultTableModel model;
	private JTable table;
	private Score score;

	public ScoreForm() { //생성자
		// JLabel 생성
		hakL = new JLabel("학번");
		nameL = new JLabel("이름");
		korL = new JLabel("국어");
		engL = new JLabel("영어");
		mathL = new JLabel("수학");

		// JTextField 생성
		hakT = new JTextField("", 22); //String text, int columns
		nameT = new JTextField("", 22); //열의 크기를 주지 않으면 텍스트필드 길이가 짧게 그려진다
		korT = new JTextField("", 22);
		engT = new JTextField("", 22);
		mathT = new JTextField("", 22);

		// JButton 생성
		inputBtn = new JButton("입력");
		printBtn = new JButton("출력");
		searchBtn = new JButton("학번검색");
		rankBtn = new JButton("순위");
		saveBtn = new JButton("파일저장");
		loadBtn = new JButton("파일읽기");

		// JTable의 타이틀
		Vector<String> vector = new Vector<String>();
		vector.add("학번");
		vector.add("이름");
		vector.add("국어");
		vector.add("영어");
		vector.add("수학");
		vector.add("총점");
		vector.add("평균");

		model = new DefaultTableModel(vector, 0); 
		//TableModel 생성, vector을 열의 이름으로 하고 행의 개수는 0
		table = new JTable(model); //TableModel을 값으로 하는 Table 생성
		JScrollPane scroll = new JScrollPane(table); //JScrollPane에 Table 붙이기, 1회용 생성
		
		score = new ScoreImpl(); //부모 = 자식

		// West - 왼쪽
		JPanel hakP = new JPanel(); //패널에 라벨과 텍스트필드 붙이기
		hakP.add(hakL);
		hakP.add(hakT);
		JPanel nameP = new JPanel();
		nameP.add(nameL);
		nameP.add(nameT);
		JPanel korP = new JPanel();
		korP.add(korL);
		korP.add(korT);
		JPanel engP = new JPanel();
		engP.add(engL);
		engP.add(engT);
		JPanel mathP = new JPanel();
		mathP.add(mathL);
		mathP.add(mathT);

		JPanel p = new JPanel(new GridLayout(5, 1)); //패널을 붙인 전체패널
		p.add(hakP);
		p.add(nameP);
		p.add(korP);
		p.add(engP);
		p.add(mathP);

		JPanel p2 = new JPanel(new GridLayout(1, 6, 5, 5)); //버튼을 붙인 패널
		p2.add(inputBtn);
		p2.add(printBtn);
		p2.add(searchBtn);
		p2.add(rankBtn);
		p2.add(saveBtn);
		p2.add(loadBtn);

		Container c = getContentPane();
		c.add("West", p);
		c.add("South", p2);
		c.add("Center", scroll);

		setBounds(800, 100, 700, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//이벤트
		event();
		
	}//ScoreForm()
	
	public void event() {
		inputBtn.addActionListener(this);
		printBtn.addActionListener(this);
		searchBtn.addActionListener(this);
		rankBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		loadBtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==inputBtn) {
			input(); //호출
	
		}else if(e.getSource()==printBtn) {
			//인터페이스 Score는 테이블이 있는지 모르므로, TableModel을 보내야 테이블의 데이터를 처리한다
			score.print(model);
			
		}else if(e.getSource()==searchBtn) {
			score.search(model);  
			
		}else if(e.getSource()==rankBtn) {
			score.tot_desc(); //총점으로 내림차순
			score.print(model);
			
		}else if(e.getSource()==saveBtn) {
			score.save();
			
		}else if(e.getSource()==loadBtn) {
			score.load();
			score.print(model);
		}
	}//actionPerformed(ActionEvent e)

	public void input() {
		//JTextField에 입력된 데이터를 가져와야 한다
		String hak = hakT.getText();
		
		//데이터가 들어왔는지 확인
		if(hak.length() == 0) { //if(hak.equals("")) //hak의 크기가 0이면 입력되지 않았음
			JOptionPane.showMessageDialog(this, "학번을 입력하세요");
			return;	
		}

		String name = nameT.getText();
		int kor = Integer.parseInt(korT.getText());
		int eng = Integer.parseInt(engT.getText());
		int math = Integer.parseInt(mathT.getText());
		
		//계산
		int tot = kor + eng + math;
		double avg = (double)tot /3;
		
		//데이터를 TableModel에 넣어야 Table에 뿌릴 수 있다
		//데이터가 여러개니까 dto 한 곳에 저장한다
		//dto에서 꺼낸 데이터를 Table에 바로 넣으면 값을 계속 덮어버리므로, dto를 list에 담는다
		
		ScoreDTO dto = new ScoreDTO(); //dto 생성
		dto.setHak(hak); //데이터를 dto에 보관
		dto.setName(name);
		dto.setKor(kor);
		dto.setEng(eng);
		dto.setMath(math);
		dto.setTot(tot);
		dto.setAvg(avg);
		
		//첫번째 방법 : ScoreDTO를 List에 담아서 JTable에 뿌리고 파일에 보관
		//데이터를 List에 보관해야 파일을 저장하고 읽을 수 있다
		
		score.input(dto);
		//인터페이스 Score의 input(ScoreDTO dto) 호출했지만 추상메소드이므로 대신
		//ScoreImpl 클래스에 Override된 input(ScoreDTO dto) 호출
		
		//두번째 방법 : ScoreDTO를 가지고 ScoreDAO.java에서 DB에 insert 한다
		//DB와 연동되면 바로 데이터가 들어가니까 데이터를 List에 보관할 필요 없음
		
		//초기화 - 데이터가 다 들어가면 초기화해야 새로운 값이 또 들어갈 수 있다
		hakT.setText("");
		nameT.setText("");
		korT.setText("");
		engT.setText("");
		mathT.setText("");

	}//input()
}

/*
String a = null;	String b = ""
a + "apple"			b + "apple"
"nullapple"			"apple"
 */














