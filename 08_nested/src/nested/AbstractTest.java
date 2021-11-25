package nested;

//POJO 형식
public abstract class AbstractTest { //추상클래스(추상메소드 있음)
	String name;

	public String getName() {
		return name;
	}

	public abstract void setName(String name); //추상메소드
	//추상메소드가 있으면 반드시 추상클래스가 있어야 함, 반드시 추상메소드를 Override 해야 함
}
