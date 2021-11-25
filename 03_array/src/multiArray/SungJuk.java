/*
3명의 총점, 평균, 학점을 구하시오
단, 평균의 소수이하 2째자리까지 출력하시오

총점 = 국어 + 영어 + 수학
평균 = 총점 / 3
평균이 90 이상이면 A
평균이 80 이상이면 B
평균이 70 이상이면 C
평균이 60 이상이면 D
그외는 F

[실행결과]
----------------------------------------------------
이름      국어      영어      수학      총점      평균      학점
----------------------------------------------------
홍길동     90       96      100
라이언     100      90      75
어피치     75       80      48
----------------------------------------------------
 */

package multiArray;

public class SungJuk {

	public static void main(String[] args) {
		//메모리 할당
		String[] name = {"홍길동", "라이언", "어피치"};
		int[][] jumsu = {{90,96,100,0}, {100,90,75,0}, {75,80,48,0}}; //{{행},{행},{행}}
		double[] avg = new double[3];
		char[] grade = new char[3];
	
		//처리
		for(int i=0; i<jumsu.length; i++) { //행 i
			for(int j=0; j<jumsu[i].length-1; j++) { //열 j
				jumsu[i][3] += jumsu[i][j]; //총점
			}//for j
			
			//평균 = 총점 / 3
			avg[i] = (double)jumsu[i][3] / 3.0;
			
			//학점
			if(avg[i]>=90) grade[i]='A'; //평균이 90 이상이면 A
			else if(avg[i]>=80) grade[i]='B';
			else if(avg[i]>=70) grade[i]='C';
			else if(avg[i]>=60) grade[i]='D';
			else grade[i]='F';
		}//for i
		
		//출력
		System.out.println("-----------------------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t학점");
		System.out.println("-----------------------------------------------");
		for(int i=0; i<jumsu.length; i++) { //0~2행
			System.out.print(name[i]+"\t");
			
			for(int j=0; j<jumsu[i].length; j++) { //0~3열
				System.out.print(jumsu[i][j]+"\t"); //국어, 영어, 수학, 총점
			}//for j
			
			System.out.println(String.format("%.2f", avg[i])+"\t"+grade[i]);
		}//for i
		System.out.println("-----------------------------------------------");
	}
}

/*
jumsu[0][3] += jumsu[0][0]
			   jumsu[0][1]
			   jumsu[0][2]
			   
jumsu[1][3] += jumsu[1][0]
			   jumsu[1][1]
			   jumsu[1][2]
			   
jumsu[i][3] += jumsu[i][j] //총점
--------------------------
avg[0] = jumsu[0][3] / 3
avg[1] = jumsu[1][3] / 3

avg[i] = jumsu[i][3] / 3 //평균 = 총점 / 3
--------------------------
name[0]   jumsu[0][0]   avg [0]   grade[0]
		  jumsu[0][1]
		  jumsu[0][2]
		  jumsu[0][3]
		    2중 for문
*/

/*
[실행결과]
-----------------------------------------------
이름	국어	영어	수학	총점	평균	학점
-----------------------------------------------
홍길동	90	96	100	286	95.33	A
라이언	100	90	75	265	88.33	B
어피치	75	80	48	203	67.67	D
-----------------------------------------------
 */












