package abstract_;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberMain {

	public static void main(String[] args) {
		//3�ڸ����� , ��� �Ҽ� ���� 3°�ڸ����� �ݿø��Ͽ� ����
		//NumberFormat nf = new NumberFormat(); //�߻�޼ҵ��̱� ������ new�� �޸𸮿� �������� ����
		NumberFormat nf  = new DecimalFormat(); //�ڽ�Ŭ������ �̿�
		System.out.println(nf.format(12345678.456789));
		System.out.println(nf.format(12345678));
		System.out.println();
		
		//��ȿ���ڰ� �ƴ� ���� ǥ������ ����. Java�� Excel�� #,###���� ���� ǥ��, Oracle�� 9,999�� ǥ�� (���� ����)
		NumberFormat nf2  = new DecimalFormat("#,###.##��"); 
		System.out.println(nf2.format(12345678.456789));
		System.out.println(nf2.format(12345678));
		System.out.println();
		
		//������ 0�� ǥ��
		NumberFormat nf3  = new DecimalFormat("#,###.00��"); 
		System.out.println(nf3.format(12345678.456789));
		System.out.println(nf3.format(12345678));
		System.out.println();
		
		//----------------------------------------------------------------------
		
		//�߻�Ŭ������ �޼ҵ带 �̿��Ͽ� ����
		//NumberFormat Ŭ������ getInstance()�޼ҵ�� static NumberFormat Ŭ������ ��������
		//NumberFormat nf4 = NumberFormat.getInstance();
		NumberFormat nf4 = NumberFormat.getCurrencyInstance();
		System.out.println(nf4.format(12345678.456789));
		System.out.println(nf4.format(12345678));
		System.out.println();
		
		NumberFormat nf5 = NumberFormat.getInstance();
		nf5.setMaximumFractionDigits(2); //�Ҽ� ���� 2° �ڸ�
		nf5.setMinimumFractionDigits(2); //������ 0�� ǥ��
		System.out.println(nf5.format(12345678.456789));
		System.out.println(nf5.format(12345678));
		System.out.println();
		
		//NumberFormat nf6 = NumberFormat.getInstance();
		NumberFormat nf6 = NumberFormat.getCurrencyInstance(Locale.US);
		nf5.setMaximumFractionDigits(2); //�Ҽ� ���� 2° �ڸ�
		nf5.setMinimumFractionDigits(2); //������ 0�� ǥ��
		System.out.println(nf6.format(12345678.456789));
		System.out.println(nf6.format(12345678));
		System.out.println();
	}

}

/*
public abstract class NumberFormat extends Format

java.lang.Object
	java.text.Format
		java.text.NumberFormat
		
NumberFormat Ŭ������ Subclasses: ChoiceFormat, DecimalFormat

---------------------------------------------------------
[������]
12,345,678.457
12,345,678

12,345,678.46��
12,345,678��

12,345,678.46��
12,345,678.00��

12,345,678.46��
12,345,678.00��


*/