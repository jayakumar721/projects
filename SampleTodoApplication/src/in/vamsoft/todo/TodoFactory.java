package in.vamsoft.todo;

public class TodoFactory {

	public static TodoDao todoDao(){
		return new TodoDao();
	}
}
