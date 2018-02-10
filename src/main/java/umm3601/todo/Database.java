package umm3601.todo;

import com.google.gson.Gson;
import com.sun.xml.internal.bind.v2.TODO;
import umm3601.todo.Todo;
import umm3601.user.User;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class Database {
  private Todo[] allTodos;

  public Database(String todoDataFile) throws IOException {
    Gson gson = new Gson();
    FileReader reader = new FileReader(todoDataFile);
    allTodos = gson.fromJson(reader, Todo[].class);
  }

  public Todo getTodo(String id) {
    return Arrays.stream(allTodos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
  }

  public Todo[] listTodos(Map<String, String[]> queryParams) {
    Todo[] filteredTodos = allTodos;

    //Filter todos if defined
    if(queryParams.containsKey("_id")){
      String targetId = queryParams.get("_id")[0];
      filteredTodos = filterTodosById(filteredTodos, targetId);
    }

    return filteredTodos;
  }

  public Todo[] filterTodosById(Todo[] todos, String targetId) {
    return Arrays.stream(todos).filter(x -> x._id.equals(targetId)).toArray(Todo[]::new);
  }

}
