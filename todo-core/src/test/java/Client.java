import com.coop.todo.modal.Todo;
import com.coop.todo.service.TodoService;
import com.coop.todo.servicelocator.ServiceLocator;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/*Gson gson = new GsonBuilder().create();
		
		TodoService service = ServiceLocator.instance().getTodoService();
		Todo todo = new Todo();
		todo.setTitle("Complete stuff..");
		todo.setContent("complete the app");
		service.createTodo(todo);
		System.out.println(gson.toJson(todo));*/
		String path = "/123d-dkj";
		System.out.println(path.substring(1));
	}

}
