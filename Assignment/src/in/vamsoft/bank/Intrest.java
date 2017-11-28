package in.vamsoft.bank;

import java.util.Scanner;

public class Intrest {
  

public static void main(String[] args) {
 
  try {
    
  System.out.println("Enter the principal amount:");
  @SuppressWarnings("resource")
  Scanner scanner = new Scanner(System.in);
  double p=scanner.nextDouble();
  System.out.println("Enter the rate of intrest in %:");
  int rate = scanner.nextInt();
  System.out.println("period:");
  int n=scanner.nextInt();
  if(p<0||rate<0||n<0) {
    throw new MyException("Negative values");
  }
  else {
    System.out.println("The simple intrest is :"+(p+rate+n)/100);
  }
  }catch (MyException e) {
     System.out.println(e.getMessage());
  }
}

}
