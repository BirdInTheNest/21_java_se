/*
[����] CompTest3
int num = 25;  �Ǵ� int num = 80;

[������]
25�� Ȧ���̴�     �Ǵ� 80�� ¦���̴�
*/

class CompTest3{
	public static void main(String[] args) {
		int num = 83;
		//num�� ����ִ� �����Ͱ� ¦���ΰ�?
		//num�� ����ִ� �����Ͱ� 2�� ���?
		//num�� ����ִ� �����Ͱ� 2�� �������� �� �������� 0�̳�?
		
		String result = num%2 == 0 ? "¦���̴�" : "Ȧ���̴�"; //== ����, ���ڿ� - String
		System.out.println(num + "�� " + result);
	}
}

/*
[������]
D:\java_se\workspace\0722>javac CompTest3.java

D:\java_se\workspace\0722>java CompTest3
83�� Ȧ���̴�
*/