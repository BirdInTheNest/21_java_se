/*
Ŭ������ new�����ڷ� �����ϸ� �޸� heap������ ����� �ּҰ��� ���´�
Ŭ������ ���� �繰�� �Ӽ�(������)�� ���(�޼ҵ�)�� ������ �޴����̴�
Ŭ������ 1�κ� ����(���� ���� ����)�� �����ؾ��Ѵ�
���� ������ �ִ� �����͸� private���� ĸ��ȭ�ϰ� ����� (�ܺο��� �����Ϳ� ���� �Ұ����ϰ� ��)
-> �޼ҵ带 ������ ������ �����ʹ� setter�� ��� �޾��ְ� getter�� ��� ������

Ŭ������ ��Ģ (SOLID)
 */

/*
[������]
----------------------------------------------------
�̸�      ����      ����      ����      ����      ���      ����
----------------------------------------------------
ȫ�浿     90       96      100
���̾�     100      90      75
����ġ     75       80      48
----------------------------------------------------
 */
package basic;

public class SungJukMain {

	public static void main(String[] args) { //1�κо� Ŭ���� ������ ������ ��
		SungJuk[] ar = new SungJuk[3]; //��ü �迭(��ü�� �� ��) 3�� ����(Ŭ���� ����x)
		for(int i=0; i<ar.length; i++) {
			ar[i] = new SungJuk(); //Ŭ���� ����
		}
		
		ar[0].setData("ȫ�浿",90,96,100); //ȣ��
		ar[1].setData("���̾�",100,89,75); //������ �����Ͱ��� �� �ٸ��⶧���� for�� ������ ����
		ar[2].setData("����ġ",75,80,48);
		
		System.out.println("�̸�\t����\t����\t����\t����\t���\t����");
		for(SungJuk s : ar) { //�渶�� Ŭ������ �� �ֱ� ������ Ŭ������ �����Ͱ��� �������
			s.calcTot(); 
			s.calcAvg();
			s.calcGrade();
			System.out.println(s.getName()+"\t"
							+ s.getKor()+"\t"
							+ s.getEng()+"\t"
							+ s.getMath()+"\t"
							+ s.getTot()+"\t"
							+ s.getAvg()+"\t"
							+ s.getGrade());
		}//for
	}     
}

/*
[������]
�̸�	����	����	����	����	���	����
ȫ�浿	90	96	100	286	95.33	A
���̾�	100	89	75	264	88.00	B
����ġ	75	80	48	203	67.67	D
 */

		/*
		//1�κо� Ŭ���� ������ ������ ��
		SungJuk aa = new SungJuk();
		SungJuk bb = new SungJuk();
		SungJuk cc = new SungJuk();
		
		aa.setData("ȫ�浿",90,96,100); //���� �����͸� ����ִ� ȣ���, ������ �߿�
		aa.calcTot(); //������ �����Ͱ��� �� �ٸ��⶧���� for�� ������ ����
		aa.calcAvg();
		aa.calcGrade();
		System.out.println(aa.getName()+"\t"
						+ aa.getKor()+"\t"
						+ aa.getEng()+"\t"
						+ aa.getMath()+"\t"
						+ aa.getTot()+"\t"
						+ aa.getAvg()+"\t"
						+ aa.getGrade());
						
		bb.setData("���̾�",100,89,75); 
		bb.calcTot(); 
		bb.calcAvg();
		bb.calcGrade();
		System.out.println(bb.getName()+"\t"
						+ bb.getKor()+"\t"
						+ bb.getEng()+"\t"
						+ bb.getMath()+"\t"
						+ bb.getTot()+"\t"
						+ bb.getAvg()+"\t"
						+ bb.getGrade());
						
		cc.setData("����ġ",75,80,48); 
		cc.calcTot(); 
		cc.calcAvg();
		cc.calcGrade();
		System.out.println(cc.getName()+"\t"
						+ cc.getKor()+"\t"
						+ cc.getEng()+"\t"
						+ cc.getMath()+"\t"
						+ cc.getTot()+"\t"
						+ cc.getAvg()+"\t"
						+ cc.getGrade());
		*/	













