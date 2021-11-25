/*
[������]
a�� �Է� : 25					a�� �Է� : 25					a�� �Է� : 25
b�� �Է� : 36					b�� �Է� : 36					b�� �Է� : 36
������(+,-,*,/) : +			������(+,-,*,/) : /			������(+,-,*,/) : #
25 + 36 = xx				25 / 36 = xx.xxxxxxxx		������ error
*/

package switch_;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SwitchTest2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("a�� �Է� : ");
		int a = Integer.parseInt(br.readLine()); //Integer.parseInt�� "25"���� ������������ ������ ���ڿ��� ��
		System.out.print("b�� �Է� : ");
		int b = Integer.parseInt(br.readLine());
		System.out.print("������(+,-,*,/) : ");
		String op = br.readLine();
		//int op = br.read(); //int op = System.in.read(); -1�� ����

		switch(op){
			//case '+' : System.out.println(a+" + "+b+" = "+(a+b)); break; //int op�� �� ���
			case "+" : System.out.println(a+" + "+b+" = "+(a+b)); break;
			case "-" : System.out.println(a+" - "+b+" = "+(a-b)); break;
			case "*" : System.out.println(a+" * "+b+" = "+(a*b)); break;
			case "/" : System.out.println(a+" / "+b+" = "+((double)a/b)); break;
			default : System.out.println("������ error");
		} //switch
	}
}

/*
[������]
D:\java_se\workspace\0723>javac SwitchTest2.java

D:\java_se\workspace\0723>java SwitchTest2
a�� �Է� : 25
b�� �Է� : 36
������(+,-,*,/) : +
25 + 36 = 61

D:\java_se\workspace\0723>java SwitchTest2
a�� �Է� : 25
b�� �Է� : 36
������(+,-,*,/) : /
25 / 36 = 0.6944444444444444

D:\java_se\workspace\0723>java SwitchTest2
a�� �Է� : 25
b�� �Է� : 36
������(+,-,*,/) : #
������ error
*/