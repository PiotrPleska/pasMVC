package pas.mvc.pasmvc.controllers;

import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import pas.mvc.pasmvc.model.*;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;

@Controller
@Path("/user")
public class AccountController {
    @Inject
    private Models models;




    @POST
    @Path("/create")
    @Consumes("application/json")
    public String createUser(ClientAccount user) {
        // Code to send a POST request to the RESTful API and create a user
        // You can use a RestClient or other HTTP client libraries

        // Example code (you may need to adjust based on your actual API):
        // restClient.createUser(user);

        // Add a success message to the model
        models.put("message", "User created successfully");

        // Return the view name (e.g., a JSP or HTML file)
        return "userCreatedView";
    }
}
