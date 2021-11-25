/*
�� IO Stream (����� ó��)

* ����
1. byte ���� ó�� (����, ������) - byte ��Ʈ��
    InputStream  	(�߻�Ŭ�����̱� ������ new�� �� ���� -> �ڽ� Ŭ���� �̿�)
    OutputStream 
    
- BufferedOutputStream
- DataOutputStream
		writeint()
		writeDouble()
- PrintStream (���� ��ȣ��)
		println()

BufferedOutputStream�̳� DataOutputStream�� �ڷ����� ���� �޼ҵ� �̸��� �޶����� Ÿ���� �ٸ��� �� ���� ����
PrintStream�� ������ �ִ� ��� �޼ҵ尡 Overload �Ǿ� Ÿ���� ������ �ʰ� println���� ���ϵǾ� ����

2. ����(char-2byte)���� ó��(����, ������, �ѱ�)-���� ��Ʈ��
    Reader   
    Writer 

��½� ���� ������ �ڵ����� ���� ����
�Է½� ���� ������ Error (FileNotFoundException)
 */

package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStream {

	public static void main(String[] args) throws IOException {
		DataOutputStream dos = new DataOutputStream(new FileOutputStream("result.txt"));
		
		dos.writeUTF("ȫ�浿");
		dos.writeInt(25);
		dos.writeFloat(185.3f); //�ڹٿ��� �Ǽ����� ����Ʈ���� double��
		
		dos.close();
		
		DataInputStream dis = new DataInputStream(new FileInputStream("result.txt"));
		
		System.out.println("�̸� = "+dis.readUTF()); //������ �� ������� ����
		System.out.println("���� = "+dis.readInt());
		System.out.println("Ű = "+dis.readFloat()); //�ڷ����� ������ ��
		
		dis.close();
	}
}