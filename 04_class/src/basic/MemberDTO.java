package basic;

public class MemberDTO { //Data Transfer Object, Value object 1�κ� ������ ����
   private String name; 
   private int age;
   private String phone;
   private String address;
   
   public void setName(String name) { //setter: �ܺηκ��� �����͸� �޾Ƽ� Ŭ������ private�� ����
      this.name = name; //�ܺηκ��� name�� �޾� this.name(�� Ŭ������ name)�� �ִ´�
   }
   public void setAge(int age) {
      this.age = age;
   }
   public void setPhone(String phone) {
      this.phone = phone;
   }
   public void setAddress(String address) {
      this.address = address;
   }
   
   public String getName() { //getter: private�� �ִ� ���� ������
      return this.name; //�򰥸��� ���� ���� this���� ����
   }
   public int getAge() {
      return age;
   }
   public String getPhone() {
      return phone;
   }
   public String getAddress() {
      return address;
   }
}