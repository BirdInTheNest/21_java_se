package swing;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class DrCanvas extends Canvas { 
	private MsPaint msPaint; //MsPaint�� �ִ� ���� �����;� �ϱ� ������ �ʵ忡 ���� �ʿ�
	
	public DrCanvas(MsPaint msPaint) { //DrCanvas �����ϸ鼭 Mspaint Ŭ���� �޾ƿ´�
		this.msPaint = msPaint; //�޾ƿ� ���� �ʵ�� �޴´�
		setBackground(new Color(255,255,128));
	}
	
	//paint()�� â�� �߸� �ٷ� ȣ��Ǵ� �ݹ�޼ҵ�, �Ź� ������ â�� ������ �׸��� �ٽ� �׸��� �ݺ�
	//�׸��� Canvas�� �׷����ϱ� paint()�� ���⿡�� ����, ��ǥ�� �ʱⰪ�� �־�� �������� ���� 
	
	@Override 
		public void paint(Graphics g) {
			//������ �׸� ���� : ��ǥ, ä���, ����, ���� �˾ƾ� �� (ShapeDTO �ʿ�)
			int x1, y1, x2, y2, z1, z2;
		
			//MsPaint()�� List�� ����ִ� ������ �׸� �׸� dto�� �ϳ��� ������ �ٽ� �׸���
			for(ShapeDTO dto : msPaint.getList()) {
				//��ǥ
				x1 = dto.getX1();
				y1 = dto.getY1();
				x2 = dto.getX2();
				y2 = dto.getY2();
				z1 = dto.getZ1();
				z2 = dto.getZ2();
				
				//case 0 : this.setForeground(Color.CYAN); break;
				//setBackground, setForeground�� repaint�� �ҷ��� �ٽ� �׸�
				//setColor�� �� �ο��� repaint �θ��� ����
				
				//��
				switch(dto.getColor()) { //int
				case 0 : g.setColor(Color.CYAN); break; 
				case 1 : g.setColor(Color.DARK_GRAY); break;
				case 2 : g.setColor(Color.PINK); break;
				case 3 : g.setColor(Color.MAGENTA); break;
				case 4 : g.setColor(Color.ORANGE); break;
				}
				
				//����
				if(dto.isFill()) { //ä���� ����
					if(dto.getShape() == Shape.LINE)
						g.drawLine(x1, y1, x2, y2);
					
					//������(x��ǥ, y��ǥ): �ּҰ�, ����(�ʺ�, ����): ���밪
					else if(dto.getShape() == Shape.CIRCLE)
						g.fillOval(Math.min(x1, x2), Math.min(y1, y2), 
								   Math.abs(x2-x1), Math.abs(y2-y1));
					
					else if(dto.getShape() == Shape.RECT)
						g.fillRect(Math.min(x1, x2), Math.min(y1, y2), 
								   Math.abs(x2-x1), Math.abs(y2-y1)); 
					
					else if(dto.getShape() == Shape.ROUNDRECT)
						g.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), 
								        Math.abs(x2-x1), Math.abs(y2-y1), z1, z2); 
				}else { //�� ����
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
			
			//���� �׷����� ����
			//��ǥ - getter �ʿ�, Mspaint�� �ؽ�Ʈ�ʵ忡�� �ؽ�Ʈ�� ������� ��������
			x1 = Integer.parseInt(msPaint.getX1T().getText().trim());
			y1 = Integer.parseInt(msPaint.getY1T().getText().trim());
			x2 = Integer.parseInt(msPaint.getX2T().getText().trim());
			y2 = Integer.parseInt(msPaint.getY2T().getText().trim());
			z1 = Integer.parseInt(msPaint.getZ1T().getText().trim());
			z2 = Integer.parseInt(msPaint.getZ2T().getText().trim());			
			//getText()�� ���ڿ��� �����´�, trim()�� ���� ���� ����
			
			//�� - Mspaint�� �޺� �ڽ����� ���õ� index ��(int) ��������
			switch(msPaint.getCombo().getSelectedIndex()) {
			case 0 : g.setColor(Color.CYAN); break;
			case 1 : g.setColor(Color.DARK_GRAY); break;
			case 2 : g.setColor(Color.PINK); break;
			case 3 : g.setColor(Color.MAGENTA); break;
			case 4 : g.setColor(Color.ORANGE); break;
			}
			
			//���� - Mspaint�� üũ�ڽ����� ������ �� isSelected�� T�� �� ä���� ����
			if(msPaint.getFill().isSelected()) { //is~() ���ϰ��� T F�� 
				if(msPaint.getLine().isSelected())
					g.drawLine(x1, y1, x2, y2);
					
				//������(x��ǥ, y��ǥ): �ּҰ�, ����(�ʺ�, ����): ���밪
				else if(msPaint.getCircle().isSelected()) //������
					g.fillOval(Math.min(x1, x2), Math.min(y1, y2),
							   Math.abs(x2-x1), Math.abs(y2-y1));
				
				else if(msPaint.getRect().isSelected())
					g.fillRect(Math.min(x1, x2), Math.min(y1, y2),
							   Math.abs(x2-x1), Math.abs(y2-y1));
				
				else if(msPaint.getRoundRect().isSelected())
					g.fillRoundRect(Math.min(x1, x2), Math.min(y1, y2), 
							        Math.abs(x2-x1), Math.abs(y2-y1), z1, z2); 
				
			}else { //F�� �� �� ����
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

//paint()�� â ũ�⸦ �����ϸ� ������ â�� ������ �ٽ� �׸���
//��ǥ 6��, ä��� T/F, ����, �� �� �˾ƾ� �ٽ� �׸� �� �ִ� (ShapeDTO �ʿ�)
//����Ʈ�� ���� dto�� ���� list -> ShapeDTO
//mouseRelease�� �� dto �����ؼ� �����ϸ� �Ƿ���?
//ShapeDTO dto = new ShapeDTO(); //���� 1���� ��� ���� ������ �� ������(mouseReleased)
//dto.setX1(???);
//dto�� list�� ���
//List<ShapeDTO> list = new ArrayList<ShapeDTO>(); //�θ� = �ڽ�

//���� x1 y1�� �� �ٲ�� x2 y2�� �ٲ�µ�, ������ ���������� x2 y2�� �ٽ� x1 y1�� �ȴ� - ���� ����











