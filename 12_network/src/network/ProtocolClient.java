package network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//Client <--BufferedReader-- 버퍼 <--InputStreamReader-- 소켓 <--socket.getInputStream-- 소켓
//		  -->BufferedWriter--	-->OutputStreamWriter--	   -->socket.getOutputStream--
//Reader 문자 단위, InputStream 바이트 단위

public class ProtocolClient {
	private Socket socket; 
	private BufferedReader br, keyboard;
	private BufferedWriter bw;
	
	public ProtocolClient() { //생성자
		InetAddress local = null;
		
		try {
			local = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		try {
			socket = new Socket(local.getHostAddress(), 9500);//소켓 생성, ip, port 필요
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));			
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			keyboard = new BufferedReader(new InputStreamReader(System.in));
			
		} catch (UnknownHostException e) {
			System.out.println("서버를 찾을 수 없습니다");
			e.printStackTrace();
			System.exit(0); //연결 끊기
			
		} catch (IOException e) {
			System.out.println("서버와 연결이 안 되었습니다");
			e.printStackTrace();
			System.exit(0); //연결 끊기
		}
		
		String msg = null;
		String line = null;
		
		while(true) {
			try {
				//서버로 보내는 쪽, bw 객체가 처리
				System.out.print("데이터 입력 : ");
				msg = keyboard.readLine(); //한 줄, 엔터 전까지만 읽는다
				
				bw.write(msg+"\n"); //"100:tea", "200:tea", "300:tea:안녕"
				//엔터를 넣어줘야 받는 쪽에서 readLine()으로 읽을 수 있다
				bw.flush();//버퍼를 비워야 그 다음 데이터를 계속 보낼 수 있다
				
				//서버로부터 받는 쪽, br 객체가 처리
				line = br.readLine(); //"tea님 입장", "tea님 퇴장", "[tea] 안녕"
				System.out.println(line); //체크
				
				String[] ar = msg.split(":"); //:를 구분자로 나눔 "100","tea"
				if(ar[0].equals(Protocol.EXIT)) { //EXIT 이니까 다 close 한다
					br.close(); //close는 양쪽에서 일어나야 함
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
