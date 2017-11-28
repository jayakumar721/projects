package in.vamsoft.day2assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

class ThreadRun1 extends Thread {
<<<<<<< HEAD
  private String file2;
=======
  private String num;
>>>>>>> 6b3f4d252156e2da132d0cad1d4670218144e3fa
  private static int value;
  ThreadRun2 con;

  public ThreadRun1(String line) {
<<<<<<< HEAD
    this.file2 = line;
  }

 
  @SuppressWarnings("static-access")
  @Override
  public void run() {
    File file = new File(this.file2);
=======
    this.num = line;
  }

  @SuppressWarnings("static-access")
  @Override
  public void run() {
    File file = new File(this.num);
>>>>>>> 6b3f4d252156e2da132d0cad1d4670218144e3fa
    FileReader fileReader;
    try {
      fileReader = new FileReader(file);
      try {
        @SuppressWarnings("resource")
        BufferedReader bufferedReader = new BufferedReader(fileReader);
<<<<<<< HEAD
        String line;
        while ((line = bufferedReader.readLine()) != null) {
          this.value=Integer.parseInt(line.toString());
          synchronized (con) {
            con.notify();
            
          }
          synchronized (this) {
            wait();
            
          }
          
=======
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

>>>>>>> 6b3f4d252156e2da132d0cad1d4670218144e3fa
        }

      } catch (Exception e) {
        System.out.println(e);
      }
<<<<<<< HEAD
    } catch (FileNotFoundException e) {
   
=======
    } catch (

    FileNotFoundException e) {

>>>>>>> 6b3f4d252156e2da132d0cad1d4670218144e3fa
      e.printStackTrace();
    }

  }
<<<<<<< HEAD
=======

>>>>>>> 6b3f4d252156e2da132d0cad1d4670218144e3fa
  public int getValue() {
    return value;
  }

<<<<<<< HEAD
  public void setCon(ThreadRun2 con) {
    this.con = con;
  }

=======
>>>>>>> 6b3f4d252156e2da132d0cad1d4670218144e3fa
}

class ThreadRun2 extends Thread {

  ThreadRun1 prod;

<<<<<<< HEAD
  public void setProd(ThreadRun1 prod) {
    this.prod = prod;
  }

=======
>>>>>>> 6b3f4d252156e2da132d0cad1d4670218144e3fa
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
<<<<<<< HEAD
      System.out.println("factorial : " + fact);
=======
      System.out.println(fact);
>>>>>>> 6b3f4d252156e2da132d0cad1d4670218144e3fa

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
<<<<<<< HEAD
    tr.setCon(tr1);
    tr1.setProd(tr);
=======
>>>>>>> 6b3f4d252156e2da132d0cad1d4670218144e3fa
    tr.start();
    tr1.start();
  }
}
