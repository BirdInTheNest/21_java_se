/*
1사분기의 과일별 합계와 월별 합계를 구하시오

클래스 : FruitTest
필드  : pum, jan, feb, mar, tot
       sumJan, sumFeb, sumMar
       
메소드 : 생성자
       calcTot()
       display()
       output() - 월별 출력  

[실행결과]
---------------------------------
PUM      JAN   FEB   MAR      TOT
---------------------------------
사과    100    80    75        255
포도     30    25    10        xxx
딸기     25    30    90        xxx
---------------------------------
        xxx   xxx   xxx
 */

package class_;

public class FruitMain {
 
	public static void main(String[] args) {
		/*
		FruitTest aa = new FruitTest("사과",100,80,75); //1인분으로 클래스 잡기
		FruitTest bb = new FruitTest("포도",30,25,10);
		FruitTest cc = new FruitTest("딸기",25,30,90); //FruitTest가 3개이므로 배열로 잡기
		
		1. 첫번째 방법
		FruitTest[] ar = new FruitTest[3];
		ar[0] = new FruitTest("사과",100,80,75); //각각의 방에 객체 생성
		ar[1] = new FruitTest("포도",30,25,10);
		ar[2] = new FruitTest("딸기",25,30,90);
		
		2. 두번째 방법
		FruitTest[] ar = new FruitTest[] {new FruitTest("사과",100,80,75),
										  new FruitTest("포도",30,25,10)
										  new FruitTest("딸기",25,30,90)};
		
		
		3. 세번째 방법														*/
		FruitTest[] ar = {new FruitTest("사과",100,80,75),
						  new FruitTest("포도",30,25,10),
					 	  new FruitTest("딸기",25,30,90)};
		
		System.out.println("---------------------------------");
		System.out.println("PUM\tJAN\tFEB\tMAR\tTOT");
		System.out.println("---------------------------------");
		
		//for(int i=0; i<ar.length; i++) { //방번호로 돌리는 거 
		//	ar[i].calcTot();
		//	ar[i].display();
		//}
			
		for(FruitTest data : ar) { // 데이터를 통으로 받아서 돌리는 거
			data.calcTot();
			data.display();
		} //확장 for문은 출력할 때 배열에 있는 값을 하나 하나 꺼낼 때 사용
		
		System.out.println("---------------------------------");
		FruitTest.output();
	}
}

/*
[실행결과]
---------------------------------
PUM	JAN	FEB	MAR	TOT
---------------------------------
사과	100	80	75	255
포도	30	25	10	65
딸기	25	30	90	145
---------------------------------
	155	135	175
*/