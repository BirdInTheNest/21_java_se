package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetMain { //Set�� add�� �ְ�

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>(); 
		//�߻�޼ҵ带 ��� Override ���ִ� Ŭ������ ����, Generic Ÿ�� �ɱ�
		set.add("ȣ����");
		set.add("����");
		set.add("ȣ����"); //Set�� �ߺ���� x, ���� x (�÷��ǰ� �ݴ���)
		set.add("�⸰");
		set.add("�ڳ���");
		
		Iterator<String> it = set.iterator(); //����
		while(it.hasNext()) {
			System.out.println(it.next());
		}//while
	}
}
