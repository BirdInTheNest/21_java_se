/*
인원수를 입력하여 인원수만큼 데이터를 입력받고 총점과 평균을 구하시오
평균은 소수이하 2째자리까지 출력

[실행결과]
인원수 입력 : 2 (cnt)

이름입력 : 홍길동 (name)
과목수 입력 : 2   (subjectCnt)
과목명 입력 : 국어 (subject)
과목명 입력 : 영어
국어 점수 입력 : 95 (jumsu)
영어 점수 입력 : 100
----------------------
이름입력 : 이기자 (name)
과목수 입력 : 3   (subjectCnt)
과목명 입력 : 국어 (subject)
과목명 입력 : 영어
과목명 입력 : 자바
국어 점수 입력 : 95 (jumsu)
영어 점수 입력 : 100
자바 점수 입력 : 100

이름		국어	영어	총점	평균
홍길동    95	100	xxx	xx.xx

이름		국어  영어	자바	총점	평균
이기자	95	100	100	xxx	xx.xx
 */

package multiArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SungJuk2 {

	public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 System.out.print("인원수 입력 : ");
		 int cnt = Integer.parseInt(br.readLine()); //인원수
		 
		 String[] name = new String [cnt]; //인원수가 2명이면 이름도 2개
		 int subjectCnt; //과목수
		 String[][] subject = new String[cnt][]; //가변길이
		 int[][] jumsu = new int[cnt][];
		 double[] avg = new double[cnt];
		 
		 //입력, 처리
		 for(int i=0; i<cnt; i++) { //인원수 만큼 반복
			 System.out.print("이름입력 : ");
			 name[i] = br.readLine();
			 
			 System.out.print("과목수 입력 : ");
			 subjectCnt = Integer.parseInt(br.readLine());
			 
			 subject[i] = new String[subjectCnt]; //메모리에 생성
			 for(int j=0; j<subjectCnt; j++) {
				 System.out.print("과목명 입력 : ");
				 subject[i][j] = br.readLine();
			 }//for j
			 
			 jumsu[i] = new int[subjectCnt+1]; //과목수 + 총점 ; 같은 int형이니까 같이 만듦
			 for(int j=0; j<subjectCnt; j++) { 
				 System.out.print(subject[i][j]+"점수 입력 : ");
				 jumsu[i][j] = Integer.parseInt(br.readLine());
				 
				 jumsu[i][subjectCnt] += jumsu[i][j]; //총점 //총점의 열은 과목수와 같음 (잔머리)
			 }//for j
			 
			 avg[i] = (double)jumsu[i][subjectCnt] / subjectCnt; //평균=총점/과목수
			 
		 }//for i
		 
		 //출력
		 for(int i=0; i<cnt; i++) { //인원수 만큼 반복
			 //타이틀
			 System.out.print("이름\t");
			 for(int j=0; j<subject[i].length; j++) {
				 System.out.print(subject[i][j]+"\t");
			 }// for j
			 System.out.println("총점\t평균");
			 
			 //데이터
			 System.out.print(name[i]+"\t");
			 for(int j=0; j<jumsu[i].length; j++) { //과목수, 총점
				 System.out.print(jumsu[i][j]+"\t");
			 }
			 System.out.println(String.format("%.2f", avg[i])); //평균은 소수이하 2째자리까지 출력
			 System.out.println();
	 
		 }//for i
	}
}

/*
[실행결과]
인원수 입력 : 2
이름입력 : 홍길동
과목수 입력 : 2
과목명 입력 : 국어
과목명 입력 : 영어
국어점수 입력 : 95
영어점수 입력 : 100
이름입력 : 이기자
과목수 입력 : 3
과목명 입력 : 국어
과목명 입력 : 영어
과목명 입력 : 자바
국어점수 입력 : 95
영어점수 입력 : 100
자바점수 입력 : 100
이름	국어	영어	총점	평균
홍길동	95	100	195	97.50

이름	국어	영어	자바	총점	평균
이기자	95	100	100	295	98.33
 */
