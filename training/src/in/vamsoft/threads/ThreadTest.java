package in.vamsoft.threads;

public class ThreadTest {
  
  /**
   * @param args.
   */
  public static void main(String[] args) {
    RunnableThread run = new RunnableThread();
    Thread t = new Thread(run);
    t.setName("jk");
    t.start();
    
    Thread t1 = new Thread(run);
    t1.start();
    t1.setName("j");
    
  }

}
