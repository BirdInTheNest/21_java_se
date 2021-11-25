package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

//Client <--BufferedReader-- 버퍼 <--InputStreamReader-- 소켓 <--socket.getInputStream-- 소켓
//		 -->BufferedWriter--	-->OutputStreamWriter--	   -->socket.getOutputStream--
//Reader 문자 단위, InputStream 바이트 단위

public class ProtocolServer { 
	private ServerSocket serverSocket;
	private Socket socket;
	private BufferedReader br;
	private BufferedWriter bw;
	
	public ProtocolServer() { //서버 소켓은 무조건 클라이언트가 접속하기를 기다린다
		try {
			serverSocket = new ServerSocket(9500); //포트 9500
			System.out.println("서버 준비 완료");
			
			socket = serverSocket.accept(); 
			//낚아채서 클라이언트와 연결할 소켓을 만들어준다, 서버 소켓 역할 끝
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));			
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

		} catch (IOException e) {
			System.out.println("클라이언트와 연결이 되지 않았습니다");
			e.printStackTrace();
			System.exit(0); //연결 끊기
		} 
		
		String line = null;
		while(true) { //서버는 메아리 역할만 한다			
			try {
				//클라이언트로부터 받는 쪽
				line = br.readLine(); //한 줄, 엔터 전까지 읽는다
									  //"100:tea", "200:tea", "300:tea:안녕"

				//클라이언트에게 보내는 쪽
				String[] ar = line.split(":"); //구분자로 끊어서 값을 가져온다
				if(ar[0].equals(Protocol.ENTER)) {
					bw.write(ar[1]+"님 입장\n"); //"tea님 입장"
					//엔터를 넣어줘야 받는 쪽에서 readLine()으로 읽을 수 있다
					bw.flush();
					
				}else if(ar[0].equals(Protocol.EXIT)) {
					bw.write(ar[1]+"님 퇴장\n"); //"tea님 퇴장"
					//엔터를 넣어줘야 받는 쪽에서 readLine()으로 읽을 수 있다
					bw.flush();
					
					br.close(); //close는 양쪽에서 일어나야 함
					bw.close();
					socket.close();
					
					System.exit(0);
					
				}else if(ar[0].equals(Protocol.SEND_MESSAGE)) {
					bw.write("["+ar[1]+"] "+ar[2]+"\n"); //"[tea] 안녕"
					//엔터를 넣어줘야 받는 쪽에서 readLine()으로 읽을 수 있다
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

//클라이언트가 여러명이면 무한루프 돌려서 낚아챈다















