package collection;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionMain3 { 

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>(); //1. Generic Ÿ�� �ϳ��� �ɱ�
		list.add("ȣ����");
		list.add("����");
		list.add("ȣ����"); //Collection�� �ߺ����, ���� ����
		//list.add(25);
		//list.add(43.8);
		list.add("�⸰");
		list.add("�ڳ���");
		
		//���
		Iterator it = list.iterator(); //����
		while(it.hasNext()) { //it.hasNext() - ���� ��ġ�� �׸� ������ T, ������ F
			System.out.println(it.next()); //it.next() - ���� ��ġ�� �׸��� ������ �������� �̵�
		}//while
		System.out.println("------------");
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}//for
		System.out.println("------------");
		
		for(String data : list) {
			System.out.println(data);
		}//for
	}
}
