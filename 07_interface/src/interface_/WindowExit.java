package interface_;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class WindowExit implements WindowListener { //import�ϰ�, Override�ϰ�
	
	//WindowListener Override - call back �޼ҵ�, JVM�� ȣ���ϴ� �޼ҵ�
	@Override
	public void windowOpened(WindowEvent e) {} 

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("���α׷� ����");
		System.exit(0); //���α׷� ���� ����
	} 
	
	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

}
