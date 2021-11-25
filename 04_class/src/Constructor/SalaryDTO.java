package Constructor;

//import java.text.DecimalFormat;
import java.util.Scanner;

public class SalaryDTO {
	private int empId; //필드 : empId(사원번호)
	private String name; 
	private String position; 
	private int basePay; 
	private int benefit;
	private double taxRate; 
	private int tax;
	private int salary; 
	//private DecimalFormat df = new DecimalFormat();
	
	public SalaryDTO() { //생성자 메소드 - 입력
		Scanner scan = new Scanner(System.in);
		
		System.out.print("사원번호 입력 : "); 
		empId = scan.nextInt();
		System.out.print("사원명 입력 : ");
		name = scan.next(); //문자열
		System.out.print("직급 입력 : ");
		position = scan.next();
		System.out.print("기본급 입력 : ");
		basePay = scan.nextInt();
		System.out.print("수당 입력 : ");
		benefit = scan.nextInt();
	}
	
	//생성자와 setter가 같은 역할을 함. setter은 계속 수정을 요할 때 강제 호출
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
	
	public void calc() { //calc() 메소드 - 계산
		int total = basePay + benefit;
		
		if(total <= 2000000) taxRate = 0.01; //세율은 합계가 200만원 이하 : 1%(0.01)
		else if(total <= 4000000) taxRate = 0.02; //400만원 이하 : 2%(0.02)
		else taxRate = 0.03; //400만원 초과 : 3%(0.03)
		
		tax = (int)(total * taxRate); //세금 = (기본급 + 수당) * 세율
		salary = total - tax; //월급 = 기본급 + 수당 - 세금
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
