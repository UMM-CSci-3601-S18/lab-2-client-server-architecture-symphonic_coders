package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class SortingTodos {

  @Test
  public void sortTodosByOwner() throws IOException{
    Database db = new Database("src/main/data/testtodos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("order", new String[] {"owner"});
    Todo[] listFilteredTodos = db.listFilteredTodos(queryParams);
    assertEquals("Incorrect number of todos returned by sorting the todos", 3, listFilteredTodos.length);
    assertEquals("Wrong todo at start of list", "58895985a22c04e761776d54", listFilteredTodos[0]._id);
    assertEquals("Wrong todo at start of list", "58895985c1849992336c219b", listFilteredTodos[1]._id);
    assertEquals("Wrong todo at start of list", "58895985ae3b752b124e7663", listFilteredTodos[2]._id);
  }

  @Test
  public void sortTodosByCategory() throws IOException{
    Database db = new Database("src/main/data/testtodos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("order", new String[] {"category"});
    Todo[] listFilteredTodos = db.listFilteredTodos(queryParams);
    assertEquals("Incorrect number of todos returned by sorting the todos", 3, listFilteredTodos.length);
    assertEquals("Wrong todo at start of list", "58895985ae3b752b124e7663", listFilteredTodos[0]._id);
    assertEquals("Wrong todo at start of list", "58895985a22c04e761776d54", listFilteredTodos[1]._id);
    assertEquals("Wrong todo at start of list", "58895985c1849992336c219b", listFilteredTodos[2]._id);
  }

  @Test
  public void sortTodosByStatus() throws IOException{
    Database db = new Database("src/main/data/testtodos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("order", new String[] {"status"});
    Todo[] listFilteredTodos = db.listFilteredTodos(queryParams);
    assertEquals("Incorrect number of todos returned by sorting the todos", 3, listFilteredTodos.length);
    assertEquals("Wrong todo at start of list", "58895985a22c04e761776d54", listFilteredTodos[0]._id);
    assertEquals("Wrong todo at start of list", "58895985c1849992336c219b", listFilteredTodos[1]._id);
    assertEquals("Wrong todo at start of list", "58895985ae3b752b124e7663", listFilteredTodos[2]._id);
  }

  @Test
  public void sortTodosByBody() throws IOException{
    Database db = new Database("src/main/data/testtodos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("order", new String[] {"body"});
    Todo[] listFilteredTodos = db.listFilteredTodos(queryParams);
    assertEquals("Incorrect number of todos returned by sorting the todos", 3, listFilteredTodos.length);
    assertEquals("Wrong todo at start of list", "58895985a22c04e761776d54", listFilteredTodos[0]._id);
    assertEquals("Wrong todo at start of list", "58895985c1849992336c219b", listFilteredTodos[1]._id);
    assertEquals("Wrong todo at start of list", "58895985ae3b752b124e7663", listFilteredTodos[2]._id);
  }
}
