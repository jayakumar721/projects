package in.vamsoft.training.watch;

public abstract class Clock implements Ticking {

  @Override
  public void tick() {
    System.out.println("Clock.tick()");
  }

}
