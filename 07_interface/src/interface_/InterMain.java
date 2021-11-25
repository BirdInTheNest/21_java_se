package interface_;

//public class InterMain implements InterA, InterB {
public class InterMain implements InterC {
	public void aa() {}
	public void bb() {}

	public void cc() {}
	public void dd() {}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*
error
1. 재구현
2. 추상클래스

원래는 InterMain이 재구현 해야한다
InterMain의 자식클래스에 떠 넘긴다
implements는 재구현해달라는 뜻
------------------------------------
자바 클래스는 다중상속이 안 된다
자바 인터페이스는 다중상속이 된다
*/



