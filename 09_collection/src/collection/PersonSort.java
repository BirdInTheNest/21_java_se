package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class PersonSort {

	public static void main(String[] args) {
		String[] ar = {"orange", "apple", "banana", "pear", "peach", "applemango"};
	
		System.out.print("���� �� = ");
		for(String str : ar) {
			System.out.print(str + "  ");
		} //���� �� = orange  apple  banana  pear  peach  applemango
		System.out.println(); 
		
		Arrays.sort(ar); //ar�� �迭�̶� Arrays.sort() ���
		
		System.out.print("���� �� = ");
		for(String str : ar) {
			System.out.print(str + "  ");
		} //���� �� = apple  applemango  banana  orange  peach  pear 
		System.out.println("\n");

		PersonDTO aa = new PersonDTO("ȫ�浿", 25); 
		PersonDTO bb = new PersonDTO("���̾�", 30);
		PersonDTO cc = new PersonDTO("����ġ", 28);
		
		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		
		System.out.println("���� �� : ");
		System.out.println(list); //list�� �ּҰ��� �׸��� ������
		System.out.println();
		
		Collections.sort(list);	//ArrayList�� Collections.sort() ���, Comparable�� ����
		
		System.out.println("���̷� ��������(��������) : ");
		System.out.println(list);
		System.out.println();
		
		System.out.println("�̸����� ��������(��������) : ");
		//Comparator�� �⺻ ���ı��� �ܿ� �ٸ� �������� �����ϰ����� �� ���
		//Comparator�� �������̽��� new�� �ȵ�, �͸� inner class�� �����ؾ���
		Comparator<PersonDTO> com = new Comparator<PersonDTO>() {
			@Override //�߻�޼ҵ� compare Override�ؾ���
			public int compare(PersonDTO dto1, PersonDTO dto2) { //���� �ΰ� ��
				//��������
				//return dto1.getName().compareTo(dto2.getName()); 
				//dto1���� ������ ���ڿ� ���� dto2���� ������ ���ڿ� �� ��
				//compareTo : �񱳴���ڰ� �� ũ��(<) -1, ���ٸ�(==) 0, ������(>) 1�� ��ȯ
				
				//��������
				//return dto2.getName().compareTo(dto1.getName());
				return dto1.getName().compareTo(dto2.getName()) * -1; //�ε�ȣ �ٲٱ�
			}
		};
		
		Collections.sort(list, com); //����Ʈ �ȿ� �ִ� ���� Comparator�� sort���ּ���
		System.out.println(list);
		System.out.println();
	}
}

/*
[������]
���� �� = orange  apple  banana  pear  peach  applemango  
���� �� = apple  applemango  banana  orange  peach  pear  

���� �� : 
[(ȫ�浿	25), (���̾�	30), (����ġ	28)]

���̷� ��������(��������) : 
[(���̾�	30), (����ġ	28), (ȫ�浿	25)]

�̸����� ��������(��������) : 
[(ȫ�浿	25), (����ġ	28), (���̾�	30)]
---------------------------------------------------------------
���ڿ��� ���� ���� �ּҰ��� �ִ�, �ѱ��ھ� ��

�� Comparable / Comparator �������̽�
��ü�� �����ϴµ� �ʿ��� �޼ҵ尡 ���ǵǾ� �ִ�
�񱳴���ڰ� �� ũ��(<) -1, ���ٸ�(==) 0, ������(>) 1�� ��ȯ�����ݴϴ�. 
�� ���� ���Ͽ� ������ �� �� �ֽ��ϴ�.

�Ϲ����� int, char, double ���� Ÿ���� �迭�̶�� ���� �Լ����� �̿�
Collections(�Ǵ� Arrays).sort()       : ���� 
Collectoins(�Ǵ� Arrays).reverse()    : ������

1. Comparable (java.lang)
- �⺻ ���ı����� �����ϴµ� ���
�ַ� Integer�� ���� warpperŬ������ String, Date, File�� ���� ��
�⺻������ ������������ ���ĵǵ��� �����Ǿ� �ִ�
- public int compareTo(T o)

public final class Integer
extends Number
implements Comparable<Integer>

2. Comparator (java.util)
- �⺻ ���ı��� �ܿ� �ٸ� �������� �����ϰ����� �� ���
- public int compare(T o1, T o2)
  public boolean equals(Object obj)
*/