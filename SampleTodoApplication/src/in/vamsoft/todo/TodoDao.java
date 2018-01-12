package in.vamsoft.todo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.catalina.connector.Request;

import com.mysql.jdbc.Statement;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import in.vamsof.servicepackagetodo.TodoInter;
import in.vamsoft.todopojos.RegistrationPojos;
import in.vamsoft.todopojos.TaskPojo;

public class TodoDao {
	Connection connection;
	ResultSet resultSet;
	
	public TodoDao() {
		// TODO Auto-generated constructor stub
		connection =DBConnectionUtil.getConnection();
	}	

	public List<TaskPojo> addTask(TaskPojo pojo) {
		List<TaskPojo> list = new ArrayList<> ();
		String Active= "Active";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("insert into taskDetails (`TaskName`, `Time`,`status` ) values (?,?,?)",Statement.RETURN_GENERATED_KEYS);
			preparedStatement.setString(1, pojo.getTask());
			preparedStatement.setTimestamp(2,Timestamp.valueOf( pojo.getDate()));
			preparedStatement.setString(3, Active);
		    int	resultSet=preparedStatement.executeUpdate();
			if(resultSet>0) {
				ResultSet resultSet1 =preparedStatement.getGeneratedKeys();
				resultSet1.next();
				int rs = resultSet1.getInt(1);
				PreparedStatement preparedStatement1 = connection.prepareStatement("Select taskId,TaskName,Time from taskDetails where status='Active'  order by taskId desc limit 5");
			    ResultSet resultSet2 = preparedStatement1.executeQuery();

			    while(resultSet2.next()) {
			    TaskPojo pojo2 = new TaskPojo();
			     pojo2.setTaskId(resultSet2.getInt(1));
			     pojo2.setTask(resultSet2.getString(2));
			     LocalDateTime dateTime = resultSet2.getTimestamp(3).toLocalDateTime();
			     pojo2.setDate(dateTime);
			     System.out.println(pojo2);
			     list.add(pojo2);
			     
			    
			    }
			  
			    
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		 return list;
	}

	public Map<String,Object> deleteTask(TaskPojo pojo) {
		List<TaskPojo> activeList = new ArrayList<> ();
		List<TaskPojo> inActiveList = new ArrayList<> ();
		String InActive= "InActive";
		try {
			PreparedStatement preparedStatement =connection.prepareStatement("update taskDetails set `status`=? ,`EndTime`=? where taskId =? ");
			preparedStatement.setString(1, InActive);
			preparedStatement.setTimestamp(2, Timestamp.valueOf( pojo.getDate()));
			preparedStatement.setInt(3, pojo.getTaskId());
			  int	resultSet=preparedStatement.executeUpdate();
				if(resultSet>0) {
     				PreparedStatement preparedStatement1 = connection.prepareStatement("Select taskId,TaskName,Time from taskDetails where status='Active'  order by taskId desc limit 5");
				    ResultSet resultSet2 = preparedStatement1.executeQuery();
    			    while(resultSet2.next()) {
				    TaskPojo pojo2 = new TaskPojo();
				     pojo2.setTaskId(resultSet2.getInt(1));
				     pojo2.setTask(resultSet2.getString(2));
				     LocalDateTime dateTime = resultSet2.getTimestamp(3).toLocalDateTime();
				     pojo2.setDate(dateTime);
				     System.out.println(pojo2);
				     activeList.add(pojo2);
				    }
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			PreparedStatement preparedStatementCompleted =connection.prepareStatement("Select taskId,TaskName,Time from taskDetails where status=?  order by taskId desc limit 5");
			preparedStatementCompleted.setString(1, InActive);
			  ResultSet	resultSet=preparedStatementCompleted.executeQuery();
				while(resultSet.next()) {
    			    while(resultSet.next()) {
				    TaskPojo pojo2 = new TaskPojo();
				     pojo2.setTaskId(resultSet.getInt(1));
				     pojo2.setTask(resultSet.getString(2));
				     LocalDateTime dateTime = resultSet.getTimestamp(3).toLocalDateTime();
				     pojo2.setDate(dateTime);
				     LocalDateTime dateTime1 = resultSet.getTimestamp(3).toLocalDateTime();
				     pojo2.setEdate(dateTime1);
				     System.out.println(pojo2);
				     inActiveList.add(pojo2);
				    }
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<String,Object> statusHolder = new HashMap<>();
		statusHolder.put("activeList",activeList);
		statusHolder.put("inActiveList",inActiveList);
		
		System.out.println(statusHolder);
		return statusHolder;
	}

	public String addUser(RegistrationPojos registrationPojos) {
		System.out.println("In new user");
		String InActive ="Active";
		try {
		PreparedStatement preparedStatement = connection.prepareStatement("insert into userDetails (`userName`, `password`,`email`,`status`,emailHashcode ) values (?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, registrationPojos.getName());
		preparedStatement.setString(2, registrationPojos.getEncodedPassword());
		preparedStatement.setString(3,registrationPojos.getEmail());
		preparedStatement.setString(4, InActive);
		preparedStatement.setString(5, registrationPojos.getEmailHashcode());
	    int	resultSet=preparedStatement.executeUpdate();
		if(resultSet>0) {
			
		  return "User Added SuccessFully";
		    
		}
		else {
		  return "Error ";
		}
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	// TODO Auto-generated method stub
	 return null;
	}

	public boolean checkEmailAvailabilty(String emString) {
		// TODO Auto-generated method stub
		System.out.println("In Check Availabilty" +emString);
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("select `email` from userDetails where email=?");
			preparedStatement.setString(1, emString);
			ResultSet result=preparedStatement.executeQuery();
			while(result.next()) {
				if(emString.equalsIgnoreCase(result.getString(1))){
					
					return true;
				}
				else{
					return false;
					}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public int Checkpassword(RegistrationPojos pojos) {
		try {
			PreparedStatement preparedStatement =connection.prepareStatement("select `userId`,`email`,`password` from userDetails where email=?");
			preparedStatement.setString(1, pojos.getEmail());
			ResultSet resulRow = preparedStatement.executeQuery();
			if(!(resulRow.wasNull())) {
				System.out.println("In true");
				while (resulRow.next()) {
				 byte[] decoder =Base64.decode(resulRow.getString(3));
				 String decodedPassword = new String(decoder);
				 if(pojos.getPassword().equals(decodedPassword)) {
					 System.out.println("correct details");
					 return resulRow.getInt(1);
				 }
				 else {
					 return 0;
				 }
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  catch (NullPointerException e) {
			e.printStackTrace();
		}
		 return 1;
	}

	
}
