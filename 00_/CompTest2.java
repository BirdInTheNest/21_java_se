/*
[����] CompTest2
int a=85, b=100; �Ǵ� int a=35, b=20;

[������]
ū�� = 100 �Ǵ� ū�� = 35
*/

class CompTest2 {
	public static void main(String[] args) {
		int a=250, b=63;
		//����: ���� a�� b���� ũ�ٸ� ? a : b;
		int result = a > b ? a : b;
		
		System.out.println("ū�� = " + result);	
	}
}

/*
[������]
D:\java_se\workspace\0722>javac CompTest2.java

D:\java_se\workspace\0722>java CompTest2
ū�� = 250
*/