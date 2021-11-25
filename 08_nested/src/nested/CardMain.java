/*
Frame / JFrame - BorderLayout (��������)
Panel		   - FlowLayout (�߾��� �߽����� ������� ��ġ)
			   - GridLayout (�յ��� �࿭��ġ)
Canvas		   - setLayout(null) (���̾ƿ��� ����) - �׸���
			   - CardLayout() (Ŭ���� ������ ī�尡 �� ���� �ö�´�)
 */

package nested;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CardMain {
	private Frame frame; //extends frame���� ���ϰ�, ������ â�� ��ü�� ���� ����
	private CardLayout card;
	
	public CardMain() {
		//JFrame�� ��ӹ��� �ʾ����Ƿ� �޸� �����ؾ� ��. ����ϸ� �ڽ��� �θ�ű��� �޸𸮿� ������
		frame = new Frame(); 
		card = new CardLayout();
		frame.setLayout(card);
		
		//Panel 7���� �迭�� ����
		Panel[] ar = new Panel[7]; //ar�̶� �̸����� �游 7�� ����, �г��� ��������� �ƴ�
		Color[] color = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, 
						 Color.MAGENTA, Color.CYAN, Color.ORANGE};
		String[] title = {"����", "�ʷ�", "�Ķ�", "���", "����", "�ϴ�", "��Ȳ"};
		
		for(int i=0; i<ar.length; i++) {
			ar[i] = new Panel(); //ar �� �濡 �г� ����
			ar[i].setBackground(color[i]);
		
			frame.add(ar[i], title[i]); //frame�� �гΰ� �� Ÿ��Ʋ�� ���϶�
		}//for
		
		//�̺�Ʈ
		for(int i=0; i<ar.length; i++) {
			ar[i].addMouseListener(new MouseAdapter() { //�͸� Inner Class {}
			//�г��� ������ ar �迭 �濡�� MouseListener�̺�Ʈ �߻�, MouseAdapter()�� ���� 
				@Override
				public void mouseClicked(MouseEvent e) { //Override�ϰ� ���� �κ�
					//card.show(frame, "����");
					card.next(frame); //next�� �̸��� �ʿ� ����
				}
			});
		}//for
		
		frame.addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});		

		frame.setBounds(900,250,200,200);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new CardMain();
	}
}