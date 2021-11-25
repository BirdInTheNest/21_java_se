class CompTest5 {
   public static void main(String[] args) {
      int num1=0, num2=0; //num1=0, num2=0   
      boolean result;
      
      result = ( (num1+=10) < 0 && (num2+=10) > 0 ); //False
	  //1. (num1+=10) -> num1=10
	  //2. (num1+=10) < 0 -> False
	  //3. False && -> 뒤의 값 수행 안함
		
      System.out.println("result = " + result); //False 
      System.out.println("num1 = " + num1 + " num2 = " + num2); //num1=10, num2=0
      System.out.println();
      
      result = ( (num1+=10) > 0 || (num2+=10) > 0 ); //True
	  //1. (num1+=10) -> num1=20
	  //2. (num1+=10) > 0 -> True
	  //3. True || -> 뒤의 값 수행 안함
		
      System.out.println("result = " + result); //True
      System.out.println("num1 = " + num1 + " num2 = " + num2); //num1=20, num2=0
   }
}

/*
[실행결과]
D:\java_se\workspace\0722>javac CompTest5.java

D:\java_se\workspace\0722>java CompTest5
result = false
num1 = 10 num2 = 0

result = true
num1 = 20 num2 = 0
*/