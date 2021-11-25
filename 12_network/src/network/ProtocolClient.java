package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//Client <--BufferedReader-- ���� <--InputStreamReader-- ���� <--socket.getInputStream-- ����
//		  -->BufferedWriter--	-->OutputStreamWriter--	   -->socket.getOutputStream--
//Reader ���� ����, InputStream ����Ʈ ����

public class ProtocolClient {
	private Socket socket; 
	private BufferedReader br, keyboard;
	private BufferedWriter bw;
	
	public ProtocolClient() { //������
		InetAddress local = null;
		
		try {
			local = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		try {
			socket = new Socket(local.getHostAddress(), 9500);//���� ����, ip, port �ʿ�
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));			
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			keyboard = new BufferedReader(new InputStreamReader(System.in));
			
		} catch (UnknownHostException e) {
			System.out.println("������ ã�� �� �����ϴ�");
			e.printStackTrace();
			System.exit(0); //���� ����
			
		} catch (IOException e) {
			System.out.println("������ ������ �� �Ǿ����ϴ�");
			e.printStackTrace();
			System.exit(0); //���� ����
		}
		
		String msg = null;
		String line = null;
		
		while(true) {
			try {
				//������ ������ ��, bw ��ü�� ó��
				System.out.print("������ �Է� : ");
				msg = keyboard.readLine(); //�� ��, ���� �������� �д´�
				
				bw.write(msg+"\n"); //"100:tea", "200:tea", "300:tea:�ȳ�"
				//���͸� �־���� �޴� �ʿ��� readLine()���� ���� �� �ִ�
				bw.flush();//���۸� ����� �� ���� �����͸� ��� ���� �� �ִ�
				
				//�����κ��� �޴� ��, br ��ü�� ó��
				line = br.readLine(); //"tea�� ����", "tea�� ����", "[tea] �ȳ�"
				System.out.println(line); //üũ
				
				String[] ar = msg.split(":"); //:�� �����ڷ� ���� "100","tea"
				if(ar[0].equals(Protocol.EXIT)) { //EXIT �̴ϱ� �� close �Ѵ�
					br.close(); //close�� ���ʿ��� �Ͼ�� ��
					bw.close();
					socket.close();
					
					keyboard.close();
					
					System.exit(0);
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//while
	}//ProtocolClient()
	
	public static void main(String[] args) {
		new ProtocolClient();
	}
}
