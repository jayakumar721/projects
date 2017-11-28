package in.vamsoft.threads;
class Thread4 extends Thread {
  @Override
  public void run() {
    System.out.println("Thread2.run()" + currentThread().getPriority());
  }
}
