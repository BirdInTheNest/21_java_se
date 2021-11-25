package Constructor;

//import java.text.DecimalFormat;
import java.util.Scanner;

public class SalaryDTO {
	private int empId; //�ʵ� : empId(�����ȣ)
	private String name; 
	private String position; 
	private int basePay; 
	private int benefit;
	private double taxRate; 
	private int tax;
	private int salary; 
	//private DecimalFormat df = new DecimalFormat();
	
	public SalaryDTO() { //������ �޼ҵ� - �Է�
		Scanner scan = new Scanner(System.in);
		
		System.out.print("�����ȣ �Է� : "); 
		empId = scan.nextInt();
		System.out.print("����� �Է� : ");
		name = scan.next(); //���ڿ�
		System.out.print("���� �Է� : ");
		position = scan.next();
		System.out.print("�⺻�� �Է� : ");
		basePay = scan.nextInt();
		System.out.print("���� �Է� : ");
		benefit = scan.nextInt();
	}
	
	//�����ڿ� setter�� ���� ������ ��. setter�� ��� ������ ���� �� ���� ȣ��
	public void setName(String name) { 
		this.name = name;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setBasePay(int basePay) {
		this.basePay = basePay;
	}
	public void setBenefit(int benefit) {
		this.benefit = benefit;
	}
	
	public void calc() { //calc() �޼ҵ� - ���
		int total = basePay + benefit;
		
		if(total <= 2000000) taxRate = 0.01; //������ �հ谡 200���� ���� : 1%(0.01)
		else if(total <= 4000000) taxRate = 0.02; //400���� ���� : 2%(0.02)
		else taxRate = 0.03; //400���� �ʰ� : 3%(0.03)
		
		tax = (int)(total * taxRate); //���� = (�⺻�� + ����) * ����
		salary = total - tax; //���� = �⺻�� + ���� - ����
	}
	
	public int getEmpId() { //getter
		return empId;
	}
	public String getName() {
		return name;
	}
	public String getPosition() {
		return position;
	}
	public int getBasePay() {
		return basePay;
	}
	/*
	public String getBasePay() {
		return df.format(basePay);
	}
	*/
	public int getBenefit() {
		return benefit;
	}
	public double getTaxRate() {
		return taxRate;
	}
	public int getTax() {
		return tax;
	}
	public int getSalary() {
		return salary;
	}
}
