package in.vamsoft.threads;

public class RunnableThreadMulti implements Runnable {

  @Override
  public void run() {
    int f = 1;
    for (int i = 1;i <= 5;i++) {
      
      f = f * i;
    }
    System.out.println(f);
    
  }
  
  

}
