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

// JFrame�� 4���� ������ �����Ǿ� �ִ� 
// JFrame > JRootPane > layeredPane (���κ��� JMenuBar, �Ʒ��κ��� contentPane) > glassPane
// JMenuBar�� JMenu, JmenuItem�� �ø� �� �ִ�. setJMenuBar()
// contentPane�� Component���� �ø� �� �ִ�. getcontentPane()

// Container�� Component�� ��� ���� ���ϸ�, contentPane�� �����̳ʴ�
// Container ���� Container�� �ø� �� ������, ���̾�α״� ������ ���� �ö� �� �ִ�.
// JFrame�� ���� �����̳��̸�, ������ ���� �������� �ø� �� ����. �������� �ΰ� ����� ���� �� ������

public class JTableEx2 extends JFrame implements ActionListener {
	private List<PersonDTO> list;
	private DefaultTableModel model;
	private JTable table;
	private JButton addBtn, delBtn;

	public JTableEx2() { //������
		list = new ArrayList<PersonDTO>(); //�θ� = �ڽ�, PersonDTO�� ������ �ϴ� ArrayList ����
		list.add(new PersonDTO("hong", "ȫ�浿", "111", "010-123-1234"));
		list.add(new PersonDTO("conan", "�ڳ�", "333", "010-777-7777"));
		
		//Ÿ��Ʋ
		Vector<String> vector = new Vector<String>(); //���� ����
		vector.addElement("���̵�"); //���Ϳ� ��� �߰�
		vector.addElement("�̸�");
		vector.add("��й�ȣ");
		vector.add("�ڵ���"); //���ʹ� �迭�� �ٸ��� ��� �׸��� �߰��� �� �ִ�
		
		model = new DefaultTableModel(vector, 0) {
		//���� ���� Ÿ��Ʋ�� TableModel ����, Ÿ��Ʋ �Ʒ��� ����� ������ּ��� 1, �̸� ������ ������ 0
			
			@Override
			public boolean isCellEditable(int row, int column) { //�ش� ��ġ�� �ִ� ���� ���� ��������
				//���� ? �� : ����;
				return column==0 ? false : true; //���� 0��°�� ���� �Ұ�, ������ ���� ���� ����
			}
			
		}; //�Ϲ�Ŭ������ {} �͸� Inner Class ��� ����
		
		table = new JTable(model); //TableModel�� ������ �ϴ� JTable ����
		JScrollPane scroll = new JScrollPane(table); //JScrollPane�� JTable �ٿ���, ��ũ���� 1ȸ��
		
		addBtn = new JButton("�߰�"); //��ư ����
		delBtn = new JButton("����");
		
		JPanel p = new JPanel(new FlowLayout(FlowLayout.RIGHT)); //�г� ����, ������ ����
		p.add(addBtn); //�гο� ��ư ���̱�
		p.add(delBtn);
		
		//������ - ArrayList�� JTable�� ���� ���� �� �ϹǷ� Vector�� �ٲ���� ��
		for(PersonDTO dto : list) { //list���� dto�� ������ ���ͷ� �����µ�, dto ���ٴ� ���� ������ �������
			Vector<String> v = new Vector<String>();
			v.add(dto.getId()); //dto���� ���� ���� ���Ϳ� ���϶�
			v.add(dto.getName());
			v.add(dto.getPwd());
			v.add(dto.getPhone());
			
			model.addRow(v); //JTableModel�� ���͸� ������ �ٿ���
		}//for
		
		Container c = this.getContentPane();
		c.add(scroll); //JTable�� ���� JScrollPane�� ���϶�
		c.add("South", p); //���ʿ� �г� ���̱�
		
		setBounds(800,100,500,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//�̺�Ʈ
		addBtn.addActionListener(this);
		delBtn.addActionListener(this);
		
	}//JTableEx2()
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addBtn) 
			insert(); //ȣ�� 
		else if(e.getSource() == delBtn) 
			delete(); //ȣ��
	}
	
	public void insert() { //�߰�
		String id = JOptionPane.showInputDialog(this, "���̵� �Է��ϼ���");
		if(id==null) { //Cancel��ư�� ������ null�� ����
			JOptionPane.showMessageDialog(this, "���̵�� �ʼ� �׸��Դϴ�");
			return;
		}
		
		//�ߺ�üũ
		for(int i=0; i<model.getRowCount(); i++) { //TableModel�� �� ������ŭ �ݺ�
			if(id.equals(model.getValueAt(i, 0))) { //id�� ���� TableModel���� ������ ���� ������
				JOptionPane.showMessageDialog(this, "��� ���� ���̵��Դϴ�");
				return;
			}
		}

		String name = JOptionPane.showInputDialog(this, "�̸��� �Է��ϼ���");
		String pwd = JOptionPane.showInputDialog(this, "��й�ȣ�� �Է��ϼ���");
		String phone = JOptionPane.showInputDialog(this, "��ȭ��ȣ�� �Է��ϼ���");
		
		Vector<String> v = new Vector<String>();
		v.add(id);
		v.add(name);
		v.add(pwd);
		v.add(phone);
		
		JOptionPane.showMessageDialog(this, "��� �Ϸ�");
		model.addRow(v); //��� �Ϸ� �޽��� �߰� �� �Ŀ� ���� �����, ���� ����
		
	}//insert()
	
	public void delete() {
		String name = JOptionPane.showInputDialog(this, "�̸��� �Է��ϼ���");
		if(name==null) return; ////Cancel��ư�� ������ null�� ����
		
		int sw=0; //����ġ ����
		for(int i=0; i<model.getRowCount(); i++) { //TableModel�� �� ������ŭ �ݺ�
			if(name.equals(model.getValueAt(i, 1))) { //name�� ���� TableModel���� ������ ���� ������
				model.removeRow(i); //TableModel���� i��° �� ���� ������
								
				//�����ϸ� �ε����� �ٽ� �ο��Ǵϱ� Iterator����ؾ� ������, ����� �� ������ �ܸӸ�
				i--; //for�� �ٽ� �� �� i++�Ǵϱ� ���� ���̶���
				sw=1; //�����Ǹ� ����ġ ���� ���� 1��
			}
		}//for
		
		if(sw==0) 
			JOptionPane.showMessageDialog(this, "ã�� �̸��� �����ϴ�");
		else 
			JOptionPane.showMessageDialog(this, "���� �Ϸ�");
	}
	
	public static void main(String[] args) {
		new JTableEx2();
	}
}













