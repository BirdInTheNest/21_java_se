package swing;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton; 

// JFrame�� 4���� ������ �����Ǿ� �ִ� 
// JFrame > JRootPane > layeredPane (���κ��� JMenuBar, �Ʒ��κ��� contentPane) > glassPane
// JMenuBar�� JMenu, JmenuItem�� �ø� �� �ִ�. setJMenuBar()
// contentPane�� Component���� �ø� �� �ִ�. getcontentPane()

// JRadioButton : ���� �׸� �߿��� �ϳ��� �׸� ������ �� �ֵ��� ���� Component
// ButtonGroup Ŭ������ �̿��Ͽ� ���� ���� �׸��� �׷����� �����ش�

public class JButtonEx extends JFrame {
	private Icon icon1 = new ImageIcon("image/aa.png"); //�̹��� ������ ����
	private Icon icon2 = new ImageIcon("image/bb.png");
	private Icon icon3 = new ImageIcon("image/cc.png");
	private Icon icon4 = new ImageIcon("image/dd.png");
	private JRadioButton[] jb = new JRadioButton[4]; //�� 4��¥�� JRadioButton �迭 ����
	private ButtonGroup bg = new ButtonGroup(); //ButtonGroup ����
	
	public JButtonEx() { //������
		super("Test"); //JFrame Ÿ��Ʋ
		Container con = this.getContentPane(); //JFrame���� ContentPane�� �����Ͷ�
		con.setLayout(new GridLayout(2,2)); //2�� 2��
		
		for(int i=0; i<jb.length; i++) {
			jb[i] = new JRadioButton(i+1+"�� ��ư", icon1); //JRadioButton ����, �ؽ�Ʈ, ������
			con.add(jb[i]); //JRadioButton�� ContentPane�� �ٿ���
			jb[i].setToolTipText(i+1+"��° ��ư�̴�. ����!!"); //Ŀ���� ���� �� �ߴ� �ؽ�Ʈ
			jb[i].setMnemonic(i+49); // ALT�� �����Ͽ� ����Ű ����
			jb[i].setRolloverIcon(icon2);
			jb[i].setPressedIcon(icon3); 
			jb[i].setSelectedIcon(icon4);
			bg.add(jb[i]); //ButtonGroup�� JRadioButton ����
		}
		pack(); //�����̳��� ũ�⸦ ���� ��� ���� ũ��� ����
		setVisible(true);
	}//JButtonEx()

	public static void main(String[] args) {
		new JButtonEx();
	}
}



















