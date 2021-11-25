/*
 *.java --ObjectOutputStream--> buffer --FileOutputStream--> file
 
 PersonDTO     --byte[]-->                   --byte[]-->     PersonDTO
 */

package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectWriteMain { //DataStream 클래스는 dto에 담지 않고 값을 보냄

	public static void main(String[] args) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("result2.txt"));

		PersonDTO dto = new PersonDTO();
		dto.setName("홍길동");
		dto.setAge(25);
		dto.setHeight(185.3);
		
		oos.writeObject(dto); //dto에 담아서 한꺼번에 보내기
		oos.close(); //ObjectOutputStream 닫기
	}
}
