function getAllTodos() {
  console.log("Getting all the todos.");

  var HttpThingy = new HttpClient();
  HttpThingy.get("/api/todos", function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}


function filterTodosByLimit() {
  console.log("Filtering the todos");

  var HttypThingy = new HttpClient();
  HttypThingy.get("/api/todos?limit=" + document.getElementById("limit").value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function filterTodosByKeyword() {
  console.log("Filtering the todos");

  var HttypThingy = new HttpClient();
  HttypThingy.get("/api/todos?keyword=" + document.getElementById("keyword").value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function filterTodosByID() {
  console.log("Filtering the todos");

  var HttypThingy = new HttpClient();
  HttypThingy.get("/api/todos?_id=" + document.getElementById("_id").value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function filterTodosByStatus() {
  console.log("Filtering the todos");

  var HttypThingy = new HttpClient();
  HttypThingy.get("/api/todos?status=" + document.getElementById("status").value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

function filterTodosByOwner() {
  console.log("Filtering the todos");

  var HttypThingy = new HttpClient();
  HttypThingy.get("/api/todos?owner=" + document.getElementById("owner").value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}


function filterTodosByCategory() {
  console.log("Filtering the todos");

  var HttypThingy = new HttpClient();
  HttypThingy.get("/api/todos?category=" + document.getElementById("category").value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}

//Basic idea of how to multiple by multiple parameters, starting with just two
/*
function filterTodosByOwnerAndKeyword() {
  console.log("Filtering the todos");

  var HttypThingy = new HttpClient();
  HttypThingy.get("/api/todos?owner=" + document.getElementById("owner").value + "&keyword=" + document.getElementById("keyword").value, function (returned_json) {
    document.getElementById('jsonDump').innerHTML = returned_json;
  });
}
*/

//Actual implementation of multiple parameter filtering
//Currently will not return anything if a field is empty even if other fields are populated
//Not sure why yet
function filterTodos() {
  console.log("Filtering the todos");

  var HttypThingy = new HttpClient();
  HttypThingy.get("/api/todos?keyword=" + document.getElementById("keyword").value
                //+ "&status=" + document.getElementById("status").value
                //+ "&_id=" + document.getElementById("keyword").value
                + "&owner=" + document.getElementById("owner").value
                //+ "&category" + document.getElementById("category").value
                //+ "&limit=" + document.getElementById("limit").value
    , function (returned_json) {
      document.getElementById('jsonDump').innerHTML = returned_json;
    });
}


function HttpClient() {
  // We'll take a URL string, and a callback function.
  this.get = function(aUrl, aCallback){
    var anHttpRequest = new XMLHttpRequest();

    // Set a callback to be called when the ready state of our request changes.
    anHttpRequest.onreadystatechange = function(){

      /**
       * Only call our 'aCallback' function if the ready state is 'DONE' and
       * the request status is 200 ('OK')
       *
       * See https://httpstatuses.com/ for HTTP status codes
       * See https://developer.mozilla.org/en-US/docs/Web/API/XMLHttpRequest/readyState
       *  for XMLHttpRequest ready state documentation.
       *
       */
      if (anHttpRequest.readyState === 4 && anHttpRequest.status === 200)
        aCallback(anHttpRequest.responseText);
    };

    anHttpRequest.open("GET", aUrl, true);
    anHttpRequest.send(null);
  }
}
