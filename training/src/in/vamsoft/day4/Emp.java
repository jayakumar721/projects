package in.vamsoft.day4;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Emp implements Serializable {
  private int empId;
  private  String empName;
  public int getEmpId() {
    return empId;
  }

	public Emp(int empId, String empName) {
    super();
    this.empId = empId;
    this.empName = empName;
  }

  @Override
	public String toString() {
		return "Emp [empId=" + empId + ", empName=" + empName + "]";
	}

  

}
