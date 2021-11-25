package exception;

public class MakeException extends Exception { //is a 상속관계, 개발자가 만든 Exception 클래스임
	private String errorMessage;
	
	public MakeException() { //기본생성자는 있어야 함
		
	}
	
	public MakeException(String errorMessage) { //에러메시지가 뜰 생성자도 있어야 함
		this.errorMessage = errorMessage;
	}
	
	@Override
	public String toString() { 
		//return errorMessage;
		return getClass()+" : "+errorMessage; //class exception.MakeException
		
		//getClass()는 현재 참조하고 있는 클래스를 확인할 수 있는 메소드
	}
}
