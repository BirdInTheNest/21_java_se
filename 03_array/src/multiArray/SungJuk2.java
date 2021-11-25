/*
�ο����� �Է��Ͽ� �ο�����ŭ �����͸� �Է¹ް� ������ ����� ���Ͻÿ�
����� �Ҽ����� 2°�ڸ����� ���

[������]
�ο��� �Է� : 2 (cnt)

�̸��Է� : ȫ�浿 (name)
����� �Է� : 2   (subjectCnt)
����� �Է� : ���� (subject)
����� �Է� : ����
���� ���� �Է� : 95 (jumsu)
���� ���� �Է� : 100
----------------------
�̸��Է� : �̱��� (name)
����� �Է� : 3   (subjectCnt)
����� �Է� : ���� (subject)
����� �Է� : ����
����� �Է� : �ڹ�
���� ���� �Է� : 95 (jumsu)
���� ���� �Է� : 100
�ڹ� ���� �Է� : 100

�̸�		����	����	����	���
ȫ�浿    95	100	xxx	xx.xx

�̸�		����  ����	�ڹ�	����	���
�̱���	95	100	100	xxx	xx.xx
 */

package multiArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SungJuk2 {

	public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 System.out.print("�ο��� �Է� : ");
		 int cnt = Integer.parseInt(br.readLine()); //�ο���
		 
		 String[] name = new String [cnt]; //�ο����� 2���̸� �̸��� 2��
		 int subjectCnt; //�����
		 String[][] subject = new String[cnt][]; //��������
		 int[][] jumsu = new int[cnt][];
		 double[] avg = new double[cnt];
		 
		 //�Է�, ó��
		 for(int i=0; i<cnt; i++) { //�ο��� ��ŭ �ݺ�
			 System.out.print("�̸��Է� : ");
			 name[i] = br.readLine();
			 
			 System.out.print("����� �Է� : ");
			 subjectCnt = Integer.parseInt(br.readLine());
			 
			 subject[i] = new String[subjectCnt]; //�޸𸮿� ����
			 for(int j=0; j<subjectCnt; j++) {
				 System.out.print("����� �Է� : ");
				 subject[i][j] = br.readLine();
			 }//for j
			 
			 jumsu[i] = new int[subjectCnt+1]; //����� + ���� ; ���� int���̴ϱ� ���� ����
			 for(int j=0; j<subjectCnt; j++) { 
				 System.out.print(subject[i][j]+"���� �Է� : ");
				 jumsu[i][j] = Integer.parseInt(br.readLine());
				 
				 jumsu[i][subjectCnt] += jumsu[i][j]; //���� //������ ���� ������� ���� (�ܸӸ�)
			 }//for j
			 
			 avg[i] = (double)jumsu[i][subjectCnt] / subjectCnt; //���=����/�����
			 
		 }//for i
		 
		 //���
		 for(int i=0; i<cnt; i++) { //�ο��� ��ŭ �ݺ�
			 //Ÿ��Ʋ
			 System.out.print("�̸�\t");
			 for(int j=0; j<subject[i].length; j++) {
				 System.out.print(subject[i][j]+"\t");
			 }// for j
			 System.out.println("����\t���");
			 
			 //������
			 System.out.print(name[i]+"\t");
			 for(int j=0; j<jumsu[i].length; j++) { //�����, ����
				 System.out.print(jumsu[i][j]+"\t");
			 }
			 System.out.println(String.format("%.2f", avg[i])); //����� �Ҽ����� 2°�ڸ����� ���
			 System.out.println();
	 
		 }//for i
	}
}

/*
[������]
�ο��� �Է� : 2
�̸��Է� : ȫ�浿
����� �Է� : 2
����� �Է� : ����
����� �Է� : ����
�������� �Է� : 95
�������� �Է� : 100
�̸��Է� : �̱���
����� �Է� : 3
����� �Է� : ����
����� �Է� : ����
����� �Է� : �ڹ�
�������� �Է� : 95
�������� �Է� : 100
�ڹ����� �Է� : 100
�̸�	����	����	����	���
ȫ�浿	95	100	195	97.50

�̸�	����	����	�ڹ�	����	���
�̱���	95	100	100	295	98.33
 */
