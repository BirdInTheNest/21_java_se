/*
★ IO Stream (입출력 처리)

* 단위
1. byte 단위 처리 (숫자, 영문자) - byte 스트림
    InputStream  	(추상클래스이기 때문에 new할 수 없다 -> 자식 클래스 이용)
    OutputStream 
    
- BufferedOutputStream
- DataOutputStream
		writeint()
		writeDouble()
- PrintStream (제일 선호함)
		println()

BufferedOutputStream이나 DataOutputStream은 자료형에 따라 메소드 이름이 달라져서 타입이 다르면 쓸 수가 없음
PrintStream은 가지고 있는 모든 메소드가 Overload 되어 타입을 가리지 않고 println으로 통일되어 있음

2. 문자(char-2byte)단위 처리(숫자, 영문자, 한글)-문자 스트림
    Reader   
    Writer 

출력시 파일 없으면 자동으로 파일 생성
입력시 파일 없으면 Error (FileNotFoundException)
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
		
		dos.writeUTF("홍길동");
		dos.writeInt(25);
		dos.writeFloat(185.3f); //자바에서 실수형은 디폴트값이 double임
		
		dos.close();
		
		DataInputStream dis = new DataInputStream(new FileInputStream("result.txt"));
		
		System.out.println("이름 = "+dis.readUTF()); //파일은 들어간 순서대로 나옴
		System.out.println("나이 = "+dis.readInt());
		System.out.println("키 = "+dis.readFloat()); //자료형을 따져야 함
		
		dis.close();
	}
}