/*
[����] CompTest4
char ch = 'T';  �Ǵ� char ch = 'e';

ch�� ����ִ� ���� �빮��(A~Z)�̸� �ҹ��ڷ� �ٲپ ���
�빮�ڰ� �ƴϸ�(�ҹ��� �ν�, a~z) �빮�ڷ� �ٲپ ���

[������]
T �� t         �Ǵ�    e �� E
*/

class CompTest4 {
	public static void main(String[] args) {
		char ch = 'T'; 

		//ch������ ���� �����Ͱ� �빮���ΰ�?
		//A ~ Z (65 ~ 90), a ~ z (97 ~ 122)

		//ch>=65 && ch<=90 ? - ����������, �˾ƺ��� ���� ó���ϴ� �� ����.
		int result = ch>='A' && ch<='Z' ? ch+32 : ch-32; //������ ��µǱ� ������ ����ȯ �ʿ�
		System.out.println(ch + " �� " + (char)result); 
	}
}

/*
[������]
D:\java_se\workspace\0722>javac CompTest4.java

D:\java_se\workspace\0722>java CompTest4
T �� t
*/