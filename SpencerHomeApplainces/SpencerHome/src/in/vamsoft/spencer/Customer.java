package in.vamsoft.spencer;

public class Customer {
  int custId;
  String name;
  int contactNo;

  public Customer() {
  }

  /**
   * @param custId For getting customerId.
   * @param name For getting customerName
   * @param contactNo For getting customerContactNumber
   */
  public Customer(int custId, String name, int contactNo) {
    super();
    this.custId = custId;
    this.name = name;
    this.contactNo = contactNo;
  }

  public int getCustId() {
    return custId;
  }

  public void setCustId(int custId) {
    this.custId = custId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getContactNo() {
    return contactNo;
  }

  public void setContactNo(int contactNo) {
    this.contactNo = contactNo;
  }

  public void addCustomer() {
    DbConnectionUtil.getConnection();

  }

  public void bookProduct(Product obj) {

  }

}
