/*
x=320, y=258로 합, 차, 곱, 몫을 구하시오

[실행결과]
x     y      sum   sub    mul    div
320   258    xxx
236   125
539   327
 */
package basic;

public class ComputeMain {

   public static void main(String[] args) {
      Compute aa = new Compute(); //생성
      aa.setX(320);
      aa.setY(258);
      
      aa.calc();
      
      System.out.println("X\tY\tSum\tSub\tMul\tDiv");
      System.out.println(aa.getX() + "\t"
                   + aa.getY() + "\t"
                   + aa.getSum() + "\t"
                   + aa.getSub() + "\t"
                   + aa.getMul() + "\t"
                   + String.format("%.2f", aa.getDiv()));   
   }
}

/*
int a, b, c; //변수
int[] ar = new int[3]; //배열

Compute aa, bb, cc; //객체
Compute[] ar = new Compute[3]; //객체 배열
 */

/*
[실행결과]
X	Y	Sum	Sub	Mul	Div
320	258	578	62	82560	1.24
 */
