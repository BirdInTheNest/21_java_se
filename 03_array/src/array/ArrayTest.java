/*
�� ����(variable) - �޸� �Ҵ�(instance)

1. �⺻��		2. ��ü��						3. �迭��

�ڷ��� ������;	Ŭ������ ��ü��	= new Ŭ������();	�ڷ���[] �迭�� = {��1, ��2,...};
boolean a;	String a = new String();	int[] ar = {��, ��, ��};   
char a;		String a = "hello";			int[] ar = {1, 2, 3};
int	a;										
double a;								�ڷ���[] �迭�� = new �ڷ���[����];
										int[] ar = new int[����];
 										int[] ar = new int[3];
 										ar[0]=1;
										ar[1]=2;
										ar[2]=3;
										
										�ڷ���[] �迭�� = new int[]{��1, ��2,...};
										int [] ar = new int[]{1, 2, 3};

										String[] ar = {"apple", "banana", "orange"};
										String[] ar = new String[3]; //��ü�迭(Ŭ����Ÿ���� ������ ����)
 */

/*
�� Array (�迭)
1. ������ �ڷ����� ����
2. �������� �޸� �Ҵ�
3. ÷�ڰ� 0���� ����
4. �ѹ� ���� �迭�� ũ��� ������ �� ���� (�߰� ������ �� ��)
 */


package array;

public class ArrayTest {

	public static void main(String[] args) {
		int[] ar; 
		ar = new int[5];
		ar[0]=27; 
		ar[1]=36;
		ar[2]=25;
		ar[3]=78;
		ar[4]=62;
		
		System.out.println("�迭�� ar = "+ar); //ar�� �ּҰ�(Ŭ������@16����) ����
		
		System.out.println("�迭 ũ�� = "+ar.length); //�迭 ũ��: �迭 ���� ����
		for(int i=0; i<ar.length; i++) {
			System.out.println("ar["+i+"] = "+ar[i]);	
		}//for i
		System.out.println();
		
		System.out.println("�Ųٷ� ���");
		for(int i=ar.length-1; i>=0; i--) {
			System.out.println("ar["+i+"] = "+ar[i]);	
		}//for i
		System.out.println();
		
		System.out.println("¦�� �����͸� ���");	 //ar[i]�� �����Ͱ� ����	
		for(int i=0; i<ar.length; i++) {
			if(ar[i]%2 == 0) System.out.println("ar["+i+"] = "+ar[i]);
		}//for i
		System.out.println();
		
		System.out.println("Ȯ�� for"); //ar �ּҿ� �ִ� �����Ͱ��� int data�� �־��ִ� �� �ݺ�, ���ο� ���� �������
		for(int data : ar) {
			System.out.println(data);
		}//for data	
	}
}

/*
[������]
�迭�� ar = [I@123a439b
�迭 ũ�� = 5
ar[0] = 27
ar[1] = 36
ar[2] = 25
ar[3] = 78
ar[4] = 62

�Ųٷ� ���
ar[4] = 62
ar[3] = 78
ar[2] = 25
ar[1] = 36
ar[0] = 27

¦�� �����͸� ���
ar[1] = 36
ar[3] = 78
ar[4] = 62

Ȯ�� for
27
36
25
78
62
*/