package basic;

class Person { //Ŭ������ ���� �޴�����. new�� ��ü�� �����ؾ� ��
	private String name; //private�� �ڽ��� Ŭ���� �ȿ����� ���� ���
	private int age;
	
	public void setName(String n) { //setter �����͸� �޴� �޼ҵ� ����
		name = n;
	}
	
	public void setAge(int a) {
		age = a;
	}
		
	public void setData(String n, int a) {
		name = n;
		age = a;
	}
	
	public void setData() {} //�ʵ�(Ŭ���� �ȿ� ����), �ʱ�ȭ�� ������ ����
		
	public String getName(){ //getter �����͸� ������ �޼ҵ� ����
		return name;
	}
	
	public int getAge(){
		return age;
	}
}
//------------
public class PersonMain {

	public static void main(String[] args) {
		Person p = new Person(); //��ü ����
		System.out.println("��ü p = "+p); //toString() ��������
		System.out.println("��ü p = "+p.toString());
		p.setName("ȫ�浿"); //ȣ��	
		p.setAge(25);
		System.out.println("�̸�="+p.getName()+"\t����="+p.getAge());
		System.out.println();
		
		Person p2 = new Person(); //��ü ����
		System.out.println("��ü p2 = "+p2);
		p2.setName("�ڳ�"); //ȣ��
		p2.setAge(13);
		System.out.println("�̸�="+p2.getName()+"\t����="+p2.getAge());	
		System.out.println();
		
		Person p3 = new Person();
		p3.setData("���̾�", 35);
		System.out.println("�̸�="+p3.getName()+"\t����="+p3.getAge());
		System.out.println();
		
		Person p4 = new Person();
		p4.setData();
		System.out.println("�̸�="+p4.getName()+"\t����="+p4.getAge());
		System.out.println();
	}
}

/*
Ŭ������ new��� �����ڸ� �̿��ؼ� �����ϸ� �޸� heap�� �Ҵ�ȴ�
heap������ �Ҵ�� ���� �̸��� ����, �ּ�(Ŭ������@16����)�� ���´�. (���� �޸� �ּҰ� �ƴ� ��������)

�޼ҵ�() - ��ɾ���� ���� (�޼ҵ� �ȿ����� ��ɾ� ��� ��)

�Լ�() �ȿ� �ִ� ������ �Ű�����, �μ���� �θ�

�� Overload �޼ҵ� Overloading (�ֵ���)
�ϳ��� Ŭ�����ȿ��� �Ȱ��� �̸��� �޼ҵ尡 2���̻� ���� �� ��
�μ�(�Ű�����) ���� Ʋ���ų� 
�μ�(�Ű�����) ������ Ʋ�� ���
 */

/*
[������]
��ü p = basic.Person@7de26db8
��ü p = basic.Person@7de26db8
�̸�=ȫ�浿	����=25

��ü p2 = basic.Person@1175e2db
�̸�=�ڳ�	����=13

�̸�=���̾�	����=35

�̸�=null	����=0
*/
