package in.vamsoft.test;

import in.vamsoft.spencer.RetailStore;
import java.util.Scanner;

public class MainClassTest {

  /**
   * @param args
   *          .
   */
  public static void main(String[] args) {
    RetailStore retailStore = new RetailStore("Spencer Home Applaiances");
    @SuppressWarnings("resource")
    Scanner scanner = new Scanner(System.in);
    @SuppressWarnings("resource")
    Scanner scanner1 = new Scanner(System.in);
    System.out.println("1.Customer\n2.Retailer");
    System.out.println("Enter your choice");
    int sc = scanner.nextInt();
    if (sc == 1) {
      System.out.println("in customer");
      System.out.println("1.View Avalible Product\n2.Book Product\n3.View Booked Product");

      int sc5 = scanner.nextInt();
      switch (sc5) {
        case 1:
          retailStore.getAllProducts();
          break;
        case 2:
          System.out.println("Enter Customer Id");
          int customerId = scanner.nextInt();

          System.out.println("Enter Name of Product:");
          String pname = scanner1.nextLine();
          System.out.println("Enter Quantity:");
          int quantity = scanner.nextInt();
          if (quantity < retailStore.checkProductAvailability(pname)) {
            System.out.println("in if");
            retailStore.bookProduct(pname, quantity, customerId);
          } else {
            System.out.println("Quantity is less");
          }

          break;

        case 3:
          System.out.println("Enter customer Id:");
          int customerId1 = scanner.nextInt();
          retailStore.getAllBookedProducts(customerId1);
          break;

        default:
          System.out.println("exit");

      }
    } else {
      System.out.println(retailStore.getStoreName());
      System.out.println("1.Add Customer\n2.Add Product\n3.Check Availability");
      System.out.println("Enter your choice");
      int sc1 = scanner.nextInt();
      switch (sc1) {
        case 1:
          System.out.println("Enter no of customers:");
          int count = 0;
          count = scanner.nextInt();
          while (count > 0) {
            System.out.println("Enter customer name:");
            String name = scanner1.nextLine();
            System.out.println("enter customer contactno");
            int contact = scanner.nextInt();
            retailStore.addCustomer(name, contact);
            count--;
          }
          break;
        case 2:
          System.out.println("Enter no of products:");
          int count1 = 0;
          count1 = scanner.nextInt();
          while (count1 > 0) {
            System.out.println("Enter product name:");
            String pname = scanner1.nextLine();
            System.out.println("enter product price");
            int price = scanner.nextInt();
            System.out.println("enter product quantity");
            int quantity = scanner.nextInt();
            retailStore.addProduct(pname, price, quantity);
            count1--;
          }
          break;

        case 3:
          System.out.println("Enter product name:");
          String productName = scanner1.nextLine();
          retailStore.checkProductAvailability(productName);
          break;
        default:
          System.out.println("invalid selection..");
      }
    }

  }
}
