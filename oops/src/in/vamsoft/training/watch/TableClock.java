package in.vamsoft.training.watch;

public class TableClock extends Clock implements Alarm {

  @Override
  public void setAlarm() {
    System.out.println("TableClock.setAlarm()");

  }

  @Override
  public void ringAlarm() {
    System.out.println("TableClock.ringAlarm()");

  }

  @Override
  public void minuteElapsed() {
    System.out.println("TableClock.minuteElapsed()");

  }

  @Override
  public void hourElapsed() {
    System.out.println("TableClock.hourElapsed()");

  }

}
