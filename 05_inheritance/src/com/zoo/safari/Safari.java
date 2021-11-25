package com.zoo.safari;

import com.zoo.Zoo;

public class Safari extends Zoo {

	public static void main(String[] args) {
		Zoo z = new Zoo();
		z.tiger();
		//z.giraffe(); protected는 같은 패키지 접근 가능, 다른 패키지인 자식클래스 접근가능이지만
		//부모 생성하고 부모의 주소값을 참조하여, Safari()가 자식인지 모르기 때문에 접근 불가로 뜨는 것임  
		
		//z.elephant();
		//z.lion();
		System.out.println("-----------");
		
		Safari s = new Safari(); //자식 생성하고 자식의 주소값을 참조하였기 때문에
		s.tiger();
		s.giraffe(); //Safari()가 자식이라는 걸 알아서 접근 가능
		//s.elephant();
		//s.lion();
	}
}
