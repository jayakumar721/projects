package in.vamsoft.test;

import java.util.Scanner;

public class MatricMul {

  @SuppressWarnings("resource")
  public static void main(String[] args) {
    int[][] a = new int[10][10];
    int[][] b = new int[10][10];
    System.out.println("Enter the size of the matrix");
    Scanner scanner = new Scanner(System.in);
    int size = scanner.nextInt();
    int i;
    int j;
    int k;
    System.out.println("enter the elements in matrix 1");
    for (i = 0; i < size; i++) {
      for (j = 0; j < size; j++) {
        a[i][j] = scanner.nextInt();
      }
    }

    System.out.println("enter the elements in matrix 2");
    for (i = 0; i < size; i++) {
      for (j = 0; j < size; j++) {
        b[i][j] = scanner.nextInt();
      }
    }
    int sum = 0;
    int[][] c = new int[10][10];
    for (i = 0; i < size; i++) {
      for (j = 0; j < size; j++) {
        for (k = 0; k < size; k++) {
          sum = sum + a[i][k] * b[k][j];
        }
        c[i][j] = sum;
        sum=0;
      }
    }
    System.out.println("Matrix multiplication");
    for (i = 0; i < size; i++) {
      for (j = 0; j < size; j++) {
        System.out.print(c[i][j] + "\t");
      }
      System.out.println();
    }
  }

}
