package in.vamsoft.threads;

public class ThreadTimeSlice {
  @SuppressWarnings("static-access")
  public static void main(String[] args) throws InterruptedException {
    ThreadToPrint t1 = new ThreadToPrint();
    Thread4 t2 = new Thread4();
    t1.start();
    t1.sleep(1000);
    t2.start();
  }
}
