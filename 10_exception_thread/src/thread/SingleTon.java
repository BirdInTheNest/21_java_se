package thread;

//�̱��� : static �޸� ����, �޸𸮿� �� 1�� �����ؼ� ��� �ҷ��� ����ϰڴ�
public class SingleTon {
	private int num=3;
	private static SingleTon instance=null; //�ʱⰪ, ó�� �� 1���� null�̰� �� �������� �ƴ�
	
	public static SingleTon getInstance() { //�޼ҵ� �̸��� getInstance�� ����
		synchronized(SingleTon.class) { //�ѹ��� �ϳ��� ���
			if(instance == null)
					instance = new SingleTon();//ó�� �� 1���� ����						
		}
		
		return instance; //SingleTon Ŭ������ ��ȯ�ϴϱ� SingleTon getInstance()�� �ٲ�
	}//getInstance()

	public static void main(String[] args) {
		SingleTon aa = new SingleTon();
		aa.num++;
		System.out.println("aa = " + aa); //Ŭ������@16����
		System.out.println("num = " + aa.num); //4
		System.out.println();
		
		SingleTon bb = new SingleTon();  //new�� ������ �޸𸮿� ��� �������
		bb.num++;
		System.out.println("bb = " + bb); //Ŭ������@16����
		System.out.println("num = " + bb.num); //4
		System.out.println();
		
		System.out.println("--- �̱��� ---");
		SingleTon cc = SingleTon.getInstance(); //���� ��ü�� ����Ų��
		cc.num++;
		System.out.println("cc = "+cc);//Ŭ������@16����
		System.out.println("num = " + cc.num); //4
		System.out.println();
		
		SingleTon dd = SingleTon.getInstance();
		dd.num++;
		System.out.println("dd = "+dd);//Ŭ������@16���� - ���� ��ü�� ����Ų��
		System.out.println("num = " + dd.num); //5
		System.out.println();
	}
}

