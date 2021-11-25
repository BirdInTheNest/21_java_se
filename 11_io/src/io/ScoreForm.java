package io;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

//Ctrl + Shift + f : �� ����

//Swing Ʋ
public class ScoreForm extends JFrame implements ActionListener{
	private JLabel hakL, nameL, korL, engL, mathL;
	private JTextField hakT, nameT, korT, engT, mathT;
	private JButton inputBtn, printBtn, searchBtn, rankBtn, saveBtn, loadBtn;
	private DefaultTableModel model;
	private JTable table;
	private Score score;

	public ScoreForm() { //������
		// JLabel ����
		hakL = new JLabel("�й�");
		nameL = new JLabel("�̸�");
		korL = new JLabel("����");
		engL = new JLabel("����");
		mathL = new JLabel("����");

		// JTextField ����
		hakT = new JTextField("", 22); //String text, int columns
		nameT = new JTextField("", 22); //���� ũ�⸦ ���� ������ �ؽ�Ʈ�ʵ� ���̰� ª�� �׷�����
		korT = new JTextField("", 22);
		engT = new JTextField("", 22);
		mathT = new JTextField("", 22);

		// JButton ����
		inputBtn = new JButton("�Է�");
		printBtn = new JButton("���");
		searchBtn = new JButton("�й��˻�");
		rankBtn = new JButton("����");
		saveBtn = new JButton("��������");
		loadBtn = new JButton("�����б�");

		// JTable�� Ÿ��Ʋ
		Vector<String> vector = new Vector<String>();
		vector.add("�й�");
		vector.add("�̸�");
		vector.add("����");
		vector.add("����");
		vector.add("����");
		vector.add("����");
		vector.add("���");

		model = new DefaultTableModel(vector, 0); 
		//TableModel ����, vector�� ���� �̸����� �ϰ� ���� ������ 0
		table = new JTable(model); //TableModel�� ������ �ϴ� Table ����
		JScrollPane scroll = new JScrollPane(table); //JScrollPane�� Table ���̱�, 1ȸ�� ����
		
		score = new ScoreImpl(); //�θ� = �ڽ�

		// West - ����
		JPanel hakP = new JPanel(); //�гο� �󺧰� �ؽ�Ʈ�ʵ� ���̱�
		hakP.add(hakL);
		hakP.add(hakT);
		JPanel nameP = new JPanel();
		nameP.add(nameL);
		nameP.add(nameT);
		JPanel korP = new JPanel();
		korP.add(korL);
		korP.add(korT);
		JPanel engP = new JPanel();
		engP.add(engL);
		engP.add(engT);
		JPanel mathP = new JPanel();
		mathP.add(mathL);
		mathP.add(mathT);

		JPanel p = new JPanel(new GridLayout(5, 1)); //�г��� ���� ��ü�г�
		p.add(hakP);
		p.add(nameP);
		p.add(korP);
		p.add(engP);
		p.add(mathP);

		JPanel p2 = new JPanel(new GridLayout(1, 6, 5, 5)); //��ư�� ���� �г�
		p2.add(inputBtn);
		p2.add(printBtn);
		p2.add(searchBtn);
		p2.add(rankBtn);
		p2.add(saveBtn);
		p2.add(loadBtn);

		Container c = getContentPane();
		c.add("West", p);
		c.add("South", p2);
		c.add("Center", scroll);

		setBounds(800, 100, 700, 300);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//�̺�Ʈ
		event();
		
	}//ScoreForm()
	
	public void event() {
		inputBtn.addActionListener(this);
		printBtn.addActionListener(this);
		searchBtn.addActionListener(this);
		rankBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		loadBtn.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==inputBtn) {
			input(); //ȣ��
	
		}else if(e.getSource()==printBtn) {
			//�������̽� Score�� ���̺��� �ִ��� �𸣹Ƿ�, TableModel�� ������ ���̺��� �����͸� ó���Ѵ�
			score.print(model);
			
		}else if(e.getSource()==searchBtn) {
			score.search(model);  
			
		}else if(e.getSource()==rankBtn) {
			score.tot_desc(); //�������� ��������
			score.print(model);
			
		}else if(e.getSource()==saveBtn) {
			score.save();
			
		}else if(e.getSource()==loadBtn) {
			score.load();
			score.print(model);
		}
	}//actionPerformed(ActionEvent e)

	public void input() {
		//JTextField�� �Էµ� �����͸� �����;� �Ѵ�
		String hak = hakT.getText();
		
		//�����Ͱ� ���Դ��� Ȯ��
		if(hak.length() == 0) { //if(hak.equals("")) //hak�� ũ�Ⱑ 0�̸� �Էµ��� �ʾ���
			JOptionPane.showMessageDialog(this, "�й��� �Է��ϼ���");
			return;	
		}

		String name = nameT.getText();
		int kor = Integer.parseInt(korT.getText());
		int eng = Integer.parseInt(engT.getText());
		int math = Integer.parseInt(mathT.getText());
		
		//���
		int tot = kor + eng + math;
		double avg = (double)tot /3;
		
		//�����͸� TableModel�� �־�� Table�� �Ѹ� �� �ִ�
		//�����Ͱ� �������ϱ� dto �� ���� �����Ѵ�
		//dto���� ���� �����͸� Table�� �ٷ� ������ ���� ��� ��������Ƿ�, dto�� list�� ��´�
		
		ScoreDTO dto = new ScoreDTO(); //dto ����
		dto.setHak(hak); //�����͸� dto�� ����
		dto.setName(name);
		dto.setKor(kor);
		dto.setEng(eng);
		dto.setMath(math);
		dto.setTot(tot);
		dto.setAvg(avg);
		
		//ù��° ��� : ScoreDTO�� List�� ��Ƽ� JTable�� �Ѹ��� ���Ͽ� ����
		//�����͸� List�� �����ؾ� ������ �����ϰ� ���� �� �ִ�
		
		score.input(dto);
		//�������̽� Score�� input(ScoreDTO dto) ȣ�������� �߻�޼ҵ��̹Ƿ� ���
		//ScoreImpl Ŭ������ Override�� input(ScoreDTO dto) ȣ��
		
		//�ι�° ��� : ScoreDTO�� ������ ScoreDAO.java���� DB�� insert �Ѵ�
		//DB�� �����Ǹ� �ٷ� �����Ͱ� ���ϱ� �����͸� List�� ������ �ʿ� ����
		
		//�ʱ�ȭ - �����Ͱ� �� ���� �ʱ�ȭ�ؾ� ���ο� ���� �� �� �� �ִ�
		hakT.setText("");
		nameT.setText("");
		korT.setText("");
		engT.setText("");
		mathT.setText("");

	}//input()
}

/*
String a = null;	String b = ""
a + "apple"			b + "apple"
"nullapple"			"apple"
 */














