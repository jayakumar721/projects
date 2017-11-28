package in.vamsoft.day2assignment2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

class ThreadRun1 extends Thread {
  private String num;

  public ThreadRun1(String line) {
    this.num = line;
  }

  @Override
  public void run() {
    File file = new File(this.num);
    FileReader fileReader;
    try {
      fileReader = new FileReader(file);
      try {
        @SuppressWarnings("resource")
        BufferedReader bufferedReader = new BufferedReader(fileReader);
<<<<<<< HEAD
        String line;
        while ((line = bufferedReader.readLine()) != null) {
=======
        StringBuffer stringBuffer = new StringBuffer();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
          stringBuffer.append(line);
>>>>>>> 6b3f4d252156e2da132d0cad1d4670218144e3fa
          System.out.println(line.toString());
        }

      } catch (Exception e) {
        // TODO: handle exception
      }
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}

class ThreadRun2 extends Thread {
  private String num;

  public ThreadRun2(String line) {
    this.num = line;
  }

  @Override
  public void run() {
    File file = new File(this.num);
    FileReader fileReader;
    try {
      fileReader = new FileReader(file);
      try {
        @SuppressWarnings("resource")
        BufferedReader bufferedReader = new BufferedReader(fileReader);
<<<<<<< HEAD
        String line;
        while ((line = bufferedReader.readLine()) != null) {
=======
        StringBuffer stringBuffer = new StringBuffer();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
          stringBuffer.append(line);
>>>>>>> 6b3f4d252156e2da132d0cad1d4670218144e3fa
          System.out.println(line.toString());
        }

      } catch (Exception e) {
        // TODO: handle exception
      }
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
}

public class Thr {

  public static void main(String[] args) {

    String file1 = args[0];
    String file2 = args[1];
    ThreadRun1 tr = new ThreadRun1(file1);
    ThreadRun2 tr1 = new ThreadRun2(file2);
    tr.start();
    tr1.start();
  }

}
