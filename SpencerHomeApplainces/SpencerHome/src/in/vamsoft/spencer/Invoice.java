package in.vamsoft.spencer;

public class Invoice {
  private int invoiceId;
  private int productId;
  private String productName;
  private int quantity;
  private int productPrice;
  private int total;

  public Invoice() {
  }

  public int getInvoiceId() {
    return invoiceId;
  }

  public void setInvoiceId(int invoiceId) {
    this.invoiceId = invoiceId;
  }

  public int getProductId() {
    return productId;
  }

  public void setProductId(int productId) {
    this.productId = productId;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  @Override
  public String toString() {
    return "Invoice [invoiceId=" + invoiceId + ", productId=" 
        + productId + ", productName=" + productName
        + ", quantity=" + quantity + ", productPrice=" + productPrice + ", total=" + total + "]\n";
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public int getProductPrice() {
    return productPrice;
  }

  public void setProductPrice(int productPrice) {
    this.productPrice = productPrice;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

}
