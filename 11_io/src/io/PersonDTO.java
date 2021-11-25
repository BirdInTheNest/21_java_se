/*
★ 객체 직렬화 : Serializable
: 클래스 객체는 파일이나 네트워크로 전송이 안되므로, 객체를 byte[] 변환시켜서 전송해야 한다 
  byte단위로 쪼개서 보내고 저장할 때는 다시 묶어서 저장
  객체 단위로 움직여야 되니까 ObjectOutputStream 사용
  
  *.java --ObjectOutputStream--> buffer --FileOutputStream--> file
 
 PersonDTO     --byte[]-->                   --byte[]-->     PersonDTO
 
 */

package io;

import java.io.Serializable;

public class PersonDTO implements Serializable { //Serializable 인터페이스는 추상메소드가 하나도 없음
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
