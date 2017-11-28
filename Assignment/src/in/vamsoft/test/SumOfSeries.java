package in.vamsoft.test;

import java.util.Scanner;

public class SumOfSeries {

  @SuppressWarnings("resource")
  public static void main(String[] args) {
    
    System.out.println("Enter the series size");
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    System.out.println("Enter the value");
    int x = scanner.nextInt();
    double sum=1;
    int fact=1;
    for(int i=1;i<=n;i++) {
      fact = fact*i;
      sum = sum + Math.pow(x, i)/fact;
      
    }
    System.out.println(sum);
  }
  public static int fact(int a) {
    for(int i=1;i<=a;i++) {
      a=a*i;
    }
    return a;
    
  }
}
