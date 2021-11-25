package collection;

import java.util.ArrayList;

public class PersonMain {
	
	public ArrayList<PersonDTO> init() { //init() 구현
		PersonDTO aa = new PersonDTO("홍길동", 25); //PersonDTO의 생성자 호출
		PersonDTO bb = new PersonDTO("라이언", 30);
		PersonDTO cc = new PersonDTO("어피치", 28);
		
		//return 값이 여러개일 때 ArrayList로 묶을 수밖에 없다
		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>(); //Generic 지정
		list.add(aa); //ArrayList에 aa 더하라
		list.add(bb);
		list.add(cc);
		
		return list; //리턴값이 있으므로 void를 ArrayList<PersonDTO>로 변경
	}//init()

	public static void main(String[] args) {
		PersonMain pm = new PersonMain();
		ArrayList<PersonDTO> list = pm.init(); //init() 호출, return값 받아서 list에 저장
		System.out.println("list = "+list);
		//기본 주소값이 클래스명@16진수인데 list는 Override해서 주소값을 [~~]로 바꿔버림
		
		for(int i=0; i<list.size(); i++) { //여기서 i는 인덱스(위치)임
			System.out.println("이름 = "+ list.get(i).getName() +"\t"+
							   "나이 = "+ list.get(i).getAge());
		} //list.get(i)은 주소값이 나옴
		System.out.println();
		
		for(PersonDTO dto : list) { //ArrayList에서 값을 하나씩 꺼내 PersonDTO에 준다
			System.out.println("이름 = "+ dto.getName() + "\t나이 = " + dto.getAge());	
		}
		System.out.println();
	}
}

/*
[실행결과]
list = [(홍길동	25), (라이언	30), (어피치	28)]
이름 = 홍길동	나이 = 25
이름 = 라이언	나이 = 30
이름 = 어피치	나이 = 28

이름 = 홍길동	나이 = 25
이름 = 라이언	나이 = 30
이름 = 어피치	나이 = 28
*/