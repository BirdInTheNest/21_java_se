/*
�� ���� for
for(int a=~~~){
      for(int b=~~~){
      }//for b
}//for a

1. for���ȿ� �� �ٸ� for���� ����
2. ������ �������� �޶�� �Ѵ�.
3. ���ļ��� �ȵȴ�.
 */

package multiFor_;

public class MultiFor {

	public static void main(String[] args) {
		int i, j;
		
		for(i=2; i<=4; i+=2) { //i=2, i=4 2�� �ݺ�
			
			for(j=1; j<=3; j++) { //j=1, j=2, j=3 3�� �ݺ�
				System.out.println("i="+i+" j="+j);
			}//for j
			
			System.out.println();
			
		}//for i
	}
}

/*
[������]
i=2 j=1
i=2 j=2
i=2 j=3

i=4 j=1
i=4 j=2
i=4 j=3
*/