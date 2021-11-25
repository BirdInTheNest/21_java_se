package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExceptionMain {

	public static void main(String[] args) { //������ - �� �Լ��� �̷� ���� �մϴ�
		
		//ArrayIndexOutOfBoundsException
		if(args.length >=1) //�����Ͱ� ������
			System.out.println("args[0] = "+args[0]);
		
		ExceptionMain em = new ExceptionMain();
		em.sub(); //ȣ��
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int a, b;
		try {
			System.out.print("���� �Է� : ");
			a = Integer.parseInt(br.readLine());
			
			System.out.print("���� �Է� : ");
			b = Integer.parseInt(br.readLine());
			
			System.out.println(a+" / "+b+" = "+a/b);
			
		}catch(IOException e) {
			e.printStackTrace();
		}catch(NumberFormatException e) {
			System.out.println("���� ���¸� �Է��ϼ���");
			e.printStackTrace();
		}catch(ArithmeticException e){
			System.out.println("0���� ������ �� �˴ϴ�");
			e.printStackTrace();
		}finally {
			System.out.println("error�� �ֵ� ���� ������ ����! DB�� Close�� �ؾ��ϹǷ� �ʼ�");
		}
	}//main(String[] args)
	
	public void sub() { //����
		System.out.println("ȣȣȣ");
	}//sub()
}

/*
�� ����ó��
: �������� ���� error�� �߻��Ͽ� ���α׷��� �ߵ��� ���ߴ� ���� �̸� �����ϴ� ��

1. ����ó���� �ֻ���Ŭ������ Exception �̴�
2. Exception�� ������ �߻��� �ϸ� �ѹ��� �ֻ��� Ŭ���� Exception���� ó���ϴ°��� ���ϴ�.
3. �ڹٰ� �����ϴ� Override�� �޼ҵ忡�� throws ����ؼ��� �ȵȴ�
4. ������ Exception  (���� ������ ��)
   - RuntimeException ���κ��� ����� ���� �ʱ⶧���� 
     �ݵ�� Exception�� ó���Ѵ� => try~catch, throws
  
 ���� Exception  (������ �Ǽ�)
   - RuntimeException ���κ��� ����� ������
     Exception�� ó������ ���� ����Ͻ� �������� ó���Ѵ�.

�� ó��
1. try {
	error�� �߻��� ���ɼ��� �ִ� ����
    } catch(){
	error�� �߻��ϸ� ó���Ǵ� �κ�
    }
2. try {
    }catch() {
    }catch() {
    }

3. try {
   } catch() {
   } finally {
	error�� �ְ� ���� ������ �����ϴ� �κ�
   }

4. throws - JVM���� �� �ѱ�� �� (���)
5. throw  - ����ڰ� ���� Exception�� �ۼ��Ͽ� �߻� (���̷���)
-----------------------------------------------------------------------------
main() ȣ�� ������ ����� �� (JVM�� �ҷ����� call back �޼ҵ���)
Ŭ������ �޸𸮿� �����Ǿ�� ȣ���� �� �ִ�.
main()�� static(�ýĿ�)�̱� ������ new�� �ʿ� ���� ȣ�� ����

f(X) = x+3 -- ����
f(2) -- ȣ��
-----------------------------------------------------------------------------
class System {
	//�ʵ�
	static InputStream in; //Ű����, �ڷ����� InputStream
	static PrintStream out; //����� ȭ��, �ڷ����� PrintStream

ExceptionMain.java <--BufferedReader-- buffer <--InputStreamReader-- System.in(InputStream)
 */