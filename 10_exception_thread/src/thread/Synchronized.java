package thread;

public class Synchronized extends Thread {
	private static int count; //Ŭ���� ��ü ������ �ο��Ǵ� ���� �ƴ϶� ���������̱� ������ count�� ����

	public Synchronized() {
		System.out.println("this = "+this); //�ּҰ��� �� �ٸ��� ������ synchronized(this)�� ����ȭ x
	}
	
	public static void main(String[] args) {
		Synchronized aa = new Synchronized(); //Ŭ���� ����, ������ ����, �޸𸮿� ���� ����
		Synchronized bb = new Synchronized(); //Ŭ���� ����, ������ ����
		Synchronized cc = new Synchronized(); //Ŭ���� ����, ������ ����
		
		aa.setName("aa"); //������ �̸� �ο�
		bb.setName("bb"); //������ �̸� �ο�
		cc.setName("cc"); //������ �̸� �ο�
		
		aa.start(); //������ ����
		bb.start(); //������ ����
		cc.start(); //������ ����
	
	}

	@Override //������ ����� run()
	//public synchronized void run() { - ����ȭ x, aa, bb, cc�� Ŭ������ �ٸ��� ������ ����и� �ʿ�
	public void run() {	
		//synchronized(this) { - ����ȭ x
		synchronized(Synchronized.class) { //����и�� ����ȭ�϶�, �ѹ��� �ϳ���
			for(int i=1; i<=5; i++) {
				count++;
				System.out.println(Thread.currentThread().getName()+" : count="+count);
				
			}//for
		}
	}	
}
