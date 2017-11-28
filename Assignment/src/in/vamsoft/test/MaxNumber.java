package in.vamsoft.test;

import java.util.Scanner;

public class MaxNumber {

  public static void main(String[] args) {
    System.out.println("Enter the size of array");
    @SuppressWarnings("resource")
    Scanner scanner = new Scanner(System.in);
    int size = scanner.nextInt();
    int i;
    int j;
    int temp;
    int[] a = new int[10];
    System.out.println("Enter the elements:");
    for (i = 0; i < size; i++) {
      a[i] = scanner.nextInt();
    }
    for (i = 0; i < size; i++) {
      for (j = i + 1; j < size; j++) {
        if (a[i] > a[j]) {
          temp = a[i];
          a[i] = a[j];
          a[j] = temp;
        }
      }
    }
    System.out.println("maximum number is:" + a[size-1]);
  }
}
