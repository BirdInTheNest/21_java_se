/*
������ ���� ���α׷�

[������]
**************
1. ����      
2. ����      
3. ����Ʈ      
4. ����
**************
�޴� : 8
1~4�������� �Է��ϼ���.

1���� ���
��ġ �Է� : 3
3��ġ�� ���� / �̹� �����Ǿ� �ֽ��ϴ�

2���� ���
��ġ �Է� : 4
4��ġ���� ���� / �����Ǿ� ���� �ʽ��ϴ�

3���� ���
1��ġ : false
2��ġ : false
3��ġ : false
4��ġ : false
5��ġ : false

4���� ���
���α׷��� �����մϴ�.
 */

package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parking {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num, index; 
		boolean[] ar = new boolean[5]; //boolean �迭�� ��� garbage���� flase�� �������
		
		while(true) {
			System.out.println();
			System.out.println("**************");
			System.out.println("   1. ����");
			System.out.println("   2. ����");
			System.out.println("   3. ����Ʈ");
			System.out.println("   4. ����");
			System.out.println("**************");
			System.out.print(" �޴� : ");
			num = Integer.parseInt(br.readLine());
			if(num==4) break; //4���� ���(����) ����
			
			if(num==1) { //1���� ���(����)
				System.out.print("��ġ �Է� : ");
				index = Integer.parseInt(br.readLine());
				
				//if(ar[index-1]==true) //false: ���� ����, true: ���� ����
				if(ar[index-1]) 
					System.out.println("�̹� �����Ǿ� �ֽ��ϴ�");
				else {
					System.out.println(index+"��ġ�� ����");
					ar[index-1] = true;
				}
				
			}else if(num==2) { //2���� ���(����)
				System.out.println("��ġ �Է� : ");
				index = Integer.parseInt(br.readLine());
				
				if(ar[index-1]) {
					System.out.println(index+"��ġ���� ����");
					ar[index-1] = false;
				}else {
					System.out.println("�����Ǿ� ���� �ʽ��ϴ�");
				}
				
			}else if(num==3) { //3���� ���(����Ʈ)
				for(int i=0; i<ar.length; i++) {
					System.out.println((i+1)+"��ġ : "+ar[i]);
				}//for				
			}else System.out.println("1~4�������� �Է��ϼ���.");
			
		}//while
		System.out.println("���α׷��� �����մϴ�.");
	}
}

/*
��ǻ�Ͱ� �ν��ϴ� ���� ��ġ ���� : 0 1 2 3 4 ... 
����� �ν��ϴ� ���� ��ġ ���� : 1 2 3 4 ... 

�� ������ ��� index�� ����� ���� �����̹Ƿ� 
boolean ar [i] = boolean ar [index-1]
 */

/*
[������]

**************
   1. ����
   2. ����
   3. ����Ʈ
   4. ����
**************
 �޴� : 3
1��ġ : false
2��ġ : false
3��ġ : false
4��ġ : false
5��ġ : false

**************
   1. ����
   2. ����
   3. ����Ʈ
   4. ����
**************
 �޴� : 1
��ġ �Է� : 1
1��ġ�� ����

**************
   1. ����
   2. ����
   3. ����Ʈ
   4. ����
**************
 �޴� : 1
��ġ �Է� : 2
2��ġ�� ����

**************
   1. ����
   2. ����
   3. ����Ʈ
   4. ����
**************
 �޴� : 3
1��ġ : true
2��ġ : true
3��ġ : false
4��ġ : false
5��ġ : false

**************
   1. ����
   2. ����
   3. ����Ʈ
   4. ����
**************
 �޴� : 1
��ġ �Է� : 1
�̹� �����Ǿ� �ֽ��ϴ�

**************
   1. ����
   2. ����
   3. ����Ʈ
   4. ����
**************
 �޴� : 2
��ġ �Է� : 
1
1��ġ���� ����

**************
   1. ����
   2. ����
   3. ����Ʈ
   4. ����
**************
 �޴� : 2
��ġ �Է� : 
4
�����Ǿ� ���� �ʽ��ϴ�

**************
   1. ����
   2. ����
   3. ����Ʈ
   4. ����
**************
 �޴� : 3
1��ġ : false
2��ġ : true
3��ġ : false
4��ġ : false
5��ġ : false

**************
   1. ����
   2. ����
   3. ����Ʈ
   4. ����
**************
 �޴� : 4
���α׷��� �����մϴ�.
*/

