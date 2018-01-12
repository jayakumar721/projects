package in.vamsoft.todopojos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskPojo {
   private int taskId;
   private String Task;
   private LocalDateTime date;
   private LocalDateTime edate;
			public TaskPojo(LocalDateTime edate) {
	super();
	this.edate = edate;
}
			public LocalDateTime getEdate() {
	return edate;
}
public void setEdate(LocalDateTime edate) {
	this.edate = edate;
}
			public String getTask() {
				return Task;
			}
			public void setTask(String task) {
				Task = task;
			}
			public LocalDateTime getDate() {
				return date;
			}
			public void setDate(LocalDateTime date) {
				this.date = date;
			}
			
			public int getTaskId() {
				return taskId;
			}
			public void setTaskId(int taskId) {
				this.taskId = taskId;
			}
			public TaskPojo(String task, LocalDateTime date) {
				super();
				Task = task;
				this.date = date;
			}
			
			public TaskPojo(int taskId, String task, LocalDateTime date) {
				super();
				this.taskId = taskId;
				Task = task;
				this.date = date;
			}
			public TaskPojo() {
				// TODO Auto-generated constructor stub
			}
		    
			public TaskPojo(int taskId, LocalDateTime date) {
				super();
				this.taskId = taskId;
				this.date = date;
			}
			@Override
			public String toString() {
				return "TaskPojo [taskId=" + taskId + ", Task=" + Task + ", date=" + date + "]";
			}
					   
		   
		
   
}
