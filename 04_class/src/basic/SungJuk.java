/*
�ʵ�
�޼ҵ� setData(�̸�, ����, ����, ����)
calcTot() //������ ���ϴ� �޼ҵ�
calcAvg() //����� ���ϴ� �޼ҵ�
calcGrade() //������ ���ϴ� �޼ҵ�
getter
 */

package basic;

public class SungJuk {
	private String name; //private�̱� ������ �ܺο��� ���� �Ұ���, ���� setter�� getter �޼ҵ带 ��������
	private int kor, eng, math, tot;
	private double avg;	
	private char grade;
	
	//�Լ�(�޼ҵ�) ���� ����� ������, ���� ����ִ� �� ȣ���
	//setter: �ܺ��� ������ n,k,e,m�� �޾� Ŭ������ private name,kor,eng,math�� ����
	public void setData(String n, int k, int e, int m) { //����
		name = n;
		kor = k;
		eng = e;
		math = m;
	} 
	
	public void calcTot() { //������ ���ϴ� �޼ҵ�
		tot = kor+eng+math;
	}
	public void calcAvg() { //����� ���ϴ� �޼ҵ�
		avg = (double)tot/3;
	}
	public void calcGrade() { //������ ���ϴ� �޼ҵ�
		if(avg>=90) grade='A'; //����� 90 �̻��̸� A
		else if(avg>=80) grade='B';
		else if(avg>=70) grade='C';
		else if(avg>=60) grade='D';
		else grade='F';
	}
	
	public String getName(){ //getter: �����Ͱ��� ������. �ڹٴ� return���� �ϳ��ۿ� �� ������
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
