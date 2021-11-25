package class_;

public class FruitTest {
	private String pum; //필드
	private int jan, feb, mar, tot; 
	private static int sumJan, sumFeb, sumMar;
	//누적을 해야 하는 sumJan, sumFeb, sumMar은 딱 한번 설정되는 static 영역에 있어야 new한 클래스의 모든 객체끼리 더해진다
	
	public FruitTest(String pum, int jan, int feb, int mar) { //생성자
		this.pum = pum;
		this.jan = jan;
		this.feb = feb;
		this.mar = mar;
	}
	
	public void calcTot() { //calcTot() 메소드
		tot = jan + feb + mar;
		
		sumJan += jan; //1월 합계
		sumFeb += feb;
		sumMar += mar;	
	} 
	
	public void display() { //display() 메소드
		System.out.println(pum+"\t"+jan+"\t"+feb+"\t"+mar+"\t"+tot);
	}
	
	public static void output() { //output()
		System.out.println("\t"+sumJan+"\t"+sumFeb+"\t"+sumMar);
	}
}
