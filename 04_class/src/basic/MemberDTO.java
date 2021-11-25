package basic;

public class MemberDTO { //Data Transfer Object, Value object 1인분 데이터 저장
   private String name; 
   private int age;
   private String phone;
   private String address;
   
   public void setName(String name) { //setter: 외부로부터 데이터를 받아서 클래스의 private에 전달
      this.name = name; //외부로부터 name을 받아 this.name(이 클래스의 name)에 넣는다
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
   
   public String getName() { //getter: private에 있는 값을 내보냄
      return this.name; //헷갈리지 않을 때는 this생략 가능
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