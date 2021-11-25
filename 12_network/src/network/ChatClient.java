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
	
	public ChatClient() { //������
		output = new JTextArea();
		output.setFont(new Font("����ü", Font.BOLD, 16));
		output.setEditable(false); ///�ѷ����� �κ��̴ϱ� �Է� �Ұ����ϰ�
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		input = new JTextField();
		sendBtn = new JButton("������");
		
		JPanel southP = new JPanel(); //FlowLayout
		southP.setLayout(new BorderLayout()); //â�� Ŀ���� �ؽ�Ʈ�ʵ嵵 ���� Ŀ���� 
		southP.add("Center", input); 
		southP.add("East", sendBtn);
		
		Container c = this.getContentPane();
		c.add("Center", scroll);
		c.add("South", southP);

		setBounds(600,200,300,300);
		setVisible(true);
		//setDefaultCloseOperation(EXIT_ON_CLOSE); //�������� ��⵵ �� �ϰ� ��������ڴ�
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				pw.println("quit"); //�������� �׸� ���´ٰ� �޽��� ����
				pw.flush();
				
				//�ڹٴ� �����, ��û�ϸ� ������ �ؾ� �Ѵ�, ������ quit�� Ŭ���̾�Ʈ���� ���� 
			}
		});
		
		//�̺�Ʈ
		sendBtn.addActionListener(this);
		input.addActionListener(this); //JTextField���� enterĥ ��
		
	}//ChatClient()
	
	public void service() {
		//����IP
//		String serverIP = JOptionPane.showInputDialog(this,
//				"����IP�� �Է��ϼ���", "����IP", JOptionPane.INFORMATION_MESSAGE);
		
		String serverIP = JOptionPane.showInputDialog(this, 
				"����IP�� �Է��ϼ���", "192.168.0.");	 //IP�ּҰ� ����Ʈ ���� �� 
		
		if(serverIP==null || serverIP.length()==0) {//��� ������ null, �Էµ��� ���� ��
			System.out.println("����IP�� �Էµ��� �ʾҽ��ϴ�"); //�޽��� ���̾�αװ� ���� ��
			System.exit(0);
		}
		
		String nickName = JOptionPane.showInputDialog(this,
				"�г����� �Է��ϼ���", "�г���", JOptionPane.INFORMATION_MESSAGE);
		
		if(nickName==null || nickName.length()==0) {
			nickName = "guest";
		}
		
		try {
			//���� ����
			socket = new Socket(serverIP, 9500);
			
			//IO ���� - ������� IO(br, pw)�� ������ ����
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			//�г����� ������ ������
			pw.println(nickName); //ln���� ���Ͱ� �����Ƿ� \n���� �ʿ� ����
			pw.flush(); //���� ����, ���۸� ����� ���� �����Ͱ� ���� �� ����
			
		} catch (UnknownHostException e) {
			System.out.println("������ ã�� �� �����ϴ�");
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			System.out.println("������ ������� �ʾҽ��ϴ�");
			e.printStackTrace();
			System.exit(0);
		}
		
		Thread t = new Thread(this); //������ ����, ChatClient()�� �����尡 �ǰ� �ʹ�
		t.start(); //������ ���� - ������ ���� run()
	
	}//service()
	
	@Override
	public void run() {
		//�����κ��� �޴� ��
		String line = null;
		
		while(true) {
			try {
				line = br.readLine();
				
				if(line == null || line.toLowerCase().equals("quit")) { 
					//��Ʈ��ũ�� �������� ���� ��� ������ ����� null���� ����
					//���� ���� quit�� �� : ���� quit�� ������ ������ �ް� quit���� ������ ����
					
					br.close();
					pw.close();
					socket.close();
					
					System.exit(0);
				}//if
				
				output.append(line+"\n"); //readLine()�� ���Ͱ� �� �����ϱ� ������ �ο�
				int pos = output.getText().length(); //JTextArea���� ������ ���ڿ��� ����
				output.setCaretPosition(pos);
				//���콺 Ŀ��(caret)�� �������� pos�� ���߸� ��ũ�ѹٰ� �ڵ����� ������
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//while
	}//run()
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//������ ������ ��
		String line = input.getText(); //JTextField���� ������ ���ڿ� ��
		pw.println(line); //������ ������
		pw.flush(); //���� ����
		input.setText(""); //JTextField �ʱ�ȭ
		
	}//actionPerformed(ActionEvent e)
	
	public static void main(String[] args) {
		new ChatClient().service();
	}
}

/*
ServerSocket
- Ŭ���̾�Ʈ�� �����⸦ ��ٸ���
- ����ä�� Ŭ���̾�Ʈ�� ������ ������ ������ش�
--------------------------------------
Ŭ���̾�Ʈ���� ������ ���� �� �׸��� �ȵȴ�
�����κ��� ���� �� �׷����� �Ȱ��� �׷�����

������ ��� Ŭ���̾�Ʈ���� ������ ������
--------------------------------------
Java�� ����� 
- ��û�� �ϸ� �ݵ�� ������ �ؾ��Ѵ�. �������� ������ ���� (����)

AJax, jQuery...React�� �񵿱��
- ��û�� �ϸ� ������ ��ٸ��� �ʰ�, �� ���� �Ѵ�
- ��û�ϰ� ������� �� ������ �ٸ� ���� �ؾ��� �ϰ� ���α׷��� © �� ����
--------------------------------------
���� ������ �ּҴ� 192�� ����
*/
























