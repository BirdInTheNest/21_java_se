package inheritance;

import java.awt.Button;
import java.awt.Frame;

public class AwtMain3 extends Frame {
	private Button newBtn, exitBtn;
	
	public void init() { //�ʱ�ȭ �޼ҵ�
		//��ư ����
		newBtn = new Button("���θ����");
		exitBtn = new Button("����");
		
		setLayout(null); //Frame�� �⺻ ���̾ƿ��� BorderLayout ��Ʈ��
		newBtn.setBounds(100,100,120,50); //��ư ��ġ ���� (x��, y��, �ʺ�, ����)
		exitBtn.setBounds(100,160,120,50);
		
		//��ư ��ġ
		add(newBtn);
		add(exitBtn);
		
		setTitle("â");
		setBounds(900,200,300,400);
		setVisible(true); //ȣ��
	}

	public static void main(String[] args) {
		new AwtMain3().init();
	}
}

/*
���� Ʋ �����

1. Panel + GridLayout : �г� 7��
or
2. setLayout(null) + ������ ��ġ ����

private Button[] btn : �迭�� ũ��� 18���� ��� for���� ����Ͽ� �����Ѵ�

private Label dispL : �� 2��, Label�� �������� ������
			  inputL (�����ʿ� 0�� ǥ���Ͻÿ�)			  
*/