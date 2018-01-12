package in.vamsoft.assign2;

import java.util.Map;

public interface CartDao {

  boolean verifyCustomer(String name, String pass);

  Map<String, Double> cart(String[] bear, String[] mobiles);

}