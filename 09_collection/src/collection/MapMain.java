package collection;

import java.util.HashMap;
import java.util.Map;

public class MapMain { //Map은 put으로 넣고, Key 이름, Value 값으로 관리

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		//추상메소드를 대신 Override 해주는 클래스로 생성, Generic 타입 걸기, Key 이름, Value 값
		map.put("book101", "백설공주");
		map.put("book201", "인아공주");
		map.put("book102", "백설공주"); //Value 중복허용
		map.put("book301", "피오나");
		map.put("book101", "엄지공주"); //Key 중복허용, Value값 덮어씀
		
		System.out.println(map.get("book102")); //백설공주
		System.out.println(map.get("book103")); //Key값이 없으면 결과값 null로 뜸
		System.out.println(map.get("book101")); //엄지공주
	}
}
