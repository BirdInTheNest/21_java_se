package com.zoo.safari;

import com.zoo.Zoo;

public class Safari extends Zoo {

	public static void main(String[] args) {
		Zoo z = new Zoo();
		z.tiger();
		//z.giraffe(); protected�� ���� ��Ű�� ���� ����, �ٸ� ��Ű���� �ڽ�Ŭ���� ���ٰ���������
		//�θ� �����ϰ� �θ��� �ּҰ��� �����Ͽ�, Safari()�� �ڽ����� �𸣱� ������ ���� �Ұ��� �ߴ� ����  
		
		//z.elephant();
		//z.lion();
		System.out.println("-----------");
		
		Safari s = new Safari(); //�ڽ� �����ϰ� �ڽ��� �ּҰ��� �����Ͽ��� ������
		s.tiger();
		s.giraffe(); //Safari()�� �ڽ��̶�� �� �˾Ƽ� ���� ����
		//s.elephant();
		//s.lion();
	}
}
