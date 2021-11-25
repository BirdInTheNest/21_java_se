package thread;

class JoinTest implements Runnable{ //JoinTest�� �����尡 �ǰ� �ʹ�

	@Override //�������̽� Runnable�� �߻�޼ҵ� run() Override �ϱ�
	public void run() {
		for(int i=1; i<=5; i++) {
			System.out.println("i = "+i);
		}
	}	
}
//-------------
public class JoinMain {

	public static void main(String[] args) {
		JoinTest jt = new JoinTest(); //������ ������ �� �ƴ�
		Thread t = new Thread(jt); //jt(JoinTest)�� ������� ����
		
		System.out.println("������ ����");
		t.start(); //������ ���� - ������ ����(run()) �ü���� �˾Ƽ� ����
		try {
			t.join(); //�����尡 �װ� �������� ��. �� ������ �� ������ ���� ������ �Ѿ
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("������ ����");
	}
}

/*
JOIN
join()�޼ҵ�� �����尡 ���� ������ ��ٸ��� �Ѵ�.
������ ������ ��� ���� ���� �Ǵ� �ɷ� �˰� �ִµ� ������� �׷��� �ʴ�. 
������ ����Ǿ ����ó�� ��׶��忡�� ������� ���ư���.
�׷��� join�� ����ϸ� �ش� �����尡 ����Ǳ���� ��ٷȴٰ� �������� �Ѿ��.
*/