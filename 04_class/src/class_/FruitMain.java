/*
1��б��� ���Ϻ� �հ�� ���� �հ踦 ���Ͻÿ�

Ŭ���� : FruitTest
�ʵ�  : pum, jan, feb, mar, tot
       sumJan, sumFeb, sumMar
       
�޼ҵ� : ������
       calcTot()
       display()
       output() - ���� ���  

[������]
---------------------------------
PUM      JAN   FEB   MAR      TOT
---------------------------------
���    100    80    75        255
����     30    25    10        xxx
����     25    30    90        xxx
---------------------------------
        xxx   xxx   xxx
 */

package class_;

public class FruitMain {
 
	public static void main(String[] args) {
		/*
		FruitTest aa = new FruitTest("���",100,80,75); //1�κ����� Ŭ���� ���
		FruitTest bb = new FruitTest("����",30,25,10);
		FruitTest cc = new FruitTest("����",25,30,90); //FruitTest�� 3���̹Ƿ� �迭�� ���
		
		1. ù��° ���
		FruitTest[] ar = new FruitTest[3];
		ar[0] = new FruitTest("���",100,80,75); //������ �濡 ��ü ����
		ar[1] = new FruitTest("����",30,25,10);
		ar[2] = new FruitTest("����",25,30,90);
		
		2. �ι�° ���
		FruitTest[] ar = new FruitTest[] {new FruitTest("���",100,80,75),
										  new FruitTest("����",30,25,10)
										  new FruitTest("����",25,30,90)};
		
		
		3. ����° ���														*/
		FruitTest[] ar = {new FruitTest("���",100,80,75),
						  new FruitTest("����",30,25,10),
					 	  new FruitTest("����",25,30,90)};
		
		System.out.println("---------------------------------");
		System.out.println("PUM\tJAN\tFEB\tMAR\tTOT");
		System.out.println("---------------------------------");
		
		//for(int i=0; i<ar.length; i++) { //���ȣ�� ������ �� 
		//	ar[i].calcTot();
		//	ar[i].display();
		//}
			
		for(FruitTest data : ar) { // �����͸� ������ �޾Ƽ� ������ ��
			data.calcTot();
			data.display();
		} //Ȯ�� for���� ����� �� �迭�� �ִ� ���� �ϳ� �ϳ� ���� �� ���
		
		System.out.println("---------------------------------");
		FruitTest.output();
	}
}

/*
[������]
---------------------------------
PUM	JAN	FEB	MAR	TOT
---------------------------------
���	100	80	75	255
����	30	25	10	65
����	25	30	90	145
---------------------------------
	155	135	175
*/