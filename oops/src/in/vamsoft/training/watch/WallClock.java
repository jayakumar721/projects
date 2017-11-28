package in.vamsoft.training.watch;

public class WallClock extends Clock {

  @Override
  public void minuteElapsed() {
    System.out.println("WallClock.minuteElapsed()");

  }

  @Override
  public void hourElapsed() {
    System.out.println("WallClock.hourElapsed()");

  }

}
