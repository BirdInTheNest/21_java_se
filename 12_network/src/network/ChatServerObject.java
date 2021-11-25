package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServerObject {
	private ServerSocket serverSocket;
	private List<ChatHandlerObject> list;
	
	public ChatServerObject() { //������
		try {
			serverSocket = new ServerSocket(9500); //���� ���� ����
			System.out.println("���� �غ� �Ϸ�");
			
			list = new ArrayList<ChatHandlerObject>();
			//client�� handler�� 1:1 �����̹Ƿ�, handler�� �˸� client ��ο��� broadcast �� �� �ִ�
	
			while(true) {
				Socket socket = serverSocket.accept(); //����ä�� Ŭ���̾�Ʈ�� ������ ������ �����
				//Ŭ���̾�Ʈ�� �����⸦ ��ٸ��� ���� ��� ����, Ŭ���̾�Ʈ�� ���� �������� ���� ��ٸ���
				System.out.println("���� �Ǿ����ϴ�");

				//�� handler���� ������ socket�� broadcast�� �� �̿��� list �ʿ�
				ChatHandlerObject handler = new ChatHandlerObject(socket, list); //������ ����
				handler.start(); //������ ���� - ������ ���� run()

				list.add(handler); //list�� ChatHandler ��´�
				
			}//while
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//ChatServerObject()
	
	public static void main(String[] args) {
		new ChatServerObject();
	}
}
