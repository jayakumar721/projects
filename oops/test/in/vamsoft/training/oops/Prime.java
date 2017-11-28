package in.vamsoft.training.oops;

import java.util.Scanner;

public class Prime {

  /**
   * @param args .
   */
  public static void main(String[] args) {
    int in;
    int out;
    int i;
    int f;
    @SuppressWarnings("resource")
    Scanner input = new Scanner(System.in);
    in = input.nextInt();
    @SuppressWarnings("resource")
    Scanner input1 = new Scanner(System.in);
    out = input1.nextInt();
    while (in < out) {
      f = 0; 
      for (i = 2;i <= in / 2 ;i++) {
        if (in % i == 0)  {
          f = 1;
          break;
        }
        
      }
      if (f == 0) {
        System.out.println(in);
      }
      in++;
    }

  }

}
