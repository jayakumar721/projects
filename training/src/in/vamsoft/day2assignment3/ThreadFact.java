package in.vamsoft.day2assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

class ThreadRun1 extends Thread {

  private String num;
  private static int value;
  ThreadRun2 con;

  public ThreadRun1(String line) {
  }

 


  @SuppressWarnings("static-access")
  @Override
  public void run() {
    File file = new File(this.num);
    FileReader fileReader;
    try {
      fileReader = new FileReader(file);
      try {
        @SuppressWarnings("resource")
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        StringBuffer stringBuffer = new StringBuffer();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
          stringBuffer.append(line);
          this.value = Integer.parseInt(line.toString());
          synchronized (con) {
            con.notify();

          }
          synchronized (this) {

            wait();

          }

        }

      } catch (Exception e) {
        System.out.println(e);
      }

    } catch (

    FileNotFoundException e) {

      e.printStackTrace();
    }

  }

  public int getValue() {
    return value;
  }
}

class ThreadRun2 extends Thread {

  ThreadRun1 prod;


  public void run() {
    for (int i = 0; i <= 5; i++) {
      try {
        synchronized (this) {
          wait();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      int fact = factorial(prod.getValue());

      System.out.println(fact);

      synchronized (prod) {
        prod.notify();

      }
    }
  }

  int factorial(int a) {
    int f = 1;
    while (a > 0) {
      f = f * a;
      a--;
    }
    return f;
  }
}

public class ThreadFact {
  public static void main(String[] args) {
    String file = args[0];
    ThreadRun1 tr = new ThreadRun1(file);
    ThreadRun2 tr1 = new ThreadRun2();

    tr.start();
    tr1.start();
  }
}
