package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

//Client <--BufferedReader-- ���� <--InputStreamReader-- ���� <--socket.getInputStream-- ����
//		 -->BufferedWriter--	-->OutputStreamWriter--	   -->socket.getOutputStream--
//Reader ���� ����, InputStream ����Ʈ ����

public class ProtocolServer { 
	private ServerSocket serverSocket;
	private Socket socket;
	private BufferedReader br;
	private BufferedWriter bw;
	
	public ProtocolServer() { //���� ������ ������ Ŭ���̾�Ʈ�� �����ϱ⸦ ��ٸ���
		try {
			serverSocket = new ServerSocket(9500); //��Ʈ 9500
			System.out.println("���� �غ� �Ϸ�");
			
			socket = serverSocket.accept(); 
			//����ä�� Ŭ���̾�Ʈ�� ������ ������ ������ش�, ���� ���� ���� ��
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));			
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

		} catch (IOException e) {
			System.out.println("Ŭ���̾�Ʈ�� ������ ���� �ʾҽ��ϴ�");
			e.printStackTrace();
			System.exit(0); //���� ����
		} 
		
		String line = null;
		while(true) { //������ �޾Ƹ� ���Ҹ� �Ѵ�			
			try {
				//Ŭ���̾�Ʈ�κ��� �޴� ��
				line = br.readLine(); //�� ��, ���� ������ �д´�
									  //"100:tea", "200:tea", "300:tea:�ȳ�"

				//Ŭ���̾�Ʈ���� ������ ��
				String[] ar = line.split(":"); //�����ڷ� ��� ���� �����´�
				if(ar[0].equals(Protocol.ENTER)) {
					bw.write(ar[1]+"�� ����\n"); //"tea�� ����"
					//���͸� �־���� �޴� �ʿ��� readLine()���� ���� �� �ִ�
					bw.flush();
					
				}else if(ar[0].equals(Protocol.EXIT)) {
					bw.write(ar[1]+"�� ����\n"); //"tea�� ����"
					//���͸� �־���� �޴� �ʿ��� readLine()���� ���� �� �ִ�
					bw.flush();
					
					br.close(); //close�� ���ʿ��� �Ͼ�� ��
					bw.close();
					socket.close();
					
					System.exit(0);
					
				}else if(ar[0].equals(Protocol.SEND_MESSAGE)) {
					bw.write("["+ar[1]+"] "+ar[2]+"\n"); //"[tea] �ȳ�"
					//���͸� �־���� �޴� �ʿ��� readLine()���� ���� �� �ִ�
					bw.flush();
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//while	
	}//ProtocolServer()
	
	public static void main(String[] args) {
		new ProtocolServer();
	}
}

//Ŭ���̾�Ʈ�� �������̸� ���ѷ��� ������ ����æ��















