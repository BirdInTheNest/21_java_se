package nested;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RGBMain extends Frame {
	private Button redBtn, greenBtn, blueBtn;
	private DrCanvas can;
	//�ٱ��� Ŭ������ ���� Ŭ���� ����� ���� �Ұ����ϹǷ� ���� Ŭ������ ��ü �����Ͽ� ���� Ŭ���� ����� ����
	
	public RGBMain() { //������
		redBtn = new Button("����"); //��ư ����
		greenBtn = new Button("�ʷ�");
		blueBtn = new Button("�Ķ�");
		
		can = new DrCanvas(); //ĵ���� ����
		
		Panel p = new Panel(); //�г� ����
		p.add(redBtn);
		p.add(greenBtn);
		p.add(blueBtn);
		
		this.add("North", p);
		this.add("Center", can);		
		
		setBounds(900,150,300,400);
		setVisible(true);
		
		//�̺�Ʈ
		//WindowAdapter�� �߻�Ŭ������ ���� new �� �� ����, ���� {}�� ����
		//WindowAdapter�� �߻�޼ҵ尡 1�� ���� (�ݵ�� Override �ؾ� �� �޼ҵ� ����, �� body)
		//���ϴ� �κ� {}�ȿ� Override�ؼ� ���
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) { //�޼ҵ��� ù���ڴ� �ҹ���
				System.exit(0);
			} 
		});	
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("���콺 Ŭ��");
			}
		});
		
		//�������̽��� new�� �ȵǼ� ���� {}�ٰ�, {}�ȿ� ���ϴ� �κ� Override �ϸ� ��
		redBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				can.setBackground(Color.RED);
			}
		}); //�͸� Inner Class�� ���� �ѹ� ���� ������ 1ȸ���� ��
		
		greenBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				can.setBackground(Color.GREEN);
			}
		});
		
		blueBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				can.setBackground(Color.BLUE);	
			}
		});	
		
	}//RGBMain()
	
	//Canvas�� new�ؼ� �ϴ� �� �ƴ϶� ��ӹ޾Ƽ� ��������� �ڹٴ� Ŭ���� ���߻���� �ȵǹǷ� ��ø��Ų��.
	class DrCanvas extends Canvas{ //DrCanvas Ŭ������ Canvas Ŭ���� ���
		
		public DrCanvas() { //������
			this.setBackground(new Color(255,200,255));
		}	
	}
	
	public static void main(String[] args) {
		new RGBMain();
	}
}
