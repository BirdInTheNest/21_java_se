/*
Frame / JFrame - BorderLayout (동서남북)
Panel		   - FlowLayout (중앙을 중심으로 순서대로 배치)
			   - GridLayout (균등한 행열배치)
Canvas		   - setLayout(null) (레이아웃이 없음) - 그림판
			   - CardLayout() (클릭할 때마다 카드가 맨 위로 올라온다)
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
	private Frame frame; //extends frame으로 안하고, 윈도우 창의 객체를 따로 만듦
	private CardLayout card;
	
	public CardMain() {
		//JFrame을 상속받지 않았으므로 메모리 생성해야 함. 상속하면 자식이 부모거까지 메모리에 생성함
		frame = new Frame(); 
		card = new CardLayout();
		frame.setLayout(card);
		
		//Panel 7개를 배열로 생성
		Panel[] ar = new Panel[7]; //ar이란 이름으로 방만 7개 만듦, 패널이 만들어진게 아님
		Color[] color = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, 
						 Color.MAGENTA, Color.CYAN, Color.ORANGE};
		String[] title = {"빨강", "초록", "파랑", "노랑", "보라", "하늘", "주황"};
		
		for(int i=0; i<ar.length; i++) {
			ar[i] = new Panel(); //ar 빈 방에 패널 생성
			ar[i].setBackground(color[i]);
		
			frame.add(ar[i], title[i]); //frame에 패널과 그 타이틀을 더하라
		}//for
		
		//이벤트
		for(int i=0; i<ar.length; i++) {
			ar[i].addMouseListener(new MouseAdapter() { //익명 Inner Class {}
			//패널이 생성된 ar 배열 방에서 MouseListener이벤트 발생, MouseAdapter()가 구현 
				@Override
				public void mouseClicked(MouseEvent e) { //Override하고 싶은 부분
					//card.show(frame, "보라");
					card.next(frame); //next는 이름이 필요 없음
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