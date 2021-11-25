package swing;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

//AbstractTableModel는 추상클래스로 추상메소드 Override 필요
class JTableModel extends AbstractTableModel{  
	
//	Object[][] data = {{"Nari", "마루치", new Integer(1234), "옆집친구"}, 
//				  	  {"One", "오윤아", new Integer(1111), "예쁜이"},
//					  {"Two", "오윤서", new Integer(2222), "귀염둥이"},
//					  {"Three", "아라치", new Integer(3333), "동아리 친구"}};

//	new Integer(1234)는 더 이상 사용되지 않고 앞으로는 사라지기 때문에 웬만하면 쓰지마라
//	Object 클래스 객체형이기 때문에 Integer 객체형 쓴 건데 그렇게 안해도 JDK 9부터는 AutoBoxing 된다
	
	Object[][] data = {{"Nari", "마루치", 1234, "옆집친구"}, 
					  {"One", "오윤아", 1111, "예쁜이"},
					  {"Two", "오윤서", 2222, "귀염둥이"},
					  {"Three", "아라치", 3333, "동아리 친구"}};
	
	String[] name = {"아이디", "이름", "비밀번호", "구분"}; //필드명

	//AbstractTableModel - 자동으로 콜백
	@Override
	public int getRowCount() { //행의 개수
		return data.length; //Object[][] data의 행의 크기
	}

	@Override
	public int getColumnCount() { //열의 개수
		return name.length; //String[] name 배열의 크기
	}

	@Override
	public Object getValueAt(int r, int c) {
		return data[r][c]; //해당 행, 열 위치에 있는 값 반환
	}
	
	@Override
	public void setValueAt(Object ob, int r, int c) {
		data[r][c] = ob;
	}

	@Override
	public String getColumnName(int c) { 
		return name[c]; //필드명(타이틀)
	}
	
	@Override
	public boolean isCellEditable(int r, int c) { //해당 행, 열 위치에 있는 값이 편집 가능한지
		//return true; //어떤 행, 열 위치에 있는 값이든 전부 편집 가능

		//조건 ? 참 : 거짓;
		return c==0 ? false : true; //열이 0번째면 편집 불가, 나머지 열은 편집 가능
	}
}
//--------------------------------
public class JTableEx extends JFrame {
	JTable table;
	JTableModel model;
	
	public JTableEx() {
		model = new JTableModel(); //JTableModel 생성
		table = new JTable(model); //JTableModel을 값으로 하는 JTable 생성
		
		JScrollPane scroll = new JScrollPane(table);
		//JScrollPane에 JTableModel을 값으로 하는 JTable을 붙여라
		
		add(scroll); //JFrame에 JScrollPane을 붙여라
		
		this.setBounds(900,100,300,300);
		this.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JTableEx();
	}
}
























