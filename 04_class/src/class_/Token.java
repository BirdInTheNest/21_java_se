package class_;

import java.util.StringTokenizer;

public class Token {

	public static void main(String[] args) {
		String str = "�п�,��,,���ӹ�";
											
		StringTokenizer st = new StringTokenizer(str, ","); //StringTokenizer Ŭ������ ��ü st ���� 
															//���ڿ� str�� ,�� �������� �и��϶�
		System.out.println("��ū ���� = "+ st.countTokens()); //3�� - "�п�","��","���ӹ�"
		 
		while(st.hasMoreTokens()) { //hasMoreTokens() - ���� ��ġ�� ��ū�� ������(T), ������(F)
			System.out.println(st.nextToken()); //nextToken() - ��ū�� ������ ���� ��ġ�� �̵�
		}//while - ������ ���� ��� �ݺ�
		System.out.println("------------------------------");
		
		String[] ar = str.split(","); //String�� �迭 ����
		for(String data : ar) {
			System.out.println(data);
		}
	}  
}

/*
�� StringTokenizer(java.util)Ŭ������ StringŬ������ split()
1. ���ڿ��� �и��� �� ��� (���ڿ�, ���ع���) - ���ڿ��� ���ع��ڸ� �������� �и��϶�.
2. �и��� ���ڿ��� Token�̶�� �Ѵ�.
3. StringTokenizer�� ����ִ� ���� �����ϰ� split()�� ����ִ� ���� �ν��Ѵ�.
---------------------------------------------------------------
StringTokenizer				StringŬ������ split()
"�п�"						"�п�"
"��"							"��"
"���ӹ�"						""
							"���ӹ�"
---------------------------------------------------------------
�迭.length : ��ɾ�
���ڿ�.length() : �޼ҵ�
---------------------------------------------------------------
hasMoreTokens() - ���� ��ġ�� ��ū�� ������(T), ������(F)		
nextToken() - ��ū�� ������ ���� ��ġ�� �̵�					
*/

/*
[������]
��ū ���� = 3
�п�
��
���ӹ�
------------------------------
�п�
��

���ӹ�
*/