package in.vamsoft.training.birds;

public class Crow extends Birds {

  @Override
  public void fly() {
    System.out.println("Crow.fly()");

  }

  @Override
  public void talk() {
    System.out.println("Crow.talk()");

  }

  public void talk(String talk) {
    System.out.println("Crow" + talk);
  }

  @Override
  public void eat() {
    System.out.println("Crow.eat()");
  }

}
