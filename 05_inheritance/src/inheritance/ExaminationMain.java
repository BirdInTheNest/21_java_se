/*
답안지를 입력하여 채점하는 프로그램을 작성하시오
이름과 5개의 답을 입력하여 OX로 채점하시오
- 총 문제수는 5문제이다
- 점수는 1문제당 20점입니다

[실행결과]
이름 입력 : 홍길동
답 입력 : 14123

이름      1 2 3 4 5   점수
홍길동   O X O X X   40

클래스 : Examination
필드  : name, dap, ox[], score
메소드 :  생성자 - Scanner
        compare() - 비교, 점수 계산
        getter
        
[실행결과]
인원수 입력 : 3

이름 입력 : 홍길동
답 입력 : 13211

이름 입력 : 코난
답 입력 : 11111

이름 입력 : 또치
답 입력 : 13242

이름      1 2 3 4 5   점수
홍길동     O X X O O   60
코난      O O O O O   100
또치      O X X X X   20
 */

package inheritance;

import java.util.Scanner;

public class ExaminationMain {

	public static void main(String[] args) {
		Examination aa = new Examination(); //클래스 메모리에 생성, 생성자 호출
		aa.compare(); //메소드 호출
		
		//출력
		System.out.print(aa.getName() + "\t");
		for(int i=0; i<aa.getOx().length; i++)
			System.out.print(aa.getOx()[i] + " ");
		System.out.println("\t" + aa.getScore());
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("인원수 입력 : ");
		int size = scan.nextInt();
		
		Examination[] ar = new Examination[size]; //자료형이 클래스형인 객체 배열 size개 생성
		//Object[] ar = new Examination[size]; //최상위 클래스인 Object로 자료형을 받아도 됨
		
		for(int i=0; i<size; i++) {
			ar[i] = new Examination(); //클래스 생성
			ar[i].compare(); //메소드 호출
			System.out.println();
		}//for
		
		//출력
		for(int k=0; k<size; k++) {
			System.out.print(ar[k].getName() + "\t");
			
			for(int i=0; i<ar[k].getOx().length; i++)
				System.out.print(ar[k].getOx()[i] + " ");
			
			System.out.println("\t" + ar[k].getScore());
		}//for k
	}
}

/*
[실행결과]
이름 입력 : 브루스
답 입력 : 11111
브루스	O O O O O 	100
인원수 입력 : 3
이름 입력 : 클락
답 입력 : 11212

이름 입력 : 배리
답 입력 : 11211

이름 입력 : 할
답 입력 : 22111

클락	O O X O X 	60
배리	O O X O O 	80
할	X X O O O 	60
*/
