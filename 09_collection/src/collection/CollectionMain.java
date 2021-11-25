package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionMain {

	public static void main(String[] args) {
		Collection coll = new ArrayList(); //�߻�޼ҵ带 ��� Override ���ִ� Ŭ������ ����
		//ArrayList list = new ArrayList(); //�߻�Ŭ���� �ƴϹǷ� new ����
		coll.add("ȣ����");
		coll.add("����");
		coll.add("ȣ����"); //Collection�� �ߺ����, ���� ����
		coll.add(25);
		coll.add(43.8);
		coll.add("�⸰");
		coll.add("�ڳ���");
		
		Iterator it = coll.iterator(); //�÷����� �����ڸ� �޼ҵ带 ���� ����
		while(it.hasNext()) { //it.hasNext() - ���� ��ġ�� �׸� ������ T, ������ F
			System.out.println(it.next()); //it.next() - ���� ��ġ�� �׸��� ������ �������� �̵�
		}//while
	}
}

/*
�� Collection (java.util)
: ��ü�� ����ִ� ���� â��
: ��ü Ÿ�Կ� ������� ���� ����
: ũ�� ���� ����

# Enumeration
# Iterator
------------------------------------------------------------------------
Interface
1. implements
	��� �߻� �޼ҵ带 Override
2. �߻�޼ҵ带 ��� Override ���ִ� Ŭ������ ���� (Implementing Class)
------------------------------------------------------------------------
Interface Collection�� Implementing Classes

Stack (Last In First Out)
LinkedList
Queue (First In First Out)
ArrayList - �迭ó�� ���, Object�� �����͸� �ްڴ�, �ε��� ����
------------------------------------------------------------------------
Interface Set�� Implementing Classes

HashSet
------------------------------------------------------------------------
Interface Map�� Implementing Classes

HashMap
*/