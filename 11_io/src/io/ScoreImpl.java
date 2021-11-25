package io;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Vector;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

//ScoreImpl Ŭ������ ScoreService ��� ���� �����Ѵ�

//ScoreImpl Ŭ������ �������̽� Score�� implements�߱� ������ 
//Score���� �߻�޼ҵ尡 ��������� Override�ؼ� ����ü�� ������ �Ѵ�

public class ScoreImpl implements Score {
	private List<ScoreDTO> list;
	
	public ScoreImpl() {
		list = new ArrayList<ScoreDTO>(); //�θ�=�ڽ�, ArrayList���� ScoreDTO�� ��ڴ�
	}

	@Override
	public void input(ScoreDTO dto) { //�Է�
		list.add(dto); //dto�� list�� ����
		System.out.println(list);
		JOptionPane.showMessageDialog(null, "��� �Ϸ�");
	}

	@Override
	public void print(DefaultTableModel model) { //TableModel�� �����͸� ��� ���
		model.setRowCount(0); //TableModel�� ���� ������ 0���� �ʱ�ȭ, �������� �� ������
		
		for(ScoreDTO dto : list) { //����Ʈ�� �ִ� dto�� ���� ���͸� �����
			Vector<String> v = new Vector<String>(); //dto ���ٴ� ���� �ϳ�
			v.add(dto.getHak()); //dto���� ���� ������ ���Ϳ� ��� �߰�
			v.add(dto.getName());
			v.add(dto.getKor() + ""); //Vector�� ���ʸ��� String�̹Ƿ� int���� ���ڿ��� �ٲٱ�
			v.add(dto.getEng() + "");
			v.add(dto.getMath() + "");
			v.add(dto.getTot() + "");
			v.add(String.format("%.2f", dto.getAvg()));
			
			model.addRow(v); //TableModel�� �� ���� ���� �߰�
		}//for
	}

	@Override
	public void search(DefaultTableModel model) { //TableModel�� �����͸� �����ͼ� �й��˻�
		String hak = JOptionPane.showInputDialog(null, 
				"�й��� �Է��ϼ���",
				"�˻�",
				JOptionPane.QUESTION_MESSAGE);
		if(hak==null || hak.length()==0) return; //��ҹ�ư�� �����ų� �Է��� ���ѰŸ� �Լ��� ������
		//Cancel�� ������ null���� ����, ���� ���̰� 0�̸� �Էµ��� ����
		
		int sw=0; //����ġ ����
		for(ScoreDTO dto : list) {
			if(hak.equals(dto.getHak())) { //�Էµ� ���� dto���� ���� ���� ������
				model.setRowCount(0); //TableModel�� ���� ������ 0���� �ʱ�ȭ
				
				Vector<String> v = new Vector<String>();
				v.add(dto.getHak()); //dto���� ���� ������ ���Ϳ� ��� �߰�
				v.add(dto.getName());
				v.add(dto.getKor() + ""); //Vector�� ���ʸ��� String�̹Ƿ� int���� ���ڿ��� �ٲٱ�
				v.add(dto.getEng() + "");
				v.add(dto.getMath() + "");
				v.add(dto.getTot() + "");
				v.add(String.format("%.2f", dto.getAvg()));
				
				model.addRow(v); //TableModel�� �� ���� ���� �߰�
				sw=1;
			}
		}//for
		
		if(sw==0)
			JOptionPane.showMessageDialog(null,  "ã���� �ϴ� �й��� �����ϴ�");
	}

	@Override
	public void tot_desc() { //�������� ��������
		//���� ���� ������ List�� ��� �� �����͸� ������ ��������(Comparable, Comparator)
		//List ���� ScoreDTO�� ��������
		//DB�� ��� : select * from ���̺� order by tot desc;
		
		Comparator<ScoreDTO> com = new Comparator<ScoreDTO>() {
			@Override
			public int compare(ScoreDTO s1, ScoreDTO s2) {
//				��������
//				if(s1.getTot() < s2.getTot()) return -1;
//				else if(s1.getTot() > s2.getTot()) return 1;
//				else return 0;
				
				//��������
				return s1.getTot() < s2.getTot() ? 1 : -1;
			}
		};
		
		Collections.sort(list, com); //Comparator�� ����
	}

	@Override
	public void save() { //��������
		JFileChooser chooser = new JFileChooser(); 
		int result = chooser.showSaveDialog(null); 
		
		File file = null;
		if(result ==JFileChooser.APPROVE_OPTION) { //Ȯ�ι�ư�� ����
			file = chooser.getSelectedFile();
		}
		//--------------------
		if(file == null) return; //Dialog���� Cancel ������ null���� ����. �Լ��� ������
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		
			//�ι�° ��� - ArrayList�� ����ִ� ScoreDTO�� ������ ����
			oos.writeInt(list.size());
			
			for(ScoreDTO dto : list) {
				oos.writeObject(dto);
			}//for
		
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void load() { //�����б�
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(null);
		
		File file = null;
		if(result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile(); //���� ����
		}
		//-----------------------
		if(file == null) return; //file�� null�̸� �Լ��� ������
		
		list.clear(); //appendó�� �����Ͱ��� �鷯�ٴ� �� ����
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			
//			ù���� ���
//			while(true) {
//				try {
//					ScoreDTO dto = (ScoreDTO)ois.readObject();
//					list.add(dto);
//					
//				}catch(EOFException e) { //���� �߻��� ������ ��� while�� ������
//					break;
//				}//end of file ����: ���̻� ���� �Ÿ��� ������ ������ (�������� �ƴ϶� ������ ��)
//				
//			}//while
			
			//�ι�° ��� - ���Ͽ��� ScoreDTO�� ������ ����� ���� �д´�
			int size = ois.readInt();
			for(int i=0; i<size; i++) { //read�� ���� Ȯ���� for�� �� ��, ����� ���� ��밡��
				ScoreDTO dto = (ScoreDTO)ois.readObject();
				list.add(dto);
			}
			
			ois.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
//��ü���� ��ġ�� Ŀ�� ������ ��ü�� �Ѿ���� �� �ƴ϶� �ּҰ��� �Ѿ�� model�� �ּҰ��� �Ѿ�� ����
//��ü�� IOStream�� Ÿ�� �� ��, ��ü�� byte[]�� �ɰ��� ����ȭ�ؾ��Ѵ�
//�ڹٰ� �����ϴ� �޼ҵ� Override�� throws�� �ȵȴ�



















