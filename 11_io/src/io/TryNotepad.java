package io;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class TryNotepad extends JFrame implements ActionListener {
	private JTextArea area;
	private MenuPane menu; 
	//Component인 MenuPane 클래스를 Container인 TryNotepad 클래스 필드에 가져와야 한다
	
	private File file; //필드는 null이라고 초기값을 굳이 주지 않아도 가지고 있음
	
	public TryNotepad() { //생성자
		area = new JTextArea(); //텍스트 생성
		area.setFont(new Font("고딕체", Font.PLAIN, 20));
		
		JScrollPane scroll = new JScrollPane(area); //스크롤 생성, 스크롤에 텍스트 붙이기
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//VerticalScrollBar에 규약을 주겠다, 항상 떠 있도록
		
		menu = new MenuPane(); //MenuPane() 생성 및 호출
		this.setJMenuBar(menu); //여기에 menu값으로 JMenuBar를 하겠다
		
		this.add("Center", scroll); //여기에 스크롤을 가운데에 붙여라
		
		setBounds(900,100,500,500);
		setVisible(true);

		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//숨지 마라
		
//		WindowAdapter는 추상클래스이지만 추상메소드가 없어서 Override할 게 없음, 익명 Inner Class 사용
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				int result = JOptionPane.showConfirmDialog(
						TryNotepad.this, //this만 쓰면 익명 Inner Class를 뜻함
						"저장하시겠습니까?", 
						"메모장",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
				if(result == JOptionPane.YES_OPTION) { //YES 0, NO 1
					//파일 저장하고
					saveDialog();
					fileWrite();
					
					System.exit(0);
				}else if(result == JOptionPane.NO_OPTION) {
					System.exit(0);					
				}
			}
		});
		
		//이벤트 처리 - 메뉴
		menu.getNewM().addActionListener(this); //menu의 NewM 값은 getter로 가져와야 함
		menu.getOpenM().addActionListener(this);
		menu.getSaveM().addActionListener(this);
		menu.getExitM().addActionListener(this);
		menu.getCutM().addActionListener(this);
		menu.getCopyM().addActionListener(this);
		menu.getPasteM().addActionListener(this);
		
	}//TryNotepad()

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==menu.getNewM()) {
			area.setText(""); //초기화
			
		}else if(e.getSource()==menu.getOpenM()) {
			openDialog(); //열기 다이얼로그 - 파일 선택
			fileRead(); //파일의 내용을 읽어서 TextArea 뿌리기
			
		}else if(e.getSource()==menu.getSaveM()) {
			saveDialog();
			fileWrite();
			
		}else if(e.getSource()==menu.getExitM()) {
			//System.exit(0); //프로그램 종료
			
			//다이얼로그
			//JOptionPane.showConfirmDialog의 결과값은 yes no cancel 문자가 아니라 정수값이다

			int result = JOptionPane.showConfirmDialog(
					this, //어디다?, null로 하면 JFrame과 상관없이 뜸
					"저장하시겠습니까?", //메시지
					"메모장", //타이틀
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			
			if(result == JOptionPane.YES_OPTION) { //YES 0, NO 1
				//파일 저장하고
				saveDialog();
				fileWrite();
				
				System.exit(0);
			}else if(result == JOptionPane.NO_OPTION) {
				System.exit(0);
			}
				
		}else if(e.getSource()==menu.getCutM()) {
			area.cut();
			
		}else if(e.getSource()==menu.getCopyM()) {
			area.copy();
			
		}else if(e.getSource()==menu.getPasteM()) {
			area.paste();
		}
	}//actionPerformed(ActionEvent e)
		
	private void openDialog() {
		JFileChooser chooser = new JFileChooser(); //JFileChooser 다이얼로그 생성
		int result = chooser.showOpenDialog(this); //JFrame 위에 OpenDialog 띄워주세요, 리턴값 저장
		if(result == JFileChooser.APPROVE_OPTION) { //result에 저장된 값이 APPROVE_OPTION 이면
			file = chooser.getSelectedFile(); //파일 선택
		}
		
		JOptionPane.showMessageDialog(this, file); //JFrame 위에 파일 메시지 띄워주세요
		//파일은 경로￦파일명으로 toString()되어 있음
		
		//return file; //openDialog()를 파일을 리턴하는 메소드로 하는 것이 필드에 File값 잡는 것보다 더 좋다
	}
	
	private void fileRead() { //파일 읽기
		if(file == null) return; //file이 null이면(선택한 내용이 없음) 함수를 나가라
		//NullPointerException일 때는 프로그램 소스를 고친다
		area.setText(""); //파일을 읽기 전에 초기화하면 파일을 계속 새로 열 때 덕지덕지 붙지 않음
				
		try {
			BufferedReader br = new BufferedReader(new FileReader(file)); //Reader 문자 단위 처리
			String line;
			
			while( (line = br.readLine()) != null) { //br.readLine()으로 읽어온 값이 없을때까지 반복
				//br.readLine()은 1즐(Enter를 칠 때까지)	읽는다

				//area.setText(line); //setText는 값을 계속 덮어쓴다
				area.append(line+"\n"); //append 끝에 계속 추가한다, line이 끝나면 강제로 줄바꾸는 거 필요	
				//(readLine()이 엔터 값을 읽어가지 않기 때문에)
			}//while
			
			br.close(); //BufferedReader 닫기
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void saveDialog() {
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showSaveDialog(this);
	
		if(result == JFileChooser.APPROVE_OPTION) { //저장 선택, 확인버튼이 눌림
			file = chooser.getSelectedFile();
		}
		
		JOptionPane.showMessageDialog(this, file);
	}
	
	private void fileWrite() {
		if(file == null) return; //Dialog에서 Cancel 누르면 null값이 들어옴. 함수를 나가라
		String data = null;
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file,false)); 
			//true이면 파일 끝에 계속 추가 false면 파일에 덮어쓴다. 기본디폴트가 false임
			data = area.getText();
			
			bw.write(data); //파일로 저장됨
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new TryNotepad();
	}
}

/*

Application <-- BufferedReader -- buffer <-- FileReader -- 키보드/화면
*.java		-- BufferedWriter -->		 -- FileWriter --> 파일/DB/네트워크
			   printWriter 			   					

 */
























