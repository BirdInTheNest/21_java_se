package com.zoo;

public class Zoo {
	public void tiger() { //public�� �� ���� ����
		System.out.println("������ ȣ����");
	}
	
	protected void giraffe() { //protected�� ���� ��Ű�� ���� ����, �ٸ� ��Ű���� �ڽ�Ŭ���� ���ٰ���
		System.out.println("���� �� �⸰");
	}
	
	void elephant() { //default�� ���� ��Ű�� ���� ����
		System.out.println("�׶��� �ڳ���");
	}
	
	private void lion() { //private�� ���� ���� ����
		System.out.println("���� ����");
	}
}

/*
�� ���������� (Modifier)
			Ŭ����	���� ��Ű��		�ٸ� ��Ű��		�ٸ� ��Ű���� �ڽ� Ŭ����
private		  O		   X			X				X
default		  O		   O			X				X
protected	  O		   O			X				O
public		  O		   O			O				O

�� default��� ���� ���� ���� �ƴ϶� 
   public, protected, private �� ���� ���� ����

�� protected�� �ٸ� ��Ű������ Sub Ŭ������� ������ �����ϴ�
   �� Sub Ŭ������ �����ؾ߸� �Ѵ�
   SuperŬ������ �����ϸ� ������ �ȵȴ�
  
  ���� ��Ű���� private�� ���� �� ���� ����
  �ٸ� ��Ű���� public���θ� ���� ���� (���� ���� public)
*/