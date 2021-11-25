package io;

import javax.swing.table.DefaultTableModel;

public interface Score {

	public void input(ScoreDTO dto); 
	
	public void print(DefaultTableModel model); //추상메소드
	
	public void search(DefaultTableModel model);
	
	public void tot_desc();

	public void save();

	public void load(); 

}

/*
Interface : Score.java - 추상메소드
Class	  : ScoreImpl.java
Class	  : ScoreImpl2.java
Class	  : ScoreImpl3.java

부모는 하나인데 밑에 자식은 여러개일 때는 부모로 참조해서 생성하는 것이 좋다 

ScoreImpl impl = new ScoreImpl(); //자식=자식 생성
Score score = new ScoreImpl(); //부모=자식 생성 - 결합도 낮추기
*/
















