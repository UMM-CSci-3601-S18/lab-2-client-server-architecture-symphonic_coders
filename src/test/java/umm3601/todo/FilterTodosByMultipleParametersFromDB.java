package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterTodosByMultipleParametersFromDB {

  @Test
  public void filterByAllParameters()  throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("owner", new String[] {"Blanche"});
    queryParams.put("category", new String[] {"software design"});
    queryParams.put("keyword", new String[] {"tempor"});
    queryParams.put("status", new String[] {"false"});

    System.out.println(queryParams);

    Todo[] filteredTodos = db.listFilteredTodos(queryParams);
    assertEquals("Incorrect number of todos returned by filtered parameters", 1, filteredTodos.length);  }
}
