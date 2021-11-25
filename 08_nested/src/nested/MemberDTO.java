package nested;

//1인분의 데이터 보관만 함 (DTO : Data Transfer Object, VO : Value Object), setter, getter
public class MemberDTO { 
	private String name, id, pwd;

	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
