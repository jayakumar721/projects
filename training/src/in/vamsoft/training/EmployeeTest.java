package in.vamsoft.training;

public class EmployeeTest {

  /**
   * @param args .
   */
  public static void main(String[] args) {

    final Employee emp1 = new Employee(1, "jk", 20000.0);
    emp1.setEmpName("jk a");

    System.out.println(emp1.getEmpCode());
    System.out.println(emp1.getEmpName());
    System.out.println("before increment:" + emp1.getSalary());

    emp1.setIncrement(5000.0);
    System.out.println("after increment:" + emp1.getSalary());

    final Employee emp2 = new Employee(2, "ram");

    System.out.println(emp2.getEmpCode());
    System.out.println(emp2.getEmpName());
    System.out.println("before increment:" + emp2.getSalary());

    emp2.setIncrement(5000.0);
    System.out.println("after increment:" + emp2.getSalary());

  }

}
