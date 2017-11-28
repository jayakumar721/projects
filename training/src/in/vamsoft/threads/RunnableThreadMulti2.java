package in.vamsoft.threads;

public class RunnableThreadMulti2 implements Runnable {

  @Override
  public void run() {
    int f = 0;
    int f1 = 1;
    for (int i = 1;i <= 10;i++) {
      System.out.println(f);
      int f2 = f + f1;
      f = f1;
      f1 = f2;
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
    }   
  }
  
  

}
