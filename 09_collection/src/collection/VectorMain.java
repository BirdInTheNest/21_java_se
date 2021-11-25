package collection;

import java.util.Iterator;
import java.util.Vector;

public class VectorMain {

	public static void main(String[] args) {
		//Collection coll = new Vector();
		
		Vector<String> v = new Vector<String>(); //기본용량 10개, 데이터 늘수록 10개씩 증가
		System.out.println("벡터 크기 = " + v.size()); //0 - 항목 개수
		System.out.println("벡터 용량 = " + v.capacity()); //10 - 벡터 크기
		System.out.println();
		
		System.out.println("----- 항목 추가 -----");
		for(int i=1; i<=10; i++) {
			v.add(i+"");
		}
		
		v.add("5"); //중복허용, 순서(인덱스) 존재
		//v.addElement("5");
		System.out.println("벡터 크기 = " + v.size()); //11
		System.out.println("벡터 용량 = " + v.capacity()); //10 -> 20
		System.out.println();
		
		for(int i=0; i<v.size(); i++) {
			System.out.print(v.get(i)+"  "); //인덱스값으로 가져오기
		}
		System.out.println();
		
		System.out.println("----- 항목 삭제 -----");
		v.remove("5"); //앞에 있는 "5"를 삭제
		//v.removeElement("5");
		v.removeElementAt(9); //charAt처럼 위치지정 필요, 뒤에 있는 "5"를 삭제
		
		Iterator<String> it = v.iterator(); //지정자 생성
		while(it.hasNext()) {
			System.out.print(it.next()+"  ");
		}
		System.out.println();
		
		Vector<String> v2 = new Vector<String>(5, 2); //기본 용량 5개로 설정, 2개씩 증가
	}
}

/*
Vector는 Collection의 Implementing Class임
Collection은 getter 못 씀, 값을 꺼내려면 Interator 사용해야 함

ArrayList는 데이터가 들어올수록 크기가 커진다

"orange".charAt(2) - a
-----------------------------------------------------------------------------
[실행결과]
벡터 크기 = 0
벡터 용량 = 10

----- 항목 추가 -----
벡터 크기 = 11
벡터 용량 = 20

1  2  3  4  5  6  7  8  9  10  5  
----- 항목 삭제 -----
1  2  3  4  6  7  8  9  10  
*/