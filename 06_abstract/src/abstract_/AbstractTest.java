package abstract_;

//POJO���� (Plain Old Java Object: �ܼ��� ������ Ŭ����)
public abstract class AbstractTest {
	String name;

	public abstract void setName(String name); //�߻�޼ҵ�
	
	public String getName() {
		return name;
	}
}

/*
��� : Ŭ������ �籸��, ������ ���ΰ� �� �� ũ�� ���׷��̵��ؼ� ������ ���� ��

�ڽ� Ŭ������ �����ϱ� ���Ͽ� �߻� Ŭ���� ���
������ �ο�

�߻�޼ҵ�� �߻�Ŭ������ ������ ��
AbstractTest must be an abstract class to define abstract methods

�߻�Ŭ������ �޸𸮿� ������ �ȵ�. new �߻�Ŭ����() �Ұ���
�ذ���
1. �ڽ�Ŭ���� : �߻�޼ҵ�� �ݵ�� Sub Class���� Override(�籸��) �� �����ؾ� �Ѵ�.
2. �޼ҵ�
3. �͸� Inner Ŭ���� 

Ŭ������ �⺻������ Object���� ��ӹ��� (extends Object ��������)
---------------------------------------------------------------
class AA {
	public final void sub(){} //�ڽ��� Override�ϸ� �ȵȴ�
	
	public abstract void sub(){} //�ڽ�Ŭ������ �ݵ�� Override���ֱ� ���ϸ� �߻�޼ҵ�� ����
}

class BB extends AA { 
	public void sub(){}
}

*/