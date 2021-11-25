package swing;

//상수화 클래스를 만들어준다 - (세번째 방법)
enum Shape{ //상수들의 집합체, 0부터 시작, 자료형이 enum임
	LINE, CIRCLE, RECT, ROUNDRECT, PEN
}
//---------------------------------

//도형 1개
public class ShapeDTO {
//	private int shape; - (첫번째 방법)
//	0이면 선, 1이면 원, 2이면 사각형, 3이면 둥근 사각형으로 정해서 사용, 알아보기 힘드므로 상수화 한다 

//	public static final int LINE=0; - (두번째 방법 - 한 두개일 때 사용)
//	public static final int CIRCLE=1;
//	public static final int RECT=2;
//	public static final int ROUNDRECT=3;
//	public static final int PEN=4;
	
	private int x1, y1, x2, y2, z1, z2;
	private boolean fill;
	private Shape shape;
	private int color; //콤보박스의 index만 부여하면 되니까 int형 사용

	//setter, getter
	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getY1() {
		return y1;
	}
	public void setY1(int y1) {
		this.y1 = y1;
	}
	public int getX2() {
		return x2;
	}
	public void setX2(int x2) {
		this.x2 = x2;
	}
	public int getY2() {
		return y2;
	}
	public void setY2(int y2) {
		this.y2 = y2;
	}
	public int getZ1() {
		return z1;
	}
	public void setZ1(int z1) {
		this.z1 = z1;
	}
	public int getZ2() {
		return z2;
	}
	public void setZ2(int z2) {
		this.z2 = z2;
	}
	public boolean isFill() {
		return fill;
	}
	public void setFill(boolean fill) {
		this.fill = fill;
	}
	public Shape getShape() {
		return shape;
	}
	public void setShape(Shape shape) {
		this.shape = shape;
	}
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		this.color = color;
	}
	
	@Override
		public String toString() {
			return shape+" ";
		}
}
