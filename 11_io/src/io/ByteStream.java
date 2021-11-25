//ByteStream.java <--BufferedInputStream-- buffer <--FileInputStream-- data.txt

package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStream {

	public static void main(String[] args) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("data.txt"));
		int data;
		
		//read()는 1개의 문자씩 읽는다, 더 이상 읽을 문자가 없으면 -1을 가져옴
		while( (data = bis.read()) != -1) { //BufferedInputStream에서 read()로 가져온 값이 -1이 아니면
			System.out.print((char)data); //read()는 한글자씩 읽어서 숫자로 가져오기 때문에 형변환 필요
		}//while
		bis.close(); //BufferedInputStream 닫기
	}
}
