package member_exam;

import java.util.List;
import java.util.Scanner;

//Service에서 데이터 입력받고, dto에 보관하고, DB dao에 저장
public class MemberService { //일만 하는 애
	Scanner scan = new Scanner(System.in);
//	private List<MemberDTO> list;
//	
//	public MemberService() { //생성자
//		list = new ArrayList<MemberDTO>(); //부모 = 자식
//	}
	
	public void menu() {
		int num; 
		
		while(true) {
			System.out.println("*****************\r\n"
					+ "1. 회원가입\r\n"
					+ "2. 로그인\r\n"
					+ "3. 회원 리스트\r\n"
					+ "4. 끝\r\n"
					+ "*****************\r\n"
					+ "번호 : ");
			num = scan.nextInt();
			if(num==4) break; //나가는 거 먼저 체크
		
			if(num==1) this.writeMember();
			else if(num==2) loginMember();
			else if(num==3) listMember();
			else System.out.println("1~4중에 선택하세요");
		}//while
		
	}//menu()

	private void writeMember() { //1. 회원가입 - 데이터 입력		
		System.out.println();
		System.out.print("이름 입력 : ");
		String name = scan.next();
		System.out.print("아이디 입력 : ");
		String id = scan.next();
		
		//DB에 연결
		MemberDAO dao = MemberDAO.getInstance();//싱글톤, 메모리에 하나로 dao 생성
		
		boolean exist = dao.isExistId(id);//id값 가지고 dao.isExistId() 호출, 리턴값 저장
		//100% boolean 형이 리턴되는 경우 메소드를 is~라고 씀
		
		if(exist) {
			System.out.println("이미 사용 중인 아이디입니다");	
			return; //함수를 나가라
		}else {
			System.out.println("사용 가능한 아이디입니다"); 				
		}
		
		System.out.print("비밀번호 입력 : ");
		String pwd = scan.next();
		System.out.print("이메일 입력 : ");
		String email = scan.next();
		
		MemberDTO dto = new MemberDTO(); //dto 생성, 값이 여러개일때는 dto 필요
		dto.setName(name);
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setEmail(email);
		
		//DB에 연결
		dao.writeMember(dto); //dto값 가지고 dao.writeMember() 호출
		
		System.out.println("회원가입을 축하합니다.");

	}//writeMember()

	private void loginMember() { //2. 로그인
		System.out.println();
		System.out.print("아이디 입력 : ");
		String id = scan.next();
		System.out.print("비밀번호 입력 : ");
		String pwd = scan.next();
		
		//DB에 연결
		MemberDAO dao = MemberDAO.getInstance(); //싱글톤
		
		String name = dao.loginMember(id, pwd);
		//id, pwd값 가지고 dao.loginMember() 호출, 리턴값 저장
		
		if(name==null) { //DB에서 가져온 값이 없으면
			System.out.println("아이디 또는 비밀번호가 맞지 않습니다");
		}else {
			System.out.println(name+"님 로그인되었습니다");
		}
	
	}//loginMember()

	private void listMember() { //3. 회원 리스트 - 출력
		//DB에 연결
		MemberDAO dao = MemberDAO.getInstance(); //싱글톤
		List<MemberDTO> list = dao.listMember(); //리턴값을 MemberDTO가 담긴 List에 저장
		
		System.out.println();
		System.out.println("이름\t아이디\t비밀번호\t이메일");
		
		for(MemberDTO dto : list) {
			System.out.println(dto); //dto의 주소값 출력 (toString())
		}//for	
		
	}//listMember()
}


















