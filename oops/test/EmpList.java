import java.util.ArrayList;
import java.util.List;

public class EmpList {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Emp e = new Emp();
    Emp e1 = new Emp();
    e.setEmpId(123);
    e.setEmpName("john");
    e1.setEmpId(235);
    e1.setEmpName("peter");
    List<Emp> empList = new ArrayList<>();
    empList.add(e1);
    empList.add(e);
    for (Emp emp : empList) {
      System.out.println(emp);
    }
  }

}
