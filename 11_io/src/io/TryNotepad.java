package io;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class TryNotepad extends JFrame implements ActionListener {
	private JTextArea area;
	private MenuPane menu; 
	//Component�� MenuPane Ŭ������ Container�� TryNotepad Ŭ���� �ʵ忡 �����;� �Ѵ�
	
	private File file; //�ʵ�� null�̶�� �ʱⰪ�� ���� ���� �ʾƵ� ������ ����
	
	public TryNotepad() { //������
		area = new JTextArea(); //�ؽ�Ʈ ����
		area.setFont(new Font("���ü", Font.PLAIN, 20));
		
		JScrollPane scroll = new JScrollPane(area); //��ũ�� ����, ��ũ�ѿ� �ؽ�Ʈ ���̱�
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		//VerticalScrollBar�� �Ծ��� �ְڴ�, �׻� �� �ֵ���
		
		menu = new MenuPane(); //MenuPane() ���� �� ȣ��
		this.setJMenuBar(menu); //���⿡ menu������ JMenuBar�� �ϰڴ�
		
		this.add("Center", scroll); //���⿡ ��ũ���� ����� �ٿ���
		
		setBounds(900,100,500,500);
		setVisible(true);

		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);//���� ����
		
//		WindowAdapter�� �߻�Ŭ���������� �߻�޼ҵ尡 ��� Override�� �� ����, �͸� Inner Class ���
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				int result = JOptionPane.showConfirmDialog(
						TryNotepad.this, //this�� ���� �͸� Inner Class�� ����
						"�����Ͻðڽ��ϱ�?", 
						"�޸���",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
				if(result == JOptionPane.YES_OPTION) { //YES 0, NO 1
					//���� �����ϰ�
					saveDialog();
					fileWrite();
					
					System.exit(0);
				}else if(result == JOptionPane.NO_OPTION) {
					System.exit(0);					
				}
			}
		});
		
		//�̺�Ʈ ó�� - �޴�
		menu.getNewM().addActionListener(this); //menu�� NewM ���� getter�� �����;� ��
		menu.getOpenM().addActionListener(this);
		menu.getSaveM().addActionListener(this);
		menu.getExitM().addActionListener(this);
		menu.getCutM().addActionListener(this);
		menu.getCopyM().addActionListener(this);
		menu.getPasteM().addActionListener(this);
		
	}//TryNotepad()

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==menu.getNewM()) {
			area.setText(""); //�ʱ�ȭ
			
		}else if(e.getSource()==menu.getOpenM()) {
			openDialog(); //���� ���̾�α� - ���� ����
			fileRead(); //������ ������ �о TextArea �Ѹ���
			
		}else if(e.getSource()==menu.getSaveM()) {
			saveDialog();
			fileWrite();
			
		}else if(e.getSource()==menu.getExitM()) {
			//System.exit(0); //���α׷� ����
			
			//���̾�α�
			//JOptionPane.showConfirmDialog�� ������� yes no cancel ���ڰ� �ƴ϶� �������̴�

			int result = JOptionPane.showConfirmDialog(
					this, //����?, null�� �ϸ� JFrame�� ������� ��
					"�����Ͻðڽ��ϱ�?", //�޽���
					"�޸���", //Ÿ��Ʋ
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE);
			
			if(result == JOptionPane.YES_OPTION) { //YES 0, NO 1
				//���� �����ϰ�
				saveDialog();
				fileWrite();
				
				System.exit(0);
			}else if(result == JOptionPane.NO_OPTION) {
				System.exit(0);
			}
				
		}else if(e.getSource()==menu.getCutM()) {
			area.cut();
			
		}else if(e.getSource()==menu.getCopyM()) {
			area.copy();
			
		}else if(e.getSource()==menu.getPasteM()) {
			area.paste();
		}
	}//actionPerformed(ActionEvent e)
		
	private void openDialog() {
		JFileChooser chooser = new JFileChooser(); //JFileChooser ���̾�α� ����
		int result = chooser.showOpenDialog(this); //JFrame ���� OpenDialog ����ּ���, ���ϰ� ����
		if(result == JFileChooser.APPROVE_OPTION) { //result�� ����� ���� APPROVE_OPTION �̸�
			file = chooser.getSelectedFile(); //���� ����
		}
		
		JOptionPane.showMessageDialog(this, file); //JFrame ���� ���� �޽��� ����ּ���
		//������ ��Σ����ϸ����� toString()�Ǿ� ����
		
		//return file; //openDialog()�� ������ �����ϴ� �޼ҵ�� �ϴ� ���� �ʵ忡 File�� ��� �ͺ��� �� ����
	}
	
	private void fileRead() { //���� �б�
		if(file == null) return; //file�� null�̸�(������ ������ ����) �Լ��� ������
		//NullPointerException�� ���� ���α׷� �ҽ��� ��ģ��
		area.setText(""); //������ �б� ���� �ʱ�ȭ�ϸ� ������ ��� ���� �� �� �������� ���� ����
				
		try {
			BufferedReader br = new BufferedReader(new FileReader(file)); //Reader ���� ���� ó��
			String line;
			
			while( (line = br.readLine()) != null) { //br.readLine()���� �о�� ���� ���������� �ݺ�
				//br.readLine()�� 1��(Enter�� ĥ ������)	�д´�

				//area.setText(line); //setText�� ���� ��� �����
				area.append(line+"\n"); //append ���� ��� �߰��Ѵ�, line�� ������ ������ �ٹٲٴ� �� �ʿ�	
				//(readLine()�� ���� ���� �о�� �ʱ� ������)
			}//while
			
			br.close(); //BufferedReader �ݱ�
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void saveDialog() {
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showSaveDialog(this);
	
		if(result == JFileChooser.APPROVE_OPTION) { //���� ����, Ȯ�ι�ư�� ����
			file = chooser.getSelectedFile();
		}
		
		JOptionPane.showMessageDialog(this, file);
	}
	
	private void fileWrite() {
		if(file == null) return; //Dialog���� Cancel ������ null���� ����. �Լ��� ������
		String data = null;
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file,false)); 
			//true�̸� ���� ���� ��� �߰� false�� ���Ͽ� �����. �⺻����Ʈ�� false��
			data = area.getText();
			
			bw.write(data); //���Ϸ� �����
			bw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new TryNotepad();
	}
}

/*

Application <-- BufferedReader -- buffer <-- FileReader -- Ű����/ȭ��
*.java		-- BufferedWriter -->		 -- FileWriter --> ����/DB/��Ʈ��ũ
			   printWriter 			   					

 */
























