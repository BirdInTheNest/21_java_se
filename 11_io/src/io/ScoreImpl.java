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

//ScoreImpl 클래스는 ScoreService 대신 일을 수행한다

//ScoreImpl 클래스는 인터페이스 Score를 implements했기 때문에 
//Score에서 추상메소드가 만들어지면 Override해서 구현체를 만들어야 한다

public class ScoreImpl implements Score {
	private List<ScoreDTO> list;
	
	public ScoreImpl() {
		list = new ArrayList<ScoreDTO>(); //부모=자식, ArrayList에는 ScoreDTO만 담겠다
	}

	@Override
	public void input(ScoreDTO dto) { //입력
		list.add(dto); //dto를 list에 담자
		System.out.println(list);
		JOptionPane.showMessageDialog(null, "등록 완료");
	}

	@Override
	public void print(DefaultTableModel model) { //TableModel의 데이터를 담고 출력
		model.setRowCount(0); //TableModel의 행의 개수를 0으로 초기화, 데이터을 싹 지워라
		
		for(ScoreDTO dto : list) { //리스트에 있는 dto를 꺼내 벡터를 만든다
			Vector<String> v = new Vector<String>(); //dto 한줄당 벡터 하나
			v.add(dto.getHak()); //dto에서 꺼낸 값으로 벡터에 요소 추가
			v.add(dto.getName());
			v.add(dto.getKor() + ""); //Vector의 제너릭이 String이므로 int값을 문자열로 바꾸기
			v.add(dto.getEng() + "");
			v.add(dto.getMath() + "");
			v.add(dto.getTot() + "");
			v.add(String.format("%.2f", dto.getAvg()));
			
			model.addRow(v); //TableModel의 행 값에 벡터 추가
		}//for
	}

	@Override
	public void search(DefaultTableModel model) { //TableModel의 데이터를 가져와서 학번검색
		String hak = JOptionPane.showInputDialog(null, 
				"학번을 입력하세요",
				"검색",
				JOptionPane.QUESTION_MESSAGE);
		if(hak==null || hak.length()==0) return; //취소버튼을 누르거나 입력을 안한거면 함수를 나가라
		//Cancel을 누르면 null값이 들어옴, 값의 길이가 0이면 입력되지 않음
		
		int sw=0; //스위치 변수
		for(ScoreDTO dto : list) {
			if(hak.equals(dto.getHak())) { //입력된 값이 dto에서 꺼낸 값과 같은지
				model.setRowCount(0); //TableModel의 행의 개수를 0으로 초기화
				
				Vector<String> v = new Vector<String>();
				v.add(dto.getHak()); //dto에서 꺼낸 값으로 벡터에 요소 추가
				v.add(dto.getName());
				v.add(dto.getKor() + ""); //Vector의 제너릭이 String이므로 int값을 문자열로 바꾸기
				v.add(dto.getEng() + "");
				v.add(dto.getMath() + "");
				v.add(dto.getTot() + "");
				v.add(String.format("%.2f", dto.getAvg()));
				
				model.addRow(v); //TableModel의 행 값에 벡터 추가
				sw=1;
			}
		}//for
		
		if(sw==0)
			JOptionPane.showMessageDialog(null,  "찾고자 하는 학번이 없습니다");
	}

	@Override
	public void tot_desc() { //총점으로 내림차순
		//파일 안의 내용을 List에 담고 그 데이터를 꺼내서 내림차순(Comparable, Comparator)
		//List 안의 ScoreDTO를 내림차순
		//DB일 경우 : select * from 테이블 order by tot desc;
		
		Comparator<ScoreDTO> com = new Comparator<ScoreDTO>() {
			@Override
			public int compare(ScoreDTO s1, ScoreDTO s2) {
//				오름차순
//				if(s1.getTot() < s2.getTot()) return -1;
//				else if(s1.getTot() > s2.getTot()) return 1;
//				else return 0;
				
				//내림차순
				return s1.getTot() < s2.getTot() ? 1 : -1;
			}
		};
		
		Collections.sort(list, com); //Comparator로 정렬
	}

	@Override
	public void save() { //파일저장
		JFileChooser chooser = new JFileChooser(); 
		int result = chooser.showSaveDialog(null); 
		
		File file = null;
		if(result ==JFileChooser.APPROVE_OPTION) { //확인버튼이 눌림
			file = chooser.getSelectedFile();
		}
		//--------------------
		if(file == null) return; //Dialog에서 Cancel 누르면 null값이 들어옴. 함수를 나가라
		
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		
			//두번째 방법 - ArrayList에 담겨있는 ScoreDTO의 개수를 저장
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
	public void load() { //파일읽기
		JFileChooser chooser = new JFileChooser();
		int result = chooser.showOpenDialog(null);
		
		File file = null;
		if(result == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile(); //파일 선택
		}
		//-----------------------
		if(file == null) return; //file이 null이면 함수를 나가라
		
		list.clear(); //append처럼 데이터값이 들러붙는 거 방지
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			
//			첫번재 방법
//			while(true) {
//				try {
//					ScoreDTO dto = (ScoreDTO)ois.readObject();
//					list.add(dto);
//					
//				}catch(EOFException e) { //에러 발생시 에러만 잡고 while문 나가라
//					break;
//				}//end of file 에러: 더이상 읽을 거리가 없으면 에러남 (컴파일이 아니라 실행할 때)
//				
//			}//while
			
			//두번째 방법 - 파일에서 ScoreDTO의 개수가 몇개인지 먼저 읽는다
			int size = ois.readInt();
			for(int i=0; i<size; i++) { //read할 때는 확장형 for문 못 씀, 출력할 때만 사용가능
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
//객체들은 덩치가 커서 데이터 자체가 넘어오는 게 아니라 주소값이 넘어옴 model도 주소값이 넘어온 것임
//객체는 IOStream을 타고 못 감, 객체를 byte[]로 쪼개서 직렬화해야한다
//자바가 제공하는 메소드 Override는 throws가 안된다



















