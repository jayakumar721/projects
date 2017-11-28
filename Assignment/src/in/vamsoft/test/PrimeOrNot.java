package in.vamsoft.test;

import java.util.Scanner;

public class PrimeOrNot {

  public static void main(String[] args) {
   int flag=0;
   System.out.println("Enter the number:");
 
  @SuppressWarnings("resource")
  Scanner sc = new Scanner(System.in);
   int a = sc.nextInt();
   for(int i=2;i<=a/2;i++) {
     if(a%i==0) {
       flag=1;
     }
   }
   if(flag==0) {
     System.out.println("prime");
   } else {
     System.out.println("not prime");
   }
   
  }

}
