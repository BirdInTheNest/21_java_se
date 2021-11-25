package collection;

import java.util.LinkedList;
import static java.lang.System.out;

public class QueueMain { //Queue는 offer로 넣고 poll로 꺼내고

	public static void main(String[] args) {
		String[] item = {"소나타", "렉스톤", "제규어"};
		LinkedList<String> q = new LinkedList<String>();
		
		for(String n : item)
			q.offer(n); //요소 추가
		
		out.println("q의 크기 : "+q.size()+"\n");
		
		String data = "";
		
		while((data=q.poll()) != null) { //(data=q.poll()) 꺼내온 데이터가 있을 때
			out.println(data+" 삭제!");
			out.println("q의 크기 : "+q.size()+"\n");
		}//while
	}
}