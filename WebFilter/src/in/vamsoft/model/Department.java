package in.vamsoft.model;

public class Department {
  
  private int deptNo;
  private String deptName;
  public int getDeptNo() {
    return deptNo;
  }
  public void setDeptNo(int deptNo) {
    this.deptNo = deptNo;
  }
  public String getDeptName() {
    return deptName;
  }
  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }
  public Department(int deptNo, String deptName) {
    super();
    this.deptNo = deptNo;
    this.deptName = deptName;
  }
  public Department() {
    
  }
  @Override
  public String toString() {
    return "Department [deptNo=" + deptNo + ", deptName=" + deptName + "]";
  }
  
  

}
