package member_exam;

//1�κ� �����͸� ������ ����, �ʵ��, setter, getter
public class MemberDTO extends Object {
	private String name;
	private String id;
	private String pwd;
	private String email;
	
//	public MemberDTO() {
//		
//	}
//	
//	public MemberDTO(String name, String id, String pwd, String email) { //������
//		this.name = name;
//		this.id = id;
//		this.pwd = pwd;
//		this.email = email;
//	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	
//	MemberServiced�� listMember()���� System.out.println(dto);�� ������ 
//	ObjectŬ������ toString()�� ���ؼ� �ּҰ��� Ŭ������@16���� ������
//	Override�϶� �ڽ�Ŭ���� �޼ҵ尡 �켱������ ������ �����Ƿ�,
//	Object�� �ڽ�Ŭ������ MemberDTO�� toString()�� Override�ؼ� ���ϴ� �������� ������
//	
//	for(MemberDTO dto : list) {
//		System.out.println(dto.getName()+"\t"
//				+ dto.getId()+"\t"
//				+ dto.getPwd()+"\t"
//				+ dto.getEmail());
//	}//for	
//	�̷��� ���� �ϴ� ����
//	for(MemberDTO dto : list) {
//		System.out.println(dto);
//	} �̷��� ���� �� �ְ� MemberDTO�� toString()�� Override

	@Override
	public String toString() {
		return name+"\t"+id+"\t"+pwd+"\t"+email;
	}	
}










