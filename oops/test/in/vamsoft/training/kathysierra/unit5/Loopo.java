package in.vamsoft.training.kathysierra.unit5;

public class Loopo {

  /**
   * @param args .
   */
  public static void main(String[] args) {
    int i;
    int j;
    for (i = 0;i < 5;i++) {
      for (j = i;j < 5 - 1;j++) {
        System.out.print(" ");
      }
      for (j = i;j >= 0;j--) {
        System.out.print(j);
      }
      for (j = 1;j <= i;j++) {
        System.out.print(j);
      }
      System.out.println();
    }
  }

}
