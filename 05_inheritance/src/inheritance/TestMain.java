package inheritance;

class Test{
	int a, b;
}
//-------------------------
public class TestMain {

	public static void main(String[] args) {
		Test aa = new Test(); //클래스를 new하면 주소값을 aa에 줌
		Test bb = aa; //주소값 전달
		aa.a = 2;
		aa.b = 5;
		System.out.println(aa.a + "\t" + aa.b); //2 5
		System.out.println(bb.a + "\t" + bb.b); //2 5 
		System.out.println();
		
		bb.a = 7;
		bb.b = 9;
		System.out.println(aa.a + "\t" + aa.b); //7 9
		System.out.println(bb.a + "\t" + bb.b); //7 9 
		System.out.println();
		
		bb = new Test();
		bb.a = 10;
		bb.b = 20;
		System.out.println(aa.a + "\t" + aa.b); //7 9
		System.out.println(bb.a + "\t" + bb.b); //10 20
	}
}

/*
[실행결과]
2	5
2	5

7	9
7	9

7	9
10	20
*/