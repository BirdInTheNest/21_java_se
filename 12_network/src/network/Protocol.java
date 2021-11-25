package network;

public class Protocol { //좌표인지, 채팅인지 구분하기 위해서 앞에 프로토콜 걸어줌
	public static final String ENTER = "100";
	public static final String EXIT = "200";
	public static final String SEND_MESSAGE = "300";
}

/*
1. 서버 실행 - 서비스를 제공한다 (통신사)
	- ServerSocket
	- 무조건 클라이언트가 접속하기를 기다린다
	- 낚아채서(accept) 클라이언트와 대화할 소켓을 만든다 - 클라이언트 수 만큼 소켓을 만듦
	- 서버는 메아리 역할
	- 모든 이에게 다 뿌려줌, 자기자신에게도 뿌려줌, 모든 이가 다 사용하기 때문에 스레드 필요
----------------------
2. 클라이언트 실행
	- Socket (휴대폰)
	- 서버 IP, port
*/













