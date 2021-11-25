/*
�� ����ȭ ó��
���� ���� ��ü�� ���ÿ� �ϳ��� �޼ҵ忡 �����Ϸ��� �� �� �ɰ��� ���ϰ� �߻� �ȴ�
�̸� �����ϱ� ���� Lock�� �Ǵ�.
�̰��� ����ȭ ó����� �Ѵ�.

[����] 
1)    public synchronized returnType �޼ҵ��(�μ��� �μ�, ...){
      }


2)    public   returnType   �޼ҵ��(�μ��� �μ�, ...){ 
      	     synchronized(this){
             }
       }

3)    public   returnType   �޼ҵ��(�μ��� �μ�, ...){ 
               synchronized(*.class){
               }
       }
*/

package thread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class ATMTest implements Runnable {
	private long depositMoney=100000; //�ܾ�
	private long balance; //ã���� �ϴ� �ݾ�

	public static void main(String[] args) { //static�������� this�� ����
		ATMTest atm = new ATMTest(); //Ŭ���� ����
		Thread mom = new Thread(atm, "����"); //������ ���� (ATMTest�� �������)
		Thread son = new Thread(atm, "�Ƶ�"); //������ ����
		
//		mom.setName("����");
//		son.setName("�Ƶ�");
		
		mom.start(); //������ ����
		son.start(); //������ ����
	}

	@Override
	public synchronized void run() { //synchronized : �� ����� ���� ������ �� ����
		System.out.println(Thread.currentThread().getName()+"�� �ȳ��ϼ���");
		//���� �����ϰ� �ִ� �����忡�� �� �̸� ���
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			System.out.print("ã���� �ϴ� �ݾ� �Է� : ");
			balance = Long.parseLong(br.readLine()); //long���̶� Long.parseLong
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//�ܾ� ���
		if(depositMoney >= balance) { //�ܾ��� ã���� �ϴ� �ݾ׺��� ũ�ų� ���� ��
			if(balance%10000 == 0) {
				depositMoney -= balance;
				System.out.println("�ܾ��� "+
				new DecimalFormat().format(depositMoney)+"�� �Դϴ�");	
			}else{ //balance%10000 != 0
				System.out.println("���� ������ �Է��ϼ���");				
			}
		}else { //depositMoney < balance
			System.out.println("�ܾ��� �����մϴ�");
		}
	}//run()
}