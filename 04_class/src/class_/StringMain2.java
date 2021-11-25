/*
ġȯ�ϴ� ���α׷��� �ۼ��Ͻÿ� - indexOf(), replace()
String Ŭ������ �޼ҵ带 �̿��Ͻÿ�
��ҹ��� ������� ������ ����Ͻÿ�

[������]
���ڿ� �Է� : aabba
���� ���ڿ� �Է� : aa
�ٲ� ���ڿ� �Է� : dd
ddbba
1�� ġȯ
----------------
���ڿ� �Է� : aAbbA
���� ���ڿ� �Է� : aa
�ٲ� ���ڿ� �Է� : dd
ddbba
1�� ġȯ
----------------
���ڿ� �Է� : aabbaa
���� ���ڿ� �Է� : aa
�ٲ� ���ڿ� �Է� : dd
ddbbdd
2�� ġȯ
----------------
���ڿ� �Է� : AAccaabbaaaaatt
���� ���ڿ� �Է� : aa
�ٲ� ���ڿ� �Է� : dd
ddccddbbddddatt
4�� ġȯ
----------------
���ڿ� �Է� : aabb
���� ���ڿ� �Է� : aaaaa
�ٲ� ���ڿ� �Է� : ddddd
�Է��� ���ڿ��� ũ�Ⱑ �۽��ϴ�
ġȯ �� �� �����ϴ�
 */

package class_;

import java.util.Scanner;

public class StringMain2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int index = 0; //0������ ��ġ ã��
		int count = 0;
		
		System.out.print("���ڿ� �Է� : ");
		String str = scan.next().toLowerCase();
		
		System.out.print("���� ���ڿ� �Է� : ");
		String target = scan.next().toLowerCase();
		
		System.out.print("�ٲ� ���ڿ� �Է� : ");
		String replacing = scan.next();
		 
		if(str.length() < target.length())
			System.out.println("�Է��� ���ڿ��� ũ�Ⱑ �۽��ϴ�");
		else {
			while( (index = str.indexOf(target, index)) != -1) { //-1�� �Ǳ� ������ �ݺ�. -1�� �Ǹ� ã�� ���� ���ٴ� ��
				//index = ���ڿ� str���� target ���ڿ��� index ��ġ�������� �����Ͽ� �˻��� ��
				count++;
				index += target.length(); //���ڿ� �˻� ������ġ�� target ���ڿ��� ���̸�ŭ ���ؾ� ��
			}//while
				
			System.out.println(str.replace(target, replacing));
			System.out.println(count+"�� ġȯ");
		}	
	}
}

/*
str --> "aabbccaahh"	target--> "aa"	replacing --> "gg"
		 0123456789
str.indexOf(str, 0) -> ������ġ 0�� //0��ġ���� ã��		str.indexOf(str, index)
str.indexOf(str, 2) -> ������ġ 2�� //6��ġ���� ã��		str.indexOf(str, index+target.length())
str.indexOf(str, 8) -> ������ġ 8��
 */

