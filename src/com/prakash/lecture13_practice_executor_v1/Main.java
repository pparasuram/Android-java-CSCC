package com.prakash.lecture13_practice_executor_v1;
import java.util.*;
import java.util.concurrent.*;

// a class to simulate data retrieval
class SomeClass implements Callable<String> {
    String url;
    public SomeClass(String url) {
        this.url = url;
    }
    public String call () throws Exception {
        System.out.println("Retrieving URL: " + url);
        return SiteDownloader.get(url);
    }
}
class SiteDownloader {
    // a method to retrieve
    static String get(String URL) {
        switch (URL) {
            case "http://www.weather.gov":
                return "Weather forecast";
            case "http://www.espn.com":
                return "Sports scores";
            case "http://www.marketwatch.com":
                return "Stock market date";
            case "http://www.fandango.com":
                return "Movie showtimes";
        }
        return "";    }
}
public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        List<Future<String>> results = new ArrayList<>();
        String[] urls = {"http://www.weather.gov", "http://www.espn.com",
                "http://www.marketwatch.com", "http://www.fandango.com"};
        //submit tasks to executor service
        for (String url : urls) {
            /*
            Callable callable = new Callable<String>() {
                @Override
                public String call() throws Exception {
                    System.out.println("Retrieving URL: " + url);
                    return SiteDownloader.get(url);
                }
            };
            */
            SomeClass someClass = new SomeClass(url);
            System.out.println("Submitting task for " + url);
            results.add(executor.submit(someClass));
        }
        // wait for tasks to finish
        boolean done = false;
        while (!done) {
            System.out.println("Still getting data...");
            done = true;
            for (Future<String> result : results) {
                if (!result.isDone()) {
                    done = false;
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            for (Future<String> result : results) {
                System.out.println("Site data: " + result.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}