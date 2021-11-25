package array;

public class BubbleSort {

	public static void main(String[] args) {
		int[] ar = {43, 30, 25, 78, 55};
		
		System.out.print("���� �� : ");
		for(int x : ar) {
			System.out.print(x+"  ");
		}
		System.out.println();
		
		//���� - ��������
		int temp;
		for(int i=0; i<ar.length-1; i++) { 
			for(int j=0; j<ar.length-1-i; j++) {
				if(ar[j] > ar[j+1]) { // > �������� < ��������
					temp = ar[j];
					ar[j] = ar[j+1];
					ar[j+1] = temp;
				}//if	
			}//for j
		}//for i
				
		System.out.print("���� �� : ");
		for(int x : ar) {
			System.out.print(x+"  ");
		}
		System.out.println();
	}
}

/*
   j      j+1
ar[0] > ar[1]	ar[0] > ar[1]	ar[0] > ar[1]	ar[0] > ar[1]
ar[1] > ar[2]	ar[1] > ar[2]	ar[1] > ar[2]
ar[2] > ar[3]	ar[2] > ar[3]
ar[3] > ar[4]

for���� �ݺ��ϴ� Ƚ�� = i�� ��, for(int i=0; i<ar.length-1; i++)
i=0 -> j=0; j<4		(j<4-0)
i=1 -> j=0; j<3		(j<4-1)
i=2 -> j=0; j<2		(j<4-2)
i=3 -> j=0; j<1		(j<4-3)
					(j<ar.length-1 -i)
					
for(int j=0; j<ar.length-1-i; j++)
 */

/*
[������]
���� �� : 43  30  25  78  55  
���� �� : 25  30  43  55  78 
 */

