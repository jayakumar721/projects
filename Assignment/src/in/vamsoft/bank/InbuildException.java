package in.vamsoft.bank;

import java.io.FileReader;

public class InbuildException {
  
  @SuppressWarnings("resource")
  public static void main(String[] args) {
    try {
      
      int a=20/0;
      System.out.println(a);
      @SuppressWarnings("unused")
      FileReader fileReader = new FileReader("/src/text.txt");
      
    } catch (Exception e) {
        e.printStackTrace();
    }
  }
}
