package interface_;

public interface InterA { //�������̽��� ����� �߻�޼ҵ常 ����, ���� �Ұ���
	public static final String NAME = "ȫ�浿"; //���ȭ
	int AGE=25; // public static final�� ��������
	
	public abstract void aa(); //�߻�޼ҵ�
	public void bb(); //abstract�� ��������
	
}

/*
�� interface (is~a ����)  (��ӹ��� ��ó�� ����)
1. ǥ�ظ����� ��Ȱ
2. ����� �߻�޼ҵ常 ����
    public static final�� ��������
    abstract�� ��������
3. interface�� implements �� Ŭ������ �ݵ�� �߻�޼ҵ带 Override(�籸��)���־�� �Ѵ�.
4. Override(�籸��) �Ҷ� �ݵ�� public�� �ٿ��� �Ѵ�.
5. ���߻���� ����
6. ��Ӱ� ���� ���϶��� extends, implements ������ ����.

[����]
interface �������̽��� {
   .....
}
class Ŭ������ implements �������̽���{
   ...
}
----------------------------------------------------------------------
Ŭ������, �������̽��� ù���ڴ� �빮��
Ŭ���� implements �������̽� 
 */
