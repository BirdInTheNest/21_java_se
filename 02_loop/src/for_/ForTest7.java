/*
 for(������=�ʱ�ġ; ����ġ; ����ġ){
        ������ ���� �� ����(�ݺ�), �����̸� ����
 }
 */

/*
[������]
-1+2-3+4-5+6-7+8-9+10 = 5
*/

package for_;

public class ForTest7 {

	public static void main(String[] args) {
		int sum=0; //�ʱⰪ �ο�
		
		for(int i=1; i<=10; i++) { 
			
			if(i%2==0) { //2�� ���� �������� 0 = 2�� ��� = ¦�� ?
				sum += i;
				System.out.print("+"+i);			
			}else {
				sum -= i;
				System.out.print("-"+i);
			}//if
			
		}//for i

		System.out.println(" = "+sum);
	}
}
