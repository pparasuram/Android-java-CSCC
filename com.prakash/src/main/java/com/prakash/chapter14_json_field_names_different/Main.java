package com.prakash.chapter14_json_field_names_different;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class ToDo {
    @SerializedName("custom_naming")
    private String body;
    private boolean done;
    private int id;
    private int priority;
    private String title;

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString() {
        return ("body: " + body + "\n done flag: " + done + "\n id: " +
                id + "\n priority: " + priority + "\n title: " + title
        );
    }
}
class ToDos {
    ToDo[] todos = new ToDo[2];
}
public class Main {
    public static void main(String[] args) {
        String jsonData = "{\n" +
                "  \"todos\": [\n" +
                "    {\n" +
                "      \"custom_naming\": \"Walk the dog\",\n" +
                "      \"done\": false,\n" +
                "      \"id\": 0,\n" +
                "      \"priority\": 3,\n" +
                "      \"title\": \"dog\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"custom_naming\": \"Pay the bills\",\n" +
                "      \"done\": false,\n" +
                "      \"id\": 1,\n" +
                "      \"priority\": 1,\n" +
                "      \"title\": \"bills\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        // Gson gson = new Gson();
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.IDENTITY).create();
        ToDos toDos = new ToDos();
        toDos = gson.fromJson(jsonData, ToDos.class);

        for (ToDo todo: toDos.todos) {
            System.out.println(todo);
        }

        // create a string with JSON data
        System.out.println(gson.toJson(toDos));
    }
}