package com.zoo;

public class Zoo {
	public void tiger() { //public은 다 접근 가능
		System.out.println("무서운 호랑이");
	}
	
	protected void giraffe() { //protected는 같은 패키지 접근 가능, 다른 패키지인 자식클래스 접근가능
		System.out.println("목이 긴 기린");
	}
	
	void elephant() { //default는 같은 패키지 접근 가능
		System.out.println("뚱뚱한 코끼리");
	}
	
	private void lion() { //private은 나만 접근 가능
		System.out.println("멋진 사자");
	}
}

/*
★ 접근제한자 (Modifier)
			클래스	같은 패키지		다른 패키지		다른 패키지인 자식 클래스
private		  O		   X			X				X
default		  O		   O			X				X
protected	  O		   O			X				O
public		  O		   O			O				O

※ default라고 직접 쓰는 것이 아니라 
   public, protected, private 를 쓰지 않은 상태

※ protected는 다른 패키지에서 Sub 클래스라면 접근이 가능하다
   단 Sub 클래스로 생성해야만 한다
   Super클래스로 생성하면 접근이 안된다
  
  같은 패키지면 private만 빼고 다 접근 가능
  다른 패키지면 public으로만 접근 가능 (따라서 웹은 public)
*/