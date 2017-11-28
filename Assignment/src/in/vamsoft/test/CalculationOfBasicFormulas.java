package in.vamsoft.test;

import java.util.Scanner;

public class CalculationOfBasicFormulas {

  public static void main(String[] args) {
    System.out.println("Enter the principal amount:");
    @SuppressWarnings("resource")
    Scanner scanner = new Scanner(System.in);
    double p=scanner.nextDouble();
    System.out.println("Enter the rate of intrest in %:");
    int rate = scanner.nextInt();
    System.out.println("period:");
    int n=scanner.nextInt();
    System.out.println("Simple Intrest:");
    double si = (p * rate * n)/100;
    System.out.println("The simple intrest is :"+si);
    double ci = p * Math.pow(1+((rate)/100),n);
    System.out.println("The compound intrest is :"+ci);
    System.out.println("Enter the number for sqrt, square and factorial");
    int sq = scanner.nextInt();
    System.out.println("The square root of "+sq+" is "+Math.sqrt(sq));
    System.out.println("The square of "+sq+" is "+sq*sq);
    int f=1;
    for(int i=1;i<=sq;i++) {
      f=f*i;
    }
    System.out.println("The factorial of "+sq+" is "+f);
    
  }
  
}
