package member_exam;

//1인분 데이터만 가지고 있음, 필드명, setter, getter
public class MemberDTO extends Object {
	private String name;
	private String id;
	private String pwd;
	private String email;
	
//	public MemberDTO() {
//		
//	}
//	
//	public MemberDTO(String name, String id, String pwd, String email) { //생성자
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
	
//	MemberServiced의 listMember()에서 System.out.println(dto);를 찍으면 
//	Object클래스의 toString()에 의해서 주소값인 클래스명@16진수 내보냄
//	Override일때 자식클래스 메소드가 우선순위를 가지고 있으므로,
//	Object의 자식클래스인 MemberDTO의 toString()을 Override해서 원하는 형식으로 리턴함
//	
//	for(MemberDTO dto : list) {
//		System.out.println(dto.getName()+"\t"
//				+ dto.getId()+"\t"
//				+ dto.getPwd()+"\t"
//				+ dto.getEmail());
//	}//for	
//	이렇게 찍어야 하는 것을
//	for(MemberDTO dto : list) {
//		System.out.println(dto);
//	} 이렇게 찍을 수 있게 MemberDTO의 toString()을 Override

	@Override
	public String toString() {
		return name+"\t"+id+"\t"+pwd+"\t"+email;
	}	
}










