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
		
		//IO ���� - ������� IO�� ������ ����
		//�����ʿ����� ��� ��Ʈ���� ���� �����ؾ� �Ѵ�, �׷��� ������ ����޽����� �� ���. ������ ��
		oos = new ObjectOutputStream(socket.getOutputStream());
		ois = new ObjectInputStream(socket.getInputStream());

	}//ChatHandler(Socket socket, List<ChatHandler> list)
	
	@Override
	public void run() {
		String nickName = null;
		InfoDTO dto = null; //�޴� InfoDTO

		try {
			while(true) {
				//Ŭ���̾�Ʈ�κ��� �޴� ��
				dto = (InfoDTO)ois.readObject(); //�޴� InfoDTO
				
				if(dto.getCommand() == Info.JOIN) {
					nickName = dto.getNickName();
					
					//���� ������ ��� Ŭ���̾�Ʈ���� ����޽��� ������
					InfoDTO sendDTO = new InfoDTO(); //������ InfoDTO
					sendDTO.setCommand(Info.SEND);
					sendDTO.setMessage(nickName+"�� �����Ͽ����ϴ�");
					broadcast(sendDTO); //��� Ŭ���̾�Ʈ���� ������
					
				}else if(dto.getCommand() == Info.EXIT) { 
					break;
					
				}else if(dto.getCommand() == Info.SEND) {
					//���� ������ ��� Ŭ���̾�Ʈ���� �޽��� ������
					InfoDTO sendDTO = new InfoDTO();
					sendDTO.setCommand(Info.SEND);
					sendDTO.setMessage("["+nickName+"] "+dto.getMessage());
					broadcast(sendDTO);					
				}	
			}//while
			
			//quit�� ���� Ŭ���̾�Ʈ���Դ� quit�� ������ �����Ѵ�
			InfoDTO sendDTO = new InfoDTO();
			
			sendDTO.setCommand(Info.EXIT);
			oos.writeObject(sendDTO);
			oos.flush();
			
			ois.close();
			oos.close();
			socket.close();
			
			//���� �ִ� Ŭ���̾�Ʈ���Դ� quit�� ���� Ŭ���̾�Ʈ�� ���� �޽����� ������
			list.remove(this);
			
			sendDTO.setCommand(Info.SEND);
			sendDTO.setMessage(nickName+"�� �����Ͽ����ϴ�");
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
















