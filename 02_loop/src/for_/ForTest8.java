/*
���ѷ���
while(true) {
	
}

for(;true;) {
	
}
	
for(;;) {
	
}
 */

/*
[����] ForTest8.java
x�� y������ ���Ͻÿ�
��, x�� ���� 0�� �ԷµǸ� ���α׷��� �����Ͻÿ�

[������]
x�� �Է� : 2
y�� �Է� : 5

2�� 5������ 32

x�� �Է� : 3
y�� �Է� : 4

3�� 4������ 81

x�� �Է� : 0
���α׷��� �����մϴ�.
 */

package for_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ForTest8 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x, y;
		int mul;
		
		for(;;) { //���ѷ���
			mul = 1; //�ʱⰪ
			
			System.out.print("x�� �Է� : ");
			x = Integer.parseInt(br.readLine());
			if(x==0) break; //x�� ���� 0�� �ԷµǸ� ���α׷��� �����Ͻÿ�
			
			System.out.print("y�� �Է� : ");
			y = Integer.parseInt(br.readLine());
			System.out.println();
			
			//x�� y���� - x�� y�� ���Ѵ� (ex.2�� 3���� = 2*2*2)
			for(int i=1; i<=y; i++) { //y�� �ݺ�
				mul *= x;
			}
			System.out.println(x+"�� "+y+"������ "+mul);
			System.out.println();
		}//for
		
		System.out.println("���α׷��� �����մϴ�.");
	}
}

/*
[������]
x�� �Է� : 2
y�� �Է� : 5

2�� 5������ 32

x�� �Է� : 3
y�� �Է� : 4

3�� 4������ 81

x�� �Է� : 0
���α׷��� �����մϴ�.
 */


