/*
★ 다중 for
for(int a=~~~){
      for(int b=~~~){
      }//for b
}//for a

1. for문안에 또 다른 for문이 존재
2. 서로의 변수명은 달라야 한다.
3. 겹쳐서도 안된다.
 */

package multiFor_;

public class MultiFor {

	public static void main(String[] args) {
		int i, j;
		
		for(i=2; i<=4; i+=2) { //i=2, i=4 2번 반복
			
			for(j=1; j<=3; j++) { //j=1, j=2, j=3 3번 반복
				System.out.println("i="+i+" j="+j);
			}//for j
			
			System.out.println();
			
		}//for i
	}
}

/*
[실행결과]
i=2 j=1
i=2 j=2
i=2 j=3

i=4 j=1
i=4 j=2
i=4 j=3
*/