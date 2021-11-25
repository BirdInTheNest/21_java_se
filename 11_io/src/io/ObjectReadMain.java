package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectReadMain {
	//IOException�� �θ��� Throwable�� �ᵵ ��
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("result2.txt"));

		PersonDTO dto = (PersonDTO)ois.readObject(); 
		//�ڽ� PersonDTO = (�ڽ� PersonDTO) �θ� Object
		
		System.out.println("�̸� = "+dto.getName()); 
		System.out.println("���� = "+dto.getAge());
		System.out.println("Ű = "+dto.getHeight());

		ois.close(); //ObjectInputStream �ݱ�
	}
}
