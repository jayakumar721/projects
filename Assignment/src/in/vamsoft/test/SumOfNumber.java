package in.vamsoft.test;

public class SumOfNumber {

  public static void main(String[] args) {

    try {
      int n = Integer.parseInt(args[0]);
      int sum = 0;
      for (int i = 0; i <= n; i++) {
        sum += i;
      }
      System.out.println("The sum in for:" + sum);
      while (n < 0) {
        sum += n;
        n--;
      }
      System.out.println("The sum in while:" + sum);
    } catch (NumberFormatException e) {
      System.out.println(e);
    }
  }

}
