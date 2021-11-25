/*
�� ��ü ����ȭ : Serializable
: Ŭ���� ��ü�� �����̳� ��Ʈ��ũ�� ������ �ȵǹǷ�, ��ü�� byte[] ��ȯ���Ѽ� �����ؾ� �Ѵ� 
  byte������ �ɰ��� ������ ������ ���� �ٽ� ��� ����
  ��ü ������ �������� �Ǵϱ� ObjectOutputStream ���
  
  *.java --ObjectOutputStream--> buffer --FileOutputStream--> file
 
 PersonDTO     --byte[]-->                   --byte[]-->     PersonDTO
 
 */

package io;

import java.io.Serializable;

public class PersonDTO implements Serializable { //Serializable �������̽��� �߻�޼ҵ尡 �ϳ��� ����
	private String name;
	private int age;
	private double height;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}	
}
