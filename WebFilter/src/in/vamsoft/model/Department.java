package in.vamsoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="departments")
public class Department {
  @Id
  @Column(name="department_id")
  private int deptNo;
  @Column(name="department_name")
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
    return "Department [deptNo=" + deptNo + ", deptName=" + deptName + "]\n";
  }
  
  

}
