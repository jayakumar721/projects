package in.vamsoft.dao;

import in.vamsoft.model.User;

public interface UserDAO {

  boolean userValidate(User user);

  String getUserName(User user);

  boolean userRegistration(User user);

  boolean verifyUser(String email);

  boolean updatePassword(User user);

}