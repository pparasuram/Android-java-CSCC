package com.prakash.chapter15_in_class_1;


import org.apache.http.HttpResponse;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import java.io.IOException;

class HttpException extends IOException {
    public HttpException (HttpResponse response) {
        super(response.getStatusLine().getStatusCode() + "; "
                + response.getStatusLine().getReasonPhrase());
    }
}


/**
 * Created by PARASUP on 12/6/2016.
 */


public class Main {
}
