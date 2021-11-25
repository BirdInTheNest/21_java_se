package inheritance;

class AAA{}
class BBB extends AAA{} //BBBŬ������ AAAŬ������ ��ӹ���(BBB is a AAA)
//---------------
public class InstanceOf {

	public static void main(String[] args) {
		AAA aa = new AAA(); //AAAŬ������ new�ϴµ� ��ü aa�� AAAŬ���� �ּҰ� ����
		BBB bb = new BBB(); //BBBŬ������ new�ϴµ� ��ü bb�� BBBŬ���� �ּҰ� ����
		AAA aa2 = new BBB(); //BBBŬ������ new�ϴµ� ��ü aa2�� AAAŬ���� �ּҰ� ����

		AAA aa3 = aa; //��ü aa�� �ּҰ� aa3�� ���ް���(aa�� aa3�� �ڷ����� AAAŬ������ ����)
		if(aa instanceof AAA) System.out.println("1. TRUE"); 
		else System.out.println("1. FALSE");
		
		//�θ� = �ڽ�
		AAA aa4 = bb; //BBBŬ���� �ּҰ� ������ ��ü bb�� AAAŬ������ ��ӹ޾ұ� ������, �θ�Ŭ���� AAA ���� ���� 
		if(bb instanceof AAA) System.out.println("2. TRUE"); 
		else System.out.println("2. FALSE");
		
		//�ڽ� = (�ڽ�)�θ� : �ڽ��� �θ�Ŭ������ �ٷ� ������ �ȵǼ� downcasting�� �ؾ���
		BBB bb2 = (BBB)aa2; //AAAŬ���� �ּҰ� ������ aa2�� BBBŬ���������� ����ȯ�Ͽ��� ��
		if(aa2 instanceof BBB) System.out.println("3. TRUE"); 
		else System.out.println("3. FALSE");
		
		//BBB bb3 = (BBB)aa; //error - �޸𸮿� AAA�� �ְ� BBB�� ���� ������ �Ұ���
		//downcasting�� ��ӵ� ���¿��� ��� �����ϰ�, ���� Ŭ������ ���� ��� �Ұ�����
		if(aa instanceof BBB) System.out.println("4. TRUE");
		else System.out.println("4. FALSE");
	}
}

/*
�� instanceof
: casting(�� ��ȯ)�� �Ǵ��� �� �Ǵ����� �Ǻ�
: ��ü�� ���ϴ� Ŭ���� Ÿ���� �޸� �Ҵ�Ǿ����� �� �Ǿ������� Ȯ��

if(aa instanceof AAA)
aa�� �ּҰ��� AAA�� �ѱ� �� �ִ°�?
aa�� �������� ���󰡸� �޸𸮿� AAA Ŭ������ �����°�?
--------------------------------------------
[������]
1. TRUE
2. TRUE
3. TRUE
4. FALSE
*/