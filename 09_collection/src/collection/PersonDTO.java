package collection;

//1�κ��� �����͸� ����
//�ܺο��� �����͸� ���������� ������(new�� �� �ѹ�), setter(������), ���������� getter �̿�
public class PersonDTO implements Comparable<PersonDTO> { 
	private String name;
	private int age;
	
	public PersonDTO(String name, int age) { //������
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

	@Override //Comparable<PersonDTO> �������̽��� �޼ҵ� compareTo�� Override
	public int compareTo(PersonDTO dto) { 
		//�������� - age �������� �� (���ϰ��� ���Ͽ� ����)
		//if(this.age < dto.age) return -1; 
		//else if(this.age == dto.age) return 0;
		//else return 1; // (this.age > dto.age)�� ��� 
		
		//��������
		if(this.age < dto.age) return 1;
		else if(this.age == dto.age) return 0;
		else return -1;
	}	
	
	@Override
	public String toString() {
		return "("+name+"\t"+age+")"; //�⺻ �ּҰ��� Ŭ������@16������ Override�Ͽ� ����
	}
	//list = [collection.PersonDTO@1175e2db, collection.PersonDTO@36aa7bc2, 
	//		  collection.PersonDTO@76ccd017]
	//list = [(ȫ�浿	25), (���̾�	30), (����ġ	28)]
}