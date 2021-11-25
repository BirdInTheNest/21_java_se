package inheritance;

class AA {
	public int a = 3;
	
	public void disp() {
		a += 5;
		System.out.print("AA : " + a + " ");
	}
}
//--------------------
class BB extends AA { //BBŬ������ AAŬ������ ��ӹ���
	public int a = 8;
	
	public void disp() { //Override(�޼ҵ忡�� ����, �ʵ忡 ���� x)�϶� �켱���� �ڽ�Ŭ������ ������ ����
		this.a += 5; //this.a = this.a + 5 //13
		System.out.print("BB : " + a + " ");
	}
}
//--------------------
public class TestMain2 {

	public static void main(String[] args) {
		BB aa = new BB(); //BBŬ������ new�ϴµ� ��ü aa�� BBŬ���� �ּҰ��� ����
		aa.disp(); //a=8 -> a=13
		System.out.println("aa : " + aa.a); //a=13
		System.out.println();
		
		AA bb = new BB(); //BBŬ������ new�ϴµ� ��ü bb�� AAŬ���� �ּҰ��� ���� (�θ�=�ڽ� : ������)
		bb.disp(); //�޼ҵ尡 Override�Ǹ� ������ �ڽ� Ŭ������ �޼ҵ带 ���� //a=8 -> a=13
		System.out.println("bb : " + bb.a); //a=3
		System.out.println();
		
		AA cc = new AA(); //AAŬ������ new�ϴµ� ��ü cc�� AAŬ���� �ּҰ��� ����
		cc.disp(); //a=3 -> a=8
		System.out.println("cc : " + cc.a); //a=8
		System.out.println();
		
		//�ڽ� = (�ڽ�)�θ� : Casting(����ȯ) //Ŭ���������� ����ȯ�� ����, Ŭ������ �ڷ����� ��ü��
		BB dd = (BB)bb; //AAŬ���� �ּҰ��� ������ ��ü bb�� ����ȯ�Ͽ� ��ü dd�� BBŬ���� �ּҰ��� ���� 
		dd.disp(); //a=13 -> a=18
		System.out.println("dd : " + dd.a); //a=18
		System.out.println();
	}
}
//�ʵ�(�������)�� Override ������ ����. Override ������ �޼ҵ忡�� ����

/*
[������]
BB : 13 aa : 13

BB : 13 bb : 3

AA : 8 cc : 8

BB : 18 dd : 18
*/









