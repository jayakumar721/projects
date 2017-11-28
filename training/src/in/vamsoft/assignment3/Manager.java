package in.vamsoft.assignment3;

public class Manager extends Employee {

  private String deptName;
  private Employee[] staff;
  private static String man;
  @SuppressWarnings("unused")
  private static int emp;

  private static int employeeCounter = 0;

  @SuppressWarnings("static-access")
  public Manager() {
    this.staff = new Employee[20];
    this.employeeCounter = 0;
  }

  @SuppressWarnings("static-access")
  public Manager(int empId, String name, int ssn, double salary, String deptName) {
    super(empId, name, ssn, salary);
    this.emp = empId;
    this.deptName = deptName;
    this.man = name;
  }

  @SuppressWarnings("static-access")
  public boolean addEmployee(int empId, String name, int ssn, double salary) {
    
    if(findEmployee(empId)==true) {
      return false;
    }else {
      this.staff[employeeCounter] = new Employee(empId,name,ssn,salary);
      this.employeeCounter +=1; 
      return true;
    }

  }

  public String getDeptName() {
    return deptName;
  }

  @SuppressWarnings("unused")
  public boolean findEmployee(int em) {
<<<<<<< HEAD
    for (int i = 0; i <= employeeCounter; i++) {
=======
    for (int i = 0; i <= 20; i++) {
>>>>>>> 6b3f4d252156e2da132d0cad1d4670218144e3fa
      if (em == this.staff[i].getEmpId()) {
        System.out.println("Employee exist!!");
        return true;
      } else {
        System.out.println("Employee does not exists!!");
        return false;
      }
    }
    return false;


  }

  public void removeEmployee(Employee emp) {
    
    Employee[] dup=new Employee[20];
<<<<<<< HEAD
    for(int i=0,j=0;i<employeeCounter;i++,j++) {
=======
    for(int i=0,j=0;i<20;i++,j++) {
>>>>>>> 6b3f4d252156e2da132d0cad1d4670218144e3fa
      if(emp==staff[j]) {
        j+=1;
      }else {
        dup[i]=staff[j];
      }
      
    }
    for(int i=0;i<20;i++) {
    System.out.println(dup[i]);
 
    }
  }

  public void printManagerDetails() throws NullPointerException {
    System.out.println("++++++++++++++++++++++++");
    System.out.println("Manager : " + man);
<<<<<<< HEAD
    for (int i = 0; i <= employeeCounter; i++) {
=======
    for (int i = 0; i <= 20; i++) {
>>>>>>> 6b3f4d252156e2da132d0cad1d4670218144e3fa
      this.staff[i].empDetails();
      System.out.println();
      System.out.println();
    }

  }

}
