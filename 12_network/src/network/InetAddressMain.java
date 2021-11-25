package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain {

	public static void main(String[] args) throws UnknownHostException {
		//InetAddress는 추상클래스가 아니지만 기본 생성자가 없기 때문에 new 불가, 메소드 이용하여 생성
		//서버(호스트의 이름)을 넣으면 InetAddress 클래스를 만들어주겠다
		
		InetAddress naver = InetAddress.getByName("www.naver.com");
		System.out.println("NAVER IP = "+naver.getHostAddress());
		System.out.println();
		
		InetAddress local = InetAddress.getLocalHost();
		System.out.println("localhost IP = "+local.getHostAddress());
		System.out.println();
		
		InetAddress[] daum = InetAddress.getAllByName("www.daum.net");
		for(InetAddress ia : daum) { //for(int i=0; i<daum.length; i++)
			System.out.println("DAUM IP = "+ia.getHostAddress());
		}//for
		System.out.println();
	}
}
 /*
윈도우 환경에서 ip확인은 ipconfig임 (CMD)
리눅스 환경에서 ip학인은 ifconfig임
*/