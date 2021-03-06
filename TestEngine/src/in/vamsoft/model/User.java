package in.vamsoft.model;

public class User {

  private String email;
  private String password;
  private String firstname;
  private String lastname;
  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String userName) {
    this.email = userName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User(String userName, String password) {
    super();
    this.email = userName;
    this.password = password;
  }

  public User() {
  }

}
