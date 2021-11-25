package inheritance2;

public class FinalMain {
	public final String FRUIT = "���"; //final ������ �빮�ڷθ� ����ϸ�, ���� ������ �� ����, �ݵ�� �ʱⰪ�� �־�� ��
	public final String FRUIT2; //Ŭ������ final �ʵ忡�� �ʱⰪ�� ���� �ʾ��� ���� �����ڸ� ���ؼ� ��ü �ʱ�ȭ

	public static final String ANIMAL = "ȣ����"; //���ȭ�� ���� public static final �̷��� ����
	public static final String ANIMAL2; //Ŭ������ static final �ʵ忡�� �ʱⰪ�� ���� �ʾ��� ���� static�������� �ʱ�ȭ
	
	static { //static final �ʵ�� static �������� �ʱⰪ�� �־�� ��
		ANIMAL2 = "�⸰";
	}
	
	public FinalMain() { //final �ʵ�� �����ڿ��� �ʱⰪ�� �־�� ��
		FRUIT2 = "����"; //�ʱ�ȭ
	}
	
	public static void main(String[] args) {
		final int AGE = 25;
		//AGE = 30; - error: final�̱� ������ ������ �� ����
		System.out.println("AGE = " + AGE);

		final int AGE2; //C������ final ������ �ʱ�ȭ�� ������ error ��
		AGE2 = 30; //JAVA�� final ������ �ʱⰪ�� �� ��ȸ�� �ѹ� �� ��
		System.out.println("AGE2 = " + AGE2);
		
		FinalMain aa = new FinalMain();
		System.out.println("FRUIT = " + aa.FRUIT);
		System.out.println("FRUIT2 = " + aa.FRUIT2);
		
		System.out.println("ANIMAL = " + FinalMain.ANIMAL);
		System.out.println("ANIMAL2 = " + FinalMain.ANIMAL2);
	}
}

/*
�� ���(Constant)
: ������ �ʴ� ��
: ���� �빮�ڷ� ����Ѵ�.
-------------------------------------------------------
�� final (���ȭ)
1. final ������ ���� ������ �� ����.
2. final ������ �ݵ�� �ʱⰪ�� �־�� �Ѵ�.
   final �ʵ�� �����ڿ��� �ʱⰪ�� �־�� �Ѵ�
   static final �ʵ�� static �������� �ʱⰪ�� �־�� �Ѵ�
3. final ������ �빮�ڷθ� ���
4. final �޼ҵ�� Override�� �� �� ����.
5. final Ŭ������ �ڽ�Ŭ������ ���� �� ����.- ����� �ȵȴ�
-------------------------------------------------------
class AA {
	public final void sub(){}
}

class BB extends AA {
	public void sub(){} - error: Override �� ��
}
-------------------------------------------------------
final class String { //class �տ� final�� �ֱ� ������ ��� �ȵ�

}

class Test extends String {

}
-------------------------------------------------------
[������]
AGE = 25
AGE2 = 30
FRUIT = ���
FRUIT2 = ����
ANIMAL = ȣ����
ANIMAL2 = �⸰
*/