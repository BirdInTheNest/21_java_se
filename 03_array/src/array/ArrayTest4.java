/*
65~90 ������ ������ 100�� �߻��Ͽ� ���ڷ� ����Ͻÿ�
- 1�ٿ� 10���� ����Ͻÿ�
- �� ���ڸ��� ��� ��µǾ����� ������ ����Ͻÿ�

[������]
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

A�� ���� = 6	B�� ���� = 4	C�� ���� = 2	
D�� ���� = 7	E�� ���� = 3	F�� ���� = 5	
G�� ���� = 0	H�� ���� = 5	I�� ���� = 4	
J�� ���� = 4	K�� ���� = 2	L�� ���� = 3	
M�� ���� = 2	N�� ���� = 4	O�� ���� = 5	
P�� ���� = 7	Q�� ���� = 4	R�� ���� = 2	
S�� ���� = 5	T�� ���� = 2	U�� ���� = 12	
V�� ���� = 1	W�� ���� = 2	X�� ���� = 4	
Y�� ���� = 1	Z�� ���� = 4
 */

package array;

public class ArrayTest4 {

	public static void main(String[] args) {
		int[] ar = new int[100]; //�� 100���� ������ �迭 ar ���� - 100�� ����
		int[] count = new int[26]; //�� 26���� ������ �迭 count ���� - A~Z

		for(int i=0; i<ar.length; i++) { //ar[i] i=0~99, �迭 ũ�⸸ŭ �ݺ�(100��)
			ar[i] = (int)(Math.random()*26) +65; //65~90 ������ ���� �߻� (A~Z)
			
			for(int j=0; j<count.length; j++) { //count[j] j=0~25, �迭 ũ�⸸ŭ �ݺ�(26��)
				//if(ar[i] == 'A') countA++; //count[j] j=0(A)~25(Z)
				if(ar[i]==(j+65)) count[j]++; //
			}//for j
		}//for i
		
		//���
		for(int i=0; i<ar.length; i++) {
			System.out.print((char)ar[i]+" ");
			if((i+1)%10==0) System.out.println(); //1�ٿ� 10���� ����Ͻÿ�, for���� �ݺ��� Ƚ�� i+1
		}//for
		System.out.println();
		
		for(int i=0; i<count.length; i++) {
			System.out.print((char)(i+65)+"�� ���� = "+count[i]+"\t");
			if((i+1)%3==0) System.out.println(); 
		}//for
	}
}

/*
count=0; //�ʱⰪ
count++; //1 2 3 4 5.. for���� �ݺ��� Ƚ��

for���� �ݺ��� Ƚ���� �̿��Ͽ� 1�ٿ� n���� ����� �� �ִ�.
---------------------------------------
ar[i]���� i�� 0 1 2 3 4...
i+1 = for���� �ݺ��� Ƚ�� 
for���� �ݺ��� Ƚ���� �̿��Ͽ� 1�ٿ� n���� ����� �� �ִ�.
 */

/*
int countA=0, countB=0, ..... countZ=0; //�ʱⰪ

if(ar[0] == 'A') countA++; //ar[0] �����Ͱ��� 'A'�̸� countA++; //1 2 3.. 
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

��������������������������������������������������������

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




