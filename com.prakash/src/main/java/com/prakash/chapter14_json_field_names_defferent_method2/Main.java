package com.prakash.chapter14_json_field_names_defferent_method2;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class TaskCollection implements Iterable<Task>{
    private List<Task> todos = new ArrayList<>();

    @Override
    public Iterator<Task> iterator() {
        return todos.iterator();
    }
}

class Task {
    private String name;
    private String description;
    private int priority;
    private int id;
    private boolean done;

    public Task(String name, String description, int priority, int id, boolean done) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.id = id;
        this.done = done;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}

class TaskDeserializer implements JsonDeserializer<Task> {
    @Override
    public Task deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        return new Task(
                jsonObject.get("title").getAsString(),
                jsonObject.get("body").getAsString(),
                jsonObject.get("priority").getAsInt(),
                jsonObject.get("id").getAsInt(),
                jsonObject.get("done").getAsBoolean()
        );
    }
}

class TaskSerializer implements JsonSerializer<Task> {
    @Override
    public JsonElement serialize(Task src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("title", src.getName());
        jsonObject.addProperty("body", src.getDescription());
        jsonObject.addProperty("priority", src.getPriority());
        jsonObject.addProperty("id", src.getId());
        jsonObject.addProperty("done", src.isDone());
        return jsonObject;
    }
}

public class Main {
    public static void main(String[] args) {
        String jsonData = "{\n" +
                "\"todos\": [\n" +
                "{\n" +
                "\"body\": \"Walk the dog\",\n" +
                "\"done\": false,\n" +
                "\"id\": 0,\n" +
                "\"priority\": 3,\n" +
                "\"title\": \"dog\"\n" +
                "},\n" +
                "{\n" +
                "\"body\": \"Pay the bills\",\n" +
                "\"done\": false,\n" +
                "\"id\": 1,\n" +
                "\"priority\": 1,\n" +
                "\"title\": \"bills\"\n" +
                "}\n" +
                "]\n" +
                "}";
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Task.class, new TaskDeserializer());
        builder.registerTypeAdapter(Task.class, new TaskSerializer());
        Gson gson = builder.create();
        TaskCollection tasks = gson.fromJson(jsonData, TaskCollection.class);
        System.out.println(gson.toJson(tasks));

    }
}
