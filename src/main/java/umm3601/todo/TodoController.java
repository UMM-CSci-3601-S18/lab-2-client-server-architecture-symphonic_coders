package umm3601.todo;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import spark.Request;
import spark.Response;

import static umm3601.Util.buildFailJsonResponse;
import static umm3601.Util.buildSuccessJsonResponse;

public class TodoController {

  private final Gson gson;
  private Database database;


  public TodoController(Database database) {
    gson = new Gson();
    this.database = database;
  }


  public JsonObject getTodo(Request req, Response res) {
    res.type("application/json");
    String id = req.params("id");
    Todo todo = database.getTodo(id);
    if (todo != null) {
      return buildSuccessJsonResponse("todo", gson.toJsonTree(todo));
    } else {
      String message = "Todo with ID " + id + " wasn't found.";
      return buildFailJsonResponse("id", message);
    }
  }


  public JsonObject getAllTodos(Request req, Response res){
    res.type("application/json");
    Todo[] todos = database.listAllTodos(req.queryMap().toMap());
    return buildSuccessJsonResponse("todos", gson.toJsonTree(todos));
  }

  public JsonObject getFilteredTodos(Request req, Response res) {
    res.type("application/json");
    Todo[] todos = database.listFilteredTodos(req.queryMap().toMap());
    return buildSuccessJsonResponse("todos", gson.toJsonTree(todos));
  }
}
