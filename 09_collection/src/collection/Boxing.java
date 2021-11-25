package collection;

public class Boxing {

	public static void main(String[] args) {
		int a = 25;
		double b = (double)a/3; //강제 형변환(int->double) / 자동 형변환(3->3.0)

		String c = "25";
		//int d = (int)c; - error :객체형을 기본형으로 형변환 불가
		int d = Integer.parseInt(c); //기본형은 기본형으로, 객체형은 객체형으로 형변환
		
		int e=5;
		Integer f = e; //AutoBoxing 기본형이 객체형으로 간다(객체화), 같은 계열이라 가능
		//Integer f = new Integer(e); - JDK 5.0 이전에서 사용
		
		Integer g=5;
		int h = g; //AutoUnBoxing 객체형이 기본형으로 간다(객체화를 푼다), 같은 계열이라 가능
		//int h = g.intValue(); - JDK 5.0 이전에서 사용		
	}
}
