package in.vamsoft.training;

import java.util.Scanner;

public class ExceptionDemo {
  /**
   * @param args .
   */
  public static void main(String[] args) {
    
    try {
      Scanner sc = new  Scanner(System.in);
      System.out.println("Enter the values");
      int numerator = sc.nextInt();
      int denominator = sc.nextInt();
      int result = numerator / denominator;
      System.out.println("the result is : " + result);
      sc.close();
    } catch (Exception e) {
      System.out.println("Divide by zero not possible :" + e.getMessage());
    }
   
  }

}
