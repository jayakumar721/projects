package in.vamsof.servicepackagetodo;

import java.util.List;
import java.util.Map;

import in.vamsoft.todopojos.RegistrationPojos;
import in.vamsoft.todopojos.TaskPojo;

public interface TodoInter {

	List<TaskPojo> addTask(TaskPojo pojo);

	 Map<String,Object> deletetask(TaskPojo pojo);


	String addUser(RegistrationPojos registrationPojos);

	boolean checkEmailAvailabilty(String email);

	int Checkpassword(RegistrationPojos pojos);

}