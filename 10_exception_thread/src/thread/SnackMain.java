package thread;

class SnackTest extends Thread { //Thread Ŭ������ ���
	private String str;
	
	public SnackTest(String str) { //������
		this.str = str;
	}
	
	public void run() {
		for(int i=1; i<=5; i++) {
			System.out.println(str+"\t i = "+i+"\t"+Thread.currentThread());
			//Thread.currentThread() : ���� �������� ������ ���
		}
	}
}
//------------
public class SnackMain { 

	public static void main(String[] args) {
		SnackTest aa = new SnackTest("�����"); //������ ����
		SnackTest bb = new SnackTest("��īĨ");
		SnackTest cc = new SnackTest("Ȩ����");
		
		//������ �̸� �ο�
		aa.setName("�����"); //Thread-0 -> �����
		bb.setName("��īĨ"); //Thread-1 -> ��īĨ
		cc.setName("Ȩ����"); //Thread-2 -> Ȩ����
		
		//�켱����(default : 5, 1~10 ���� �ο�, �������� �켱���� ����, but �ü�� ���������)
		//aa.setPriority(10);	//aa.setPriority(Thread.MAX_PRIORITY); //10
		//bb.setPriority(Thread.MIN_PRIORITY); //1
		//cc.setPriority(Thread.NORM_PRIORITY); //normal, 5
		
		aa.start(); //������ ���� -> ������ ���� run() (������� �ü���� ���� �����)
		
		try {
			aa.join(); //������ ���̱� -> aa�� ���� ������ bb�� cc�� block����
		} catch (InterruptedException e) { //Interrupted : �ܺ� �ڱ�
			e.printStackTrace();
		} 
		
		bb.start();
		cc.start();
	}
}

/*
�� ���μ���(process)
: ���� �������� ���α׷�

�� ��Ƽ���μ���(��Ƽ�½�ŷ)
: �ϳ��� cpu�� �������� �������α׷��� ���ÿ� ����
: �ú��ҽý���

�� Thread
1. ���� ���α׷� (������ ���α׷�)
2. main �޼ҵ嵵 �ϳ��� �������̴�
3. ������ �����Ϸ��� run()�� ����� �ȴ�

�� ��Ƽ������
�ϳ��� ���α׷����� ���� ���� ������(�������α׷�)�� ���ÿ� �����ϴ� ���� �ǹ��Ѵ�.
(�����带 ª�� �ð����� �����ϰ� �� �ٸ� �����带 ª�� �ð����� �����Ѵ�)

1. �������
�� Thread Ŭ������ ���
�� Runnable �������̽��� �̿�  (Runnable : ���డ�ɻ���)

2. ó�� 
������ ���� -> ������ ����(start()) -> ������ ����(run())�� �ü���� �˾Ƽ� (Running : ���� ����)
--------------------------------------------------------------------------------
�켱����
�ý����� busy�� �� �켱������ ���� �����忡�� ���� CPU�� �Ҵ��� �ش�
��Ƽ�������� ������ ���ϴ� ���� ������ �����ٸ�(thread scheduling)�̶�� �Ѵ�
������ �����ٸ� ��Ŀ��� �� ���� ����� �ִµ� �켱����(priority)��İ� ��ȯ �Ҵ�(Round-Robin)��� �ִ�
��ȯ �Ҵ����� �����尡 ����� �ð��Ҵ緮�� ���ϰ� �Ҵ緮�� �ð���ŭ �����带 �����Ű�� �� �ٸ� �����带 �����Ű�� ��� 
��ȯ �Ҵ����� JVM(�ڹ� ���� ���)�� ���� �����Ǳ� ������ �������� ���Ƿ� ������ �� ����.
�����ڰ� ����� �� �ִ� �켱���� ����� �� �״�� � �����带 �켱������ ó������ �켱������ �ο��ϴ� ����̴�.
�켱������ 1���� 10���� �ο��� �� �ְ� 1�� ���� ���� 10�� ���� ����. 
�켱������ Thread Ŭ������ setPriority() �޼ҵ�� ������ �ο��� �� �ִ�.

//Ű����ũ ���α׷�, pc�� ���� ���α׷� ���� ������� ���� ���ƾ� ��
--------------------------------------------------------------------------------
[������]
�����	 i = 1	Thread[Thread-0,5,main]
��īĨ	 i = 1	Thread[Thread-1,5,main]
�����	 i = 2	Thread[Thread-0,5,main]
�����	 i = 3	Thread[Thread-0,5,main]
Ȩ����	 i = 1	Thread[Thread-2,5,main]
�����	 i = 4	Thread[Thread-0,5,main]
Ȩ����	 i = 2	Thread[Thread-2,5,main]
�����	 i = 5	Thread[Thread-0,5,main]
Ȩ����	 i = 3	Thread[Thread-2,5,main]
��īĨ	 i = 2	Thread[Thread-1,5,main]
Ȩ����	 i = 4	Thread[Thread-2,5,main]
��īĨ	 i = 3	Thread[Thread-1,5,main]
��īĨ	 i = 4	Thread[Thread-1,5,main]
��īĨ	 i = 5	Thread[Thread-1,5,main]
Ȩ����	 i = 5	Thread[Thread-2,5,main]
*/