package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayTest2 {

	public static void main(String[] args) throws IOException {
		
		for(int i=0; i<args.length; i++) { 
			System.out.println("args["+i+"] = "+args[i]); //args[i] ����
			System.out.println("args["+i+"] ���ڿ� ũ�� = "+args[i].length());	//String�� �����ڵ� ��	
			System.out.println("args["+i+"] ù��° ���� = "+args[i].charAt(0));	
			System.out.println("args["+i+"] �ι�° ���� = "+args[i].charAt(1));	
			System.out.println();
		}//for i
		System.out.println();
		
		System.out.println("Ȯ�� for");
		for(String data : args) {
			System.out.println(data);
			System.out.println("���ڿ� ũ�� = "+data.length());		
			System.out.println("ù��° ���� = "+data.charAt(0));	
			System.out.println();
		}//for data
		System.out.println();
		
		/*
		���ڿ��� �Է¹޾Ƽ� ��� ��ġ�� ���ڸ� ����Ͻÿ�
		
		[������]
		���ڿ� �Է� : �ڳ���		���ڿ� �Է� : �ٴ��ڳ���		���ڿ� �Է� : �����ú�
		��� ���� = ��		��� ���� = ��			��� ���� = ��
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("���ڿ� �Է� : ");
		String str = br.readLine();
		
		int index = str.length()/2; //������ 3/2=1 : args[1], �ټ����� 5/2=2 : args[2] -> ��� ����
		
		System.out.println("��� ���� = "+str.charAt(index));
	}
}

/*
javac ArrayTest2.java
java ArraTest2 ȣ���� ����

Eclipse���� ������ �Էºκ� �ϴ� ��:
��Ŭ�� - Rus As - Run Configurations - Arguments
Name�� Ŭ�������� �´��� Ȯ�� �� Program arguments�� �Է�

[������]
args[0] = �ٴ��ڳ���
args[0] ���ڿ� ũ�� = 5
args[0] ù��° ���� = ��
args[0] �ι�° ���� = ��

args[1] = ����
args[1] ���ڿ� ũ�� = 2
args[1] ù��° ���� = ��
args[1] �ι�° ���� = ��

args[2] = �����ӱ�
args[2] ���ڿ� ũ�� = 4
args[2] ù��° ���� = ��
args[2] �ι�° ���� = ��


Ȯ�� for
�ٴ��ڳ���
���ڿ� ũ�� = 5
ù��° ���� = ��

����
���ڿ� ũ�� = 2
ù��° ���� = ��

�����ӱ�
���ڿ� ũ�� = 4
ù��° ���� = ��


���ڿ� �Է� : �����ú�
��� ���� = ��
*/