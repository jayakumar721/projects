package in.vamsoft.threads;

public class SynThread {

  
  double balance;
  
  public SynThread(double balance) {
    this.balance = balance;
  }
  
  public double getBalance() {
    return balance;
  }
  
  /**
   * @param amount.
   */
  public void withdraw(double amount) {
    if ((balance - amount) >= 0) {
      try {
        Thread.sleep(4000);
      } catch (InterruptedException e) {
        System.out.println(e);
      }
      balance -= amount;
      System.out.println("withdrawl by thread " + Thread.currentThread().getName() 
          + " successfull balance :" + getBalance());
    } else {
      System.out.println("insufficient funds for thread " + Thread.currentThread().getName() 
          + " successfull balance :" + getBalance());
    }
  }
}
