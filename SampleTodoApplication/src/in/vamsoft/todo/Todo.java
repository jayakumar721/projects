package in.vamsoft.todo;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import in.vamsof.servicepackagetodo.ServiceTodo;
import in.vamsof.servicepackagetodo.TodoInter;
import in.vamsoft.todopojos.TaskPojo;

/**
 * Servlet implementation class ToDo
 */
@WebServlet("/Todo")
public class Todo extends HttpServlet {
	private static final long serialVersionUID = 1L;
		HttpSession session;
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		   PrintWriter printWriter = response.getWriter();
		   String task =request.getParameter("task");
		   String operation =request.getParameter("operation");
		  
		
		 if (operation.equals("Add")) {
				
				 request.getSession();
				 request.setAttribute("task", task);
				 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
				 LocalDateTime localdate = LocalDateTime.now();
	   	         TaskPojo pojo = new TaskPojo(task, localdate);
    			
				 TodoInter todoInter = new ServiceTodo();
				 List<TaskPojo>  list = todoInter.addTask(pojo);
					JSONArray array1 = new JSONArray();

				 for (TaskPojo taskPojo : list) {
					    JSONObject json = new JSONObject();
					    try {
							json.put("TaskId", taskPojo.getTaskId());
							json.put("Task", taskPojo.getTask());
							json.put("taskTime", taskPojo.getDate());
						} catch (JSONException e) {
							e.printStackTrace();
						
						}
					    array1.put(json);	
				 }
				 response.getWriter().write(array1.toString());
				 
		 
				
			}
			else if(operation.equals("delete")){
				request.getSession();
				int TaskId=Integer.parseInt(request.getParameter("TaskId"));
				LocalDateTime localdate = LocalDateTime.now();
	   	        TaskPojo pojo = new TaskPojo(TaskId, localdate);
	   	        TodoInter todoInter = new ServiceTodo();
	   	        Map<String, Object> statusMap = todoInter.deletetask(pojo);
	   	        JSONArray array1 = new JSONArray();
	   	        for (Entry<String, Object> taskPojo : statusMap.entrySet()) {
		   	    	JSONObject json = new JSONObject();
		   	    	try {
						json.put(taskPojo.getKey(),taskPojo.getValue());
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		   	    	array1.put(json);
		   	     }	   	     
	   	  
	   	     response.getWriter().write(array1.toString());
	   	     
			}
	}

}
