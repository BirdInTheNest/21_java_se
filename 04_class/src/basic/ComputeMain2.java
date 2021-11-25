package basic;

public class ComputeMain2 {

	public static void main(String[] args) {
		Compute[] ar = new Compute[3]; //객체 배열 생성
		for(int i=0; i<ar.length; i++) {
			ar[i] = new Compute(); //클래스 생성
		}//for
					
		ar[0].setX(320);
		ar[0].setY(258);
		
		ar[1].setX(236);
		ar[1].setY(125);
		
		ar[2].setX(539);
		ar[2].setY(327);
		
		System.out.println("X\tY\tSum\tSub\tMul\tDiv");
		for(int i=0; i<ar.length; i++) {
			ar[i].calc();
		      
		    System.out.println(ar[i].getX() + "\t"
		                   + ar[i].getY() + "\t"
		                   + ar[i].getSum() + "\t"
		                   + ar[i].getSub() + "\t"
		                   + ar[i].getMul() + "\t"
		                   + String.format("%.2f", ar[i].getDiv()));
		}//for
	}
}

//클래스를 잡을 때에는 항상 1줄 기준으로 잡아야 한다 (1인분)

/*
[실행결과]
X	Y	Sum	Sub	Mul	Div
320	258	578	62	82560	1.24
236	125	361	111	29500	1.89
539	327	866	212	176253	1.65
*/