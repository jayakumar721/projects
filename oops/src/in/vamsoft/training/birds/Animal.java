package in.vamsoft.training.birds;

public class Animal implements Talking {

  @Override
  public void talk() {
    System.out.println("Animal.talk()");
  }

  @Override
  public void fly() {
    System.out.println("Animal.fly()");

  }

}