package in.vamsoft.servlet.dao;

public class UserLogin {

  private String uname;
  private String pass;
  public String getUname() {
    return uname;
  }
  public void setUname(String uname) {
    this.uname = uname;
  }
  public String getPass() {
    return pass;
  }
  public void setPass(String pass) {
    this.pass = pass;
  }
  public UserLogin(String uname, String pass) {
    super();
    this.uname = uname;
    this.pass = pass;
  }
  
  
  
}
