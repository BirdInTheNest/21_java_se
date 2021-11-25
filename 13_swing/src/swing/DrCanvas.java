package swing;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class DrCanvas extends Canvas { 
	private MsPaint msPaint; //MsPaint에 있는 값을 가져와야 하기 때문에 필드에 선언 필요
	
	public DrCanvas(MsPaint msPaint) { //DrCanvas 생성하면서 Mspaint 클래스 받아온다
		this.msPaint = msPaint; //받아온 값을 필드로 받는다
		setBackground(new Color(255,255,128));
	}
	
	//paint()는 창이 뜨면 바로 호출되는 콜백메소드, 매번 기존의 창을 버리고 그림을 다시 그리고를 반복
	//그림은 Canvas에 그려지니까 paint()는 여기에서 구현, 좌표의 초기값이 있어야 에러나지 않음 
	
	@Override 
		public void paint(Graphics g) {
			//기존에 그린 도형 : 좌표, 채우기, 도형, 색을 알아야 함 (ShapeDTO 필요)
			int x1, y1, x2, y2, z1, z2;
		
			//MsPaint()의 List에 담겨있는 예전에 그린 그림 dto를 하나씩 꺼내서 다시 그리기
			for(ShapeDTO dto : msPaint.getList()) {
				//좌표
				x1 = dto.getX1();
				y1 = dto.getY1();
				x2 = dto.getX2();
				y2 = dto.getY2();
				z1 = dto.getZ1();
				z2 = dto.getZ2();
				
				//case 0 : this.setForeground(Color.CYAN); break;
				//setBackground, setForeground는 repaint를 불러서 다시 그림
				//setColor는 색 부여라서 repaint 부르지 않음
				
				//색
				switch(dto.getColor()) { //int
				case 0 : g.setColor(Color.CYAN); break; 
				case 1 : g.setColor(Color.DARK_GRAY); break;
				case 2 : g.setColor(Color.PINK); break;
				case 3 : g.setColor(Color.MAGENTA); break;
				case 4 : g.setColor(Color.ORANGE); break;
				}
				
				//도형
				if(dto.isFill()) { //채워진 도형
					if(dto.getShape() == Shape.LINE)
						g.drawLine(x1, y1, x2, y2);
					
					//시작점(x좌표, y좌표): 최소값, 끝점(너비, 높이): 절대값
					else if(dto.getShape() == Shape.CIRCLE)
						g.fillOval(Math.min(x1, x2), Math.min(y1, y2), 
								   Math.abs(x2-x1), Math.abs(y2-y1));
					
					else if(dto.getShape() == Shape.RECT)
						g.fillRect(Math.min(x1, x2), Math.min(y1, y2), 
								   Math.abs(x2-x1), Math.abs(y2-y1)); 
					
					else if(dto.getShape() == Shape.ROUNDRECT)
						g.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), 
								        Math.abs(x2-x1), Math.abs(y2-y1), z1, z2); 
				}else { //빈 도형
					if(dto.getShape() == Shape.LINE)
						g.drawLine(x1, y1, x2, y2);
						
					else if(dto.getShape() == Shape.CIRCLE)
						g.drawOval(Math.min(x1, x2), Math.min(y1, y2), 
								   Math.abs(x2-x1), Math.abs(y2-y1));
					
					else if(dto.getShape() == Shape.RECT)
						g.drawRect(Math.min(x1, x2), Math.min(y1, y2), 
								   Math.abs(x2-x1), Math.abs(y2-y1)); 
					
					else if(dto.getShape() == Shape.ROUNDRECT)
						g.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), 
								        Math.abs(x2-x1), Math.abs(y2-y1), z1, z2); 
				}
			}//for
			
			//------------------------------------------------------------------
			
			//새로 그려지는 도형
			//좌표 - getter 필요, Mspaint의 텍스트필드에서 텍스트를 공백없이 가져오기
			x1 = Integer.parseInt(msPaint.getX1T().getText().trim());
			y1 = Integer.parseInt(msPaint.getY1T().getText().trim());
			x2 = Integer.parseInt(msPaint.getX2T().getText().trim());
			y2 = Integer.parseInt(msPaint.getY2T().getText().trim());
			z1 = Integer.parseInt(msPaint.getZ1T().getText().trim());
			z2 = Integer.parseInt(msPaint.getZ2T().getText().trim());			
			//getText()은 문자열을 가져온다, trim()은 양쪽 공백 제외
			
			//색 - Mspaint의 콤보 박스에서 선택된 index 값(int) 가져오기
			switch(msPaint.getCombo().getSelectedIndex()) {
			case 0 : g.setColor(Color.CYAN); break;
			case 1 : g.setColor(Color.DARK_GRAY); break;
			case 2 : g.setColor(Color.PINK); break;
			case 3 : g.setColor(Color.MAGENTA); break;
			case 4 : g.setColor(Color.ORANGE); break;
			}
			
			//도형 - Mspaint의 체크박스에서 가져온 값 isSelected가 T일 때 채워진 도형
			if(msPaint.getFill().isSelected()) { //is~() 리턴값은 T F임 
				if(msPaint.getLine().isSelected())
					g.drawLine(x1, y1, x2, y2);
					
				//시작점(x좌표, y좌표): 최소값, 끝점(너비, 높이): 절대값
				else if(msPaint.getCircle().isSelected()) //내접원
					g.fillOval(Math.min(x1, x2), Math.min(y1, y2),
							   Math.abs(x2-x1), Math.abs(y2-y1));
				
				else if(msPaint.getRect().isSelected())
					g.fillRect(Math.min(x1, x2), Math.min(y1, y2),
							   Math.abs(x2-x1), Math.abs(y2-y1));
				
				else if(msPaint.getRoundRect().isSelected())
					g.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), 
							        Math.abs(x2-x1), Math.abs(y2-y1), z1, z2); 
				
			}else { //F일 때 빈 도형
				if(msPaint.getLine().isSelected())
					g.drawLine(x1, y1, x2, y2);
					
				else if(msPaint.getCircle().isSelected())
					g.drawOval(Math.min(x1, x2), Math.min(y1, y2), 
							   Math.abs(x2-x1), Math.abs(y2-y1));
				
				else if(msPaint.getRect().isSelected())
					g.drawRect(Math.min(x1, x2), Math.min(y1, y2), 
							   Math.abs(x2-x1), Math.abs(y2-y1)); 
				
				else if(msPaint.getRoundRect().isSelected())
					g.drawRoundRect(Math.min(x1, x2), Math.min(y1, y2), 
							        Math.abs(x2-x1), Math.abs(y2-y1), z1, z2);
			}	
		}//paint(Graphics g)	
}

//paint()는 창 크기를 조절하면 기존의 창을 버리고 다시 그린다
//좌표 6개, 채우기 T/F, 도형, 색 을 알아야 다시 그릴 수 있다 (ShapeDTO 필요)
//리스트를 만들어서 dto를 저장 list -> ShapeDTO
//mouseRelease될 때 dto 생성해서 저장하면 되려나?
//ShapeDTO dto = new ShapeDTO(); //도형 1개의 모든 정보 저장할 때 생성됨(mouseReleased)
//dto.setX1(???);
//dto를 list에 담기
//List<ShapeDTO> list = new ArrayList<ShapeDTO>(); //부모 = 자식

//선은 x1 y1이 안 바뀌고 x2 y2만 바뀌는데, 연필은 꼬리물듯이 x2 y2가 다시 x1 y1이 된다 - 연필 숙제











