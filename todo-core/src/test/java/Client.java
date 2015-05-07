import com.coop.todo.modal.Todo;
import com.coop.todo.service.TodoService;
import com.coop.todo.servicelocator.ServiceLocator;


public class Client {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		TodoService service = ServiceLocator.instance().getTodoService();
		Todo todo = service.createToDo("i am todo");
		System.out.println(todo.getTitle());
	}

}
