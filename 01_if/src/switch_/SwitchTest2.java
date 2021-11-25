/*
[실행결과]
a값 입력 : 25					a값 입력 : 25					a값 입력 : 25
b값 입력 : 36					b값 입력 : 36					b값 입력 : 36
연산자(+,-,*,/) : +			연산자(+,-,*,/) : /			연산자(+,-,*,/) : #
25 + 36 = xx				25 / 36 = xx.xxxxxxxx		연산자 error
*/

package switch_;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SwitchTest2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("a값 입력 : ");
		int a = Integer.parseInt(br.readLine()); //Integer.parseInt은 "25"같은 숫자형식으로 구성된 문자열만 됨
		System.out.print("b값 입력 : ");
		int b = Integer.parseInt(br.readLine());
		System.out.print("연산자(+,-,*,/) : ");
		String op = br.readLine();
		//int op = br.read(); //int op = System.in.read(); -1개 문자

		switch(op){
			//case '+' : System.out.println(a+" + "+b+" = "+(a+b)); break; //int op로 한 경우
			case "+" : System.out.println(a+" + "+b+" = "+(a+b)); break;
			case "-" : System.out.println(a+" - "+b+" = "+(a-b)); break;
			case "*" : System.out.println(a+" * "+b+" = "+(a*b)); break;
			case "/" : System.out.println(a+" / "+b+" = "+((double)a/b)); break;
			default : System.out.println("연산자 error");
		} //switch
	}
}

/*
[실행결과]
D:\java_se\workspace\0723>javac SwitchTest2.java

D:\java_se\workspace\0723>java SwitchTest2
a값 입력 : 25
b값 입력 : 36
연산자(+,-,*,/) : +
25 + 36 = 61

D:\java_se\workspace\0723>java SwitchTest2
a값 입력 : 25
b값 입력 : 36
연산자(+,-,*,/) : /
25 / 36 = 0.6944444444444444

D:\java_se\workspace\0723>java SwitchTest2
a값 입력 : 25
b값 입력 : 36
연산자(+,-,*,/) : #
연산자 error
*/