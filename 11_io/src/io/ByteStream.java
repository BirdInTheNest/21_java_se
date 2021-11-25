//ByteStream.java <--BufferedInputStream-- buffer <--FileInputStream-- data.txt

package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStream {

	public static void main(String[] args) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream("data.txt"));
		int data;
		
		//read()�� 1���� ���ھ� �д´�, �� �̻� ���� ���ڰ� ������ -1�� ������
		while( (data = bis.read()) != -1) { //BufferedInputStream���� read()�� ������ ���� -1�� �ƴϸ�
			System.out.print((char)data); //read()�� �ѱ��ھ� �о ���ڷ� �������� ������ ����ȯ �ʿ�
		}//while
		bis.close(); //BufferedInputStream �ݱ�
	}
}
