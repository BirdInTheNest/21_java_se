package network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressMain {

	public static void main(String[] args) throws UnknownHostException {
		//InetAddress�� �߻�Ŭ������ �ƴ����� �⺻ �����ڰ� ���� ������ new �Ұ�, �޼ҵ� �̿��Ͽ� ����
		//����(ȣ��Ʈ�� �̸�)�� ������ InetAddress Ŭ������ ������ְڴ�
		
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
������ ȯ�濡�� ipȮ���� ipconfig�� (CMD)
������ ȯ�濡�� ip������ ifconfig��
*/