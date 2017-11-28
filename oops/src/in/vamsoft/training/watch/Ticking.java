package in.vamsoft.training.watch;

public interface Ticking {
  int factor = 60;

  void tick();

  void minuteElapsed();

  void hourElapsed();

}
