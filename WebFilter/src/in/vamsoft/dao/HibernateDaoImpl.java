package in.vamsoft.dao;

import java.util.List;

import javax.persistence.NamedQuery;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import in.vamsoft.model.Department;
import in.vamsoft.model.Employee;

@NamedQuery(name="empdetails", query="select * from empcpy where deptid=:did")
public class HibernateDaoImpl {
  
  SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
  Session session = null;
  
  public List<Department> getAllDept() {
    session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    List<Department> list = session.createCriteria(Department.class).list();
    transaction.commit();
    return list;
  }
  
  public List<Employee> getEmoloyeeByDept(int deptid){
    
    session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    
    
    Query q = session.getNamedQuery("empdetails").setInteger("did", deptid);
    List<Employee> list = q.getResultList();
    transaction.commit();
    return list;
    
  }

}
