package in.vamsoft.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import in.vamsoft.dao.ProductDao;
import in.vamsoft.spencer.Product;

class ProductDaoTest {
  
 static ProductDao productDao=null;

  @BeforeAll
  public static void createProductDao() {
    productDao=new ProductDao();

  }
  
  
  @Test
  void testAddProduct() {
    Product product =new Product(8, "Panasonic", 30, 50);
    boolean actual=productDao.addProduct(product);
    assertTrue(actual);

  }

  @Test
  void testCheckProductAvailability() {
    int actual=productDao.checkProductAvailability("mobile");
    assertEquals(599, actual);
  }

  @Test
  void testGetAllProducts() {
  List<Product> products= productDao.getAllProducts();
  assertEquals(6, products.size());
  }

}
