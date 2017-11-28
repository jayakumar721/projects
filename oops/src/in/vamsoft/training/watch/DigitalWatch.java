package in.vamsoft.training.watch;

public class DigitalWatch extends Watch implements StopWatch {

  @Override
  public void minuteElapsed() {
    super.minuteElapsed();
  }

  public void setAlarm(String tone) {
    System.out.println("DigitalWatch.setAlarm()" + tone);
  }

  @Override
  public void ringAlarm() {
    System.out.println("DigitalWatch.ringAlarm()");

  }

  @Override
  public void hourElapsed() {
    System.out.println("DigitalWatch.hourElapsed()");

  }

  @Override
  public void start() {
    System.out.println("DigitalWatch.start()");

  }

  @Override
  public void pause() {
    System.out.println("DigitalWatch.pause()");

  }

  @Override
  public void stop() {
    System.out.println("DigitalWatch.stop()");

  }

  @Override
  public void lapTimer() {
    System.out.println("DigitalWatch.lapTimer()");

  }

}
