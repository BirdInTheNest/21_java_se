package collection;

class GenericTest2<T>{ //Generic: ����Ÿ������ �𸣴ϱ� Ŭ���� ������ <T> Type(��������)���� �����ص�
	private T a;
	
	public GenericTest2(T a) { //�����ڴ� new �Ҷ� 1�� ȣ��, �����ڿ� setter�� �ϴ� ���� ����
		this.a = a;
	} 
	
	public void setA(T a) { //setter�� �ַ� �����Ҷ� ���
		this.a = a;
	}
	
	public T getA() {
		return a;
	}	
}
//----------------
public class GenericMain2 {

	public static void main(String[] args) {
		GenericTest2<?> aa = new GenericTest2<String>("ȫ�浿"); //? �� ����ϸ� Object�� �ν�
		//aa.setA("ȫ�浿"); - error, ? �� ����ϸ� �ݵ�� �����ڸ� ���ؼ� �����͸� �Է¹޴´�
		String name = (String)aa.getA(); //aa.getA()�� ������Ʈȭ �ż� ĳ���� �ʿ�
		System.out.println("�̸� = "+name);
		
		GenericTest2<?> bb = new GenericTest2<Integer>(25);
		int age = (Integer)bb.getA(); //bb.getA()�� ������Ʈȭ �ż� ĳ���� �ʿ�
		//AutoUnBoxing ��ü�� Integer�� �⺻�� int�� ����
		System.out.println("���� = "+age);
	}
}

/*
�ڷ���
1. �⺻��
2. ��ü��

AutoBoxing �⺻���� ��ü������ ����(��üȭ)
AutoUnBoxing ��ü���� �⺻������ ����(��üȭ�� Ǭ��)
*/