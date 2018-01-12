package in.vamsoft.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import in.vamsoft.model.Employee;

public class HibernateUtil {

  private static SessionFactory sessionFactory=null;
  public static SessionFactory getSessionFactory() {
    System.out.println("HibernateUtil.getSessionFactory()");
    sessionFactory = new Configuration().addPackage("in.vamsoft.model").addAnnotatedClass(Employee.class).configure("/resources/hibernate.cfg.xml").buildSessionFactory();
    return sessionFactory;
  }
  
}
