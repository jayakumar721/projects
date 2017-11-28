package in.vamsoft.bank;

import in.vamsoft.test.CurrentAcc;
import in.vamsoft.test.SavingsAcc;

public class Account implements CurrentAcc, SavingsAcc {

  @Override
  public void disp() {
    System.out.println("Account Details");

  }

  public static void main(String[] args) {
    Account c = new Account();
    c.disp();
  }
}
