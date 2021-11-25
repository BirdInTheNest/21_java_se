package class_;

public class FruitTest {
	private String pum; //�ʵ�
	private int jan, feb, mar, tot; 
	private static int sumJan, sumFeb, sumMar;
	//������ �ؾ� �ϴ� sumJan, sumFeb, sumMar�� �� �ѹ� �����Ǵ� static ������ �־�� new�� Ŭ������ ��� ��ü���� ��������
	
	public FruitTest(String pum, int jan, int feb, int mar) { //������
		this.pum = pum;
		this.jan = jan;
		this.feb = feb;
		this.mar = mar;
	}
	
	public void calcTot() { //calcTot() �޼ҵ�
		tot = jan + feb + mar;
		
		sumJan += jan; //1�� �հ�
		sumFeb += feb;
		sumMar += mar;	
	} 
	
	public void display() { //display() �޼ҵ�
		System.out.println(pum+"\t"+jan+"\t"+feb+"\t"+mar+"\t"+tot);
	}
	
	public static void output() { //output()
		System.out.println("\t"+sumJan+"\t"+sumFeb+"\t"+sumMar);
	}
}
