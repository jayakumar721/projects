package in.vamsoft.threads;

public class MultiThread {
  
  /**
   * @param args.
   * @throws InterruptedException . 
   */
  public static void main(String[] args) throws InterruptedException {
    RunnableThreadMulti m1 = new RunnableThreadMulti();
    System.out.println("Thread starting....");
    Thread t1 = new Thread(m1);
    t1.start();
    RunnableThreadMulti2 m2 = new RunnableThreadMulti2();
    Thread t2 = new Thread(m2);
    t2.setPriority(9);
    t2.start();
    t1.join();
    t2.join();
    System.out.println("Threads Executed!!!");
  }

}
