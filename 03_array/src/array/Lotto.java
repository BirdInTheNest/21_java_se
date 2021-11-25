/*
로또 - 자동
1~45사이의 난수를 6개 발생하시오
- 중복된 숫자 없어야 한다.
- 오름차순
- 5줄씩 끊어서 출력

[실행결과]
 7 12 25 36 37 42
 
첫번째 결과가 잘 나오면 두번째로 수정하시오

돈 입력 : 7000

    9   10   14   19   22   30
    1   17   21   31   34   36
   10   20   22   27   33   39
   20   23   28   31   36   38
    1   11   12   26   27   31

   11   13   20   33   37   40
    5   15   17   23   35   38
 */

package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Lotto {

   public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int[] lotto = new int[6];
      int money;
      
      System.out.print("돈 입력 : ");
      money = Integer.parseInt(br.readLine());
      
      for(int k=1; k<=money/1000; k++) { //1000원에 한줄 출력하므로, 돈 낸만큼 반복
         for(int i=0; i<lotto.length; i++) {
            lotto[i] = (int)(Math.random()*45) + 1; //난수 발생 (1~45)
            
            //중복 비교
            for(int j=0; j<i; j++){
               if(lotto[i] == lotto[j]) {
                  i--; //for i로 다시 가서 i++하고 lotto[i]를 생성하기 때문에 i--필요(원상복귀)
                  break; //for j를 벗어나라 > for i로 가서 다시 난수 발생
               }
            }//for j
         }//for i
      
         /*
         //정렬
         int temp;
         for(int i=0; i<lotto.length-1; i++) {
            for(int j=i+1; j<lotto.length; j++) {
               if(lotto[i] > lotto[j]) {
                  temp = lotto[i];
                  lotto[i] =  lotto[j];
                  lotto[j] = temp;
               }
            }
         }
         */
         Arrays.sort(lotto); //static이라서 클래스명으로 바로 사용할 수 있음 (java.util.Arrays)
      
         //출력
         for(int data : lotto){
            System.out.print(String.format("%5d", data));
         }
         System.out.println();
         
         if(k%5==0) System.out.println(); //for k문 반복횟수를 이용하여 1줄에 5개 띄어쓰기 가능
      }//for k
   }
}

/*
숫자 중복확인 (그 전에 뽑은 숫자 중에 같은 숫자가 있는지 비교)
lotto[0]   lotto[1]==lotto[0]   lotto[2]==lotto[0]   lotto[3]==lotto[0]   ...
										  lotto[1]			   lotto[1]   ...
										  					   lotto[2]   ...
for(int i=0; i<lotto.length; i++){
	for(int j=0; j<i; j++){

	}
}
*/

/*
[실행결과]
돈 입력 : 7000
    5   31   38   39   44   45
   11   12   19   34   37   42
    5    9   11   23   32   34
    5    6    8   24   33   36
   11   15   16   17   22   24

    9   16   17   23   37   39
   11   15   22   24   30   40
 */





