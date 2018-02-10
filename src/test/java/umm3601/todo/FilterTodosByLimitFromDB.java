package umm3601.todo;

  import org.junit.Test;
  import umm3601.todo.Database;
  import umm3601.todo.Todo;

  import java.io.IOException;
  import java.util.HashMap;
  import java.util.Map;

  import static junit.framework.TestCase.assertEquals;

public class FilterTodosByLimitFromDB {

  @Test
  public void listTodosByLimit() throws IOException{
    Database db = new Database("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("limit", new String[] {"7"});
    Todo[] listTodos7 = db.listTodos(queryParams);
    assertEquals("Server did not properly limit todos", 7, listTodos7.length);
  }
}
