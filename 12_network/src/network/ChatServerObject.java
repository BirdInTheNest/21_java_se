package network;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServerObject {
	private ServerSocket serverSocket;
	private List<ChatHandlerObject> list;
	
	public ChatServerObject() { //생성자
		try {
			serverSocket = new ServerSocket(9500); //서버 소켓 생성
			System.out.println("서버 준비 완료");
			
			list = new ArrayList<ChatHandlerObject>();
			//client와 handler가 1:1 연결이므로, handler만 알면 client 모두에게 broadcast 할 수 있다
	
			while(true) {
				Socket socket = serverSocket.accept(); //낚아채서 클라이언트와 연결할 소켓을 만든다
				//클라이언트가 들어오기를 기다리는 연결 대기 상태, 클라이언트가 물기 전가지는 그저 기다린다
				System.out.println("연결 되었습니다");

				//각 handler마다 각자의 socket과 broadcast할 때 이용할 list 필요
				ChatHandlerObject handler = new ChatHandlerObject(socket, list); //스레드 생성
				handler.start(); //스레드 시작 - 스레드 실행 run()

				list.add(handler); //list에 ChatHandler 담는다
				
			}//while
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}//ChatServerObject()
	
	public static void main(String[] args) {
		new ChatServerObject();
	}
}
