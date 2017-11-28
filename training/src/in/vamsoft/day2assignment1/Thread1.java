package in.vamsoft.day2assignment1;

public class Thread1 implements Runnable {

  @Override
  public void run() {

    
    for(int i=5;i<500;) {
      System.out.println(Thread.currentThread().getName() + " " + i);
      i+=5;
    }
  }
}
