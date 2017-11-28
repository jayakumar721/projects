package in.vamsoft.servlets.dao;

public class Customer {

  private String custName;
  private String date;
  private String address;
  private String phnNo;
  private String gender;
  private String hobbies;

  public String getCustName() {
    return custName;
  }

  @Override
  public String toString() {
    return "Customer [custName=" + custName + ", date=" + date + ", address=" + address + ", phnNo=" + phnNo
        + ", gender=" + gender + ", hobbies=" + hobbies + "]\n";
  }

  public void setCustName(String custName) {
    this.custName = custName;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPhnNo() {
    return phnNo;
  }

  public void setPhnNo(String phnNo) {
    this.phnNo = phnNo;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getHobbies() {
    return hobbies;
  }

  public void setHobbies(String hobbies) {
    this.hobbies = hobbies;
  }

  public Customer(String custName, String date, String address, String phnNo, String gender, String hobbies) {
    super();
    this.custName = custName;
    this.date = date;
    this.address = address;
    this.phnNo = phnNo;
    this.gender = gender;
    this.hobbies = hobbies;
  }

  public Customer() {

  }

}
