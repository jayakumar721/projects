package in.vamsoft.trainingday2;

@SuppressWarnings("serial")
public class InvalidSalaryException extends Exception {
  
  public enum Salary {
    min_Salary, max_Salary; 
  }
  
  Salary errorcode;


  
  public InvalidSalaryException(String message) {
    super(message);
  }
  
  public InvalidSalaryException(String mesage,Salary errorcode) {
    super(mesage);
    this.errorcode =  errorcode;
  }
  
  public Salary getErrorCode() {
    return errorcode;
  }
  

}
