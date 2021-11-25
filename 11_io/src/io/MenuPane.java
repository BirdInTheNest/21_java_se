package io;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuPane extends JMenuBar {
	private JMenu fileM, editM, viewM;
	private JMenuItem newM, openM, saveM, exitM, cutM, copyM, pasteM;
	
	public MenuPane() { //생성자
		fileM = new JMenu("파일"); //메뉴 생성
		editM = new JMenu("편집");
		viewM = new JMenu("보기");
		
		newM = new JMenuItem("새로만들기"); //메뉴 아이템 생성
		openM = new JMenuItem("열기");
		saveM = new JMenuItem("저장");
		exitM = new JMenuItem("종료");
		cutM = new JMenuItem("잘라내기");
		copyM = new JMenuItem("복사");
		pasteM = new JMenuItem("붙여넣기");
		
		fileM.add(newM); //메뉴에 메뉴 아이템 붙이기
		fileM.add(openM);
		fileM.add(saveM);
		fileM.add(exitM);
		
		editM.add(cutM);
		editM.add(copyM);
		editM.add(pasteM);
		
		this.add(fileM); //메뉴바에 메뉴 붙이기
		this.add(editM);
		this.add(viewM);
	}//MenuPane()

	public JMenu getFileM() {
		return fileM;
	}
	public JMenu getEditM() {
		return editM;
	}
	public JMenu getViewM() {
		return viewM;
	}
	public JMenuItem getNewM() {
		return newM;
	}
	public JMenuItem getOpenM() {
		return openM;
	}
	public JMenuItem getSaveM() {
		return saveM;
	}
	public JMenuItem getExitM() {
		return exitM;
	}
	public JMenuItem getCutM() {
		return cutM;
	}
	public JMenuItem getCopyM() {
		return copyM;
	}
	public JMenuItem getPasteM() {
		return pasteM;
	}
}

//Component는 단독으로 뜨지 않고, Container가 있어야 뜰 수 있다