package in.vamsoft.day4;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialDemo {

  @SuppressWarnings("resource")
  public static void main(String[] args) throws IOException, ClassNotFoundException {
    Emp ee = new Emp(12, "jk");
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("text.txt"));
    objectOutputStream.writeObject(ee);
    System.out.println("object Added..");
    
    ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("text.txt"));
    Emp emp = (Emp) inputStream.readObject();
    System.out.println(emp);
  }
  
  
  
  
}
