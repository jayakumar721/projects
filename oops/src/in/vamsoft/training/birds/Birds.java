package in.vamsoft.training.birds;

public abstract class Birds implements Flying, Talking, Eating {
  @Override
  public void eat() {
    System.out.println("Birds.eat()");
  }

}
