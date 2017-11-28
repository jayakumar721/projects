package in.vamsoft.bank;

public class OuterClass {
  
  public void show() {
    System.out.println("OuterClass.show()");
  }
  class InnerClass{
    OuterClass out = new OuterClass();
    public void innerShow() {
      out.show();
      System.out.println("OuterClass.InnerClass.innerShow()");
      
    }
  }
  
  public static void main(String[] args) {
    OuterClass in = new OuterClass();
    in.show();
  }

}
