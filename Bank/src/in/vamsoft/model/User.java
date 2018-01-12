package in.vamsoft.model;

public class User {

  private String emailId;
  private String passWord;
  public String getEmailId() {
    return emailId;
  }
  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }
  public String getPassWord() {
    return passWord;
  }
  public void setPassWord(String passWord) {
    this.passWord = passWord;
  }
  public User(String userId, String passWord) {
    super();
    this.emailId = userId;
    this.passWord = passWord;
  }
  public User() {
    // TODO Auto-generated constructor stub
  }
  
}
