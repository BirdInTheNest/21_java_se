/*
 do{
   ������ ���� �� ����(�ݺ�), �����̸� ����
 }while(����);
 */

/*
1 2 3 4 5 6 7 8 9 10 ����Ͻÿ�

A~Z���� ����Ͻÿ�. ��, 1�ٿ� 7���� ����Ͻÿ�.
	
[������]
1 2 3 4 5 6 7 8 9 10

A B C D E F G
H I J K L M N
O P Q R S T U
V W X Y Z
 */	

package while_;

public class DoWhileTest {

	public static void main(String[] args) {
		
		int a=0;
		
		do {
			a++; // 1 2 3...
			System.out.print(a+" ");
		}while(a<10);
		
		System.out.println("\n");
		
		
		char ch='A';
		int count=0;
				
		do {
			System.out.print(ch+" ");
			ch++; //B C D...
			count++; //do while�� �ݺ��� Ƚ��
			
			if(count%7==0) System.out.println(); //1�ٿ� 7���� ���
			
		}while(ch<='Z');
	}
}
