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
		super("미니 그림판"); //setTitle("미니 그림판");
		//JLabel 생성
		x1L = new JLabel("x1");
		y1L = new JLabel("y1");
		x2L = new JLabel("x2");
		y2L = new JLabel("y2");
		z1L = new JLabel("z1");
		z2L = new JLabel("z2");
		
		//JTextField 생성
		x1T = new JTextField("0", 4); //String text, int columns
		y1T = new JTextField("0", 4); //열의 크기를 주지 않으면 텍스트필드가 짧게 그려진다
		x2T = new JTextField("0", 4);
		y2T = new JTextField("0", 4);
		z1T = new JTextField("50", 4); //모서리가 깎이는 부분 값 고정
		z2T = new JTextField("50", 4);
		
		//JCheckBox 생성
		fill = new JCheckBox("채우기");
		
		//JRadioButton 생성 - ButtonGroup으로 묶어줘야 버튼 중복 선택이 안 됨
		line = new JRadioButton("선");
		circle = new JRadioButton("원");
		rect = new JRadioButton("사각형", true); //true면 처음에 항상 선택된 상태
		roundRect = new JRadioButton("둥근사각형");
		pen = new JRadioButton("연필");
		
		ButtonGroup group = new ButtonGroup();
		group.add(line);
		group.add(circle);
		group.add(rect);
		group.add(roundRect);
		group.add(pen);
		
		//JComboBox<String> 생성
		String[] color = {"하늘","회색","분홍","보라","주황"}; //0 1 2 3 4 (index)
		combo = new JComboBox<String>(color);//JComboBox<String>(String[] items)
		
		//JButton 생성
		draw = new JButton("그리기");
		
		//DrCanvas 생성
		can = new DrCanvas(this); //this는 MsPaint를 말함
		
		//List<ShapeDTO> 생성
		list = new ArrayList<ShapeDTO>();
		
		//North 패널 - FlowLayout(순서배치), 기본이 가운데 정렬
		JPanel northP = new JPanel(); 
		northP.add(x1L); northP.add(x1T); //패널에 라벨과 텍스트필드 붙이기
		northP.add(y1L); northP.add(y1T);
		northP.add(x2L); northP.add(x2T);
		northP.add(y2L); northP.add(y2T);
		northP.add(z1L); northP.add(z1T);
		northP.add(z2L); northP.add(z2T);
		northP.add(fill); //패널에 체크박스 붙이기
		
		//South 패널
		JPanel southP = new JPanel();
		southP.add(line); //패널에 라디오버튼 붙이기
		southP.add(circle);
		southP.add(rect);
		southP.add(roundRect);
		southP.add(pen);
		southP.add(combo); //패널에 콤보박스 붙이기
		southP.add(draw); //패널에 버튼 붙이기

		Container c = this.getContentPane();
		c.add("North", northP);
		c.add("Center", can);
		c.add("South", southP);
		
		setBounds(700,100,600,600);
		setResizable(true);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//이벤트
		draw.addActionListener(this); //그리기 버튼

		can.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				x1T.setText(e.getX()+""); //텍스트필드에 이벤트가 발생한 시점의 좌표를 넣는다
				y1T.setText(e.getY()+"");
			}//mousePressed(MouseEvent e)
			
			@Override
			public void mouseReleased(MouseEvent e) {
				//System.out.println("mouseReleased : "+e.getX()+", "+e.getY());

				int x1 = Integer.parseInt(x1T.getText()); //텍스트에서 가져온 문자열 값
				int y1 = Integer.parseInt(y1T.getText());
				if(x1 == e.getX() && y1 == e.getY()) return; 
				//그림의 시작점과 mouseReleased된 값이 같으면 안 그린 경우이므로 리스트에서 제외
				
				//도형 1개의 모든 정보 저장하는 mouseReleased일 때 dto 생성
				ShapeDTO dto = new ShapeDTO();
				
				//좌표 - 텍스트필드에서 값을 가져와 dto에 저장
				dto.setX1(Integer.parseInt(x1T.getText()));
				dto.setY1(Integer.parseInt(y1T.getText()));
				dto.setX2(Integer.parseInt(x2T.getText()));
				dto.setY2(Integer.parseInt(y2T.getText()));
				dto.setZ1(Integer.parseInt(z1T.getText()));
				dto.setZ2(Integer.parseInt(z2T.getText()));
				
				//채우기 - fill이 선택되었는지 아닌지, is~는 결과값이 T/F
				dto.setFill(fill.isSelected());
				
				//도형 - 도형이 선택되었다면 dto에 도형 저장
				if(line.isSelected()) dto.setShape(Shape.LINE);
				else if(circle.isSelected()) dto.setShape(Shape.CIRCLE);
				else if(rect.isSelected()) dto.setShape(Shape.RECT);
				else if(roundRect.isSelected()) dto.setShape(Shape.ROUNDRECT);
				
				//색 - 콤보상자에서 선택된 index를 dto에 저장
				dto.setColor(combo.getSelectedIndex());
				
				list.add(dto); //list에 dto 저장
				
				//System.out.println(list); //체크
			}//mouseReleased(MouseEvent e)
		});
		
		can.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				//드래그는 x1, y1은 고정값, x2, y2만 바뀜
				x2T.setText(e.getX()+""); //텍스트필드에 이벤트가 발생한 시점의 좌표를 가져옴
				y2T.setText(e.getY()+""); 
				
				can.repaint(); //드래그를 놓는 순간 캔버스에 다시 그리기
			}
		});	
	}//MsPaint()

	@Override
	public void actionPerformed(ActionEvent e) {
		can.repaint(); //그리기 버튼 클릭시 캔버스에 다시 그리기
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












