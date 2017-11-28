package in.vamsoft.test;

public class Multiplication {
  
  public static void main(String[] args) {
    try {
      int a = Integer.parseInt(args[0]);
      for(int i=1;i<=10;i++) {
        System.out.println(a + "*" + i + "=" + a*i);
      }
    }catch (NumberFormatException e) {
      System.out.println(e);
    }
  }

}
