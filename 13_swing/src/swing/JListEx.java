package swing;

import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.DefaultListModel;//데이터 항목 추가, 수정, 삭제 등 내부 작업을 함
import javax.swing.JFrame;
import javax.swing.JList; //항목 나열, 화면에 띄워주는 역할(view)
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

// JScrollPane 위에 JList, JTextArea 등의 Component를 올리면 스크롤 할 수 있다

//JFrame은 BorderLayout(동서남북)
public class JListEx extends JFrame {
	public JListEx() { //생성자
		super("JList Test"); //JFrame 타이틀, 부모 생성자 호출
		
		setLayout(new FlowLayout()); //BorderLayout 깨고 FlowLayout으로
		
		String[] listData = {"Hong", "Gil", "Dong", "JAVA", "JSP"};
		JList<String> list1 = new JList<String>(listData);//String 배열을 값으로 하는 JList 생성
		
		list1.setSelectedIndex(0); //list의 0번(Hong)에 초점을 맞춰라 
		
		//ListModel 생성하고, JList 생성해서 JList에 ListModel을 값으로 준다
//		DefaultListModel<String> model = new DefaultListModel<String>();
//		JList<String> list2 = new JList<String>(model); //항목은 문자열
		
		//ListModel을 값으로 하는 JList 생성, ListModel은 JList에서 값을 가져온다
		JList<String> list2 = new JList<String>(new DefaultListModel<String>());
		DefaultListModel<String> model = (DefaultListModel<String>)list2.getModel();
		//자식 DefaultListModel = (자식 DefaultListModel) 부모 ListModel
		
		model.addElement("사과"); //데이터 항목 추가, 수정, 삭제 등 내부 작업을 하는 ListModel에 요소 추가
		model.addElement("배");
		model.addElement("딸기");
		model.addElement("바나나");
		
		list2.setSelectedIndex(1); //list의 1번(배)에 초점을 맞춰라 
		
		Vector<String> vListData = new Vector<String>(); //벡터 생성
		JList<String> list3 = new JList<String>(vListData); //벡터를 값으로 하는 JList 생성
		
		JScrollPane scroll = new JScrollPane(list3); //JList를 scroll에 붙여라
		
		vListData.add("축구"); //벡터에 요소 추가
		vListData.add("야구");
		vListData.add("농구");
		vListData.add("배구");
		vListData.add("테니스");
		vListData.add("수영");
		vListData.add("옥상");
		vListData.add("태권도");
		vListData.add("유도");
		
		class Student{ //JListEx() 생성자 메소드 안에서만 사용 가능한 local inner class - 1회용
			String id;
			String name;
			String department;
			
			public Student(String di, String name, String department) { //생성자
				this.id = id;
				this.name = name;
				this.department = department;
			}
			
			@Override //Student 클래스
			public String toString() { 
				return name;
			}
		}
		
		//ListModel을 값으로 하는 JList 생성, ListModel은 JList에서 값을 가져온다
		JList<Student> list4 = new JList<Student>(new DefaultListModel<Student>());
		DefaultListModel<Student> model2 = (DefaultListModel<Student>)list4.getModel();
		//자식 DefaultListModel = (자식 DefaultListModel) 부모 ListModel
		
		list4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		//JList의 SelectionMode를 하나만 선택할 수 있도록 설정
		
		//데이터 항목 추가, 수정, 삭제 등 내부 작업을 하는 ListModel에 요소 추가
		model2.addElement(new Student("100","홍길동","전산과")); //Student 클래스 생성자로 값 가져오기
		model2.addElement(new Student("200","손오공","건축과"));
		model2.addElement(new Student("300","사오정","토목과"));
		model2.addElement(new Student("400","저팔계","경영학"));
		
		list4.setSelectedIndex(2); //list의 2번에 초점을 맞춰라 
		
		add(list1); //JList를 JFrame에 더하라
		add(list2);
		add(scroll); //JList를 붙인 scroll을 JFrame에 더하라
		add(list4);
		
		setBounds(300,200,400,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}//JListEx()
	
	public static void main(String[] args) {
		new JListEx();
	}
}


















