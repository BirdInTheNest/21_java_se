package swing;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class MsPaint extends JFrame implements ActionListener {
	private JLabel x1L, y1L, x2L, y2L, z1L, z2L;
	private JTextField x1T, y1T, x2T, y2T, z1T, z2T;
	private JCheckBox fill;
	private JRadioButton line, circle, rect, roundRect, pen;
	private JComboBox<String> combo;
	private JButton draw;
	private DrCanvas can;
	private List<ShapeDTO> list;
	
	public MsPaint() {
		super("�̴� �׸���"); //setTitle("�̴� �׸���");
		//JLabel ����
		x1L = new JLabel("x1");
		y1L = new JLabel("y1");
		x2L = new JLabel("x2");
		y2L = new JLabel("y2");
		z1L = new JLabel("z1");
		z2L = new JLabel("z2");
		
		//JTextField ����
		x1T = new JTextField("0", 4); //String text, int columns
		y1T = new JTextField("0", 4); //���� ũ�⸦ ���� ������ �ؽ�Ʈ�ʵ尡 ª�� �׷�����
		x2T = new JTextField("0", 4);
		y2T = new JTextField("0", 4);
		z1T = new JTextField("50", 4); //�𼭸��� ���̴� �κ� �� ����
		z2T = new JTextField("50", 4);
		
		//JCheckBox ����
		fill = new JCheckBox("ä���");
		
		//JRadioButton ���� - ButtonGroup���� ������� ��ư �ߺ� ������ �� ��
		line = new JRadioButton("��");
		circle = new JRadioButton("��");
		rect = new JRadioButton("�簢��", true); //true�� ó���� �׻� ���õ� ����
		roundRect = new JRadioButton("�ձٻ簢��");
		pen = new JRadioButton("����");
		
		ButtonGroup group = new ButtonGroup();
		group.add(line);
		group.add(circle);
		group.add(rect);
		group.add(roundRect);
		group.add(pen);
		
		//JComboBox<String> ����
		String[] color = {"�ϴ�","ȸ��","��ȫ","����","��Ȳ"}; //0 1 2 3 4 (index)
		combo = new JComboBox<String>(color);//JComboBox<String>(String[] items)
		
		//JButton ����
		draw = new JButton("�׸���");
		
		//DrCanvas ����
		can = new DrCanvas(this); //this�� MsPaint�� ����
		
		//List<ShapeDTO> ����
		list = new ArrayList<ShapeDTO>();
		
		//North �г� - FlowLayout(������ġ), �⺻�� ��� ����
		JPanel northP = new JPanel(); 
		northP.add(x1L); northP.add(x1T); //�гο� �󺧰� �ؽ�Ʈ�ʵ� ���̱�
		northP.add(y1L); northP.add(y1T);
		northP.add(x2L); northP.add(x2T);
		northP.add(y2L); northP.add(y2T);
		northP.add(z1L); northP.add(z1T);
		northP.add(z2L); northP.add(z2T);
		northP.add(fill); //�гο� üũ�ڽ� ���̱�
		
		//South �г�
		JPanel southP = new JPanel();
		southP.add(line); //�гο� ������ư ���̱�
		southP.add(circle);
		southP.add(rect);
		southP.add(roundRect);
		southP.add(pen);
		southP.add(combo); //�гο� �޺��ڽ� ���̱�
		southP.add(draw); //�гο� ��ư ���̱�

		Container c = this.getContentPane();
		c.add("North", northP);
		c.add("Center", can);
		c.add("South", southP);
		
		setBounds(700,100,600,600);
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//�̺�Ʈ
		draw.addActionListener(this); //�׸��� ��ư

		can.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x1T.setText(e.getX()+""); //�ؽ�Ʈ�ʵ忡 �̺�Ʈ�� �߻��� ������ ��ǥ�� �ִ´�
				y1T.setText(e.getY()+"");
			}//mousePressed(MouseEvent e)
			
			@Override
			public void mouseReleased(MouseEvent e) {
				//System.out.println("mouseReleased : "+e.getX()+", "+e.getY());

				int x1 = Integer.parseInt(x1T.getText()); //�ؽ�Ʈ���� ������ ���ڿ� ��
				int y1 = Integer.parseInt(y1T.getText());
				if(x1 == e.getX() && y1 == e.getY()) return; 
				//�׸��� �������� mouseReleased�� ���� ������ �� �׸� ����̹Ƿ� ����Ʈ���� ����
				
				//���� 1���� ��� ���� �����ϴ� mouseReleased�� �� dto ����
				ShapeDTO dto = new ShapeDTO();
				
				//��ǥ - �ؽ�Ʈ�ʵ忡�� ���� ������ dto�� ����
				dto.setX1(Integer.parseInt(x1T.getText()));
				dto.setY1(Integer.parseInt(y1T.getText()));
				dto.setX2(Integer.parseInt(x2T.getText()));
				dto.setY2(Integer.parseInt(y2T.getText()));
				dto.setZ1(Integer.parseInt(z1T.getText()));
				dto.setZ2(Integer.parseInt(z2T.getText()));
				
				//ä��� - fill�� ���õǾ����� �ƴ���, is~�� ������� T/F
				dto.setFill(fill.isSelected());
				
				//���� - ������ ���õǾ��ٸ� dto�� ���� ����
				if(line.isSelected()) dto.setShape(Shape.LINE);
				else if(circle.isSelected()) dto.setShape(Shape.CIRCLE);
				else if(rect.isSelected()) dto.setShape(Shape.RECT);
				else if(roundRect.isSelected()) dto.setShape(Shape.ROUNDRECT);
				
				//�� - �޺����ڿ��� ���õ� index�� dto�� ����
				dto.setColor(combo.getSelectedIndex());
				
				list.add(dto); //list�� dto ����
				
				//System.out.println(list); //üũ
			}//mouseReleased(MouseEvent e)
		});
		
		can.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				//�巡�״� x1, y1�� ������, x2, y2�� �ٲ�
				x2T.setText(e.getX()+""); //�ؽ�Ʈ�ʵ忡 �̺�Ʈ�� �߻��� ������ ��ǥ�� ������
				y2T.setText(e.getY()+""); 
				
				can.repaint(); //�巡�׸� ���� ���� ĵ������ �ٽ� �׸���
			}
		});	
	}//MsPaint()

	@Override
	public void actionPerformed(ActionEvent e) {
		can.repaint(); //�׸��� ��ư Ŭ���� ĵ������ �ٽ� �׸���
	}
	
	//getter
	public JTextField getX1T(){
		return x1T;
	}
	public JTextField getY1T(){
		return y1T;
	}
	public JTextField getX2T(){
		return x2T;
	}
	public JTextField getY2T(){
		return y2T;
	}
	public JTextField getZ1T(){
		return z1T;
	}
	public JTextField getZ2T(){
		return z2T;
	}
	public JComboBox<String> getCombo(){
		return combo;
	}
	public JCheckBox getFill() {
		return fill;
	}
	public JRadioButton getLine() {
		return line;
	}
	public JRadioButton getCircle() {
		return circle;
	}
	public JRadioButton getRect() {
		return rect;
	}
	public JRadioButton getRoundRect() {
		return roundRect;
	}
	public JRadioButton getPen() {
		return pen;
	}
	public List<ShapeDTO> getList(){
		return list;
	}
	
	public static void main(String[] args) {
		new MsPaint();
	}
}












