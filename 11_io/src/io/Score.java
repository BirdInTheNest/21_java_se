package io;

import javax.swing.table.DefaultTableModel;

public interface Score {

	public void input(ScoreDTO dto); 
	
	public void print(DefaultTableModel model); //�߻�޼ҵ�
	
	public void search(DefaultTableModel model);
	
	public void tot_desc();

	public void save();

	public void load(); 

}

/*
Interface : Score.java - �߻�޼ҵ�
Class	  : ScoreImpl.java
Class	  : ScoreImpl2.java
Class	  : ScoreImpl3.java

�θ�� �ϳ��ε� �ؿ� �ڽ��� �������� ���� �θ�� �����ؼ� �����ϴ� ���� ���� 

ScoreImpl impl = new ScoreImpl(); //�ڽ�=�ڽ� ����
Score score = new ScoreImpl(); //�θ�=�ڽ� ���� - ���յ� ���߱�
*/
















