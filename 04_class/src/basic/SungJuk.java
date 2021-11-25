/*
필드
메소드 setData(이름, 국어, 영어, 수학)
calcTot() //총점을 구하는 메소드
calcAvg() //평균을 구하는 메소드
calcGrade() //학점을 구하는 메소드
getter
 */

package basic;

public class SungJuk {
	private String name; //private이기 때문에 외부에서 접근 불가능, 따라서 setter와 getter 메소드를 만들어야함
	private int kor, eng, math, tot;
	private double avg;	
	private char grade;
	
	//함수(메소드) 식을 세운게 구현부, 값을 집어넣는 게 호출부
	//setter: 외부의 데이터 n,k,e,m을 받아 클래스의 private name,kor,eng,math에 전달
	public void setData(String n, int k, int e, int m) { //구현
		name = n;
		kor = k;
		eng = e;
		math = m;
	} 
	
	public void calcTot() { //총점을 구하는 메소드
		tot = kor+eng+math;
	}
	public void calcAvg() { //평균을 구하는 메소드
		avg = (double)tot/3;
	}
	public void calcGrade() { //학점을 구하는 메소드
		if(avg>=90) grade='A'; //평균이 90 이상이면 A
		else if(avg>=80) grade='B';
		else if(avg>=70) grade='C';
		else if(avg>=60) grade='D';
		else grade='F';
	}
	
	public String getName(){ //getter: 데이터값을 내보냄. 자바는 return값을 하나밖에 못 보낸다
		return name;
	}
	public int getKor(){ 
		return kor;
	}
	public int getEng(){ 
		return eng;
	}
	public int getMath(){ 
		return math;
	}
	public int getTot(){ 
		return tot;
	}
	public String getAvg() {
		return String.format("%.2f", avg);
	}
	public char getGrade(){ 
		return grade;
	}
}
