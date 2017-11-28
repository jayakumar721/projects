package in.vamsoft.test;

public class SimpleInterest {
  double si;
  public SimpleInterest(double p,int rate,int n) {
   si= (p * rate * n)/100;
   System.out.println("The simple intrest is :"+si);
  }
}
