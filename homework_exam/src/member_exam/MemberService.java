package member_exam;

import java.util.List;
import java.util.Scanner;

//Service���� ������ �Է¹ް�, dto�� �����ϰ�, DB dao�� ����
public class MemberService { //�ϸ� �ϴ� ��
	Scanner scan = new Scanner(System.in);
//	private List<MemberDTO> list;
//	
//	public MemberService() { //������
//		list = new ArrayList<MemberDTO>(); //�θ� = �ڽ�
//	}
	
	public void menu() {
		int num; 
		
		while(true) {
			System.out.println("*****************\r\n"
					+ "1. ȸ������\r\n"
					+ "2. �α���\r\n"
					+ "3. ȸ�� ����Ʈ\r\n"
					+ "4. ��\r\n"
					+ "*****************\r\n"
					+ "��ȣ : ");
			num = scan.nextInt();
			if(num==4) break; //������ �� ���� üũ
		
			if(num==1) this.writeMember();
			else if(num==2) loginMember();
			else if(num==3) listMember();
			else System.out.println("1~4�߿� �����ϼ���");
		}//while
		
	}//menu()

	private void writeMember() { //1. ȸ������ - ������ �Է�		
		System.out.println();
		System.out.print("�̸� �Է� : ");
		String name = scan.next();
		System.out.print("���̵� �Է� : ");
		String id = scan.next();
		
		//DB�� ����
		MemberDAO dao = MemberDAO.getInstance();//�̱���, �޸𸮿� �ϳ��� dao ����
		
		boolean exist = dao.isExistId(id);//id�� ������ dao.isExistId() ȣ��, ���ϰ� ����
		//100% boolean ���� ���ϵǴ� ��� �޼ҵ带 is~��� ��
		
		if(exist) {
			System.out.println("�̹� ��� ���� ���̵��Դϴ�");	
			return; //�Լ��� ������
		}else {
			System.out.println("��� ������ ���̵��Դϴ�"); 				
		}
		
		System.out.print("��й�ȣ �Է� : ");
		String pwd = scan.next();
		System.out.print("�̸��� �Է� : ");
		String email = scan.next();
		
		MemberDTO dto = new MemberDTO(); //dto ����, ���� �������϶��� dto �ʿ�
		dto.setName(name);
		dto.setId(id);
		dto.setPwd(pwd);
		dto.setEmail(email);
		
		//DB�� ����
		dao.writeMember(dto); //dto�� ������ dao.writeMember() ȣ��
		
		System.out.println("ȸ�������� �����մϴ�.");

	}//writeMember()

	private void loginMember() { //2. �α���
		System.out.println();
		System.out.print("���̵� �Է� : ");
		String id = scan.next();
		System.out.print("��й�ȣ �Է� : ");
		String pwd = scan.next();
		
		//DB�� ����
		MemberDAO dao = MemberDAO.getInstance(); //�̱���
		
		String name = dao.loginMember(id, pwd);
		//id, pwd�� ������ dao.loginMember() ȣ��, ���ϰ� ����
		
		if(name==null) { //DB���� ������ ���� ������
			System.out.println("���̵� �Ǵ� ��й�ȣ�� ���� �ʽ��ϴ�");
		}else {
			System.out.println(name+"�� �α��εǾ����ϴ�");
		}
	
	}//loginMember()

	private void listMember() { //3. ȸ�� ����Ʈ - ���
		//DB�� ����
		MemberDAO dao = MemberDAO.getInstance(); //�̱���
		List<MemberDTO> list = dao.listMember(); //���ϰ��� MemberDTO�� ��� List�� ����
		
		System.out.println();
		System.out.println("�̸�\t���̵�\t��й�ȣ\t�̸���");
		
		for(MemberDTO dto : list) {
			System.out.println(dto); //dto�� �ּҰ� ��� (toString())
		}//for	
		
	}//listMember()
}


















