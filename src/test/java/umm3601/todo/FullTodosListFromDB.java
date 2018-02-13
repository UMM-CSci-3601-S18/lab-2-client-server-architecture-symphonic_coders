package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class FullTodosListFromDB {

  @Test
  public void totalTodosCount() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTODOS = db.listAllTodos(new HashMap<>());
    assertEquals("Incorrect total number of todos", 300, allTODOS.length);
  }
}
