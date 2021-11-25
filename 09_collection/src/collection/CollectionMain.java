package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionMain {

	public static void main(String[] args) {
		Collection coll = new ArrayList(); //추상메소드를 대신 Override 해주는 클래스로 생성
		//ArrayList list = new ArrayList(); //추상클래스 아니므로 new 가능
		coll.add("호랑이");
		coll.add("사자");
		coll.add("호랑이"); //Collection은 중복허용, 순서 존재
		coll.add(25);
		coll.add(43.8);
		coll.add("기린");
		coll.add("코끼리");
		
		Iterator it = coll.iterator(); //컬렉션의 지정자를 메소드를 통해 생성
		while(it.hasNext()) { //it.hasNext() - 현재 위치에 항목 있으면 T, 없으면 F
			System.out.println(it.next()); //it.next() - 현재 위치의 항목을 꺼내고 다음으로 이동
		}//while
	}
}

/*
★ Collection (java.util)
: 객체를 담아주는 저장 창고
: 객체 타입에 상관없이 저장 가능
: 크기 조절 가능

# Enumeration
# Iterator
------------------------------------------------------------------------
Interface
1. implements
	모든 추상 메소드를 Override
2. 추상메소드를 대신 Override 해주는 클래스가 존재 (Implementing Class)
------------------------------------------------------------------------
Interface Collection의 Implementing Classes

Stack (Last In First Out)
LinkedList
Queue (First In First Out)
ArrayList - 배열처럼 취급, Object로 데이터를 받겠다, 인덱스 존재
------------------------------------------------------------------------
Interface Set의 Implementing Classes

HashSet
------------------------------------------------------------------------
Interface Map의 Implementing Classes

HashMap
*/