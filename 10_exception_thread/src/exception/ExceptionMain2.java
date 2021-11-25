package exception;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ExceptionMain2 {
	private int dan;
	
	public void input() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("원하는 단을 입력 : ");
		try {
			dan = Integer.parseInt(br.readLine());			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void output() {
		if(dan>=2 && dan<=9) {
			for(int i=1; i<10; i++) {
				System.out.println(dan+"*"+i+"="+dan*i);
			}
		}else {
			//System.out.println("2~9 사이의 숫자만 입력하세요");
			try {
				//개발자가 강제로 Exception 발생
				//throw new Exception("2~9 사이의 숫자만 입력하세요");
				
				throw new MakeException("2~9 사이의 숫자만 입력하세요");
				
			}catch(Exception e) {
				e.printStackTrace();
			}			
		}
	}

	public static void main(String[] args) {
		ExceptionMain2 em = new ExceptionMain2();
		em.input();
		em.output();
	}
}