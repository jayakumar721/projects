package in.vamsoft.threads;
class Thread2 extends Thread{
  @Override
  public void run() {
    System.out.println("Thread2.run()"+currentThread().getPriority());
  }
}
