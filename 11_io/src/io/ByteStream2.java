package io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStream2 {

	public static void main(String[] args) throws IOException {
		//파일의 이름만 알고 있으면 파일의 크기를 구하지 못하기 때문에, 파일을 알아야 한다
		File file = new File("data.txt");
		int size = (int)file.length(); //파일 크기를 long으로 줬는데 int에 들어갈 수 없으니 캐스팅 필요
		
		byte[] b = new byte[size]; //파일 크기만큼 byte 배열 생성
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		bis.read(b, 0, size); //byte[] b를 0번 방부터 파일의 크기인 size만큼 읽어라
		
		System.out.println(new String(b)); //배열은 for문으로 값을 꺼내야 하니까 String으로 변환해서 찍어라
		bis.close(); //BufferedInputStream 닫기
	}
}