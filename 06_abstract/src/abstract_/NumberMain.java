package abstract_;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberMain {

	public static void main(String[] args) {
		//3자리마다 , 찍고 소수 이하 3째자리까지 반올림하여 제공
		//NumberFormat nf = new NumberFormat(); //추상메소드이기 때문에 new로 메모리에 생성하지 못함
		NumberFormat nf  = new DecimalFormat(); //자식클래스를 이용
		System.out.println(nf.format(12345678.456789));
		System.out.println(nf.format(12345678));
		System.out.println();
		
		//유효숫자가 아닌 것은 표현하지 않음. Java와 Excel은 #,###으로 숫자 표현, Oracle은 9,999로 표현 (형식 지정)
		NumberFormat nf2  = new DecimalFormat("#,###.##원"); 
		System.out.println(nf2.format(12345678.456789));
		System.out.println(nf2.format(12345678));
		System.out.println();
		
		//강제로 0을 표시
		NumberFormat nf3  = new DecimalFormat("#,###.00원"); 
		System.out.println(nf3.format(12345678.456789));
		System.out.println(nf3.format(12345678));
		System.out.println();
		
		//----------------------------------------------------------------------
		
		//추상클래스를 메소드를 이용하여 생성
		//NumberFormat 클래스의 getInstance()메소드는 static NumberFormat 클래스를 생성해줌
		//NumberFormat nf4 = NumberFormat.getInstance();
		NumberFormat nf4 = NumberFormat.getCurrencyInstance();
		System.out.println(nf4.format(12345678.456789));
		System.out.println(nf4.format(12345678));
		System.out.println();
		
		NumberFormat nf5 = NumberFormat.getInstance();
		nf5.setMaximumFractionDigits(2); //소수 이하 2째 자리
		nf5.setMinimumFractionDigits(2); //강제로 0을 표시
		System.out.println(nf5.format(12345678.456789));
		System.out.println(nf5.format(12345678));
		System.out.println();
		
		//NumberFormat nf6 = NumberFormat.getInstance();
		NumberFormat nf6 = NumberFormat.getCurrencyInstance(Locale.US);
		nf5.setMaximumFractionDigits(2); //소수 이하 2째 자리
		nf5.setMinimumFractionDigits(2); //강제로 0을 표시
		System.out.println(nf6.format(12345678.456789));
		System.out.println(nf6.format(12345678));
		System.out.println();
	}

}

/*
public abstract class NumberFormat extends Format

java.lang.Object
	java.text.Format
		java.text.NumberFormat
		
NumberFormat 클래스의 Subclasses: ChoiceFormat, DecimalFormat

---------------------------------------------------------
[실행결과]
12,345,678.457
12,345,678

12,345,678.46원
12,345,678원

12,345,678.46원
12,345,678.00원

12,345,678.46원
12,345,678.00원


*/