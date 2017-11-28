package in.vamsoft.bank;

import java.util.Scanner;

public class Factorial {
  
  public static void main(String[] args) {
    try {
      System.out.println("Enter a number");
      @SuppressWarnings("resource")
      Scanner sc = new Scanner(System.in);
      int a = sc.nextInt();
      if(a<0) {
        throw new MyException("Negative value");
      } else {
        for (int i=1;i<=a;i++) {
          a=a*i;
        }
        System.out.println(a);
      }
    } catch (MyException e) {
        System.out.println(e.getMessage());
    }
  }

}
