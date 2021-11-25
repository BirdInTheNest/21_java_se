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
	
	public ChatClientObject() { //������
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
				//���� ��ü InfoDTO�� IO�� ���ؼ� ������ ������ �Ұ�. ��ü�� ���ſ��� �Ѿ �� ����
				//��ü�� byte[]�� ��ȯ�� ������� �Ѵ� (��ü ����ȭ - InfoDTO�� Serializable)
				
				InfoDTO dto = new InfoDTO();
				dto.setCommand(Info.EXIT); //�������� �׸� ���´ٰ� �޽��� ����
				
				try {
					oos.writeObject(dto);
					oos.flush();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//�̺�Ʈ
		sendBtn.addActionListener(this);
		input.addActionListener(this); //JTextField���� enterĥ ��
		
	}//ChatClientObject()
	
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
			
			//IO ���� - ������� IO�� ������ ����
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			
			//�г����� ������ ������
			InfoDTO dto = new InfoDTO();
			dto.setCommand(Info.JOIN);
			dto.setNickName(nickName);
			oos.writeObject(dto);
			oos.flush();
			
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
		InfoDTO dto = null; //dto�� ������ dto�� �ޱ� ������ new�� �ʿ� ����
		
		while(true) {		
			try {
				dto = (InfoDTO)ois.readObject(); //�����κ��� InfoDTO�� �´�, �ڽ� = (�ڽ�)�θ�

				if(dto.getCommand() == Info.EXIT) { 
					ois.close();
					oos.close();
					socket.close();
					
					System.exit(0);
					
				}else if(dto.getCommand() == Info.SEND) {
					output.append(dto.getMessage()+"\n"); 
					//readObject()�� ���Ͱ� �� �����ϱ� ������ �ο�
					int pos = output.getText().length(); //JTextArea���� ������ ���ڿ��� ����
					output.setCaretPosition(pos);
					//���콺 Ŀ��(caret)�� �������� pos�� ���߸� ��ũ�ѹٰ� �ڵ����� ������					
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
		//������ ������ ��
		String line = input.getText(); //JTextField���� ������ ���ڿ� ��
				
		InfoDTO dto = new InfoDTO();
		if(line.toLowerCase().equals("quit")) {
			dto.setCommand(Info.EXIT);
		}else {
			dto.setCommand(Info.SEND);
			dto.setMessage(line);
		}
		
		try {
			oos.writeObject(dto); //������ ������
			oos.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		} 
		
		input.setText(""); //JTextField �ʱ�ȭ
		
	}//actionPerformed(ActionEvent e)
	
	public static void main(String[] args) {
		new ChatClientObject().service();
	}
}









