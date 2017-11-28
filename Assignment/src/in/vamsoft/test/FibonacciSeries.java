package in.vamsoft.test;

import java.util.Scanner;

public class FibonacciSeries {
  public static void main(String[] args) {
    System.out.println("Enter the number:");
    @SuppressWarnings("resource")
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    int f1=0;
    int f2=1;
    int sum=0;
    for(int i = 0;i <= num; i++) {
      System.out.println(f1);
      sum = f1+f2;
      f1=f2;
      f2=sum;
    }
  }

}
