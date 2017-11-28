package in.vamsoft.day6;


public class ThreadDemoLambda {

  public static void main(String[] args) {
  
    Runnable r1 = new Runnable() {
      
      @Override
      public void run() {
        System.out.println("ThreadDemoLambda1.main(...).new Runnable() {...}.run()");
        
      }
    };
    Runnable r2 = new Runnable() {
      
      @Override
      public void run() {
        System.out.println("ThreadDemoLambda2.main(...).new Runnable() {...}.run()");
        
      }
    };
    
    Thread thread = new Thread(()->System.out.println("hello"));
    thread.start();
    Thread thread2 = new Thread(r1);
    thread2.start();
    Thread thread3 = new Thread(r2);
    thread3.start();
  }
  
  
}
