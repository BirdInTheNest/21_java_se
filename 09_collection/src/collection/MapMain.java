package collection;

import java.util.HashMap;
import java.util.Map;

public class MapMain { //Map�� put���� �ְ�, Key �̸�, Value ������ ����

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		//�߻�޼ҵ带 ��� Override ���ִ� Ŭ������ ����, Generic Ÿ�� �ɱ�, Key �̸�, Value ��
		map.put("book101", "�鼳����");
		map.put("book201", "�ξư���");
		map.put("book102", "�鼳����"); //Value �ߺ����
		map.put("book301", "�ǿ���");
		map.put("book101", "��������"); //Key �ߺ����, Value�� ���
		
		System.out.println(map.get("book102")); //�鼳����
		System.out.println(map.get("book103")); //Key���� ������ ����� null�� ��
		System.out.println(map.get("book101")); //��������
	}
}
