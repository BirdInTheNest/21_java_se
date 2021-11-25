package network;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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

public class ChatClientObject extends JFrame implements ActionListener, Runnable {
	private JTextArea output;
	private JTextField input;
	private JButton sendBtn;
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	public ChatClientObject() { //생성자
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
				//절대 객체 InfoDTO는 IO를 통해서 데이터 전송이 불가. 객체는 무거워서 넘어갈 수 없음
				//객체를 byte[]로 변환을 시켜줘야 한다 (객체 직렬화 - InfoDTO에 Serializable)
				
				InfoDTO dto = new InfoDTO();
				dto.setCommand(Info.EXIT); //서버에게 그만 끊는다고 메시지 보냄
				
				try {
					oos.writeObject(dto);
					oos.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//이벤트
		sendBtn.addActionListener(this);
		input.addActionListener(this); //JTextField에서 enter칠 때
		
	}//ChatClientObject()
	
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
			
			//IO 생성 - 스레드는 IO를 가지고 있음
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			
			//닉네임을 서버로 보내기
			InfoDTO dto = new InfoDTO();
			dto.setCommand(Info.JOIN);
			dto.setNickName(nickName);
			oos.writeObject(dto);
			oos.flush();
			
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
		InfoDTO dto = null; //dto로 보내고 dto를 받기 때문에 new할 필요 없다
		
		while(true) {		
			try {
				dto = (InfoDTO)ois.readObject(); //서버로부터 InfoDTO가 온다, 자식 = (자식)부모

				if(dto.getCommand() == Info.EXIT) { 
					ois.close();
					oos.close();
					socket.close();
					
					System.exit(0);
					
				}else if(dto.getCommand() == Info.SEND) {
					output.append(dto.getMessage()+"\n"); 
					//readObject()은 엔터값 안 읽으니까 강제로 부여
					int pos = output.getText().length(); //JTextArea에서 가져온 문자열의 길이
					output.setCaretPosition(pos);
					//마우스 커서(caret)의 포지션을 pos에 맞추면 스크롤바가 자동으로 내려감					
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}//while
	}//run()
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//서버로 보내는 쪽
		String line = input.getText(); //JTextField에서 가져온 문자열 값
				
		InfoDTO dto = new InfoDTO();
		if(line.toLowerCase().equals("quit")) {
			dto.setCommand(Info.EXIT);
		}else {
			dto.setCommand(Info.SEND);
			dto.setMessage(line);
		}
		
		try {
			oos.writeObject(dto); //서버로 보내기
			oos.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
		
		input.setText(""); //JTextField 초기화
		
	}//actionPerformed(ActionEvent e)
	
	public static void main(String[] args) {
		new ChatClientObject().service();
	}
}









