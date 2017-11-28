package in.vamsoft.training.oops;

public class SportsCar extends Car {

  public SportsCar() {
    System.out.println("SportsCar.SportsCar()");
  }

  public SportsCar(String model) {
    System.out.println("SportsCar.SportsCar()");
    System.out.println(model);
  }

  @Override
  public void start() {
    System.out.println("SportsCar.start()");
  }

  @Override
  public void brake() {
    System.out.println("SportsCar.brake()");
  }

  public void fourWheelDrive() {
    System.out.println("SportsCar.fourWheelDrive()");
  }

  @Override
  public void handBrake() {
    System.out.println("SportsCar.handBrake()");
  }

}
