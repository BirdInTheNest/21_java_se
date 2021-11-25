package Constructor;

import java.text.DecimalFormat;
import java.util.Scanner;

public class SalaryService {
	private SalaryDTO[] ar; //�ʵ忡 �ν��Ͻ������� SalaryDTOŬ������ ��ü�迭 ar ����
	Scanner scan = new Scanner(System.in); //IOException�� �ʿ� ����
	DecimalFormat df = new DecimalFormat(); //java.text.DecimalFormat
	
	public SalaryService(SalaryDTO[] ar) { //3. SalaryMain���� �ڷ����� SalaryDTO[]�� ar�� �ּҰ� ����
										   //ar�� �ڷ����� SalaryDTO Ŭ�������� ��ü �迭
		this.ar = ar; //4. ar �ּҰ� ������� ���� SalaryService Ŭ����(this.ar)�� �ּҰ� ����
	}

	public void menu() { //�޴��Լ� ����
		int num;		
		
		while(true) { //�ݺ�
			System.out.println();
	        System.out.println("********************");
	        System.out.println("     1. ��� ���");
	        System.out.println("     2. ��ü ���");
	        System.out.println("     3. ��� ���� ����");
	        System.out.println("     4. ���");
	        System.out.println("     5. ������");
	        System.out.println("********************");
	        System.out.print("     ��ȣ : ");
			num = scan.nextInt();
			if(num==5) break;
			
			if(num==1) insertEmp(); //1���� ��� insertEmp() �޼ҵ� �ۼ�
			else if(num==2) display(); //2���� ��� display() �޼ҵ� �ۼ�
			else if(num==3) updateEmp(); //3���� ��� updateEmp() �޼ҵ� �ۼ�
			else if(num==4) deleteEmp(); //4���� ��� deleteEmp() �޼ҵ� �ۼ�
		}//while
	}

	public void insertEmp() { //1. ��� ���
		int i;
		for(i=0; i<ar.length; i++) {
			if(ar[i]==null) break; //������� ã�ƶ�
		}
		
		if(i==ar.length) { //for���� �� ������
			System.out.println("���� �ʰ�..");
			return; //���� �����ָ鼭 �Լ�(�޼ҵ�) insertMember�� �����
		}
		
		ar[i] = new SalaryDTO(); //������� Ŭ���� ��ü ����
		ar[i].calc();
		
		System.out.println();
		System.out.println("��� �Ϸ�...");
	}
	
	public void display() { //2. ��ü ���
		System.out.println();
		System.out.println("�����ȣ\t�̸�\t����\t�⺻��\t\t����\t����\t����\t����");
		for(int i=0; i<ar.length; i++) {
			if(ar[i] != null) { //null�� �ƴ� ��(��ϵ� ȸ����)�� ����
				System.out.println(ar[i].getEmpId()+"\t"
		                         + ar[i].getName()+"\t"
		                         + ar[i].getPosition()+"\t"
		                         + df.format(ar[i].getBasePay())+"\t"
		                         + df.format(ar[i].getBenefit())+"\t"
		                         + (int)(ar[i].getTaxRate()*100)+"%\t"
		                         + df.format(ar[i].getTax())+"\t"
		                         + df.format(ar[i].getSalary()));
			}//if
		}//for	
	}
	
	private void updateEmp() {
		System.out.print("�����ȣ �Է� : ");
		int empId = scan.nextInt();
		
		int i;
		for(i=0; i<ar.length; i++) {
			if(ar[i] != null) { //null�� �ƴ� ��(��ϵ� ȸ����)�� ����
				if(ar[i].getEmpId() == empId) break; //ar[i]�� ����� ���� �Է��� ���� ������ ������
				//empId �������̶� equals�� ������� �ʾƵ� ��. ���ڿ��� equals�� ����ؾ� ��
			}//if
		}//for
		
		if(i==ar.length) { //for���� �� ������
			System.out.println("ã���� �ϴ� ����� �����ϴ�");
			return; //���� �����ָ鼭 �Լ�(�޼ҵ�) updateMember�� �����
		}
		
		System.out.println(ar[i].getEmpId()+"\t"
		                 + ar[i].getName()+"\t"
		                 + ar[i].getPosition()+"\t"
		                 + df.format(ar[i].getBasePay())+"\t"
		                 + df.format(ar[i].getBenefit())+"\t"
		                 + (int)(ar[i].getTaxRate()*100)+"%\t"
		                 + df.format(ar[i].getTax())+"\t"
		                 + df.format(ar[i].getSalary()));
   
		System.out.println();
	    System.out.print("������ ����� �Է� : ");
	    ar[i].setName(scan.next());
	    System.out.print("������ ���� �Է� : ");
	    ar[i].setPosition(scan.next());
	    System.out.print("������ �⺻�� �Է� : ");
	    ar[i].setBasePay(scan.nextInt());
	    System.out.print("������ ���� �Է� : ");
	    ar[i].setBenefit(scan.nextInt());
	   
	    ar[i].calc();
	    
	    System.out.println();
	    System.out.println("���� �Ϸ�...");
	}
	
	public void deleteEmp() { // 4. ��� //�޼ҵ�(�Լ�) �����δ� ���� �������
	      System.out.print("��� ��ȣ �Է� : ");
	      int empId = scan.nextInt();
	      
	      int i;
	      for(i=0; i<ar.length; i++) {
	         if(ar[i] != null) { //�����Ͱ��� null�� �ƴϸ� ��ϵ� ȸ����
	            if(ar[i].getEmpId() == empId) break; //ar[i]�� ����� ���� �Է��� ���� ������ ������
	         }//if
	      }//for
	      
	      if(i==ar.length) { //i==ar.length�� �Ǿ��ٴ� �ǹ̴� for�� �ݺ��� ������ �ص� ã���� �ϴ� ���� �����ٴ� �� 
	         System.out.println("ã���� �ϴ� ȸ���� �����ϴ�");
	         return;
	      } 
	         ar[i] = null; //���� i���� ����� �����͸� �ʱ�ȭ�϶�
	         System.out.println();
	         System.out.println("���� �Ϸ�...");
	}
}
