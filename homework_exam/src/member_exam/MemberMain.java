/*
회원 관리 프로그램
아래의 조건에 맞게 회원 관리 프로그램을 작성하시오

[조건]
1. 회원가입 시에는 이름, 아이디, 비밀번호, 이메일 입력하시오.
2. 각 기능별 따라 4개의 클래스로 나누어 작성하시오
MemberDTO.java
MemberDAO.java
MemberService.java
MemberMain.java
3. 회원가입 시 아이디 중복체크 하시오
- 아이디가 존재하면 "이미 사용 중인 아이디입니다" 메시지 출력
- 아이디기 존재하지 않으면 "사용 가능한 아이디입니다" 메시지 출력
4. 테이블을 작성하시오
이름은 null이 허용되지 않도록 제약조건을 넣으시오
아이디는 중복되지 않도록 제약조건을 넣으시오
5. toString()을 Override 하시오
6. 회원 리스트에서 이름으로 오름차순 하시오
7. 소스코드는 메일로 보내고 결과 화면은 캡처하여 LMS로 제출하시오
[실행결과]
--- 실행 시 ---
menu()
*****************
1. 회원가입
2. 로그인
3. 회원 리스트
4. 끝
*****************
번호 : 8
1~4중에 선택하세요

--- 1번 회원가입을 선택했을 때 ---
writeMember()
-> 아이디가 없을 때
이름 입력 : 홍길동
아이디 입력 : hong 사용 가능한 아이디입니다
비밀번호 입력 :
이메일 입력 :

회원가입을 축하합니다.

-> 아이디가 있을 때
이름 입력 : 홍길동
아이디 입력 : hong 이미 사용 중인 아이디입니다

--- 2번 로그인을 선택했을 때 ---
loginMember()

-> 아이디가 존재했을 때
아이디 입력 : hong
비밀번호 입력 : 111

홍길동님 로그인

-> 아이디가 존재하지 않을 때
아이디 입력 : hong
비밀번호 입력 : 111

아이디 또는 비밀번호가 맞지 않습니다

--- 3번 회원 리스트를 선택했을 때 ---
listMember()

이름 아이디 비밀번호 이메일
라이언 ryan 111 ryan@naver.com
홍길동 hong 111 hong@java.com
 */

package member_exam;

public class MemberMain {

	public static void main(String[] args) { //메인은 시작과 종료
		MemberService service = new MemberService(); //클래스 생성, 생성자 호출
		service.menu();
		System.out.println("프로그램을 종료합니다");
	}
}