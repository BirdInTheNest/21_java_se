package nested;

//POJO ����
public abstract class AbstractTest { //�߻�Ŭ����(�߻�޼ҵ� ����)
	String name;

	public String getName() {
		return name;
	}

	public abstract void setName(String name); //�߻�޼ҵ�
	//�߻�޼ҵ尡 ������ �ݵ�� �߻�Ŭ������ �־�� ��, �ݵ�� �߻�޼ҵ带 Override �ؾ� ��
}
