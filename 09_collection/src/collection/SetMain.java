package collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetMain { //Set은 add로 넣고

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>(); 
		//추상메소드를 대신 Override 해주는 클래스로 생성, Generic 타입 걸기
		set.add("호랑이");
		set.add("사자");
		set.add("호랑이"); //Set은 중복허용 x, 순서 x (컬렉션과 반대임)
		set.add("기린");
		set.add("코끼리");
		
		Iterator<String> it = set.iterator(); //생성
		while(it.hasNext()) {
			System.out.println(it.next());
		}//while
	}
}
