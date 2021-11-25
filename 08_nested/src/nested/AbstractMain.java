package nested;

public class AbstractMain {

	public static void main(String[] args) {
		//AbstractTest at = new AbstractTest(); - error: �߻�Ŭ������ new �� �� ����
		AbstractTest at = new AbstractTest() { //�͸� Inner Class(����)
			@Override
			public void setName(String name) { //�޼ҵ��� �����θ� ���� �� �ִ� �� Ŭ����

			}
		}; //�͸� Inner Class
		
		//�������̽��� new�� �� x, �͸� Inner Class�� new�Ͽ� �������̽� ����
		InterA in = new InterA() { 
			@Override
			public void aa() {}
			@Override
			public void bb() {}
		}; 
		
		//AbstractExam ae = new AbstractExam(); -error: �߻�Ŭ������ �޸� ���� �Ұ�
		AbstractExam ae = new AbstractExam() { //�͸� Inner Class(����)
			//Override �ص� �ǰ� �� �ص� �ǰ� 
		};
	}
}

/*
�߻�Ŭ����
1. �ڽ� Ŭ���� �̿��Ͽ� ����
2. �޼ҵ� �̿��Ͽ� ����
3. �͸� Inner Ŭ���� �̿��Ͽ� ���� - new Ŭ����(){}; - �͸� Inner Class(����)

AbstractMain.java
AbstractMain.class
AbstractMain$1.class - ù��° �͸��Դϴ�
--------------------------------------------------
�������̽�
1. implements - ��� �߻�޼ҵ�� Override �ؾ���
2. ��� implements���ִ� Ŭ���� �̿��Ͽ� ����
3. �޼ҵ� �̿��Ͽ� ����
4. �͸� Inner Ŭ���� �̿��Ͽ� ���� - new �������̽�(){}; - �͸� Inner Class(����)
*/