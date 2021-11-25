/*
월급 계산 프로그램
이름, 직급, 기본급, 수당을 입력하여 급여, 세금, 월급을 계산하시오
세율은 급여가 4,000,000 만원 이상이면 3% 아니면 2%로 한다 (조건연산자 - 조건 ? 참 : 거짓)

급여 = 기본급 + 수당
세금 = 급여 * 세율
월급 = 급여 - 세금

세금은 calcTax() 메소드 구하여 가져온다 (return)
월급은 calcSalary()  메소드 구하여 가져온다 (return)

[실행결과]
이름 입력  : 홍길동
직급 입력  : 부장
기본급 입력 : 4500000
수당 입력 : 200000

         *** 홍길동 월급 명세서 ***
직급 : 부장
기본급          수당         급여         세율      세금      월급
4,500,000     200,000     4,700,000   3%      xxxxx   xxxxxxx
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Salary {
   public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		Salary s = new Salary(); //클래스명 객체명 = new 클래스명(); - 객체 생성

		System.out.print("이름 입력  : ");
		String name = br.readLine();

		System.out.print("직급 입력  : ");
		String position = br.readLine();
		
		System.out.print("기본급 입력 : ");
		int basePay = Integer.parseInt(br.readLine());

		System.out.print("수당 입력 : ");
		int allowance = Integer.parseInt(br.readLine());

		int pay = basePay + allowance; //급여 = 기본급 + 수당

		double taxRate = pay >=4000000 ? 0.03 : 0.02;
		//세율은 급여가 4,000,000 만원 이상이면 3% 아니면 2%로 한다 (조건연산자 - 조건 ? 참 : 거짓)





		int tax = Integer.parseInt(s.calcTax(pay, taxRate)); //세금 = 급여 * 세율

		//int salary = s.calcSalary(pay, tax); //월급 = 급여 - 세금 -error String cannot be converted to int
		int salary = Integer.parseInt(s.calcSalary(pay, tax));


		System.out.println("\t\t"+"*** "+name+" 월급 명세서 ***");
		System.out.println("직급 : "+position);
		System.out.println("기본급\t\t수당\t\t급여\t\t세율\t\t세금\t\t월급");
		System.out.println(basePay+"\t\t"+allowance+"\t\t"+pay+"\t\t"+taxRate+"\t\t"+tax+"\t\t"+salary);
   }
	
	public String calcTax(int pay, double taxRate){
		return String.format("%d", pay * taxRate);
   }

   	public String calcSalary(int pay, int tax){
		return String.format("%d", pay - tax);
   }
}