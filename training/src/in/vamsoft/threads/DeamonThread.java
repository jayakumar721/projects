package in.vamsoft.threads;

class Deamon extends Thread{
  public void run() {
    for (int i =1;i <= 20;i++) {
      System.out.println("Deamon Thread " + i);
    }
  }
}
class SampleThread extends Thread{
  public void run() {
    for (int i =1;i <= 5;i++) {
      System.out.println("Thread" + i);
    }
  }
}
public class DeamonThread {
  
  public static void main(String[] args) {
    Deamon d = new Deamon();
    SampleThread sd = new SampleThread();
    d.setDaemon(true);
    sd.start();
    d.start();
  }
  
  

}
