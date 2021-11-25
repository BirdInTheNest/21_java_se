/*
★ 변수(variable) - 메모리 할당(instance) //(메모리에 방을 잡는 것, instance : 메모리에 일정구역을 잡는 것)
: 변하는 값, 데이터를 저장하는 곳

클래스명의 첫 글자는 대문자로 시작하고, 변수나 메소드의 첫 글자는 소문자로 시작함

1. 기본형
자료형 변수명;
int a;

2. 객체형 (클래스형으로 잡는 것)
클래스명 객체명 = new 클래스명(); //이렇게 해야 메모리에 변수가 생성이 됨
DecimalFormat decimalFormat = new DecimalFormat();

3. 배열형
자료형[] 배열명 = {값1, 값2, 값3, …}	[] - 배열이라는 뜻, 0번 방부터 시작함 (cf. 오라클은 1부터 시작함)
int[] ar = new int[개수]
*/

/*
★ 메소드()
: 명령어들의 집합
: 기본적으로 public static void main(String[] ) 제공
: 호출한 메소드는 반드시 호출한 곳으로 되돌아온다 (수행시간이 길어지고, 복귀함과 동시에 함수에 있는 모든 메모리는 소멸)
: return(결과값, 반환값)은 반드시 1개뿐이다 (cf. 파이썬은 return을 여러 개 가질 수 있다.)
: return이 없으면 void로 선언한다 (결과물이 아무것도 나오지 않음)

1. 구현
returnType 메소드명(인수형 인수, 인수형 인수,...) {
	메소드body
}

2. 호출
객체명.메소드명(값1, 값2,...)
클래스명.메소드명(값1, 값2,...) → 메소드가 static 일 경우

기본형		Wrapper Class (기본형을 클래스화시킨 것)
--------------------------------
boolean		Boolean
char		Character
byte		Byte
short		Short
int			Integer
long		Long
float		Float
double		Double
*/

/*
실행시 이름, 국어, 영어, 수학 점수를 입력받아서 총점과 평균을 구하시오 //메소드를 만들어서 총점과 평균을 구한다
단) 국어, 영어, 수학은 문자열이므로 정수형으로 변환해야 한다.- Integer 클래스의 메소드를 이용
//java.lang.Integer.parseInt(String s) - static int //static이기 때문에 new 안해도 됨

[실행결과]
javac SungJuk.java
java  SungJuk  홍길동  95  97  100 

   *** 홍길동 성적표 ***
국어   영어   수학    총점   평균
95    97    100   xxx   xx.xx
*/

class SungJuk {
	public static void main(String[] args) {
		SungJuk sj = new SungJuk(); //클래스명 객체명 = new 클래스명(); //이렇게 해야 메모리에 변수(객체)가 생성이 됨

		String name = args[0]; //배열 args 첫번째값(문자열형)을 name변수에 저장
		int kor = Integer.parseInt(args[1]); //배열 args 두번째값(문자열형)을 정수형으로 변환하여 kor변수에 저장
		int eng = Integer.parseInt(args[2]); //배열 args 세번째값(문자열형)을 정수형으로 변환하여 eng변수에 저장
		int math = Integer.parseInt(args[3]); //배열 args 네번째값(문자열형)을 정수형으로 변환하여 math변수에 저장

		int tot = sj.total(kor, eng, math); //총점 메소드 생성- 객체명sj.메소드명total(값kor, eng, math)의 메소드를 정수형 tot변수에 저장
											  
		//double avg = sj.average(tot); -error : String cannot be converted to double
		String avg = sj.average(tot); //평균 메소드 생성- 객체명sj.메소드명average(값tot)의 메소드를 문자열형 avg변수에 저장

		System.out.println("\t *** " + name + " 성적표 ***");
		System.out.println("국어\t영어\t수학\t총점\t평균");
		System.out.println(kor +"\t"+ eng +"\t"+ math +"\t"+ tot +"\t"+ avg);
	}

	public int total(int kor, int eng, int math){
		return kor + eng + math; 		
	}

	//public double avgerage(int tot){
	//	return tot/3.0;		
	//}
	public String average(int tot){
		return String.format("%.2f", tot/3.0);		
	}
}

/*
[실행결과]
D:\java_se\workspace\0722>javac SungJuk.java

D:\java_se\workspace\0722>java SungJuk 홍길동  95  97  100
         *** 홍길동 성적표 ***
국어    영어    수학    총점    평균
95      97      100     292     97.33
*/