package in.vamsof.servicepackagetodo;

import java.util.List;
import java.util.Map;

import in.vamsoft.todo.TodoDao;
import in.vamsoft.todo.TodoFactory;
import in.vamsoft.todopojos.RegistrationPojos;
import in.vamsoft.todopojos.TaskPojo;

public class ServiceTodo implements TodoInter {
	TodoDao dao = TodoFactory.todoDao();
	
	/* (non-Javadoc)
	 * @see in.vamsof.servicepackagetodo.TodoInter#addTask()
	 */
	@Override
	public List<TaskPojo> addTask(TaskPojo pojo){
		return dao.addTask(pojo);
	}

	@Override
	public Map<String,Object> deletetask(TaskPojo pojo) {
		// TODO Auto-generated method stub
		return dao.deleteTask(pojo);
	}

	

	@Override
	public String addUser(RegistrationPojos registrationPojos) {
		// TODO Auto-generated method stub
		return dao.addUser(registrationPojos);
	}

	@Override
	public boolean checkEmailAvailabilty(String email) {
		// TODO Auto-generated method stub
		return dao.checkEmailAvailabilty(email);
	}

	@Override
	public int Checkpassword(RegistrationPojos pojos) {
		// TODO Auto-generated method stub
		return dao.Checkpassword(pojos);
	}

	
}
