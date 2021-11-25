package collection;

import java.util.Stack;
import static java.lang.System.out;

public class StackMain { //Stack은 push로 넣고 pop으로 꺼내고

	public static void main(String[] args) {
		String[] groupA = {"우즈베키스탄", "쿠웨이트", "사우디", "대한민국"};
		Stack<String> stack = new Stack<String>();
		
		for(int i=0; i<groupA.length; i++)
			stack.push(groupA[i]);
		
		while( ! stack.isEmpty() ) //stack.isEmpty() F -> !이면 T
			out.println( stack.pop() ); //꺼내라
	}
}