package in.vamsoft.day4;

import java.io.RandomAccessFile;

public class RandomAccess {

  public static void main(String[] args) {
    try {
      @SuppressWarnings("resource")
      RandomAccessFile access = new RandomAccessFile("text.txt","rw");
      access.write("welcome".getBytes());
      access.seek(5);
      int i;
      while((i=access.read())!=-1) {
        System.out.println((char)i);
      }
      access.seek(access.length());
      access.write("appending".getBytes());
      System.out.println();
      access.seek(0);
      while((i=access.read())!=-1) {
        System.out.println(i);
      }
      
    } catch (Exception e) {
      System.out.println(e);
    }
  }
  
}
