/*
1~10������ ���� ���Ͻÿ�

[������]
i		sum		mul
1		1		1
2		3		2
3		6		6
4		10		24
5		15		120
6		21		720
7		28		5040
8		36		40320
9		45		362880
10		55		3628800
*/

package for_;

public class ForTest4 {

	public static void main(String[] args) {
		int sum=0; //garbage���� �����Ƿ� �ʱ�ȭ�ؾ��� 
		int mul=1;
		
		for(int i=1; i<=10; i++) {
			sum += i; //sum = sum + i;
			mul *= i;
			System.out.println(i+"\t"+sum+"\t"+mul); //sysout Ctrl + Space bar �ڵ��ϼ�
		}//for
	}
}

//Ctrl + F11 : ������
