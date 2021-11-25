package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

//	ArrayList<SungJukDTO> list = new ArrayList<SungJukDTO>(); ArrayList�� �θ�� List�̹Ƿ�
//	List<SungJukDTO> list = new ArrayList<SungJukDTO>(); �θ� = �ڽ����� �����ϴ� ���� �� ����
//	Generic�� Ŭ���� ������ ������ Ÿ���� ����� �ش�.
//	ArrayList Ŭ������ �����ϴµ�, ������ Ÿ���� <SungJukDTO>�� ����Ͽ�, <SungJukDTO> �����͸� ����

public class SungJukService {
	Scanner scan = new Scanner(System.in);
	private List<SungJukDTO> list;
	
	public SungJukService() { //������
		list = new ArrayList<SungJukDTO>(); //�θ� = �ڽ�(������)
	}

	public void menu() {
		int num;		
		while(true) {
			System.out.println();
			System.out.println("****************");
			System.out.println("	1. �Է�");
			System.out.println("	2. ���");
			System.out.println("	3. �˻�");
			System.out.println("	4. ����");
			System.out.println("	5. ����");
			System.out.println("	6. ��");
			System.out.println("****************");
			System.out.print("��ȣ : ");
			num = scan.nextInt();
		      
			if(num==6) break;
			if(num==1) insertArticle();
			else if(num==2) printArticle();
			else if(num==3) searchArticle();
			else if(num==4) deleteArticle();
			else if(num==5) sortArticle();
			else System.out.println("1~6 �߿� �����ϼ���");
		}//while
	}//menu()
	
	private void insertArticle() { //�Է�
		System.out.println();
		System.out.print("��ȣ �Է� :");
		int num = scan.nextInt();
		System.out.print("�̸� �Է� :");
		String name = scan.next();
		System.out.print("���� �Է� :");
		int kor = scan.nextInt();
		System.out.print("���� �Է� :");
		int eng = scan.nextInt();
		System.out.print("���� �Է� :");
		int math = scan.nextInt();

		//�����Ͱ��� �������ϱ� dto�� �����ϸ鼭 �����͸� ����
		SungJukDTO dto = new SungJukDTO(num, name, kor, eng, math); 
		dto.calc(); //����, ��� ���
		
		//1�κ��� �����͸� ������ dto�� �������ϱ� ArrayList�� ����� ����, ���� �����ϴ� �� �ƴ϶� �ּҰ��� ������
		//list�� Ŭ�����ϱ� �������� SungJukDTO�� �޸𸮿��� �������� ����

		list.add(dto); 
		//System.out.println(list); //list�� toString()�� Override�ؼ� Ŭ@16���� --> [~,~,] �ٲ�

		System.out.println("��� �Ϸ�");
		
	}//insertArticle()
	
	private void printArticle() { //���
		System.out.println();
		System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
		for(SungJukDTO dto : list) { 
			System.out.println(dto);
		}	

//		����Ʈ ũ�⸸ŭ for�� ������ list�� i��° �ּҰ����� ���� SungJukDTO�� �̸��� �����͵� ������, 
//		Ȯ���� for������ ���� �������� ���� �� ����
		
//		for(int i=0; i<list.size(); i++) {
//			System.out.println(list.get(i).getName());
//		} 		
	}//printArticle()
	
	private void searchArticle() { //�˻�
		System.out.println();
		System.out.print("�˻� �� �̸� �Է� : ");
		String findName = scan.next();
		int sw=0; //switch ���� ����
		
		for(SungJukDTO dto : list) {
			if(findName.equals(dto.getName())) { //findName�� ���ڿ��� dto���� ������ �̸��� ������
				if(sw==0) System.out.println("��ȣ\t�̸�\t����\t����\t����\t����\t���");
				System.out.println(dto);
				sw=1; //dto �����͸� ������ ���� 1��
			}
		}//for	
		
		if(sw==0)
			System.out.println("ã���� �ϴ� �̸��� �����ϴ�.");
		
	}//searchArticle()
	
	private void deleteArticle() { //����
		System.out.println();
		System.out.print("������ �̸� �Է� : ");
		String name = scan.next();
		int sw=0; //switch ���� ����
		
		Iterator<SungJukDTO> it = list.iterator(); //����, Iterator�� �������̽��� new�� ���� �� ��.
		while(it.hasNext()) { //it�� ���� �ִ���, �׸��� ������ T ������ F
			SungJukDTO dto = it.next(); //���� �׸��� ������ �������� �̵�, �����͸� ������ dto�� ����
			
			if(dto.getName().equals(name)) { //dto���� ������ �̸��� ������ �̸��� ������
				it.remove(); //it�� ����Ű�� ���� ��ġ�� ����� �� �ƴ϶�, �Ʊ� dto�� �־���� ���� ����� ����
				sw=1; //dto�� �ִ� �����͸� �����ϸ� ���� 1��
			}
		}//while
		
		if(sw==0) 
			System.out.println("ã���� �ϴ� �̸��� �����ϴ�.");
		else			
			System.out.println("�����͸� �����Ͽ����ϴ�.");

//		list.size(����Ʈ�� ũ��)�� for���� ������ list ���� �����͸� �����ϸ� �� �ȴ�
//		����Ʈ�� �����͸� �����ϸ� ����Ʈ�� ũ�⵵ ���� �ٱ� ������, ����Ʈ �ȿ� �ִ� �׸���� �ε����� ���ŵȴ�. 
//		���� Iterator�� ����Ͽ� ����Ʈ�� �ִ� �׸���� ���� dto�� �����ϰ�, �� ������ dto�� �����ؾ� �Ѵ�. 

//		for(int i=0; i<list.size(); i++) { 
//			if(list.get(i).getName().equals(name)) { 
//				list.remove(list.get(i));
//				sw=1; 
//			}
//		} //error �߻�
		
	}//deleteArticle()

	private void sortArticle() { //����
		System.out.println();
		int num;
		
		while(true) {
			System.out.println();
			System.out.println("*****************");
			System.out.println("	1. �̸����� ��������");
			System.out.println("	2. �������� ��������");
			System.out.println("	3. �����޴�");
			System.out.println("*****************");
			System.out.print("��ȣ");
			num = scan.nextInt();
			if(num==3) break;
			
//			Comparable / Comparator �������̽��� new�� �ȵ�, �͸� �̳� Ŭ���� {} �̿��Ͽ� ����
//			Comparable�� �⺻ ���ı����� �����ϴµ� ����ϸ�, �⺻������ ������������ ���ĵǵ��� �����Ǿ� �ִ�
//			Comparator�� �⺻ ���ı��� �ܿ� �ٸ� �������� �����ϰ����� �� ����Ѵ�
//			�񱳴���ڰ� �� ũ��(<) -1, ���ٸ�(==) 0, ������(>) 1�� ��ȯ�Ѵ�
			
			if(num==1) { 
//				Comparator<SungJukDTO> com = new Comparator<SungJukDTO>() { 
//					@Override
//					public int compare(SungJukDTO s1, SungJukDTO s2) {
//						return s1.getName().compareTo(s2.getName());
//					}
//				};
//				
//				Collections.sort(list, com); //Comparator�� ����
//				printArticle();
				
//				SungJukDTO Ŭ�������� Comparable<SungJukDTO> �����س��Ƽ� Comparable ���� ��� ����			
				Collections.sort(list); //Comparable�� ����
				printArticle(); //���

			}else if(num==2) {
				Comparator<SungJukDTO> com = new Comparator<SungJukDTO>() {
					@Override
					public int compare(SungJukDTO s1, SungJukDTO s2) {
						//���ǿ����� : ���� ? �� : ����;
						//return s1.getTot() > s2.getTot() ? 1 : -1; //���ڴϱ� ���� �� ����, ��������
						return s1.getTot() > s2.getTot() ? -1 : 1; //��������
					}
				};
				
				Collections.sort(list, com); //Comparator�� ����
				printArticle(); //���
			}
		}//while
	}//sortArticle()
}