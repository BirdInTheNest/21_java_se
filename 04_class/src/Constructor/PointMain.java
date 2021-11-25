package Constructor;

public class PointMain {
	private int x, y;
	
	public PointMain(){ //�����ڿ� void���� �ȵ�
		x = y = 10;
	}
	public PointMain(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void calcPlus() { //�޼ҵ� ����
		x += 10;
	}
	
	public void calcPlus(int x, int y) { //Overload //�⺻���� ���� ��
		this.x += x;
		this.y += y;
	}
	
	public PointMain(PointMain aa, PointMain bb) { //��ü�� Ŭ�������� ���� ��
		this.x = aa.x + bb.x;
		this.y = aa.y * bb.y;
	}

	public static void main(String[] args) {
		PointMain aa = new PointMain();
		System.out.println("x = "+aa.x + "\t y = "+aa.y);
		
		System.out.println("\n x�� ���� +10 �����ϴ� �޼ҵ带 �ۼ��Ͻÿ� - calcPlus()");
		aa.calcPlus(); //�޼ҵ� ȣ��
		System.out.println("x = "+aa.x + "\t y = "+aa.y);
		System.out.println();
		
		PointMain bb = new PointMain(100, 200);
		System.out.println("x = "+bb.x + "\t y = "+bb.y);
		
		System.out.println("\n 3, -8�� �μ��� �޾Ƽ� x�� ����, y�� �����ϴ� �޼ҵ带 �ۼ��Ͻÿ� - calcPlus()");
		bb.calcPlus(3, -8);
		System.out.println("x = "+bb.x + "\t y = "+bb.y);
		System.out.println();
		
		System.out.println("\n x�� aa�� x���� bb�� x���� ���ϰ�, y������ ���ϱ�");
		PointMain cc = new PointMain(aa, bb);
		System.out.println("x = "+cc.x + "\t y = "+cc.y);
		System.out.println();
		
	}

}//class PointMain

/*
[������]
x = 10	 y = 10

 x�� ���� +10 �����ϴ� �޼ҵ带 �ۼ��Ͻÿ� - calcPlus()
x = 20	 y = 10

x = 100	 y = 200

 3, -8�� �μ��� �޾Ƽ� x�� ����, y�� �����ϴ� �޼ҵ带 �ۼ��Ͻÿ� - calcPlus()
x = 103	 y = 192


 x�� aa�� x���� bb�� x���� ���ϰ�, y������ ���ϱ�
x = 123	 y = 1920
 */


/*
�����ڿ� setter�� ���� ������ ��

������				setter
- Ŭ������
- �ڵ�ȣ�� (1�� ó��)	- ����ȣ�� (��� ������ ���Ҷ�)
 */
