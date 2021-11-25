/*
�迭�� ũ�⸦ �Է¹޾Ƽ� ������ �迭�� �����ϰ� ������ �Է� �� ����Ͻÿ�
��, �ִ밪�� ���Ͻÿ�

�迭 ũ�� �Է� : 7
ar[0] �Է� : 6
ar[1] �Է� : 8
ar[2] �Է� : 9
ar[3] �Է� : 3
ar[4] �Է� : 2
ar[5] �Է� : 4
ar[6] �Է� : 5

6  8  9  3  2  4  5  
�� = xxx
�ִ밪 = xx
�ּҰ� = xx
 */

package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayTest3 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("�迭 ũ�� �Է� : "); 
		int size = Integer.parseInt(br.readLine());	//�迭�� ũ�⸦ �Է¹޾Ƽ� 
		int[] ar = new int[size]; //������ �迭�� ���� - �޸𸮿� ������ �迭�� ���� size�� ����
	
		int sum = 0; //�ʱⰪ
		int max, min;
		
		for(int i=0; i<ar.length; i++) { //���� ���� 4: ar[0], ar[1] ar[2] ar[3]
			System.out.print("ar["+i+"] �Է� : ");
			ar[i] = Integer.parseInt(br.readLine()); //ar[i]�� ������ �Է�
		
			sum += ar[i]; //�����Ͱ����� ��
		}//for
		
		max = min = ar[0]; //�ʱⰪ
		for(int i=1; i<ar.length; i++) {
			if(ar[i] > max) max = ar[i]; //max �� �ٲ�ġ��
			if(ar[i] < min) min = ar[i]; //min �� �ٲ�ġ��
		}//for
		
		for(int a : ar) { //ar �ּҿ� �ִ� �����Ͱ��� int a�� �־��ִ� �� �ݺ�, ���ο� ���� �������
			System.out.print(a+"  ");
		}//for
		
		System.out.println();
		System.out.println("�� = "+sum);
		System.out.println("�ִ밪 = "+max);
		System.out.println("�ּҰ� = "+min);	
	}
}

/*
���� max�� �ʱⰪ�� 0�� ��� ��� �����Ͱ��� -���� �� �ִ밪�� �� ����
���� max�� �ʱⰪ���� ������ �� �ϳ��� ���´� ar[0]
ar[1] > max�̸� max = ar[1]
ar[2] > max�̸� max = ar[2]
...
 */



/*
[������]
�迭 ũ�� �Է� : 5
ar[0] �Է� : -12
ar[1] �Է� : -58
ar[2] �Է� : -35
ar[3] �Է� : -42
ar[4] �Է� : -55
-12  -58  -35  -42  -55  
�� = -202
�ִ밪 = -12
�ּҰ� = -58
*/