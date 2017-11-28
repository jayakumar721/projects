package in.vamsoft.day6;

interface int1{
  public default void me1() {
    System.out.println("int1.me1()");
  }
  public void me2();
}
interface int2{
  public default void me1() {
    System.out.println("int2.me1()");
  }
  
}

class Demo implements int1,int2{

  @Override
  public void me1() {
    // TODO Auto-generated method stub
    int1.super.me1();
  }

  @Override
  public void me2() {
    System.out.println("Demo.me2()");
    
  }
  
  
  
}


public class InterfaceDemo  {

  public static void main(String[] args) {
    Demo demo = new Demo();
    demo.me1();
    demo.me2();
  }
}
