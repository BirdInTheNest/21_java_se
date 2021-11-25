package collection;

import java.text.DecimalFormat;

//1인분의 데이터 저장
public class SungJukDTO implements Comparable<SungJukDTO> {
	private int no;
	private String name;
	private int kor, eng, math, tot;
	private double avg;
	
	public SungJukDTO() { //기본생성자
		
	}

	public SungJukDTO(int no, String name, int kor, int eng, int math) { //생성자
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	} //생성자를 통해서 데이터를 받는다
	
	public void calc() {
		tot = kor + eng + math;
		avg = (double)tot /3;
	}

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getTot() {
		return tot;
	}
	public void setTot(int tot) {
		this.tot = tot;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	
//	String 클래스의 toString()은 기본적으로 Object의 기본 주소값 클래스명@16진수을 Override해서 바꾼다. 
//	@Override
//	public String toString() {
//		return super.toString();
//	}
	
	@Override
	public String toString() { //Override하여 리턴값을 클래스명@16진수가 아닌 원하는 값으로 변경한다.
		DecimalFormat df = new DecimalFormat("#.##");
		return no+"\t"+name+"\t"+kor+"\t"+eng+"\t"+math+"\t"+tot+"\t"+df.format(avg); 
	}

//	Comparable 인터페이스는 기본 정렬기준을 구현하는데 사용한다.
//	기본적으로 오름차순으로 정렬되도록 구현되어 있으며,
//	비교대상자가 더 크면(<) -1, 같다면(==) 0, 작으면(>) 1을 반환한다.
//	Collections(또는 Arrays).sort()로 정렬한다.
	
//	문자열은 숫차처럼 크다 작다 비교 안된다. 
//	따라서 String 클래스의 Comparable 인터페이스의 CompareTo 메소드 필요
	
	@Override //implements Comparable<SungJukDTO>하면 생김
	public int compareTo(SungJukDTO s) { //SungJukDTO의 값 비교
		return this.name.compareTo(s.name); //데이터 받은 값과 SungJukDTO의 값 비교
	}
}
