package in.vamsoft.threads;
class ThreadToPrint extends Thread {
  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out.println(i);
    }
  }
}