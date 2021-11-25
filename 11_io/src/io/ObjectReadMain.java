package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectReadMain {
	//IOException의 부모인 Throwable을 써도 됨
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("result2.txt"));

		PersonDTO dto = (PersonDTO)ois.readObject(); 
		//자식 PersonDTO = (자식 PersonDTO) 부모 Object
		
		System.out.println("이름 = "+dto.getName()); 
		System.out.println("나이 = "+dto.getAge());
		System.out.println("키 = "+dto.getHeight());

		ois.close(); //ObjectInputStream 닫기
	}
}
