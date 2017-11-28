package in.vamsoft.training;

public class StaticDemo {

  public static StaticDemo instance;

  private StaticDemo() {
    System.out.println("StaticDemo.StaticDemo()");
  }

  /**
   * @return .
   */
  public static StaticDemo getInstance() {
    if (instance == null) {
      instance = new StaticDemo();
    }
    return instance;

  }

  public void display() {
    System.out.println("Sample");
  }

}
