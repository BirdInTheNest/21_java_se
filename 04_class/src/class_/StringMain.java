package class_;

public class StringMain {

	public static void main(String[] args) {
		String a = "apple"; //String�� ���ڿ� ���ͷ� ������ �����ϴ�. new�� �������� �ʾƵ� ��. 
		String b = "apple"; //�Ȱ��� ���ڿ� ���ͷ��� �޸𸮿� 1���� �����ȴ�
		if(a == b) System.out.println("a�� b�� �������� ����"); //�ּҰ� ��
		else System.out.println("a�� b�� �������� �ٸ���");
		
		if(a.equals(b)) System.out.println("a�� b�� ���ڿ��� ����");
		else System.out.println("a�� b�� ���ڿ��� �ٸ���");
		System.out.println(); 
		
		String c = new String("apple"); //new�� �����ϸ� �޸𸮿� �Ź� ����, �ּҰ� �ٸ�
		String d = new String("apple");
		if(c == d) System.out.println("c�� d�� �������� ����"); //�ּҰ� ��
		else System.out.println("c�� d�� �������� �ٸ���");
		
		if(c.equals(d)) System.out.println("c�� d�� ���ڿ��� ����");
		else System.out.println("c�� d�� ���ڿ��� �ٸ���");
		System.out.println();
		
		String e = "���� ��¥�� " + 1991 + 7 + 16; //���ڿ��� ������ �Ұ���
		System.out.println("e = "+e);
		System.out.println("���ڿ� ũ�� = " + e.length()); //14
		
		System.out.println("ù��° ���� = " + e.charAt(0));
		System.out.println("�ι�° ���� = " + e.charAt(1));
		System.out.println("������ ���� = " + e.charAt(13));
		
		System.out.println("�κ� ���ڿ� ����=" + e.substring(7));
		System.out.println("�κ� ���ڿ� ����=" + e.substring(7,11)); //1991	-7�� ��ġ���� 11�� ��������
		
		System.out.println("�빮�� ���� = " + "Hello".toUpperCase());
		System.out.println("�ҹ��� ���� = " + "Hello".toLowerCase());
		
		System.out.println("���ڿ� �˻� = " + e.indexOf("¥")); //4 �� ���ڿ��� 4��° ��ġ�� �ִ�
		System.out.println("���ڿ� �˻� = " + e.indexOf("��¥")); //3
		System.out.println("���ڿ� �˻� = " + e.indexOf("���ٺ�")); //-1 �� ���ڿ��� ����
		System.out.println("���ڿ� �˻� = " + e.indexOf("1")); //7
		System.out.println("���ڿ� �˻� = " + e.indexOf("1",0));
		System.out.println("���ڿ� �˻� = " + e.indexOf("1",8));
		
		System.out.println("���ڿ� ġȯ = " + e.replace("��¥", "����"));
		
	}
}

/*
���ڿ��� ������ �ȵǹǷ� �޸� 4�� �����ȴ�
JVM�� ���ؼ� ���� �� Garbage Collector�� ������
Garbage Collector�� ����(������ ����)�Ǹ� ��ǻ�ʹ� �����

"���� ��¥�� "
"���� ��¥�� 1991"
"���� ��¥�� 19917"
        012      789 //���ڿ����� index���� �ִ�
e ---> "���� ��¥�� 1991716"
 */

/*
* ���(Constant) - ������ �ʴ� ��
 ���� ��� : 25
 ���� ��� : 'A'(65), 'a'(97), '0'(48)
 
* ���ͷ�(Literal) - ������ ����
1. ������ ���ͷ� : 25, 16, -125
2. �Ǽ��� ���ͷ� : 25.6, -43.8
3. ������ ���ͷ� : 'A', 'a', '0'
4. ���ڿ� ���ͷ� : "A", "a", "0"

new �����ڸ� ���� ������ �޸𸮿� ��� �����ȴ�.
�̱��� : �ѹ� �������� ��� ����ϰڴ�. -DB
 */

/*
[������]
a�� b�� �������� ����
a�� b�� ���ڿ��� ����

c�� d�� �������� �ٸ���
c�� d�� ���ڿ��� ����

e = ���� ��¥�� 1991716
���ڿ� ũ�� = 14
ù��° ���� = ��
�ι�° ���� = ��
������ ���� = 6
�κ� ���ڿ� ����=1991716
�κ� ���ڿ� ����=1991
�빮�� ���� = HELLO
�ҹ��� ���� = hello
���ڿ� �˻� = 4
���ڿ� �˻� = 3
���ڿ� �˻� = -1
���ڿ� �˻� = 7
���ڿ� �˻� = 7
���ڿ� �˻� = 10
���ڿ� ġȯ = ���� ���ڴ� 1991716

*/