package collection;

import java.util.ArrayList;

public class PersonMain {
	
	public ArrayList<PersonDTO> init() { //init() ����
		PersonDTO aa = new PersonDTO("ȫ�浿", 25); //PersonDTO�� ������ ȣ��
		PersonDTO bb = new PersonDTO("���̾�", 30);
		PersonDTO cc = new PersonDTO("����ġ", 28);
		
		//return ���� �������� �� ArrayList�� ���� ���ۿ� ����
		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>(); //Generic ����
		list.add(aa); //ArrayList�� aa ���϶�
		list.add(bb);
		list.add(cc);
		
		return list; //���ϰ��� �����Ƿ� void�� ArrayList<PersonDTO>�� ����
	}//init()

	public static void main(String[] args) {
		PersonMain pm = new PersonMain();
		ArrayList<PersonDTO> list = pm.init(); //init() ȣ��, return�� �޾Ƽ� list�� ����
		System.out.println("list = "+list);
		//�⺻ �ּҰ��� Ŭ������@16�����ε� list�� Override�ؼ� �ּҰ��� [~~]�� �ٲ����
		
		for(int i=0; i<list.size(); i++) { //���⼭ i�� �ε���(��ġ)��
			System.out.println("�̸� = "+ list.get(i).getName() +"\t"+
							   "���� = "+ list.get(i).getAge());
		} //list.get(i)�� �ּҰ��� ����
		System.out.println();
		
		for(PersonDTO dto : list) { //ArrayList���� ���� �ϳ��� ���� PersonDTO�� �ش�
			System.out.println("�̸� = "+ dto.getName() + "\t���� = " + dto.getAge());	
		}
		System.out.println();
	}
}

/*
[������]
list = [(ȫ�浿	25), (���̾�	30), (����ġ	28)]
�̸� = ȫ�浿	���� = 25
�̸� = ���̾�	���� = 30
�̸� = ����ġ	���� = 28

�̸� = ȫ�浿	���� = 25
�̸� = ���̾�	���� = 30
�̸� = ����ġ	���� = 28
*/