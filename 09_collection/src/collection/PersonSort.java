package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class PersonSort {

	public static void main(String[] args) {
		String[] ar = {"orange", "apple", "banana", "pear", "peach", "applemango"};
	
		System.out.print("정렬 전 = ");
		for(String str : ar) {
			System.out.print(str + "  ");
		} //정렬 전 = orange  apple  banana  pear  peach  applemango
		System.out.println(); 
		
		Arrays.sort(ar); //ar은 배열이라 Arrays.sort() 사용
		
		System.out.print("정렬 후 = ");
		for(String str : ar) {
			System.out.print(str + "  ");
		} //정렬 후 = apple  applemango  banana  orange  peach  pear 
		System.out.println("\n");

		PersonDTO aa = new PersonDTO("홍길동", 25); 
		PersonDTO bb = new PersonDTO("라이언", 30);
		PersonDTO cc = new PersonDTO("어피치", 28);
		
		ArrayList<PersonDTO> list = new ArrayList<PersonDTO>();
		list.add(aa);
		list.add(bb);
		list.add(cc);
		
		System.out.println("정렬 전 : ");
		System.out.println(list); //list의 주소값은 항목을 보여줌
		System.out.println();
		
		Collections.sort(list);	//ArrayList라 Collections.sort() 사용, Comparable로 정렬
		
		System.out.println("나이로 오름차순(내림차순) : ");
		System.out.println(list);
		System.out.println();
		
		System.out.println("이름으로 오름차순(내림차순) : ");
		//Comparator는 기본 정렬기준 외에 다른 기준으로 정렬하고자할 때 사용
		//Comparator는 인터페이스라 new가 안됨, 익명 inner class로 생성해야함
		Comparator<PersonDTO> com = new Comparator<PersonDTO>() {
			@Override //추상메소드 compare Override해야함
			public int compare(PersonDTO dto1, PersonDTO dto2) { //인자 두개 비교
				//오름차순
				//return dto1.getName().compareTo(dto2.getName()); 
				//dto1에서 가져온 문자열 값과 dto2에서 가져온 문자열 값 비교
				//compareTo : 비교대상자가 더 크면(<) -1, 같다면(==) 0, 작으면(>) 1을 반환
				
				//내림차순
				//return dto2.getName().compareTo(dto1.getName());
				return dto1.getName().compareTo(dto2.getName()) * -1; //부등호 바꾸기
			}
		};
		
		Collections.sort(list, com); //리스트 안에 있는 것을 Comparator로 sort해주세요
		System.out.println(list);
		System.out.println();
	}
}

/*
[실행결과]
정렬 전 = orange  apple  banana  pear  peach  applemango  
정렬 후 = apple  applemango  banana  orange  peach  pear  

정렬 전 : 
[(홍길동	25), (라이언	30), (어피치	28)]

나이로 오름차순(내림차순) : 
[(라이언	30), (어피치	28), (홍길동	25)]

이름으로 오름차순(내림차순) : 
[(홍길동	25), (어피치	28), (라이언	30)]
---------------------------------------------------------------
문자열은 값이 없고 주소값만 있다, 한글자씩 비교

★ Comparable / Comparator 인터페이스
객체을 정렬하는데 필요한 메소드가 정의되어 있다
비교대상자가 더 크면(<) -1, 같다면(==) 0, 작으면(>) 1을 반환시켜줍니다. 
이 값을 비교하여 정렬을 할 수 있습니다.

일반적인 int, char, double 같은 타입의 배열이라면 다음 함수들을 이용
Collections(또는 Arrays).sort()       : 정렬 
Collectoins(또는 Arrays).reverse()    : 뒤집기

1. Comparable (java.lang)
- 기본 정렬기준을 구현하는데 사용
주로 Integer와 같은 warpper클래스와 String, Date, File과 같은 것
기본적으로 오름차순으로 정렬되도록 구현되어 있다
- public int compareTo(T o)

public final class Integer
extends Number
implements Comparable<Integer>

2. Comparator (java.util)
- 기본 정렬기준 외에 다른 기준으로 정렬하고자할 때 사용
- public int compare(T o1, T o2)
  public boolean equals(Object obj)
*/