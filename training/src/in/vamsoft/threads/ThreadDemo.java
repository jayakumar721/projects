package in.vamsoft.threads;

public class ThreadDemo extends Thread {

  @Override
  public void run() {
    for (int i = 5;i >= 1;i--) {
      System.out.println(Thread.currentThread().getName() + " : " + i);
    }
  }
  
  

}
