package abstract_;

public class AbstractMain extends AbstractTest {
	
	@Override //�ݵ�� Override�ؾ��Ѵ�. ������ �ο�
	public void setName(String name) {
		this.name = name;
	}
	

	public static void main(String[] args) {
		//AbstractTest at = new AbstractTest(); //�߻��̶� new�� �� ����
		//�θ� = �ڽ�
		AbstractTest at = new AbstractMain(); //�ڽ�Ŭ������ �����Ѵ�
		at.setName("ȫ�浿");
		System.out.println(at.getName());

	}

}

/*
�� �߻�Ŭ���� - Sub class ����
1. �߻�ȭ �۾�
2. �޼ҵ忡 body {} �� ���� �޼ҵ带 �߻�޼ҵ��� �Ѵ�.
    �߻�޼ҵ忡�� abstract ��� Ű���带 ��� �Ѵ�
    �߻�޼ҵ�� {} body ���� ;�� ����Ѵ�
3. �߻�޼ҵ尡 �ִ� Ŭ������ �ݵ�� �߻�Ŭ�����̾�� �Ѵ�.
4. �߻�޼ҵ尡 ���� �߻�Ŭ������ �ǹ̻��� �߻�Ŭ������� �Ѵ�.
    �ǹ̻��� �߻�Ŭ������ �޼ҵ�� ��� ��body�� �Ǿ� �ִ�.
5. �߻�Ŭ������ �ڽ��� Ŭ������ �޸� ������ �� �� ����
    => �����Ϸ���
     ��. Sub Class�� �̿�(�ݵ�� Sub Class�� �߻�޼ҵ带 Override �ؾ� �Ѵ�)
     ��. �޼ҵ带 �̿�
6. �߻�޼ҵ�� �ݵ�� Sub Class���� Override �� �����ؾ� �Ѵ�.
    Override�� ���ϸ� Sub Class ������ abstract �� �Ǿ�� �Ѵ�.
    
    
    
    //�ƹ��� �ּҰ��� �θ�Ŭ������ �����ص� �������̵�Ǹ� �ڽ�Ŭ������ �޼ҵ带 �����ϰ� ��
*/




