package swing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

// JFrame은 4개의 층으로 구성되어 있다 
// JFrame > JRootPane > layeredPane (윗부분은 JMenuBar, 아랫부분은 contentPane) > glassPane
// JMenuBar에 JMenu, JmenuItem을 올릴 수 있다. setJMenuBar()
// contentPane에 Component들을 올릴 수 있다. getcontentPane()

// Container는 Component를 담는 것을 말하며, contentPane는 컨테이너다
// Container 위에 Container를 올릴 수 있으며, 다이얼로그는 프레임 위에 올라갈 수 있다.
// JFrame은 최종 컨테이너이며, 프레임 위에 프레임을 올릴 수 없다. 프레임을 두개 만들면 각자 떠 버린다

public class JTableEx2 extends JFrame implements ActionListener {
	private List<PersonDTO> list;
	private DefaultTableModel model;
	private JTable table;
	private JButton addBtn, delBtn;

	public JTableEx2() { //생성자
		list = new ArrayList<PersonDTO>(); //부모 = 자식, PersonDTO를 값으로 하는 ArrayList 생성
		list.add(new PersonDTO("hong", "홍길동", "111", "010-123-1234"));
		list.add(new PersonDTO("conan", "코난", "333", "010-777-7777"));
		
		//타이틀
		Vector<String> vector = new Vector<String>(); //벡터 생성
		vector.addElement("아이디"); //벡터에 요소 추가
		vector.addElement("이름");
		vector.add("비밀번호");
		vector.add("핸드폰"); //벡터는 배열과 다르게 계속 항목을 추가할 수 있다
		
		model = new DefaultTableModel(vector, 0) {
		//벡터 값을 타이틀로 TableModel 생성, 타이틀 아래에 빈공간 만들어주세요 1, 미리 만들지 마세요 0
			
			@Override
			public boolean isCellEditable(int row, int column) { //해당 위치에 있는 값이 편집 가능한지
				//조건 ? 참 : 거짓;
				return column==0 ? false : true; //열이 0번째면 편집 불가, 나머지 열은 편집 가능
			}
			
		}; //일반클래스도 {} 익명 Inner Class 사용 가능
		
		table = new JTable(model); //TableModel을 값으로 하는 JTable 생성
		JScrollPane scroll = new JScrollPane(table); //JScrollPane에 JTable 붙여라, 스크롤은 1회용
		
		addBtn = new JButton("추가"); //버튼 생성
		delBtn = new JButton("삭제");
		
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT)); //패널 생성, 오른쪽 정렬
		p.add(addBtn); //패널에 버튼 붙이기
		p.add(delBtn);
		
		//데이터 - ArrayList는 JTable에 직접 붙지 못 하므로 Vector로 바꿔줘야 함
		for(PersonDTO dto : list) { //list에서 dto를 꺼내서 벡터로 보내는데, dto 한줄당 벡터 한줄이 만들어짐
			Vector<String> v = new Vector<String>();
			v.add(dto.getId()); //dto에서 꺼낸 값을 벡터에 더하라
			v.add(dto.getName());
			v.add(dto.getPwd());
			v.add(dto.getPhone());
			
			model.addRow(v); //JTableModel에 벡터를 행으로 붙여라
		}//for
		
		Container c = this.getContentPane();
		c.add(scroll); //JTable이 붙은 JScrollPane을 더하라
		c.add("South", p); //남쪽에 패널 붙이기
		
		setBounds(800,100,500,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//이벤트
		addBtn.addActionListener(this);
		delBtn.addActionListener(this);
		
	}//JTableEx2()
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addBtn) 
			insert(); //호출 
		else if(e.getSource() == delBtn) 
			delete(); //호출
	}
	
	public void insert() { //추가
		String id = JOptionPane.showInputDialog(this, "아이디를 입력하세요");
		if(id==null) { //Cancel버튼을 누르면 null이 들어옴
			JOptionPane.showMessageDialog(this, "아이디는 필수 항목입니다");
			return;
		}
		
		//중복체크
		for(int i=0; i<model.getRowCount(); i++) { //TableModel의 행 개수만큼 반복
			if(id.equals(model.getValueAt(i, 0))) { //id의 값이 TableModel에서 가져온 값과 같은지
				JOptionPane.showMessageDialog(this, "사용 중인 아이디입니다");
				return;
			}
		}

		String name = JOptionPane.showInputDialog(this, "이름을 입력하세요");
		String pwd = JOptionPane.showInputDialog(this, "비밀번호를 입력하세요");
		String phone = JOptionPane.showInputDialog(this, "전화번호를 입력하세요");
		
		Vector<String> v = new Vector<String>();
		v.add(id);
		v.add(name);
		v.add(pwd);
		v.add(phone);
		
		JOptionPane.showMessageDialog(this, "등록 완료");
		model.addRow(v); //등록 완료 메시지 뜨고 난 후에 값이 저장됨, 순서 차이
		
	}//insert()
	
	public void delete() {
		String name = JOptionPane.showInputDialog(this, "이름을 입력하세요");
		if(name==null) return; ////Cancel버튼을 누르면 null이 들어옴
		
		int sw=0; //스위치 변수
		for(int i=0; i<model.getRowCount(); i++) { //TableModel의 행 개수만큼 반복
			if(name.equals(model.getValueAt(i, 1))) { //name의 값이 TableModel에서 가져온 값과 같은지
				model.removeRow(i); //TableModel에서 i번째 행 값을 지워라
								
				//삭제하면 인덱스가 다시 부여되니까 Iterator사용해야 하지만, 사용할 수 없으니 잔머리
				i--; //for문 다시 돌 때 i++되니까 값이 또이또이
				sw=1; //삭제되면 스위치 변수 값을 1로
			}
		}//for
		
		if(sw==0) 
			JOptionPane.showMessageDialog(this, "찾는 이름이 없습니다");
		else 
			JOptionPane.showMessageDialog(this, "삭제 완료");
	}
	
	public static void main(String[] args) {
		new JTableEx2();
	}
}













