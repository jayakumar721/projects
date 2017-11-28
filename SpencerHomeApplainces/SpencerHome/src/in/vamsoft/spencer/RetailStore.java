package in.vamsoft.spencer;

import in.vamsoft.dao.CustomerDaoImpl;
import in.vamsoft.dao.ProductDao;

import java.sql.Connection;

import java.util.List;

public class RetailStore {

  String storeName;
  public static int custId = 0;
  public static int pId = 0;
  Connection connection = null;
  CustomerDaoImpl impl = new CustomerDaoImpl();
  ProductDao productDao = new ProductDao();

  public RetailStore(String name) {
    this.storeName = name;
  }

  public String getStoreName() {
    return storeName;
  }

  public void setStoreName(String storeName) {
    this.storeName = storeName;
  }

  /**
   * @param name getting customerName as parameter.
   * @param contact name getting customerContact as parameter.
   */
  public void addCustomer(String name, int contact) {
    System.out.println(impl.getLastCustomerId());
    custId = impl.getLastCustomerId() + 1;
    Customer c = new Customer(custId, name, contact);
    impl.addCustomer(c);
    System.out.println("customer added");

  }

  /**
   * @param pname productName.
   * @param price productPrice
   * @param quantity productQuantity
   */
  public void addProduct(String pname, double price, int quantity) {
    pId = productDao.getLastProductId() + 1;
    Product p = new Product(pId, pname, quantity, price);
    productDao.addProduct(p);
    System.out.println("product added");

  }

  /**
   * @param productName productName.
   * @return checkingAvailability
   */
  public int checkProductAvailability(String productName) {
    System.out.println(productDao.checkProductAvailability(productName));
    return productDao.checkProductAvailability(productName);

  }

  public List<Product> getAllProducts() {
    System.out.println(productDao.getAllProducts());
    return productDao.getAllProducts();
  }

  /**
   * @param pname productName.
   * @param quantity productQuantity
   * @param customerid CustomerId
   * @return .
   */
  public boolean bookProduct(String pname, int quantity, int customerid) {
    System.out.println("RetailStore.bookproduct()");

    return (productDao.bookproduct(pname, quantity, customerid));
  }

  public void getAllBookedProducts(int custId) {
    System.out.println((impl.getAllBookedProducts(custId)));
  }

}
