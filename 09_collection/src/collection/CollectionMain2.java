package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionMain2 {

	//@SuppressWarnings("all")
	@SuppressWarnings({"rawtypes", "unchecked"}) //2. 워닝 억제 어노테이션 사용
	public static void main(String[] args) {
		//Collection<String> coll = new ArrayList<String>(); //1. 제너릭으로 타입을 하나로 걸기
		
		Collection coll = new ArrayList();
		//ArrayList list = new ArrayList();
		coll.add("호랑이");
		coll.add("사자");
		coll.add("호랑이"); //중복허용, 순서
		coll.add(25);
		coll.add(43.8);
		coll.add("기린");
		coll.add("코끼리");
		
		Iterator it = coll.iterator(); //지정자를 컬렉션 안에 생기도록 메소드를 통해 생성
		while(it.hasNext()) { //it.hasNext() - 현재 위치에 항목 있으면 T, 없으면 F
			System.out.println(it.next()); //it.next() - 현재 위치의 항목을 꺼내고 다음으로 이동
		}//while
	}
}

/*
Warning(노란 밑줄) : 에러가 나진 않는데 불안하니 1. 제너릭으로 타입을 하나로 하거나, 2. 워닝 억제 어노테이션 사용

★ 자바가 제공하는 어노테이션
1. @Override
2. @Deprecated
3. @SuppressWarnings(옵션)

옵션
1. all : 모든 경고를 억제
2. cast : 캐스트 연산자 관련 경고 억제
3. dep-ann : 사용하지 말아야 할 주석 관련 경고 억제
4. deprecation : 사용하지 말아야 할 메소드 관련 경고 억제
5. fallthrough : switch문에서의 break 누락 관련 경고 억제
6. finally : 반환하지 않는 finally 블럭 관련 경고 억제
7. null : null 분석 관련 경고 억제
8. rawtypes : 제네릭을 사용하는 클래스 매개변수가 불특정일 때의 경고 억제
9. unchecked : 검증되지 않은 연산자 관련 경고 억제
10. unused : 사용하지 않는 코드 관련 경고 억제
-----------------------------------------------------------------
배열의 크기 length
문자열의 크기 length()
리스트의 크기 size
*/