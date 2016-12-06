package com.prakash.chapter14_json_1;
/**
 * Created by PARASUP on 11/29/2016.
 */
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;


// a class representing a city's forecast
class Forecast {
    private String name;
    private List<Double> forecast;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getForecast() {
        return new ArrayList<Double>(forecast);
    }

    public void setForecast(List<Double> forecast) {
        this.forecast = forecast;
    }

    public String toString() {
        List<String> forecastStrings = new ArrayList<String>();
        for (Double temp: forecast) {
            forecastStrings.add(temp.toString());
        }
        List<String> list = Arrays.asList("Alice", "Bob", "Charlie");

        String forecastString = String.join(", ", forecastStrings);
        return String.format("The forecast for %s: is %s", name, forecastString);
    }
}


public class Main {
    public static void  main(String[] args){
        System.out.println("Hello World PP!");
        String jsonData = "{" +
                "       \"name\": \"columbus\", " +
                "        \"forecast\": " +
                "[40, 50, 65, 60, 70]" +
                "}";
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(jsonData).getAsJsonObject();
        Forecast forecast = new Forecast();
        ArrayList<Double> oneForecast = new ArrayList<Double>();
        for (Map.Entry<String,JsonElement>entry: jsonObject.entrySet()){
            if(entry.getValue().isJsonArray()){
                // value is an array
                JsonArray jsonArray = entry.getValue().getAsJsonArray();
                for (JsonElement element: jsonArray){
                    // System.out.println(entry.getKey() + " has element " + element.toString());
                    oneForecast.add(Double.parseDouble(element.toString()));
                }
                forecast.setForecast(oneForecast);
            }
            else
            {
                // System.out.println();
                forecast.setName(entry.getValue().toString());
            }
        }
        System.out.println(forecast.toString());
    }
}
