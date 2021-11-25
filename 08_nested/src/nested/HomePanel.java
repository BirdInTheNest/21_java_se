package nested;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;

//Panel로 상속을 받았기 때문에 이 자체로 실행불가, Panel(Component를 묶어주는 Layer역할만 함)
public class HomePanel extends Panel { 
	
	public HomePanel() { //생성자
		this.setBackground(Color.YELLOW);
	}
	
	@Override
	public void paint(Graphics g) {
		Toolkit t = Toolkit.getDefaultToolkit();
		Image img = t.getImage("image/study.gif");
		g.drawImage(img, 30, 50, this); //이미지, 위치지정, 여기에
	}
}