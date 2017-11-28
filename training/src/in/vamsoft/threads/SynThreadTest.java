package in.vamsoft.threads;

class RunThread implements Runnable {

  SynThread amount;
  double wd;
  
  public RunThread(SynThread ss, int i) {
    // TODO Auto-generated constructor stub
    this.amount = ss;
    this.wd = i;
  }

  @Override
  public void run() {
    System.out.println("Balance for " + Thread.currentThread().getName() + " : " 
          + amount.getBalance());
    synchronized (amount) {
      amount.withdraw(wd);
    }
  }
  
}

public class SynThreadTest {

  /**
   * @param args.
   */
  public static void main(String[] args) {
    SynThread ss = new SynThread(2000);
    RunThread r1 = new RunThread(ss,700);
    RunThread r2 = new RunThread(ss,1500);
    Thread t1 = new Thread(r1,"Thread1");
    Thread t2 = new Thread(r2,"Thread2");
    t1.start();
    t2.start();
  }
  
}
