/*
[������]
���۰� �Է� : 5
���� �Է� : 20
5 ~ 20������ �� = xx
*/

package for_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ForTest5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int start, end;
		int sum=0;
		int count=0;
		
		System.out.print("���۰� �Է� : ");
		start = Integer.parseInt(br.readLine());
		System.out.print("���� �Է� : ");
		end = Integer.parseInt(br.readLine());
		
		for(int i=start; i<=end; i++) {
			sum += i;
			System.out.print(i+" ");
			count++; //for���� �ݺ��Ǵ� Ƚ�� 1 2 3 4 5 6 7 ...
			if(count%5==0) System.out.println(); //5�� ����� ���� ���
		}//for
		
		System.out.println();
		System.out.print(start+" ~ "+end+"������ �� = "+sum);
	}
}

/*
[������]
���۰� �Է� : 5
���� �Է� : 20
5 6 7 8 9 
10 11 12 13 14 
15 16 17 18 19 
20 
5 ~ 20������ �� = 200
*/
