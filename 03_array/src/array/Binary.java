/*
10������ �Է��Ͽ� 2������ ��ȯ�Ͻÿ�
- 0�� �ԷµǸ� ���α׷��� �����Ͻÿ�
- ������ �ԷµǸ� ���Է��Ͻÿ�
- 4���� ��� �����ֱ�
- Integer.toBinaryString() ��� X

10���� �Է� : -5

10���� �Է� : 12
1100

10���� �Է� : 250
1111 1010

10���� �Է� : -8

10���� �Է� : 0
���α׷��� �����մϴ�
 */

package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Binary {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int dec; //int�� 4byte - 32bit
		int[] binary = new int[32];
		
		while(true) {
			System.out.print("10���� �Է� : ");
			dec = Integer.parseInt(br.readLine());
			if(dec==0) break; //0�� �ԷµǸ� ���α׷��� �����Ͻÿ�
			if(dec<0) continue; //������ �ԷµǸ� ���Է��Ͻÿ� //while�� �� ó������ ���� �ٽ� 
			
			//���࿡ 5�� 2������ ��ȯ: 10������ ���� 0�� �ɶ����� 2�� ������, ���� �������� �Ųٷ� ���
			//i=0�϶� 5/2=2..1, i=1�϶� 2/2=1..0, i=2�϶� 1/2=0..1
			int i;
			for(i=0; dec!=0; i++) { //���� 0�� �Ǹ� �ݺ����� �ʴ´�
				//System.out.println("i="+i); //�����
				binary[i] = dec%2;
				dec = dec/2; //��
				//���� 0�� �Ǿ� �ݺ����� �ʾƵ� i++�� �ֱ� ������ �̹� i=3�� �Ǿ�����
				//���� �Ųٷ� ����� �� �ʿ��� k=i-1�� �Ǿ�� ��
			}//for
			//System.out.println("Ż�� i="+i); //�����
			
			//�Ųٷ� ���
			for(int k=i-1; k>=0; k--) {
				System.out.print(binary[k]);
				if(k%4==0) System.out.print(" "); //4���� ��� �����ֱ�
			}
			System.out.println("\n");
		}//while
		
		System.out.println("���α׷��� �����մϴ�");
	}
}













