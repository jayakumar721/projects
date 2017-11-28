package in.vamsoft.servlet.dao;

import java.util.Map;

public interface CartDao {

  boolean verifyCustomer(String name, String pass);

  Map<String, Double> cart(String[] bear, String[] mobiles);

}