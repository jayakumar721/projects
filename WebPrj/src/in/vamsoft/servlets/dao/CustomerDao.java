package in.vamsoft.servlets.dao;

import java.util.List;

public interface CustomerDao {

  void addCustomer(Customer c);

  List<Customer> getAllCustomerDetails();

}