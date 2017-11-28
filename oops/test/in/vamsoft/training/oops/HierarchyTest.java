package in.vamsoft.training.oops;

public class HierarchyTest {

  /**
   * .
   *
   * @param args
   *          .
   */
  public static void main(String[] args) {
    final SportsCar car = new SportsCar("Xuv");
    car.brake();
    final Car c = new SportsCar();
    final Car c1 = new SportsCar();
    System.out.println(car);
    System.out.println(c);
  }
}
