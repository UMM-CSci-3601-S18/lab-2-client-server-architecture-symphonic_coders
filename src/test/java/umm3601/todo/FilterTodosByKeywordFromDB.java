package umm3601.todo;

import org.junit.Test;

import java.util.Map;
import java.io.IOException;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

public class FilterTodosByKeywordFromDB {

  @Test
  public void filterTodosByKeyword() throws IOException{
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTodos = db.listFilteredTodos(new HashMap<>());

    Todo[] filteredTodos = db.filterTodosByKeyword(allTodos, "tempor");
    assertEquals("Incorrect number of todos returned by keyword", 68, filteredTodos.length);
  }

  @Test
  public void listTodosByKeyword() throws IOException{
    Database db = new Database("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("keyword", new String[] {"tempor"});
    Todo[] listFilteredTodos = db.listFilteredTodos(queryParams);
    assertEquals("Incorrect number of todos returned by keyword", 68, listFilteredTodos.length);
  }
}
