package multiArray;

public class MultiArray {

	public static void main(String[] args) {
		int[][] ar = {{10, 20}, {30, 40}, {50, 60}}; //3행 2열 - 고정길이
		
		System.out.println("배열명 ar = "+ar); //행의 주소는 ar이 가지고 있고,
		System.out.println();
		
		System.out.println("행 ar[0] = "+ar[0]); //열의 주소는 행 ar[i]이 가지고 있음
		System.out.println("행 ar[1] = "+ar[1]);
		System.out.println("행 ar[2] = "+ar[2]);
		System.out.println();
		
		for(int i=0; i<ar.length; i++) {
			for(int j=0; j<ar[i].length; j++) {
				System.out.println("ar["+i+"]["+j+"] = "+ar[i][j]);
			}//for j
			System.out.println();
		}//for i
	}
}

/*
[실행결과]
배열명 ar = [[I@123a439b

행 ar[0] = [I@7de26db8
행 ar[1] = [I@1175e2db
행 ar[2] = [I@36aa7bc2

ar[0][0] = 10
ar[0][1] = 20

ar[1][0] = 30
ar[1][1] = 40

ar[2][0] = 50
ar[2][1] = 60
*/