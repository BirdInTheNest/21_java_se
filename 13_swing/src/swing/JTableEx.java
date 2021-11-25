package swing;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

//AbstractTableModel�� �߻�Ŭ������ �߻�޼ҵ� Override �ʿ�
class JTableModel extends AbstractTableModel{  
	
//	Object[][] data = {{"Nari", "����ġ", new Integer(1234), "����ģ��"}, 
//				  	  {"One", "������", new Integer(1111), "������"},
//					  {"Two", "������", new Integer(2222), "�Ϳ�����"},
//					  {"Three", "�ƶ�ġ", new Integer(3333), "���Ƹ� ģ��"}};

//	new Integer(1234)�� �� �̻� ������ �ʰ� �����δ� ������� ������ �����ϸ� ��������
//	Object Ŭ���� ��ü���̱� ������ Integer ��ü�� �� �ǵ� �׷��� ���ص� JDK 9���ʹ� AutoBoxing �ȴ�
	
	Object[][] data = {{"Nari", "����ġ", 1234, "����ģ��"}, 
					  {"One", "������", 1111, "������"},
					  {"Two", "������", 2222, "�Ϳ�����"},
					  {"Three", "�ƶ�ġ", 3333, "���Ƹ� ģ��"}};
	
	String[] name = {"���̵�", "�̸�", "��й�ȣ", "����"}; //�ʵ��

	//AbstractTableModel - �ڵ����� �ݹ�
	@Override
	public int getRowCount() { //���� ����
		return data.length; //Object[][] data�� ���� ũ��
	}

	@Override
	public int getColumnCount() { //���� ����
		return name.length; //String[] name �迭�� ũ��
	}

	@Override
	public Object getValueAt(int r, int c) {
		return data[r][c]; //�ش� ��, �� ��ġ�� �ִ� �� ��ȯ
	}
	
	@Override
	public void setValueAt(Object ob, int r, int c) {
		data[r][c] = ob;
	}

	@Override
	public String getColumnName(int c) { 
		return name[c]; //�ʵ��(Ÿ��Ʋ)
	}
	
	@Override
	public boolean isCellEditable(int r, int c) { //�ش� ��, �� ��ġ�� �ִ� ���� ���� ��������
		//return true; //� ��, �� ��ġ�� �ִ� ���̵� ���� ���� ����

		//���� ? �� : ����;
		return c==0 ? false : true; //���� 0��°�� ���� �Ұ�, ������ ���� ���� ����
	}
}
//--------------------------------
public class JTableEx extends JFrame {
	JTable table;
	JTableModel model;
	
	public JTableEx() {
		model = new JTableModel(); //JTableModel ����
		table = new JTable(model); //JTableModel�� ������ �ϴ� JTable ����
		
		JScrollPane scroll = new JScrollPane(table);
		//JScrollPane�� JTableModel�� ������ �ϴ� JTable�� �ٿ���
		
		add(scroll); //JFrame�� JScrollPane�� �ٿ���
		
		this.setBounds(900,100,300,300);
		this.setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new JTableEx();
	}
}
























