package io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStream2 {

	public static void main(String[] args) throws IOException {
		//������ �̸��� �˰� ������ ������ ũ�⸦ ������ ���ϱ� ������, ������ �˾ƾ� �Ѵ�
		File file = new File("data.txt");
		int size = (int)file.length(); //���� ũ�⸦ long���� ��µ� int�� �� �� ������ ĳ���� �ʿ�
		
		byte[] b = new byte[size]; //���� ũ�⸸ŭ byte �迭 ����
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		bis.read(b, 0, size); //byte[] b�� 0�� ����� ������ ũ���� size��ŭ �о��
		
		System.out.println(new String(b)); //�迭�� for������ ���� ������ �ϴϱ� String���� ��ȯ�ؼ� ����
		bis.close(); //BufferedInputStream �ݱ�
	}
}