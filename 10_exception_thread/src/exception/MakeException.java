package exception;

public class MakeException extends Exception { //is a ��Ӱ���, �����ڰ� ���� Exception Ŭ������
	private String errorMessage;
	
	public MakeException() { //�⺻�����ڴ� �־�� ��
		
	}
	
	public MakeException(String errorMessage) { //�����޽����� �� �����ڵ� �־�� ��
		this.errorMessage = errorMessage;
	}
	
	@Override
	public String toString() { 
		//return errorMessage;
		return getClass()+" : "+errorMessage; //class exception.MakeException
		
		//getClass()�� ���� �����ϰ� �ִ� Ŭ������ Ȯ���� �� �ִ� �޼ҵ�
	}
}
