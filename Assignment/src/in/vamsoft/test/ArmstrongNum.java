package in.vamsoft.test;

import java.util.Scanner;

public class ArmstrongNum {

  public static void main(String[] args) {
    System.out.println("Enter a number:");
    @SuppressWarnings("resource")
    Scanner scanner = new Scanner(System.in);
    int num = scanner.nextInt();
    int temp;
    int remainder;
    int sum = 0;
    System.out.println("Armstrong numbers");
    for (int i = 1; i <= num; i++) {
      temp = i;
      while (temp >0) {
        remainder = temp % 10;
        sum = sum + (remainder * remainder * remainder);
        temp = temp / 10;

      }
      if (i == sum) {
        System.out.println(sum);
      }
      sum=0;
    }

  }

}
