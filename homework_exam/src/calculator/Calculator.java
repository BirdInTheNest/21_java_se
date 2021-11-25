/*
[1������]
  private Button[] btn; 
 - �迭�� ũ��� 18���� ��� for ���� ����Ͽ� �����Ѵ�.
private Label dispL
                  inputL
- inputL�� 0�� �����ʿ� ǥ���Ѵ�.
- Label�� �������� ������

[2������]

1.���ڸ� ������ �̺�Ʈ �߻� -ActionListener
   1,2,3,4,5,6,7,8,9,0

2.StringBuffer buffer --> "7" append�� �߰�
���۷ε��� 7�� �󺧿� �ѷ��ش�!
 - 7�� ������ 7�� StringBuffer�� �߰��ȴ�. -append()
 - �߰��� StringBuffer�� ������ Label�� ����� -setText()
 - �����߿��� 0�� �� ó������ �߰��� �ȵȴ�. �տ� ���ڰ� ������쿡�� 0�� �߰��ȴ�. -if��

3.C�� ������ Label, StringBuffer ��� �ʱ�ȭ�ȴ�. setText("0")

[3�� ����]
���࿡ ���� ������ �߰��ǰ�
	 ���� ������ �׳� ���
	 
<- ������ �ѱ��ھ� ��������
   ���������� �� ����� �ٽ� 0���� �ȴ� - delete() ���
*/

package calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculator extends JFrame implements ActionListener, WindowListener {
	private JLabel dispL, inputL;
	private JButton[] btn;
	private String[] num = {"7", "8", "9", "/", //�ڷ����� String Ŭ�������� ��ü �迭 num ����
						   "4", "5", "6", "*", 
						   "1", "2", "3", "-", 
						   ".", "0", "=", "+" , 
						   "C", "��"};
	
	private StringBuffer dispBuffer = new StringBuffer();
	private StringBuffer inputBuffer = new StringBuffer();
	
	private double result; //ó���� ��, �߰� ���
	private char op; //������ '+':43, '-':45, '*':42, '/':47 
	private DecimalFormat df = new DecimalFormat("#,###.#######");
	
	public void init() { //�ʱ�ȭ �޼ҵ�
		dispL = new JLabel("", JLabel.RIGHT); //������ ����
		dispL.setOpaque(true); //JLable�� ������ �⺻������ �����̱� ������ �������ϰ� �������� ���� ����ȴ�
		dispL.setBackground(new Color(254,254,241));
		dispL.setFont(new Font("�������", Font.BOLD, 20));
		
		inputL = new JLabel("0", JLabel.RIGHT); //(String text, int horizontalAlignment)
		inputL.setOpaque(true);
		inputL.setBackground(new Color(254,254,241));
		inputL.setFont(new Font("�������", Font.BOLD, 20));
		
		btn = new JButton[18]; //�ڷ����� JButton Ŭ�������� ��ü �迭 btn ����, �� 18��
		for(int i=0; i<btn.length; i++) { 
			btn[i] = new JButton(num[i]); //��ü �迭 btn�� �� �濡 ���� num[i]���� ���� JButton ����
		} //��ư ����
		
		//�г� ���� - ��ü�г� center�� �ϳ� ��� �� �ȿ� �г� 7�� �ֱ�
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(7,1,5,5));
		p.setBackground(new Color(252,251,214));

		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(1,4,5,5));
		p1.setBackground(new Color(252,251,214));
		for(int i=0; i<4; i++) {
			p1.add(btn[i]);
			btn[i].setBackground(new Color(249,247,164));
			btn[i].setFont(new Font("�������", Font.BOLD, 20));
		}
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(1,4,5,5));
		p2.setBackground(new Color(252,251,214));
		for(int i=4; i<8; i++) {
			p2.add(btn[i]);
			btn[i].setBackground(new Color(249,247,164));
			btn[i].setFont(new Font("�������", Font.BOLD, 20));
		}
		
		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(1,4,5,5));
		p3.setBackground(new Color(252,251,214));
		for(int i=8; i<12; i++) {
			p3.add(btn[i]);
			btn[i].setBackground(new Color(249,247,164));
			btn[i].setFont(new Font("�������", Font.BOLD, 20));
		}
		
		JPanel p4 = new JPanel();
		p4.setLayout(new GridLayout(1,4,5,5));
		p4.setBackground(new Color(252,251,214));
		for(int i=12; i<16; i++) {
			p4.add(btn[i]);
			btn[i].setBackground(new Color(249,247,164));
			btn[i].setFont(new Font("�������", Font.BOLD, 20));
		}
		
		JPanel p5 = new JPanel();
		p5.setLayout(new GridLayout(1,2,5,5));
		p5.setBackground(new Color(252,251,214));
		for(int i=16; i<btn.length; i++) {
			p5.add(btn[i]);
			btn[i].setBackground(new Color(249,247,164));
			btn[i].setFont(new Font("�������", Font.BOLD, 20));
		}
	
		add("Center", p);
		p.add(dispL); //���� �ٷ� ��ü�гο� ���̱�
		p.add(inputL);
		p.add(p5);
		p.add(p1);
		p.add(p2);
		p.add(p3);
		p.add(p4);
	
		setTitle("Calculator");
		//setDefaultCloseOperation(DISPOSE_ON_CLOSE); //x������ ����
		setBounds(900,300,300,400); //â�� ó�� �ߴ� ��ġ, â ũ��
		setResizable(false); //â ũ������ �ȵǰ� ���Ƶ�
		setVisible(true);
		
		//�̺�Ʈ
		this.addWindowListener(this);
		
		for(int i=0; i<btn.length; i++) {
			btn[i].addActionListener(this);
		}
	}//init()

	//ActionListener Override
	@Override
	public void actionPerformed(ActionEvent e) {
		//����
		if(e.getActionCommand()=="1" || //�̺�Ʈ�� �׼��� ����� �� �����̸�
		   e.getActionCommand()=="2" ||
		   e.getActionCommand()=="3" ||
		   e.getActionCommand()=="4" ||
		   e.getActionCommand()=="5" ||
		   e.getActionCommand()=="6" ||
		   e.getActionCommand()=="7" ||
		   e.getActionCommand()=="8" ||
		   e.getActionCommand()=="9" ||
		   e.getActionCommand()=="0") {
			
			//�� ó���� inputL�� 0�� ǥ���ϰ� ������ buffer�� �Էµ� ���ڴ� ����(buffer.length()==0)
			//StringBuffer delete(int start, int end) : start��° ���ں��� end��° ���� �������� �����
				
			if(inputBuffer.length()==1 && inputBuffer.toString().equals("0")) {
				inputBuffer.delete(0,1); //0������ 1�� �������� ����
			} //inputBuffer�� �Էµ� ���� �ϳ���, inputBuffer�� ���� ���ڿ��� ��ȯ�� ���� 0�� ���� ��
			
			inputBuffer.append(e.getActionCommand()); //�̺�Ʈ�� �׼��� ����� ���ڸ� inputBuffer�� �߰�
			inputL.setText(inputBuffer+""); //inputBuffer�� �Էµ� ���� +""�� ���ڿ��� ����� inputL�� ����
			
		}else if(e.getActionCommand() == "C") { //�̺�Ʈ�� �׼��� ����� �� C�̸�
			dispBuffer.delete(0, dispBuffer.length()); //0������ dispBuffer.length() �������� ����
			inputBuffer.delete(0, inputBuffer.length()); //0������ inputBuffer.length() �������� ����
			
			dispL.setText(""); //dispL�� ���ڿ� "" ����, �ʱ�ȭ
			inputL.setText("0"); //inputL�� ���ڿ� 0 ����, �ʱ�ȭ
			
			result = op = 0; //�߰������, ������ ��� �ʱ�ȭ
			
		}else if(e.getActionCommand()== ".") { //�̺�Ʈ�� �׼��� ����� �� .�̸�
			if(inputBuffer.indexOf(".") == -1){ //indexOf�� ã�� ���� ������ ������� -1�� 
				inputBuffer.append("."); //inputBuffer�� .�� ������ .�߰�
			}
			inputL.setText(inputBuffer+""); //inputBuffer�� �Էµ� ���� +""�� ���ڿ��� ����� inputL�� ����
			
		}else if(e.getActionCommand() == "��") { //�̺�Ʈ�� �׼��� ����� �� ���̸�
			inputBuffer.delete(inputBuffer.length()-1, inputBuffer.length()); //������ ���� ����
			if(inputBuffer.length() == 0) //inputBuffer�� �Էµ� ���� ������
				inputBuffer.append("0"); //inputBuffer�� 0 �ֱ�, �ʱ�ȭ
			
			inputL.setText(inputBuffer+"");

		}else if(e.getActionCommand() == "+") {
			calc(); //���
			op='+'; //������ op�� + ����ְ�
			
			dispBuffer.append(inputBuffer+" + "); //dispBuffer�� inputBuffer ���� + �ְ�
			
			//setText�� String���� �Ѹ���
			dispL.setText(dispBuffer+""); //dispBuffer�� �Էµ� ���� +""�� ���ڿ��� ����� dispL�� ����
			inputL.setText(df.format(result)); //�߰��� result�� inputL�� ����
			
			inputBuffer.delete(0, inputBuffer.length()); //0������ inputBuffer.length() �������� ����
			
		}else if(e.getActionCommand() == "-") {
			calc(); //���
			op='-';
			
			dispBuffer.append(inputBuffer+" - ");
			
			dispL.setText(dispBuffer+""); 
			inputL.setText(df.format(result));
			
			inputBuffer.delete(0, inputBuffer.length());
			
		}else if(e.getActionCommand() == "*") {
			calc(); //���
			op='*';
			
			dispBuffer.append(inputBuffer+" * ");
			
			dispL.setText(dispBuffer+""); 
			inputL.setText(df.format(result));
			
			inputBuffer.delete(0, inputBuffer.length());
			
		}else if(e.getActionCommand() == "/") {
			calc(); //���
			op='/';
			
			dispBuffer.append(inputBuffer+" / ");
			
			dispL.setText(dispBuffer+""); 
			inputL.setText(df.format(result));
			
			inputBuffer.delete(0, inputBuffer.length());
			
		}else if(e.getActionCommand() == "=") {
			calc(); //���
			op=0; //������ �ʱ�ȭ
			
			dispBuffer.append(inputBuffer+"");
			
			dispL.setText(dispBuffer+""); 
			inputL.setText(df.format(result));
			
			dispBuffer.delete(0, dispBuffer.length());
			inputBuffer.delete(0, inputBuffer.length());	
		}
	}//actionPerformed(ActionEvent e)
	
//	���⿡ ���ڰ� �����ٰ� �����ڰ� ������ ���̻� ���ڰ� ������ �����Ƿ� ������� �����
//	���� �����ڰ� ������ ����� ���� ����. ���ڸ� result�� ����, �����ڸ� op�� ����
//	���� �����ڰ� ������ ����� �ؼ� result�� ����, ���ο� �����ڸ� op�� ����
	public void calc() {
		//��� -  result���� ó�� ���� �߰� ���
		if(op==0) result = Double.parseDouble(inputBuffer+""); //�����ڰ� ������ result�� ó�� ��
		else if(op=='+') result += Double.parseDouble(inputBuffer+""); //�����ڰ� ������ result�� �߰���
		else if(op=='-') result -= Double.parseDouble(inputBuffer+"");
		else if(op=='*') result *= Double.parseDouble(inputBuffer+"");
		else if(op=='/') result /= Double.parseDouble(inputBuffer+"");
	}

	//WindowListener Override
	@Override
	public void windowOpened(WindowEvent e) {}
	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0); //���α׷� ����
	}
	@Override
	public void windowClosed(WindowEvent e) {}
	@Override
	public void windowIconified(WindowEvent e) {}
	@Override
	public void windowDeiconified(WindowEvent e) {}
	@Override
	public void windowActivated(WindowEvent e) {}
	@Override
	public void windowDeactivated(WindowEvent e) {}

	public static void main(String[] args) {
		new Calculator().init();
	}
}

//StringBuffer deleteCharAt(int index) : �Ű������� ���� ��ġ����° ���ڸ� �����
