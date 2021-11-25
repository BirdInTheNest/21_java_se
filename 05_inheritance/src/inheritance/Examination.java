package inheritance;

import java.util.Scanner;

public class Examination {
	public static final String JUNGDAP = "11111"; //상수화는 public static final로 씀
	
	private String name = null; //필드 String 초기값은 null
	private String dap;
	private char[] ox = null; //배열의 크기를 잡지 않으면 초기값은 null임
	private int score;
	
	public Examination() { //생성자
		Scanner scan = new Scanner(System.in);
		
		System.out.print("이름 입력 : ");
		name = scan.next();
		System.out.print("답 입력 : ");
		dap = scan.next();
		
		ox = new char[5]; //배열크기가 5개인 문자 배열 생성
	}
		
	public void compare() { //비교 메소드
		for(int i=0; i<ox.length; i++) {
			if(dap.charAt(i) == JUNGDAP.charAt(i)) { 
				ox[i] = 'O';
				score += 20;
			}
			else ox[i] = 'X';
		}//for	
	}
		
	public String getName() {
		return name;
	}
	
	public char[] getOx() { //자료형을 문자 배열형으로 받음
		return ox;
	}
	
	public int getScore() {
		return score;
	}
}
