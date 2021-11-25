package network;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class ChatClient extends JFrame implements ActionListener, Runnable {
	private JTextArea output;
	private JTextField input;
	private JButton sendBtn;
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;
	
	public ChatClient() { //생성자
		output = new JTextArea();
		output.setFont(new Font("돋움체", Font.BOLD, 16));
		output.setEditable(false); ///뿌려지는 부분이니까 입력 불가능하게
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		input = new JTextField();
		sendBtn = new JButton("보내기");
		
		JPanel southP = new JPanel(); //FlowLayout
		southP.setLayout(new BorderLayout()); //창이 커지면 텍스트필드도 같이 커지게 
		southP.add("Center", input); 
		southP.add("East", sendBtn);
		
		Container c = this.getContentPane();
		c.add("Center", scroll);
		c.add("South", southP);

		setBounds(600,200,300,300);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE); //서버에게 얘기도 안 하고 끊어버리겠다
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				pw.println("quit"); //서버에게 그만 끊는다고 메시지 보냄
				pw.flush();
				
				//자바는 동기식, 요청하면 응답을 해야 한다, 서버도 quit을 클라이언트에게 보냄 
			}
		});
		
		//이벤트
		sendBtn.addActionListener(this);
		input.addActionListener(this); //JTextField에서 enter칠 때
		
	}//ChatClient()
	
	public void service() {
		//서버IP
//		String serverIP = JOptionPane.showInputDialog(this,
//				"서버IP를 입력하세요", "서버IP", JOptionPane.INFORMATION_MESSAGE);
		
		String serverIP = JOptionPane.showInputDialog(this, 
				"서버IP를 입력하세요", "192.168.0.");	 //IP주소값 디폴트 잡은 거 
		
		if(serverIP==null || serverIP.length()==0) {//취소 누르면 null, 입력되지 않을 때
			System.out.println("서버IP가 입력되지 않았습니다"); //메시지 다이얼로그가 떠도 됨
			System.exit(0);
		}
		
		String nickName = JOptionPane.showInputDialog(this,
				"닉네임을 입력하세요", "닉네임", JOptionPane.INFORMATION_MESSAGE);
		
		if(nickName==null || nickName.length()==0) {
			nickName = "guest";
		}
		
		try {
			//소켓 생성
			socket = new Socket(serverIP, 9500);
			
			//IO 생성 - 스레드는 IO(br, pw)를 가지고 있음
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			//닉네임을 서버로 보내기
			pw.println(nickName); //ln으로 엔터값 있으므로 \n보낼 필요 없음
			pw.flush(); //버퍼 비우기, 버퍼를 비워야 다음 데이터값 보낼 수 있음
			
		} catch (UnknownHostException e) {
			System.out.println("서버를 찾을 수 없습니다");
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			System.out.println("서버가 연결되지 않았습니다");
			e.printStackTrace();
			System.exit(0);
		}
		
		Thread t = new Thread(this); //스레드 생성, ChatClient()가 스레드가 되고 싶다
		t.start(); //스레드 시작 - 스레드 실행 run()
	
	}//service()
	
	@Override
	public void run() {
		//서버로부터 받는 쪽
		String line = null;
		
		while(true) {
			try {
				line = br.readLine();
				
				if(line == null || line.toLowerCase().equals("quit")) { 
					//네트워크가 원할하지 않은 경우 서버가 끊기고 null값이 들어옴
					//받은 값이 quit일 때 : 내가 quit을 보내면 서버가 받고 quit으로 응답을 보냄
					
					br.close();
					pw.close();
					socket.close();
					
					System.exit(0);
				}//if
				
				output.append(line+"\n"); //readLine()은 엔터값 안 읽으니까 강제로 부여
				int pos = output.getText().length(); //JTextArea에서 가져온 문자열의 길이
				output.setCaretPosition(pos);
				//마우스 커서(caret)의 포지션을 pos에 맞추면 스크롤바가 자동으로 내려감
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//while
	}//run()
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//서버로 보내는 쪽
		String line = input.getText(); //JTextField에서 가져온 문자열 값
		pw.println(line); //서버로 보내기
		pw.flush(); //버퍼 비우기
		input.setText(""); //JTextField 초기화
		
	}//actionPerformed(ActionEvent e)
	
	public static void main(String[] args) {
		new ChatClient().service();
	}
}

/*
ServerSocket
- 클라이언트가 들어오기를 기다린다
- 낚아채서 클라이언트와 연결할 소켓을 만들어준다
--------------------------------------
클라이언트에서 서버로 보낼 때 그리면 안된다
서버로부터 받을 때 그려져야 똑같이 그려진다

서버는 모든 클라이언트에게 응답을 보낸다
--------------------------------------
Java는 동기식 
- 요청을 하면 반드시 응답을 해야한다. 응답하지 않으면 먹통 (소켓)

AJax, jQuery...React는 비동기식
- 요청을 하면 응답을 기다리지 않고, 내 할일 한다
- 요청하고 응답오면 그 다음에 다른 일을 해야지 하고 프로그램을 짤 수 없다
--------------------------------------
가상 아이피 주소는 192로 시작
*/
























