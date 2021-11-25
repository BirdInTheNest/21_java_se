package network;

import java.io.Serializable;

//네트워크를 오고 가는 것이 문자열이 아니라 InfoDTO 단위로 전송된다

enum Info{
	JOIN, EXIT, SEND
}

public class InfoDTO implements Serializable {
	private String nickName;
	private String message;
	private Info command;
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Info getCommand() {
		return command;
	}
	public void setCommand(Info command) {
		this.command = command;
	}
}

//BufferedReader, PrintWrier 쓰지 마시오
//ObjectInputStream, ObjectOutputStream 사용하세요

//readLine(), println() 쓰지 마시오
//readObject(), writeObject() 사용하세요