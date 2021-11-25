package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	private ServerSocket serverSocket;
	private List<ChatHandler> list;
	
	public ChatServer() { //������
		try {
			serverSocket = new ServerSocket(9500); //���� ���� ����
			System.out.println("���� �غ� �Ϸ�");
			
			list = new ArrayList<ChatHandler>();
			//client�� handler�� 1:1 �����̹Ƿ�, handler�� �˸� client ��ο��� broadcast �� �� �ִ�
	
			while(true) {
				Socket socket = serverSocket.accept(); //����ä�� Ŭ���̾�Ʈ�� ������ ������ �����
				//Ŭ���̾�Ʈ�� �����⸦ ��ٸ��� ���� ��� ����, Ŭ���̾�Ʈ�� ���� �������� ���� ��ٸ���
				System.out.println("���� �Ǿ����ϴ�");

				//�� handler���� ������ socket�� broadcast�� �� �̿��� list �ʿ�
				ChatHandler handler = new ChatHandler(socket, list); //������ ����
				handler.start(); //������ ���� - ������ ���� run()

				list.add(handler); //list�� ChatHandler ��´�
				
			}//while
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ChatServer();
	}
}

/*
����� ���� ChatServer�� �����尡 �� �� ����
������ �����带 ����� Ŭ���� ChatHandler�� �ʿ�

���� ä���� ChatClient�� ChatHandler�� �ϰ� �ȴ� (�����尡 ����)
ChatClient�� ChatHandler�� �� �� �����忩�� �Ѵ�
 */














