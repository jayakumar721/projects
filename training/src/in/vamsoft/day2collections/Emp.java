package in.vamsoft.day2collections;

public class Emp implements Comparable<Emp> {
  private int empId;
  
  @Override
  public String toString() {
    return "Emp [empId=" + empId + ", empName=" + empName 
        + ", code=" + code + "]\n";
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + empId;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Emp other = (Emp) obj;
    if (empId != other.empId) {
      return false;
    }
    return true;
  }

  private String empName;
  private int code;
  
  public int getEmpId() {
    return empId;
  }
  
  public void setEmpId(int empId) {
    this.empId = empId;
  }
  
  public String getEmpName() {
    return empName;
  }
  
  public void setEmpName(String empName) {
    this.empName = empName;
  }
  
  public int getCode() {
    return code;
  }
  
  public void setCode(int code) {
    this.code = code;
  }
  
  /**
   * @param empId .
   * @param empName .
   * @param code .
   */
  public Emp(int empId, String empName, int code) {
    super();
    this.empId = empId;
    this.empName = empName;
    this.code = code;
  }

  @Override
  public int compareTo(Emp o) {
    if (this.empId < o.empId) {
      return -1;
    } else if (this.empId > o.empId) {
      return 1;
    } else {
      return 0;
    }
    
  }
  
}
