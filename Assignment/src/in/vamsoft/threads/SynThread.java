package in.vamsoft.threads;

public class SynThread {

  public static void main(String[] args) {
    SampleThread t1 = new SampleThread();
    SampleThread1 t2 = new SampleThread1();
    t1.start();
    t2.start();
  }

  public void disp() {
    System.out.println("SynThread.disp()");
  }
}
