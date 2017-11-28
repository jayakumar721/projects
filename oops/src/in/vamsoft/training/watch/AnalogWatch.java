package in.vamsoft.training.watch;

public class AnalogWatch extends Watch {

  @Override
  public void setAlarm() {
    super.setAlarm();
  }

  @Override
  public void ringAlarm() {
    System.out.println("AnalogWatch.ringAlarm()");

  }

  @Override
  public void hourElapsed() {
    System.out.println("AnalogWatch.hourElapsed()");

  }

  @Override
  public void minuteElapsed() {
    super.minuteElapsed();
    System.out.println("AnalogWatch.minuteElapsed()");
  }

}
