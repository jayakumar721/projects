package in.vamsoft.day2assignment1;

public class ThreadDemo {
  

  public static void main(String[] args) {
    Thread1 th = new Thread1();
    Thread t = new Thread(th);
    Thread2 th1 = new Thread2();
    Thread t1 = new Thread(th1);
    Thread3 th2 = new Thread3();
    Thread t2 = new Thread(th2);
    t.start();
    t1.start();
    t2.start();
  }

}
