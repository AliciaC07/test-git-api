package com.api.controllers;

import com.api.config.*;
import com.api.dashboard.DashboardItems;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import io.quarkiverse.freemarker.TemplatePath;
import io.vertx.core.json.JsonObject;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.io.IOException;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

import static jakarta.ws.rs.core.MediaType.TEXT_HTML;
import static jakarta.ws.rs.core.MediaType.TEXT_PLAIN;

@Path(Endpoints.ENDPOINT_VERSION)
public class VersionService {
    @ConfigProperty(name = "git.tok.request.event")
    String token;

    @Inject
    @TemplatePath("dashboard.ftl")
    Template dashboard;



    @GET
    @Path(Endpoints.BACKEND_VERSION)
    @Produces(TEXT_PLAIN)
    public String backendVersion() throws URISyntaxException, IOException, InterruptedException {

        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(new URI(Url.buildUrlContent(Repos.BACKEND)))
                .header("Authorization", token)
                .GET()
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request2, HttpResponse.BodyHandlers.ofString());
        JsonObject jsonObject = new JsonObject(response.body());

        return DecodeBase64.getContentDecode(jsonObject.getString("content").replace("\n", ""));

    }

//    public String getAllUserView()
//            throws TemplateException, IOException {
//        List<User> users = userResource.getUsers();
//        StringWriter stringWriter = new StringWriter();
//        home.process(Map.of("users", users), stringWriter);
//        return stringWriter.toString();
//    }

    @GET
    @Path("/test-ftl")
    @Produces(TEXT_HTML)
    public String dashboardView() throws TemplateException, IOException {
        List<String> items = DashboardItems.getAllDashboardItems();
        StringWriter stringWriter = new StringWriter();
        dashboard.process(Map.of("items", items), stringWriter);
        return stringWriter.toString();
    }

}
