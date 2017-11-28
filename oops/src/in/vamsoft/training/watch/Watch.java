package in.vamsoft.training.watch;

public abstract class Watch extends Clock implements Alarm {

  @Override
  public void minuteElapsed() {
    System.out.println("Watch.minuteElapsed()");
  }

  @Override
  public void setAlarm() {
    System.out.println("Watch.setAlarm()");
  }

}
