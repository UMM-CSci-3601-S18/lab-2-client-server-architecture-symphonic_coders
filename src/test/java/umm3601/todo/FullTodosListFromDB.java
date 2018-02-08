package umm3601.todo;

import com.sun.xml.internal.bind.v2.TODO;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class FullTodosListFromDB {

  @Test
  public void totalTodosCount() throws IOException {
    Database db = new Database("src/main/data/todos.json");
    Todo[] allTODOS = db.listTodos(new HashMap<>());
    assertEquals("Incorrect total number of todos", 300, allTODOS.length);
  }
}