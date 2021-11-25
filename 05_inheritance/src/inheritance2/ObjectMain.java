package inheritance2;

class Test extends Object { //Ŭ������ �ֻ��� Ŭ���� Object�� ��ӹ���(default), extends Object ��������
	@Override //�θ�Ŭ������ �ڽ�Ŭ������ Override�� �޼ҵ尡 �ִٸ�, �θ� �� ���õǰ� �ڽ� �ŷ� ó���� 
	public String toString() {
		return getClass() + "@���ٺ�"; //Override ��ӹ޾ұ� ������ �θ� �� ���õǰ� �ڽ� �ŷ� ó���� 
	}
}
//---------------
class Sample extends Object { 
	
}
//---------------
public class ObjectMain {

	public static void main(String[] args) { //main �޼ҵ�
		Test t = new Test();
		System.out.println("��ü t = " + t); //�ּҰ� ����
		System.out.println("��ü t = " + t.toString()); //��ü�� ���ڿ��� ��ȯ
		System.out.println();
		
		Sample s = new Sample();
		System.out.println("��ü s = " + s.toString()); //��ü�� ���ڿ��� ��ȯ: Ŭ����@16����
		System.out.println("��ü s = " + s.hashCode()); //��ü�� 10������ ��ȯ: 10����
		System.out.println();
		
		String str = "apple";
		System.out.println("��ü str = " + str.toString()); //��ü�� ���ڿ��� ��ȯ: ���ڿ�
		System.out.println("��ü str = " + str.hashCode()); //��ü�� 10������ ��ȯ: 10����
		//���ڿ��� ���Ѵ�� ������ �� �ֱ� ������, ������� ���ڿ��� 10������ �� ǥ������ ���Ѵ�.
		System.out.println();
		
		String aa = new String("apple");
		String bb = new String("apple");
		System.out.println("aa==bb : " + (aa == bb)); //�ּҺ� false
		System.out.println("aa.equals(bb) : " + (aa.equals(bb))); //���ڿ��� true
		System.out.println();
		
		Object cc = new Object();
		Object dd = new Object();
		System.out.println("cc==dd : " + (cc == dd)); //�ּҺ� false
		System.out.println("cc.equals(dd) : " + (cc.equals(dd))); //�ּҺ� false
		System.out.println(); //ObjectŸ���̱� ������ equals�� ��� �ּҺ��ϴ� ����
		
		Object ee = new String("apple");
		Object ff = new String("apple");
		System.out.println("ee==ff : " + (ee == ff)); //�ּҺ� false
		System.out.println("ee.equals(ff) : " + (ee.equals(ff))); //���ڿ��� true
		//Override�� �Ǹ� �ڽİ� �����ϱ� ������, String�� equals�� �����ϱ� ������ ���ڿ��񱳰� �Ǵ� ����
		//���ڿ������� �������̵� ���ױ� ������ Ŭ����@16���� �� �ƴ϶� ���ڿ����� ǥ����
		
		
	}

}

/*
class Object {
	public String toString() 		//Ŭ����@16����
	public int hashCode() 			//10����
	public boolean equals(Object)	//�ּ� ��
}

final class String { 				//final class �����δ� �ڽ��� ������ ����
	public String toString() 		//���ڿ� - String Ŭ������ �������� �������̵��ؼ� �θ�� �����ϰ� ���� ó���ؼ� ���ڿ��� ����
	public int hashCode() 			//10����(���Ѵ�� ������ �� �ִ� ���ڿ��� �� ǥ�������� ���Ѵ�)
	public boolean equals(Object) 	//���ڿ� ��
}

int�� 40�� �����ۿ� ǥ���ȵ�.
(���ڿ��� ���Ѵ�� ������ �� ����)


�ּ��� ǥ����� �� �ϳ� : Collection -> ArrayList [~~~]
--------------------------------------
[������]
��ü t = class inheritance2.Test@���ٺ�
��ü t = class inheritance2.Test@���ٺ�

��ü s = inheritance2.Sample@1175e2db
��ü s = 292938459

��ü str = apple
��ü str = 93029210

aa==bb : false
aa.equals(bb) : true

cc==dd : false
cc.equals(dd) : false

ee==ff : false
ee.equals(ff) : true
*/