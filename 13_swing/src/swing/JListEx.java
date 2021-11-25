package swing;

import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.DefaultListModel;//������ �׸� �߰�, ����, ���� �� ���� �۾��� ��
import javax.swing.JFrame;
import javax.swing.JList; //�׸� ����, ȭ�鿡 ����ִ� ����(view)
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

// JScrollPane ���� JList, JTextArea ���� Component�� �ø��� ��ũ�� �� �� �ִ�

//JFrame�� BorderLayout(��������)
public class JListEx extends JFrame {
	public JListEx() { //������
		super("JList Test"); //JFrame Ÿ��Ʋ, �θ� ������ ȣ��
		
		setLayout(new FlowLayout()); //BorderLayout ���� FlowLayout����
		
		String[] listData = {"Hong", "Gil", "Dong", "JAVA", "JSP"};
		JList<String> list1 = new JList<String>(listData);//String �迭�� ������ �ϴ� JList ����
		
		list1.setSelectedIndex(0); //list�� 0��(Hong)�� ������ ����� 
		
		//ListModel �����ϰ�, JList �����ؼ� JList�� ListModel�� ������ �ش�
//		DefaultListModel<String> model = new DefaultListModel<String>();
//		JList<String> list2 = new JList<String>(model); //�׸��� ���ڿ�
		
		//ListModel�� ������ �ϴ� JList ����, ListModel�� JList���� ���� �����´�
		JList<String> list2 = new JList<String>(new DefaultListModel<String>());
		DefaultListModel<String> model = (DefaultListModel<String>)list2.getModel();
		//�ڽ� DefaultListModel = (�ڽ� DefaultListModel) �θ� ListModel
		
		model.addElement("���"); //������ �׸� �߰�, ����, ���� �� ���� �۾��� �ϴ� ListModel�� ��� �߰�
		model.addElement("��");
		model.addElement("����");
		model.addElement("�ٳ���");
		
		list2.setSelectedIndex(1); //list�� 1��(��)�� ������ ����� 
		
		Vector<String> vListData = new Vector<String>(); //���� ����
		JList<String> list3 = new JList<String>(vListData); //���͸� ������ �ϴ� JList ����
		
		JScrollPane scroll = new JScrollPane(list3); //JList�� scroll�� �ٿ���
		
		vListData.add("�౸"); //���Ϳ� ��� �߰�
		vListData.add("�߱�");
		vListData.add("��");
		vListData.add("�豸");
		vListData.add("�״Ͻ�");
		vListData.add("����");
		vListData.add("����");
		vListData.add("�±ǵ�");
		vListData.add("����");
		
		class Student{ //JListEx() ������ �޼ҵ� �ȿ����� ��� ������ local inner class - 1ȸ��
			String id;
			String name;
			String department;
			
			public Student(String di, String name, String department) { //������
				this.id = id;
				this.name = name;
				this.department = department;
			}
			
			@Override //Student Ŭ����
			public String toString() { 
				return name;
			}
		}
		
		//ListModel�� ������ �ϴ� JList ����, ListModel�� JList���� ���� �����´�
		JList<Student> list4 = new JList<Student>(new DefaultListModel<Student>());
		DefaultListModel<Student> model2 = (DefaultListModel<Student>)list4.getModel();
		//�ڽ� DefaultListModel = (�ڽ� DefaultListModel) �θ� ListModel
		
		list4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); 
		//JList�� SelectionMode�� �ϳ��� ������ �� �ֵ��� ����
		
		//������ �׸� �߰�, ����, ���� �� ���� �۾��� �ϴ� ListModel�� ��� �߰�
		model2.addElement(new Student("100","ȫ�浿","�����")); //Student Ŭ���� �����ڷ� �� ��������
		model2.addElement(new Student("200","�տ���","�����"));
		model2.addElement(new Student("300","�����","����"));
		model2.addElement(new Student("400","���Ȱ�","�濵��"));
		
		list4.setSelectedIndex(2); //list�� 2���� ������ ����� 
		
		add(list1); //JList�� JFrame�� ���϶�
		add(list2);
		add(scroll); //JList�� ���� scroll�� JFrame�� ���϶�
		add(list4);
		
		setBounds(300,200,400,300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
	}//JListEx()
	
	public static void main(String[] args) {
		new JListEx();
	}
}


















