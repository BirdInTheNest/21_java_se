/*
성적관리 프로그램
1. 번호, 이름, 국어, 영어, 수학점수를 입력하여 총점과 평균을 구하시오
2. 각 기능에 따라 3개의 클래스로 나누어 작성하시오
   SungJukDTO.java
   SungJukService.java
   SungJukMain.java - 시작점과 종료점
3. 평균은 소수이하 2째자리까지 출력
   소수이하 자리값이 0이면 출력하지 않는다
   ex) 92.000 → 92로 출력하시오
4. 번호는 중복되지 않게 입력한다.
5. 이름은 중복되어도 된다 (똑같은 이름을 입력하세요)
6. Comparable / Comparator 써도 되고, 아니면 Comparator 2번 써도 된다
7. SungJukDTO에서 toString()을 Override 하시오
	15      홍길동   90      92      91      xxx      xx.xx 얘를 주소값으로 변경

menu()
*****************
   1. 입력
   2. 출력
   3. 검색
   4. 삭제
   5. 정렬
   6. 끝
*****************
   번호 : 8
1~6중에 선택하세요

insertArticle()
번호 입력 :
이름 입력 :
국어 입력 :
영어 입력 :
수학 입력 :

 등록 완료

printArticle()
번호      이름      국어      영어      수학      총점      평균
15      홍길동   90      92      91      xxx      xx.xx
30      또치      85      92      100      xxx      xx.xx

searchArticle()
검색 할 이름 입력 : 코난
찾고자 하는 이름이 없습니다

검색 할 이름 입력 : 홍길동
번호      이름      국어      영어      수학      총점      평균
15      홍길동   90      92      91      xxx      xx.xx
16      홍길동   89      45      78      xxx      xx.xx

deleteArticle() - 똑같은 이름이 있으면 모두 삭제
삭제 할 이름 입력 : 홍길동
데이터를 삭제하였습니다

sortArticle()
1. 이름으로 오름차순
2. 총점으로 내림차순
3. 이전메뉴
 번호 입력 : 
 */

package collection;

public class SungJukMain {

	public static void main(String[] args) { //서비스 생성하고 메뉴함수 부르고 끝
//		List 처리
//		SungJukService service = new SungJukService(); 
//		service.menu();
		
//		DB 처리
		SungJukServiceDB serviceDB = new SungJukServiceDB();
		serviceDB.menu();

		System.out.println("프로그램을 종료합니다");
	}
}

/*
테이블명 : sungjuk
no number unique, --유일한 키, 중복불가
name varchar2(20) not null, --null값이 안됨, 반드시 입력해야함
kor number,
eng number,
math number,
tot number,
avg number(5,2) --전체 4자리에 소수점 이하 2자리
 */
