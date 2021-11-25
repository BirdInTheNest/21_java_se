/*
65~90 사이의 난수를 100개 발생하여 문자로 출력하시오
- 1줄에 10개씩 출력하시오
- 각 문자마다 몇개씩 출력되었는지 개수를 출력하시오

[실행결과]
E P A M A P Y K D P 
Q H X S O S P Q T U 
K F U D D Z C O F Z 
B J L I X P H O X F 
C Z N U D P U U R V 
S U X H F I Z U L U 
J I M A E Q H H T Q 
S B W A R N O I U W 
P L N U E N F O U B 
D A S J B U D D J A 

A의 개수 = 6	B의 개수 = 4	C의 개수 = 2	
D의 개수 = 7	E의 개수 = 3	F의 개수 = 5	
G의 개수 = 0	H의 개수 = 5	I의 개수 = 4	
J의 개수 = 4	K의 개수 = 2	L의 개수 = 3	
M의 개수 = 2	N의 개수 = 4	O의 개수 = 5	
P의 개수 = 7	Q의 개수 = 4	R의 개수 = 2	
S의 개수 = 5	T의 개수 = 2	U의 개수 = 12	
V의 개수 = 1	W의 개수 = 2	X의 개수 = 4	
Y의 개수 = 1	Z의 개수 = 4
 */

package array;

public class ArrayTest4 {

	public static void main(String[] args) {
		int[] ar = new int[100]; //방 100개인 정수형 배열 ar 생성 - 100개 문자
		int[] count = new int[26]; //방 26개인 정수형 배열 count 생성 - A~Z

		for(int i=0; i<ar.length; i++) { //ar[i] i=0~99, 배열 크기만큼 반복(100번)
			ar[i] = (int)(Math.random()*26) +65; //65~90 사이의 난수 발생 (A~Z)
			
			for(int j=0; j<count.length; j++) { //count[j] j=0~25, 배열 크기만큼 반복(26번)
				//if(ar[i] == 'A') countA++; //count[j] j=0(A)~25(Z)
				if(ar[i]==(j+65)) count[j]++; //
			}//for j
		}//for i
		
		//출력
		for(int i=0; i<ar.length; i++) {
			System.out.print((char)ar[i]+" ");
			if((i+1)%10==0) System.out.println(); //1줄에 10개씩 출력하시오, for문이 반복된 횟수 i+1
		}//for
		System.out.println();
		
		for(int i=0; i<count.length; i++) {
			System.out.print((char)(i+65)+"의 개수 = "+count[i]+"\t");
			if((i+1)%3==0) System.out.println(); 
		}//for
	}
}

/*
count=0; //초기값
count++; //1 2 3 4 5.. for문이 반복된 횟수

for문이 반복된 횟수를 이용하여 1줄에 n개씩 출력할 수 있다.
---------------------------------------
ar[i]에서 i는 0 1 2 3 4...
i+1 = for문이 반복된 횟수 
for문이 반복된 횟수를 이용하여 1줄에 n개씩 출력할 수 있다.
 */

/*
int countA=0, countB=0, ..... countZ=0; //초기값

if(ar[0] == 'A') countA++; //ar[0] 데이터값이 'A'이면 countA++; //1 2 3.. 
if(ar[0] == 'B') countB++;
...
if(ar[0] == 'Z') countZ++;
----------------------------
if(ar[1] == 'A') countA++;
if(ar[1] == 'B') countB++;
...
if(ar[1] == 'Z') countZ++;
----------------------------
.....
----------------------------
if(ar[99] == 'A') countA++;
if(ar[99] == 'B') countB++;
...
if(ar[99] == 'Z') countZ++;

――――――――――――――――――――――――――――

if(ar[0] == 'A') count[0]++; //count[j] j=0(A)~25(Z)
if(ar[0] == 'B') count[1]++;
...
if(ar[0] == 'Z') count[25]++;
----------------------------
if(ar[1] == 'A') count[0]++;
if(ar[1] == 'B') count[1]++;
...
if(ar[1] == 'Z') count[25]++;
----------------------------
.....
----------------------------
if(ar[99] == 'A') count[0]++;
if(ar[99] == 'B') count[1]++;
...
if(ar[99] == 'Z') count[25]++;
 */




