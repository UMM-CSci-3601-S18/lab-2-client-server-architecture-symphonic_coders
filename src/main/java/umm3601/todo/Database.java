package umm3601.todo;

import com.google.gson.Gson;

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
    if(queryParams.containsKey("_id") && !(queryParams.get("_id")[0].equals(""))){
      String targetId = queryParams.get("_id")[0];
      filteredTodos = filterTodosById(filteredTodos, targetId);
    }

    if(queryParams.containsKey("status") && !(queryParams.get("status")[0].equals(""))){
      Boolean targetStatus = Boolean.parseBoolean(queryParams.get("status")[0]);
      filteredTodos = filterTodosByStatus(filteredTodos, targetStatus);
    }

    if(queryParams.containsKey("keyword") && !(queryParams.get("keyword")[0].equals(""))){
      String targetKeyword = queryParams.get("keyword")[0];
      filteredTodos = filterTodosByKeyword(filteredTodos, targetKeyword);
    }

    if(queryParams.containsKey("owner") && !(queryParams.get("owner")[0].equals(""))){
      String targetOwner = queryParams.get("owner")[0];
      filteredTodos = filterTodosByOwner(filteredTodos, targetOwner);
    }

    if(queryParams.containsKey("category") && !(queryParams.get("category")[0].equals(""))){
      String targetCategory = queryParams.get("category")[0];
      filteredTodos = filterTodosByCategory(filteredTodos, targetCategory);
    }

    if(queryParams.containsKey("limit") && !(queryParams.get("limit")[0].equals(""))){
      int todoLimit = Integer.parseInt(queryParams.get("limit")[0]);
      Todo[] tempTodos = new Todo[todoLimit];
      for(int i = 0; i < todoLimit; i++){
        tempTodos[i] = filteredTodos[i];
      }
      filteredTodos = tempTodos;
    }

    //Doesn't work
    /*
    if(queryParams.containsKey("order") && !(queryParams.get("order")[0].equals(""))){
      if(queryParams.get("order").equals("owner")){
        SortExample.sortByOwner(filteredTodos);
      }
    }
    */

    return filteredTodos;
  }

  public Todo[] filterTodosById(Todo[] todos, String targetId) {
    return Arrays.stream(todos).filter(x -> x._id.equals(targetId)).toArray(Todo[]::new);
  }

  public Todo[] filterTodosByStatus(Todo[] todos, Boolean targetStatus){
    return Arrays.stream(todos).filter(x -> x.status == targetStatus).toArray(Todo[]::new);
  }

  public Todo[] filterTodosByKeyword(Todo[] todos, String targetKeyword){
    return Arrays.stream(todos).filter(x -> x.body.contains(targetKeyword)).toArray(Todo[]::new);
  }

  private Todo[] filterTodosByOwner(Todo[] todos, String targetOwner){
    return Arrays.stream(todos).filter(x -> x.owner.equals(targetOwner)).toArray(Todo[]::new);
  }

  private Todo[] filterTodosByCategory(Todo[] todos, String targetCategory){
    return Arrays.stream(todos).filter(x -> x.category.equals(targetCategory)).toArray(Todo[]::new);
  }

}
