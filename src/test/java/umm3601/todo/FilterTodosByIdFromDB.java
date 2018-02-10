package umm3601.todo;

import org.junit.Test;
import umm3601.todo.Database;
import umm3601.todo.Todo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterTodosByIdFromDB {

  @Test
  public void filterTodosById() throws IOException {
    umm3601.todo.Database db = new umm3601.todo.Database("src/main/data/todos.json");
    Todo[] allTodos = db.listTodos(new HashMap<>());

    Todo[] id58895985186754887e0381f5Filter = db.filterTodosById(allTodos, "58895985186754887e0381f5");
    assertEquals("Incorrect number of todos with Id 58895985186754887e0381f5", 1, id58895985186754887e0381f5Filter.length);

    Todo[] id58895985223ab2f3822cb856Filter = db.filterTodosById(allTodos, "58895985223ab2f3822cb856");
    assertEquals("Incorrect number of todos with id 58895985223ab2f3822cb856", 1, id58895985223ab2f3822cb856Filter.length);
  }

  @Test
  public void listTodosWithIdFilter() throws IOException {
    umm3601.todo.Database db = new Database("src/main/data/todos.json");
    Map<String, String[]> queryParams = new HashMap<>();

    queryParams.put("_id", new String[] {"58895985f4dfa75aa1882a2a"});
    Todo[] id58895985f4dfa75aa1882a2aTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with id 58895985f4dfa75aa1882a2a", 1, id58895985f4dfa75aa1882a2aTodos.length);

    queryParams.put("_id", new String[] {"58895985f0a4bbea24084abf"});
    Todo[] id58895985f0a4bbea24084abfTodos = db.listTodos(queryParams);
    assertEquals("Incorrect number of todos with id 58895985f0a4bbea24084abf", 1, id58895985f0a4bbea24084abfTodos.length);
  }
}
