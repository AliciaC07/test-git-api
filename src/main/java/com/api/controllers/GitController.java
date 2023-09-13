package com.api.controllers;

import com.api.config.*;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Path(Endpoints.ENDPOINT_UPDATE)
public class GitController {
    @ConfigProperty(name = "git.tok.request.event")
    String token;

    @POST
    @Path(Endpoints.UPDATE_BACKEND)
    @Produces(MediaType.TEXT_PLAIN)
    public String backendUpdate() throws URISyntaxException, IOException, InterruptedException {

        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(new URI(Url.buildUrl(Repos.OWNER, Repos.BACKEND)))
                .header("Authorization", token)
                .POST(HttpRequest.BodyPublishers.ofString("{\"event_type\":\""+ EventType.BACKEND +"\"}"))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request2, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            // Status code is 200 (OK)
            System.out.println("Request was successful");
            return ResponseMessage.WORKFLOW_RUNNING;
        } else if (response.statusCode() == 204) {
            // Status code is 404 (Not Found)
            System.out.println("Resource not found");
            return ResponseMessage.WORKFLOW_RUNNING;
        } else if (response.statusCode() == 404) {
            // Status code is 404 (Not Found)
            System.out.println("Resource not found");
            return ResponseMessage.WORKFLOW_FAILED;
        } else if (response.statusCode() == 500) {
            // Status code is 500 (Internal Server Error)
            System.out.println("Internal server error");
            return ResponseMessage.WORKFLOW_FAILED;
        } else {
            // Handle other status codes as needed
            System.out.println("Received a status code: " + response.statusCode());
            return ResponseMessage.WORKFLOW_RUNNING;
        }

    }

    @POST
    @Path(Endpoints.UPDATE_FRONTEND)
    @Produces(MediaType.TEXT_PLAIN)
    public String frontendUpdate() throws URISyntaxException, IOException, InterruptedException {

        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(new URI(Url.buildUrl(Repos.OWNER, Repos.FRONTEND)))
                .header("Authorization", token)
                .POST(HttpRequest.BodyPublishers.ofString("{\"event_type\":\""+ EventType.FRONTEND +"\"}"))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request2, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            // Status code is 200 (OK)
            System.out.println("Request was successful");
            return ResponseMessage.WORKFLOW_RUNNING;
        } else if (response.statusCode() == 204) {
            // Status code is 404 (Not Found)
            System.out.println("Resource not found");
            return ResponseMessage.WORKFLOW_RUNNING;
        } else if (response.statusCode() == 404) {
            // Status code is 404 (Not Found)
            System.out.println("Resource not found");
            return ResponseMessage.WORKFLOW_FAILED;
        } else if (response.statusCode() == 500) {
            // Status code is 500 (Internal Server Error)
            System.out.println("Internal server error");
            return ResponseMessage.WORKFLOW_FAILED;
        } else {
            // Handle other status codes as needed
            System.out.println("Received a status code: " + response.statusCode());
            return ResponseMessage.WORKFLOW_RUNNING;
        }

    }
    @POST
    @Path(Endpoints.UPDATE_DASHBOARD)
    @Produces(MediaType.TEXT_PLAIN)
    public String dashBoardUpdate() throws URISyntaxException, IOException, InterruptedException {

        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(new URI(Url.buildUrl(Repos.OWNER, Repos.DASHBOARD)))
                .header("Authorization", token)
                .POST(HttpRequest.BodyPublishers.ofString("{\"event_type\":\""+ EventType.DASHBOARD +"\"}"))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request2, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            // Status code is 200 (OK)
            System.out.println("Request was successful");
            return ResponseMessage.WORKFLOW_RUNNING;
        } else if (response.statusCode() == 204) {
            // Status code is 404 (Not Found)
            System.out.println("Resource not found");
            return ResponseMessage.WORKFLOW_RUNNING;
        } else if (response.statusCode() == 404) {
            // Status code is 404 (Not Found)
            System.out.println("Resource not found");
            return ResponseMessage.WORKFLOW_FAILED;
        } else if (response.statusCode() == 500) {
            // Status code is 500 (Internal Server Error)
            System.out.println("Internal server error");
            return ResponseMessage.WORKFLOW_FAILED;
        } else {
            // Handle other status codes as needed
            System.out.println("Received a status code: " + response.statusCode());
            return ResponseMessage.WORKFLOW_RUNNING;
        }

    }
    @POST
    @Path(Endpoints.UPDATE_QUOTAS)
    @Produces(MediaType.TEXT_PLAIN)
    public String quotasUpdate() throws URISyntaxException, IOException, InterruptedException {

        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(new URI(Url.buildUrl(Repos.OWNER, Repos.QUOTAS)))
                .header("Authorization", token)
                .POST(HttpRequest.BodyPublishers.ofString("{\"event_type\":\""+ EventType.QUOTAS +"\"}"))
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request2, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            // Status code is 200 (OK)
            System.out.println("Request was successful");
            return ResponseMessage.WORKFLOW_RUNNING;
        } else if (response.statusCode() == 204) {
            // Status code is 404 (Not Found)
            System.out.println("Resource not found");
            return ResponseMessage.WORKFLOW_RUNNING;
        } else if (response.statusCode() == 404) {
            // Status code is 404 (Not Found)
            System.out.println("Resource not found");
            return ResponseMessage.WORKFLOW_FAILED;
        } else if (response.statusCode() == 500) {
            // Status code is 500 (Internal Server Error)
            System.out.println("Internal server error");
            return ResponseMessage.WORKFLOW_FAILED;
        } else {
            // Handle other status codes as needed
            System.out.println("Received a status code: " + response.statusCode());
            return ResponseMessage.WORKFLOW_RUNNING;
        }

    }


}
