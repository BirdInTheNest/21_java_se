package collection;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionMain3 { 

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>(); //1. Generic 타입 하나로 걸기
		list.add("호랑이");
		list.add("사자");
		list.add("호랑이"); //Collection은 중복허용, 순서 존재
		//list.add(25);
		//list.add(43.8);
		list.add("기린");
		list.add("코끼리");
		
		//출력
		Iterator it = list.iterator(); //생성
		while(it.hasNext()) { //it.hasNext() - 현재 위치에 항목 있으면 T, 없으면 F
			System.out.println(it.next()); //it.next() - 현재 위치의 항목을 꺼내고 다음으로 이동
		}//while
		System.out.println("------------");
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}//for
		System.out.println("------------");
		
		for(String data : list) {
			System.out.println(data);
		}//for
	}
}
