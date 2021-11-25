/*
클래스를 new연산자로 생성하면 메모리 heap영역에 생기고 주소값을 갖는다
클래스는 실제 사물의 속성(데이터)과 기능(메소드)을 정의한 메뉴판이다
클래스는 1인분 단위(가장 작은 단위)로 설정해야한다
내가 가지고 있는 데이터를 private으로 캡슐화하고 감춰라 (외부에서 데이터에 접근 불가능하게 함)
-> 메소드를 만들어내서 들어오는 데이터는 setter가 모두 받아주고 getter가 모두 내보냄

클래스의 법칙 (SOLID)
 */

/*
[실행결과]
----------------------------------------------------
이름      국어      영어      수학      총점      평균      학점
----------------------------------------------------
홍길동     90       96      100
라이언     100      90      75
어피치     75       80      48
----------------------------------------------------
 */
package basic;

public class SungJukMain {

	public static void main(String[] args) { //1인분씩 클래스 일일이 만들어야 됨
		SungJuk[] ar = new SungJuk[3]; //객체 배열(객체가 들어갈 방) 3개 생성(클래스 생성x)
		for(int i=0; i<ar.length; i++) {
			ar[i] = new SungJuk(); //클래스 생성
		}
		
		ar[0].setData("홍길동",90,96,100); //호출
		ar[1].setData("라이언",100,89,75); //들어오는 데이터값이 다 다르기때문에 for문 돌리지 못함
		ar[2].setData("어피치",75,80,48);
		
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t학점");
		for(SungJuk s : ar) { //방마다 클래스가 들어가 있기 때문에 클래스에 데이터값을 집어넣음
			s.calcTot(); 
			s.calcAvg();
			s.calcGrade();
			System.out.println(s.getName()+"\t"
							+ s.getKor()+"\t"
							+ s.getEng()+"\t"
							+ s.getMath()+"\t"
							+ s.getTot()+"\t"
							+ s.getAvg()+"\t"
							+ s.getGrade());
		}//for
	}     
}

/*
[실행결과]
이름	국어	영어	수학	총점	평균	학점
홍길동	90	96	100	286	95.33	A
라이언	100	89	75	264	88.00	B
어피치	75	80	48	203	67.67	D
 */

		/*
		//1인분씩 클래스 일일이 만들어야 됨
		SungJuk aa = new SungJuk();
		SungJuk bb = new SungJuk();
		SungJuk cc = new SungJuk();
		
		aa.setData("홍길동",90,96,100); //직접 데이터를 집어넣는 호출부, 순서가 중요
		aa.calcTot(); //들어오는 데이터값이 다 다르기때문에 for문 돌리지 못함
		aa.calcAvg();
		aa.calcGrade();
		System.out.println(aa.getName()+"\t"
						+ aa.getKor()+"\t"
						+ aa.getEng()+"\t"
						+ aa.getMath()+"\t"
						+ aa.getTot()+"\t"
						+ aa.getAvg()+"\t"
						+ aa.getGrade());
						
		bb.setData("라이언",100,89,75); 
		bb.calcTot(); 
		bb.calcAvg();
		bb.calcGrade();
		System.out.println(bb.getName()+"\t"
						+ bb.getKor()+"\t"
						+ bb.getEng()+"\t"
						+ bb.getMath()+"\t"
						+ bb.getTot()+"\t"
						+ bb.getAvg()+"\t"
						+ bb.getGrade());
						
		cc.setData("어피치",75,80,48); 
		cc.calcTot(); 
		cc.calcAvg();
		cc.calcGrade();
		System.out.println(cc.getName()+"\t"
						+ cc.getKor()+"\t"
						+ cc.getEng()+"\t"
						+ cc.getMath()+"\t"
						+ cc.getTot()+"\t"
						+ cc.getAvg()+"\t"
						+ cc.getGrade());
		*/	













