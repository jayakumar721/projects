package in.vamsoft.training;

public class StaticDemoTest {

  static {
    System.out.println("StaticDemoTest.enclosing_method()");
  }

  /**
   * @param args .
   */
  public static void main(String[] args) {

    final StaticDemo demo = StaticDemo.getInstance();
    demo.display();
    final StaticDemo demo1 = StaticDemo.getInstance();
    demo1.display();
  }

  static {
    System.out.println("StaticDemoTest.enclosing_method1()");
  }

}
