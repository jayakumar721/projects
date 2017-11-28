package in.vamsoft.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Assert;

import in.vamsoft.dao.CustomerDaoImpl;
import in.vamsoft.spencer.Customer;
import in.vamsoft.spencer.Invoice;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CustomerDaoTest {

  static CustomerDaoImpl customerDaoImpl = null;
  
  @BeforeAll
  public static void createDao() {
    customerDaoImpl  = new CustomerDaoImpl();
  }

  @Disabled
 public  void testAddCustomer() {
    System.out.println("inside test");
    Customer customer = new Customer(100, "jk", 989895);
    boolean result = customerDaoImpl.addCustomer(customer);
    assertTrue(result);
    

  }


  @Test
  void testCheckCustomerId() {
   
    boolean actual = customerDaoImpl.checkCustomerId(1);
    assertTrue(actual);
   
  }

  @Test
  void testGetAllBookedProducts() {
    List<Invoice> products = customerDaoImpl.getAllBookedProducts(1);
    assertEquals(2, products.size());
    
  }

}
