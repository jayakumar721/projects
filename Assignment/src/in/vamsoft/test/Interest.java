package in.vamsoft.test;

import java.util.Scanner;

public class Interest extends SimpleInterest {


public Interest(double p, int rate, int n) {
    super(p, rate, n);
  }

public static void main(String[] args) {
  System.out.println("Enter the principal amount:");
  @SuppressWarnings("resource")
  Scanner scanner = new Scanner(System.in);
  double p=scanner.nextDouble();
  System.out.println("Enter the rate of intrest in %:");
  int rate = scanner.nextInt();
  System.out.println("period:");
  int n=scanner.nextInt();
  @SuppressWarnings("unused")
  Interest interest = new Interest(p, rate, n);
}

  
  
}
