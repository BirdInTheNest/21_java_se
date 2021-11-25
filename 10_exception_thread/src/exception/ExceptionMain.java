package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionMain {

	public static void main(String[] args) { //구현부 - 이 함수는 이런 일을 합니다
		
		//ArrayIndexOutOfBoundsException
		if(args.length >=1) //데이터가 들어오면
			System.out.println("args[0] = "+args[0]);
		
		ExceptionMain em = new ExceptionMain();
		em.sub(); //호출
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a, b;
		try {
			System.out.print("정수 입력 : ");
			a = Integer.parseInt(br.readLine());
			
			System.out.print("정수 입력 : ");
			b = Integer.parseInt(br.readLine());
			
			System.out.println(a+" / "+b+" = "+a/b);
			
		}catch(IOException e) {
			e.printStackTrace();
		}catch(NumberFormatException e) {
			System.out.println("숫자 형태만 입력하세요");
			e.printStackTrace();
		}catch(ArithmeticException e){
			System.out.println("0으로 나누면 안 됩니다");
			e.printStackTrace();
		}finally {
			System.out.println("error가 있든 없든 무조건 실행! DB는 Close를 해야하므로 필수");
		}
	}//main(String[] args)
	
	public void sub() { //구현
		System.out.println("호호호");
	}//sub()
}

/*
★ 예외처리
: 생각지도 않은 error가 발생하여 프로그램이 중도에 멈추는 것을 미리 예방하는 것

1. 예외처리의 최상위클래스는 Exception 이다
2. Exception이 여러개 발생을 하면 한번에 최상위 클래스 Exception으로 처리하는것이 편하다.
3. 자바가 제공하는 Override한 메소드에는 throws 사용해서는 안된다
4. 컴파일 Exception  (보험 들어놓는 것)
   - RuntimeException 으로부터 상속을 받지 않기때문에 
     반드시 Exception을 처리한다 => try~catch, throws
  
 실행 Exception  (개발자 실수)
   - RuntimeException 으로부터 상속을 받으며
     Exception을 처리하지 말고 비즈니스 로직으로 처리한다.

※ 처리
1. try {
	error가 발생할 가능성이 있는 영역
    } catch(){
	error가 발생하면 처리되는 부분
    }
2. try {
    }catch() {
    }catch() {
    }

3. try {
   } catch() {
   } finally {
	error가 있건 없건 무조건 실행하는 부분
   }

4. throws - JVM에게 떠 넘기는 것 (백신)
5. throw  - 사용자가 직접 Exception을 작성하여 발생 (바이러스)
-----------------------------------------------------------------------------
main() 호출 시점은 실행될 때 (JVM이 불러내는 call back 메소드임)
클래스는 메모리에 생성되어야 호출할 수 있다.
main()은 static(시식용)이기 때문에 new할 필요 없이 호출 가능

f(X) = x+3 -- 구현
f(2) -- 호출
-----------------------------------------------------------------------------
class System {
	//필드
	static InputStream in; //키보드, 자료형이 InputStream
	static PrintStream out; //모니터 화면, 자료형이 PrintStream

ExceptionMain.java <--BufferedReader-- buffer <--InputStreamReader-- System.in(InputStream)
 */