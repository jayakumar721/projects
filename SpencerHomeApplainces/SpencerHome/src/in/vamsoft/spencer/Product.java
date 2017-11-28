package in.vamsoft.spencer;

public class Product {

  int productId;
  String productName;
  int quantity;
  double price;

  public Product() {

  }

  @Override
  public String toString() {
    return "Product [product_id=" + productId + ", product_name=" + productName + ", "
        + "quantity=" + quantity + ", price=" + price + "]\n";
  }

  /**
   * @param productId for setting productId.
   * @param productName for setting productName.
   * @param quantity for setting productQuantity.
   * @param price for setting price.
   */
  public Product(int productId, String productName, int quantity, double price) {
    super();
    this.productId = productId;
    this.productName = productName;
    this.quantity = quantity;
    this.price = price;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public String getProduct_name() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

}
