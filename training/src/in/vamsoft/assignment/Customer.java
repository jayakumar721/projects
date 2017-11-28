package in.vamsoft.assignment;

public class Customer implements Comparable<Customer> {
  
  int custId;
  public String name;
  long mobile;
  String address;
  
  /**
   * @param custId.
   * @param name.
   * @param mobile.
   * @param address.
   */
  public Customer(int custId, String name,long mobile, String address) {
    super();
    this.custId = custId;
    this.name = name;
    this.mobile = mobile;
    this.address = address;
  }

  @Override
  public int compareTo(Customer o) {
    if (this.custId < o.custId) {
      return -1;
    } else if (this.custId > o.custId) {
      return 1;      
    } else {
      return 0;
    }
  }

  @Override
  public String toString() {
    return "Customer [custId=" + custId + ", name=" + name 
        + ", mobile=" + mobile + ", address=" + address + "]\n";
  }
  

}
