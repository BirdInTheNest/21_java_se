package inheritance;

import java.awt.Button;
import java.awt.Frame;

//Frame�� BorderLayout(������������ ��ġ �Ǿ� ����) - �������Ͽ��� 1���� ��ư�� ���� �� �ִ�
public class AwtMain extends Frame {
	private Button northBtn, southBtn, eastBtn, westBtn, centerBtn; //Ŭ������ �ʵ�� �ʱⰪ null ����
	
	public void init() { //init() �ʱ�ȭ �޼ҵ�
		//��ư ���� - ũ�Ⱑ �������� ����
		northBtn = new Button("����");
		southBtn = new Button("����");
		eastBtn = new Button("����");
		westBtn = new Button("����");
		centerBtn = new Button("�߾�");
		
		//��ġ
		add("North", northBtn);
		add("South", southBtn);
		add("East", eastBtn);
		add("West", westBtn);
		add("Center", centerBtn);
		
		setBounds(900,200,300,400); //â ũ�� ����
		setVisible(true); //ȣ��
	}

	public static void main(String[] args) {
		//AwtMain am = new AwtMain();
		//am.init();
		new AwtMain().init(); //1ȸ��, AwtMainŬ���� �����ϰ�, ������ �޼ҵ� ȣ���ϰ�, init() �θ���
	}
}

/*
�� Exception ����ó��

IOException
�������� �� �߻�, �������

NullPointerException : null���� ���� �ִ�. new�������� new�ش޶�
������ �� �߻�, ������ �ڵ� �߸�
*/
