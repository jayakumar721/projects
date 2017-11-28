package in.vamsoft.threads;
class SampleThread1 extends Thread {
  SynThread thread = new SynThread();

  @Override
  public void run() {
    System.out.println("Thread2.run()" + currentThread().getPriority());
    thread.disp();
  }
}