package collection;

//1인분의 데이터만 저장
//외부에서 데이터를 가져오려면 생성자(new할 때 한번), setter(수정용), 내보내려면 getter 이용
public class PersonDTO implements Comparable<PersonDTO> { 
	private String name;
	private int age;
	
	public PersonDTO(String name, int age) { //생성자
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override //Comparable<PersonDTO> 인터페이스의 메소드 compareTo를 Override
	public int compareTo(PersonDTO dto) { 
		//오름차순 - age 기준으로 비교 (리턴값을 비교하여 정렬)
		//if(this.age < dto.age) return -1; 
		//else if(this.age == dto.age) return 0;
		//else return 1; // (this.age > dto.age)인 경우 
		
		//내림차순
		if(this.age < dto.age) return 1;
		else if(this.age == dto.age) return 0;
		else return -1;
	}	
	
	@Override
	public String toString() {
		return "("+name+"\t"+age+")"; //기본 주소값인 클래스명@16진수를 Override하여 변경
	}
	//list = [collection.PersonDTO@1175e2db, collection.PersonDTO@36aa7bc2, 
	//		  collection.PersonDTO@76ccd017]
	//list = [(홍길동	25), (라이언	30), (어피치	28)]
}