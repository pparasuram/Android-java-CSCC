package com.prakash.chapter15_http_json_example;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

class HttpException extends IOException {
    public HttpException(HttpResponse response) {
        super(response.getStatusLine().getStatusCode() + ": "
                + response.getStatusLine().getReasonPhrase());
    }
}

class HttpRequests {
    private CloseableHttpClient client = HttpClientBuilder.create().build();

    public HttpRequests (String username, String password){
        CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY,
                new UsernamePasswordCredentials(username, password));
        client = HttpClientBuilder.create()
                .setDefaultCredentialsProvider(credentialsProvider).build();
    }

    // return true if status is between 200 and 300
    private static boolean isSuccess(HttpResponse response) throws IOException {
        StatusLine status = response.getStatusLine();
        return (status.getStatusCode() >= 200 && status.getStatusCode() < 300);
    }

    // send specified request and return response as a string
    private String makeRequest(HttpRequestBase request) throws IOException {
        CloseableHttpResponse response = client.execute(request);
        try {
            if (!isSuccess(response)) {
                throw new HttpException(response);
            }

            return EntityUtils.toString(response.getEntity());
        }
        finally {
            response.close();
        }
    }

    private void addData(HttpEntityEnclosingRequestBase request, String contentType, String data)
            throws UnsupportedEncodingException {
        request.setHeader("Content-type", contentType);

        StringEntity requestData = new StringEntity(data);
        request.setEntity(requestData);
    }


    // send a GET request to the specified URL
    public String get(String url) throws IOException {
        HttpGet request = new HttpGet(url);
        return makeRequest(request);

    }

    // send a DELETE request to the specified URL
    public String delete(String url) throws IOException {
        HttpDelete request = new HttpDelete(url);
        return makeRequest(request);
    }

    // send a POST request to the specified URL with the specified data
    // and the specified content-type
    public String post(String url, String contentType, String data) throws IOException{
        HttpPost request = new HttpPost(url);
        addData(request, contentType, data);
        return makeRequest(request);
    }

    // send a PUT request to the specified URL with the specified data
    // and the specified content-type
    public String put(String url, String contentType, String data) throws IOException{
        HttpPut request = new HttpPut(url);
        addData(request, contentType, data);
        return makeRequest(request);
    }
}

// a To-do class with a basic constructor, getters, and setters
class Todo {
    private String title;
    private String body;
    private int priority;
    private Integer id = null; //only set an int when the server assigns an ID

    public Todo(String title, String body, int priority) {
        this.title = title;
        this.body = body;
        this.priority = priority;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TODO ID: " + id + ", Title: " + title + ", Body: " + body
                + ", Priority: " + priority;
    }
}

// a collection of Todos; only support iteration
class TodoCollection implements Iterable<Todo> {
    private List<Todo> todos;


    @Override
    public Iterator<Todo> iterator() {
        return todos.iterator();
    }
}

class TodoAPIWrapper {
    Gson gson = new Gson();
    private HttpRequests requests;
    private String hostURL;

    TodoAPIWrapper(String username, String password, String hostURL) {
        requests = new HttpRequests(username, password);
        this.hostURL = hostURL;
    }

    // get all the todos
    public TodoCollection getTodos() {
        String url = hostURL + "/todos/api/v1.0/todos";
        try {
            String response = requests.get(url);
            return gson.fromJson(response, TodoCollection.class);
        } catch (IOException e) {
            System.out.println("Unable to get todos");
        }
        return null;
    }

    // create a new todo
    public Todo createTodo(String title, String body, int priority) {
        Todo newTodo = new Todo(title, body, priority);
        String url = hostURL + "/todos/api/v1.0/todo/create";
        String contentType  = "application/json";
        String postData = gson.toJson(newTodo);
        try {
            requests.post(url, contentType, postData);
            return newTodo;
        } catch (IOException e) {
            System.out.println("Unable to create new task: " + title);
        }
        return null;
    }
    // get a todo by id
    // api returns a todo nested in a JSON object,
    // need to use nested object with GSON
    public Todo getTodo(int id) {
        String url = hostURL + "/todos/api/v1.0/todo/" + id;
        try {
            String response = requests.get(url);
            JsonParser parser = new JsonParser();
            JsonObject jsonObject = parser.parse(response).getAsJsonObject();
            return gson.fromJson(jsonObject.get("todo").toString(), Todo.class);
        } catch (IOException e) {
            System.out.println("Unable to get todo with id" + id);
        }
        return null;
    }

    // get first todo that matches title
    public Todo getTodo(String title) {
        TodoCollection todos = getTodos();
        for (Todo todo: todos) {
            if (todo.getTitle().equals(title)) {
                return todo;
            }
        }
        return null;
    }

    // delete a todo by id
    public boolean removeTodo(int id) {
        String url = hostURL + "/todos/api/v1.0/todo/delete/" + id;
        try {
            requests.delete(url);
            return true;
        }
        catch (IOException e) {
            System.out.println("Unable to delete todo with ID " + id);
        }
        return false;
    }

    // update a tod
    public Todo updateTodo(Todo todo) {
        if (todo.getId() == null)
            return null;
        String url = hostURL + "/todos/api/v1.0/todo/update/"+todo.getId();
        // System.out.println(url);
        String contentType  = "application/json";
        String putData = gson.toJson(todo);
        try {
            requests.put(url, contentType, putData);
            return todo;
        } catch (IOException e) {
            System.out.println("Unable to update task: " + todo.getId() + " title: " + todo.getTitle());
        }
        return null;
    }


}

public class Main {
    public static void main(String[] args) {
        TodoAPIWrapper todoAPI = new TodoAPIWrapper("prakash", "prakash",
                "http://todo.eastus.cloudapp.azure.com/todo-android");

        // create two todos
        System.out.println("Adding todos");
        todoAPI.createTodo("Study", "Study for exam", 2);
        todoAPI.createTodo("Dinner", "Prepare dinner", 3);

        // create todo with id 0

        // System.out.println("Creating todo with id 0");
        // todoAPI.createTodo("run", "jogging for fun", 2, 0);

        // get todos and list them
        System.out.println("Getting todos");
        TodoCollection todos = todoAPI.getTodos();
        for (Todo todo: todos) {
            System.out.println(todo);
        }
        // update todo with id 1

        System.out.println("Updating todo with id: 1");

        System.out.println("Getting the todo 1");

        Todo updateTodo = todoAPI.getTodo(1);

        System.out.println(updateTodo);

        System.out.println("Updating the todo 1");

        updateTodo.setBody("Body build");
        updateTodo.setTitle("Exercise body");
        updateTodo.setPriority(1);
        // System.out.println(updateTodo);
        updateTodo = todoAPI.updateTodo(updateTodo);
        System.out.println("Updated todo is");
        System.out.println(updateTodo);
        // remove todo with id 0
        System.out.println("Removing todo");
        todoAPI.removeTodo(0);

        //get remaining todos and list them
        System.out.println("Getting remaining todos");
        todos = todoAPI.getTodos();
        for (Todo todo: todos) {
            System.out.println(todo);
        }

    }
}