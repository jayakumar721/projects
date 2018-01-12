package in.serial;


public class Test {

  int x = 3;
  int y = 4;
  
  boolean isEqual() {
    return(x==y);
  }
  
  public static void main(String[] args) {
    Test ob = new Test();
    ob.x=5;
    ob.y=5;
    System.out.println(ob.isEqual());
  }
  
}
