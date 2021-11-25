package inheritance;

import java.util.Scanner;

public class Examination {
	public static final String JUNGDAP = "11111"; //���ȭ�� public static final�� ��
	
	private String name = null; //�ʵ� String �ʱⰪ�� null
	private String dap;
	private char[] ox = null; //�迭�� ũ�⸦ ���� ������ �ʱⰪ�� null��
	private int score;
	
	public Examination() { //������
		Scanner scan = new Scanner(System.in);
		
		System.out.print("�̸� �Է� : ");
		name = scan.next();
		System.out.print("�� �Է� : ");
		dap = scan.next();
		
		ox = new char[5]; //�迭ũ�Ⱑ 5���� ���� �迭 ����
	}
		
	public void compare() { //�� �޼ҵ�
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
	
	public char[] getOx() { //�ڷ����� ���� �迭������ ����
		return ox;
	}
	
	public int getScore() {
		return score;
	}
}
