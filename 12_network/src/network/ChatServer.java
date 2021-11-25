package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	private ServerSocket serverSocket;
	private List<ChatHandler> list;
	
	public ChatServer() { //생성자
		try {
			serverSocket = new ServerSocket(9500); //서버 소켓 생성
			System.out.println("서버 준비 완료");
			
			list = new ArrayList<ChatHandler>();
			//client와 handler가 1:1 연결이므로, handler만 알면 client 모두에게 broadcast 할 수 있다
	
			while(true) {
				Socket socket = serverSocket.accept(); //낚아채서 클라이언트와 연결할 소켓을 만든다
				//클라이언트가 들어오기를 기다리는 연결 대기 상태, 클라이언트가 물기 전가지는 그저 기다린다
				System.out.println("연결 되었습니다");

				//각 handler마다 각자의 socket과 broadcast할 때 이용할 list 필요
				ChatHandler handler = new ChatHandler(socket, list); //스레드 생성
				handler.start(); //스레드 시작 - 스레드 실행 run()

				list.add(handler); //list에 ChatHandler 담는다
				
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
절대로 서버 ChatServer는 스레드가 될 수 없다
서버의 스레드를 대신할 클래스 ChatHandler가 필요

실제 채팅은 ChatClient와 ChatHandler가 하게 된다 (스레드가 돈다)
ChatClient와 ChatHandler는 둘 다 스레드여야 한다
 */














