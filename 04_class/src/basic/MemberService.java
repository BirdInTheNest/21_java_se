package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MemberService {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	MemberDTO[] ar = new MemberDTO[5]; //��ü�迭 ����. ���߿� Ŭ������ ��ü�� �����ؾ���
	
	public void menu() throws IOException{ //�޴��Լ� ����
		int num;		
		
		while(true) { //�ݺ�
			System.out.println();
	        System.out.println("********************");
	        System.out.println("     1. ����");
	        System.out.println("     2. ���");
	        System.out.println("     3. ����");
	        System.out.println("     4. Ż��");
	        System.out.println("     5. ������");
	        System.out.println("********************");
	        System.out.print("     ��ȣ : ");
			num = Integer.parseInt(br.readLine());
			if(num==5) break;
			
			if(num==1) insertMember();
			else if(num==2) list();
			else if(num==3) updateMember();
			else if(num==4) deleteMember();
		}//while
	}
	
	public void insertMember() throws IOException { //1. ����
		int i;
		for(i=0; i<ar.length; i++) {
			if(ar[i]==null) break; //������� ã�ƶ�
		}
		
		if(i==ar.length) { //for���� �� ������
			System.out.println("���� �ʰ�..");
			return; //���� �����ָ鼭 �Լ�(�޼ҵ�) insertMember�� �����
		}
		
		ar[i] = new MemberDTO(); //������� Ŭ���� ��ü ����
		
		System.out.print("�̸� �Է� : ");
		ar[i].setName(br.readLine());
		System.out.print("���� �Է� : ");
		ar[i].setAge(Integer.parseInt(br.readLine()));
		System.out.print("�ڵ��� �Է� : ");
		ar[i].setPhone(br.readLine());
		System.out.print("�ּ� �Է� : ");
		ar[i].setAddress(br.readLine());
		
		int count=0;
		for(i=0; i<ar.length; i++) {
			if(ar[i] == null) count++;
		}
		System.out.println();
		System.out.println("��� �Ϸ�...");
		System.out.println(count+"�ڸ��� ���ҽ��ϴ�");
	}
	
	public void list() { //2. ��� -> �� 5���߿��� ��ϵ� ȸ���� �����ش�
		System.out.println();
		System.out.println("�̸�\t����\t�ڵ���\t\t�ּ�");
		for(int i=0; i<ar.length; i++) {
			if(ar[i] != null) { //null�� �ƴ� ��(��ϵ� ȸ����)�� ����
				System.out.println(ar[i].getName()+"\t"
                        + ar[i].getAge()+"\t"
                        + ar[i].getPhone()+"\t"
                        + ar[i].getAddress());
			}
		}	
	}
	
	public void updateMember() throws IOException{ //3. ����
		System.out.print("�ҵ��� ��ȣ �Է� : ");
		String phone = br.readLine();
		
		int i;
		for(i=0; i<ar.length; i++) {
			if(ar[i] != null) { //null�� �ƴ� ��(��ϵ� ȸ����)�� ����
				if(ar[i].getPhone().equals(phone)) break; //ar[i]�� ����� ���� �Է��� ���� ������ ������
			}//if
		}//for
		
		if(i==ar.length) { //for���� �� ������
			System.out.println("ã���� �ϴ� ȸ���� �����ϴ�");
			return; //���� �����ָ鼭 �Լ�(�޼ҵ�) updateMember�� �����
		}
		
		System.out.println(ar[i].getName()+"\t"
                + ar[i].getAge()+"\t"
                + ar[i].getPhone()+"\t"
                + ar[i].getAddress());
   
	    System.out.print("������ �̸� �Է� : ");
	    ar[i].setName(br.readLine());
	    System.out.print("������ ���� �Է� : ");
	    ar[i].setAge(Integer.parseInt(br.readLine()));
	    System.out.print("������ �ڵ��� �Է� : ");
	    ar[i].setPhone(br.readLine());
	    System.out.print("������ �ּ� �Է� : ");
	    ar[i].setAddress(br.readLine());
	   
	    System.out.println();
	    System.out.println("���� �Ϸ�...");
	}
	
	public void deleteMember() throws IOException { // 4. Ż�� //�޼ҵ�(�Լ�) �����δ� ���� �������
	      System.out.print("�ڵ��� ��ȣ �Է� : ");
	      String phone = br.readLine();
	      
	      int i;
	      for(i=0; i<ar.length; i++) {
	         if(ar[i] != null) { //�����Ͱ��� null�� �ƴϸ� ��ϵ� ȸ����
	            if(ar[i].getPhone().equals(phone)) break; //ar[i]�� ����� ���� �Է��� ���� ������ ������
	         }//if
	      }//for
	      
	      if(i==ar.length) { //i==ar.length�� �Ǿ��ٴ� �ǹ̴� for�� �ݺ��� ������ �ص� ã���� �ϴ� ���� �����ٴ� �� 
	         System.out.println("ã���� �ϴ� ȸ���� �����ϴ�");
	         
	      }else { //���� i���� ����� �����͸� �ʱ�ȭ�϶�
	         ar[i] = null;
	         System.out.println("Ż�� �Ϸ�...");
	      }
	}
}