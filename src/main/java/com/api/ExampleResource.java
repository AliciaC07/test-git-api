package com.api;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Path("/hello")
public class ExampleResource {

    private final String url =
            "https://api.github.com/repos/AinsaWeb-Dominicana/neo-routemee-loans-dashboard/actions/workflows";


    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        return "Hello from RESTEasy Reactive";
    }

    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String testApi() throws URISyntaxException, IOException, InterruptedException {

        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(new URI(url))
                .header("Authorization", "Bearer {token_git}")
                .GET()
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request2, HttpResponse.BodyHandlers.ofString());



        return response.body();
    }
}
