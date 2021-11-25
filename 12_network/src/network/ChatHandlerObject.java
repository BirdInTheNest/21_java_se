package network;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ChatHandlerObject extends Thread {
	private Socket socket;
	private List<ChatHandlerObject> list;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	public ChatHandlerObject(Socket socket, List<ChatHandlerObject> list) throws IOException {
		this.socket = socket;
		this.list = list;
		
		//IO 생성 - 스레드는 IO를 가지고 있음
		//서버쪽에서는 출력 스트림을 먼저 생성해야 한다, 그렇지 않으면 입장메시지가 안 뜬다. 이유는 모름
		oos = new ObjectOutputStream(socket.getOutputStream());
		ois = new ObjectInputStream(socket.getInputStream());

	}//ChatHandler(Socket socket, List<ChatHandler> list)
	
	@Override
	public void run() {
		String nickName = null;
		InfoDTO dto = null; //받는 InfoDTO

		try {
			while(true) {
				//클라이언트로부터 받는 쪽
				dto = (InfoDTO)ois.readObject(); //받는 InfoDTO
				
				if(dto.getCommand() == Info.JOIN) {
					nickName = dto.getNickName();
					
					//나를 포함한 모든 클라이언트에게 입장메시지 보내기
					InfoDTO sendDTO = new InfoDTO(); //보내는 InfoDTO
					sendDTO.setCommand(Info.SEND);
					sendDTO.setMessage(nickName+"님 입장하였습니다");
					broadcast(sendDTO); //모든 클라이언트에게 보내기
					
				}else if(dto.getCommand() == Info.EXIT) { 
					break;
					
				}else if(dto.getCommand() == Info.SEND) {
					//나를 포함한 모든 클라이언트에게 메시지 보내기
					InfoDTO sendDTO = new InfoDTO();
					sendDTO.setCommand(Info.SEND);
					sendDTO.setMessage("["+nickName+"] "+dto.getMessage());
					broadcast(sendDTO);					
				}	
			}//while
			
			//quit을 보낸 클라이언트에게는 quit을 보내고 종료한다
			InfoDTO sendDTO = new InfoDTO();
			
			sendDTO.setCommand(Info.EXIT);
			oos.writeObject(sendDTO);
			oos.flush();
			
			ois.close();
			oos.close();
			socket.close();
			
			//남아 있는 클라이언트에게는 quit을 보낸 클라이언트의 퇴장 메시지를 보낸다
			list.remove(this);
			
			sendDTO.setCommand(Info.SEND);
			sendDTO.setMessage(nickName+"님 퇴장하였습니다");
			broadcast(sendDTO);	
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	
	}
	
	private void broadcast(InfoDTO sendDTO) {
		for(ChatHandlerObject handler : list) {
			try {
				handler.oos.writeObject(sendDTO);
				handler.oos.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}//for
	}//broadcast(InfoDTO sendDTO)
}
















