package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterTodosByStatusFromDB {

  @Test
  public void filterTodosByStatusComplete() throws IOException{
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] filteredTodos = db.filterTodosByStatus(allTodos, true);
    assertEquals("Incorrect number of todos returned by status complete", 143, filteredTodos.length);
  }

  @Test
  public void listTodosByStatusComplete() throws IOException{
    Database db = new Database("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("status", new String[] {"true"});
    Todo[] listFilteredTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos returned by status complete", 143, listFilteredTodos.length);
  }

  @Test
  public void filterTodosByStatusIncomplete() throws IOException{
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] filteredTodos = db.filterTodosByStatus(allTodos, false);
    assertEquals("Incorrect number of todos returned by status incomplete", 157, filteredTodos.length);
  }

  @Test
  public void listTodosByStatusIncomplete() throws IOException{
    Database db = new Database("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("status", new String[] {"false"});
    Todo[] listFilteredTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos returned by status incomplete", 157, listFilteredTodos.length);
  }

}
