/*
�� �ݺ���
1. for
[����]
 for(������=�ʱ�ġ; ����ġ; ����ġ){			 
     ������ ���� �� ����						
 }									 	 

for(A; B; C) {
	D
}	    
[�������]
A B(���� ��) D {C B(���� ��) D} {C B(���� ��) D} {C B(���� ��) D}
*/

//�ڹ��� ������ ����ִ� �����Ⱓ : ���� {}

package for_;
public class ForTest {
	public static void main(String[] args) {
		int i;
		for(i=1; i<=10; i++) {
			System.out.println("�ȳ��ϼ��� "+i);
		} //for
		
		System.out.println("Ż�� i = "+i);
		System.out.println();
		
		//10 9 8 7 6 5 4 3 2 1
		for(i=10; i>=1; i--) {
			System.out.print(i+" ");
		} //for
		System.out.println(); 
		
		//A(65) B C D E F G... X Y Z(90)
		for(i='A'; i<='Z'; i++) {
			System.out.print((char)i+" ");
		} //for	
	}
}

/*
[������]
�ȳ��ϼ��� 1
�ȳ��ϼ��� 2
�ȳ��ϼ��� 3
�ȳ��ϼ��� 4
�ȳ��ϼ��� 5
�ȳ��ϼ��� 6
�ȳ��ϼ��� 7
�ȳ��ϼ��� 8
�ȳ��ϼ��� 9
�ȳ��ϼ��� 10
Ż�� i = 11

10 9 8 7 6 5 4 3 2 1 
A B C D E F G H I J K L M N O P Q R S T U V W X Y Z 
*/