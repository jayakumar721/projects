package in.vamsoft.test;

import java.util.Scanner;

public class FloydsTriangle {

  @SuppressWarnings("resource")
  public static void main(String[] args) {
    System.out.println("Enter the number:");
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(i + "\t");
      }
      System.out.println();
    }
    System.out.println();
    System.out.println();
    int count = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(count + "\t");
        count++;
      }
      System.out.println();
    }
    System.out.println();
    System.out.println();
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= i; j++) {
        System.out.print(count % 2 + "\t");
        count++;
      }
      System.out.println();
    }

  }

}
