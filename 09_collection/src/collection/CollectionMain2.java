package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionMain2 {

	//@SuppressWarnings("all")
	@SuppressWarnings({"rawtypes", "unchecked"}) //2. ���� ���� ������̼� ���
	public static void main(String[] args) {
		//Collection<String> coll = new ArrayList<String>(); //1. ���ʸ����� Ÿ���� �ϳ��� �ɱ�
		
		Collection coll = new ArrayList();
		//ArrayList list = new ArrayList();
		coll.add("ȣ����");
		coll.add("����");
		coll.add("ȣ����"); //�ߺ����, ����
		coll.add(25);
		coll.add(43.8);
		coll.add("�⸰");
		coll.add("�ڳ���");
		
		Iterator it = coll.iterator(); //�����ڸ� �÷��� �ȿ� ���⵵�� �޼ҵ带 ���� ����
		while(it.hasNext()) { //it.hasNext() - ���� ��ġ�� �׸� ������ T, ������ F
			System.out.println(it.next()); //it.next() - ���� ��ġ�� �׸��� ������ �������� �̵�
		}//while
	}
}

/*
Warning(��� ����) : ������ ���� �ʴµ� �Ҿ��ϴ� 1. ���ʸ����� Ÿ���� �ϳ��� �ϰų�, 2. ���� ���� ������̼� ���

�� �ڹٰ� �����ϴ� ������̼�
1. @Override
2. @Deprecated
3. @SuppressWarnings(�ɼ�)

�ɼ�
1. all : ��� ��� ����
2. cast : ĳ��Ʈ ������ ���� ��� ����
3. dep-ann : ������� ���ƾ� �� �ּ� ���� ��� ����
4. deprecation : ������� ���ƾ� �� �޼ҵ� ���� ��� ����
5. fallthrough : switch�������� break ���� ���� ��� ����
6. finally : ��ȯ���� �ʴ� finally �� ���� ��� ����
7. null : null �м� ���� ��� ����
8. rawtypes : ���׸��� ����ϴ� Ŭ���� �Ű������� ��Ư���� ���� ��� ����
9. unchecked : �������� ���� ������ ���� ��� ����
10. unused : ������� �ʴ� �ڵ� ���� ��� ����
-----------------------------------------------------------------
�迭�� ũ�� length
���ڿ��� ũ�� length()
����Ʈ�� ũ�� size
*/