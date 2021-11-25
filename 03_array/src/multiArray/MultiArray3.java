/*
[실행결과] 
 1   2   3   0
 4   5   6   0
 7   8   9   0
 0   0   0   0
 */

package multiArray;

public class MultiArray3 {

	public static void main(String[] args) {
		int[][] ar = {{1,2,3,0}, {4,5,6,0}, {7,8,9,0}, {0,0,0,0}};
		
		//합
		for(int i=0; i<ar.length-1; i++) {
			for(int j=0; j<ar[i].length-1; j++) {
				ar[i][3] += ar[i][j];
				ar[3][i] += ar[j][i]; //ar[3][j] += ar[i][j];
				ar[3][3] += ar[i][j];
			}//for j
		}//for i
		
		//출력
		for(int i=0; i<ar.length; i++) {
			for(int j=0; j<ar[i].length; j++){
				System.out.print(String.format("%4d", ar[i][j]));
			}//for j
			System.out.println();
		}//for i
	}
}

/*
ar[0][3] += ar[0][0]  1
			ar[0][1]  2
			ar[0][2]  3

ar[1][3] += ar[1][0]  4
			ar[1][1]  5
			ar[1][2]  6
			
ar[2][3] += ar[2][0]  7
			ar[2][1]  8
			ar[2][2]  9
*/

/*
ar[3][0] += ar[0][0]  1
			ar[1][0]  4
			ar[2][0]  7

ar[3][1] += ar[0][1]  2
			ar[1][1]  5
			ar[2][1]  8
			
...
			
ar[3][i] += ar[j][i]
---------------------------
ar[3][0] += ar[0][0]  1
ar[3][1] += ar[0][1]  2
ar[3][2] += ar[0][2]  3

ar[3][0] += ar[1][0]  4
ar[3][1] += ar[1][1]  5
ar[3][2] += ar[1][2]  6

...
			
ar[3][j] += ar[i][j]
*/

/*
 [실행결과]
   1   2   3   6
   4   5   6  15
   7   8   9  24
  12  15  18  45
 */







