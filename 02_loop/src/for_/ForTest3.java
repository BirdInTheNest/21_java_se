/*
65~90������ ����(A ~ Z)�� 100�� �߻��Ͽ� ����Ͻÿ�
��, 1�ٿ� 10���� �������� �Ͻÿ� 

[������]
H  D  D  R  A  Y  A  K  T  H
C  X  F  Z  B  S  L  Y  Q  D
H  K  O  H  O  B  Z  N  J  T
U  P  A  P  K  Q  G  W  F  A
S  U  D  Z  I  V  J  U  O  G
L  M  Z  L  H  U  Y  D  Q  R
F  T  I  Z  A  W  E  O  F  Z
A  Y  C  I  U  Z  O  B  C  G
H  G  Y  Z  V  P  I  R  L  G
Y  H  R  R  M  H  Y  S  B  P

�� A�� ���� = ??
*/

package for_;

public class ForTest3 {

	public static void main(String[] args) {
		int rand;
		int count=0;
		
		for(int i=1; i<=100; i++) { //100�� �ݺ�
			//(int)(Math.random()* b-a+1) +a; //a~b���� ����
			rand = (int)(Math.random()*26) +65; //65~90������ ����(A ~ Z)
			System.out.print((char)rand+" ");
			
			if(i%10 == 0) System.out.println();	//10�� ����� ���� ���		
			
			if(rand=='A') count++; //rand=='A'�϶����� count++
		}//for
		 
		System.out.println();
		System.out.println("�� A�� ���� = "+count);
	}
}

/*
[������]
Z Y C F H B K J X P 
L Z Y Q Q F B I U X 
B C B D E N U Y Z L 
N D H U J I J H O J 
U T T A E G K S E J 
F O E K E J Z D S D 
S R O A Q S A B W D 
W M C K U I O N E F 
X N A N H P R X Z X 
Q Z T Z M A I W E A 

�� A�� ���� = 6
*/
