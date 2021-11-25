package collection;

class GenericTest<T>{
	private T a;
	
	public void setA(T a) {
		this.a = a;
	}
	public T getA() {
		return a;
	}	
}
//----------------
public class GenericMain {

	public static void main(String[] args) {
		GenericTest<String> aa = new GenericTest<String>(); //Ŭ���� ������ Ÿ���� ����� �ش�
		aa.setA("ȫ�浿");
		System.out.println("�̸� = "+aa.getA());
		
		//aa.setA(25); - error 
		GenericTest<Integer> bb = new GenericTest<Integer>(); //<>�ȿ��� Ŭ�������� ����
		bb.setA(25);
		System.out.println("���� = "+bb.getA());	
	}
}

/*
�� Generic
: ���׸��� �������� Ÿ���� �������� �ʰ� ������ �� Ÿ���� �����ǹǷ� ���� ������ ���α׷����� �����ϴ�
: ���� �߿� Ÿ�� �浹 ������ ������ �� �ִ�
: ���α׷� ���� �� Ÿ�� ĳ���� ������ �ʿ� �������� ClassCastException�� ���� �� �� �ִ�
: Ŭ���� ������ Ÿ���� ����� �ش�.
: <T> <E> <K> <V> 4���� ���ڷ� ǥ���Ѵ� 

<T> Type(��������)
: ����� ������ Ÿ���� �����Ѵ�.
: ? �� ����ϸ� Object�� �ν��Ѵ�.
: ? �� ����ϸ� �ݵ�� �����ڸ� ���ؼ� �����͸� �Է¹޴´�.
<E> Element(���, �׸�)
<K> Key
<V> Value

*/