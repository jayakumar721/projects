package in.vamsoft.threads;
public class SampleThread extends Thread {
  SynThread thread = new SynThread();

  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println(i);
      thread.disp();
      synchronized (thread) {
        try {
          wait();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }
  }
}