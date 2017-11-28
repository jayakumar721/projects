package in.serial;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExternExm {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    try {
      FileOutputStream fos = new FileOutputStream("tex.txt");
      Emp e = new Emp();
      e.setEmpId(2345);
      e.setEmpName("ss");
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(e);
      oos.close();
      FileInputStream fis = new FileInputStream("tex.txt");
      ObjectInputStream ois = new ObjectInputStream(fis);
      Object obj = ois.readObject();
      System.out.println(obj);
      ois.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    

  }

}
