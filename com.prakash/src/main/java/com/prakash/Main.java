package com.prakash;

/**
 * Created by PARASUP on 11/29/2016.
 */
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.List;
import java.util.Map;

class Forecast{
    private String name;
    private List<Double> forecast;

    @Override
    public String toString() {
        String returnValue = "The forecast for " + name + " is:" + "Prakash";
        for (Double temperature:forecast){

        }
        return super.toString();
    }
}
public class Main {
    public static void  main(String[] args){
        System.out.println("Hello World!");
        String jsonData = "{" +
                "       \"name\": \"columbus\", " +
                "        \"forecast\": " +
                "[40, 50, 65, 60, 70]" +
                "}";
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(jsonData).getAsJsonObject();
        for (Map.Entry<String,JsonElement>entry: jsonObject.entrySet()){
            if(entry.getValue().isJsonArray()){
                // value is an array
                JsonArray jsonArray = entry.getValue().getAsJsonArray();
                for (JsonElement element: jsonArray){
                    System.out.println(entry.getKey() + " has element " + element.toString());
                }
            }
            else
            {
                System.out.println(entry.getKey() + " has value "+ entry.getKey());
            }
        }
    }
}
