package pas.mvc.pasmvc.controllers;


import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.mvc.View;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import pas.mvc.pasmvc.model.*;
import pas.mvc.pasmvc.services.AccountService;
import jakarta.ws.rs.FormParam;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

@Controller
@Path("/user")
public class AccountController {
    @Context
    private HttpServletRequest request;

    @Inject
    private AccountService accountService;

    @POST
    @Path("/create")
    @Consumes("application/x-www-form-urlencoded")
    public Response  createUser(
            @FormParam("login") String login,
            @FormParam("password") String password,
            @FormParam("personalId") String personalId
    ) {
        ClientAccount user = new ClientAccount(login, password, personalId);
        accountService.createAccount(user);
        request.setAttribute("user", user);

        return Response.seeOther(URI.create("/pasMVC-1.0-SNAPSHOT/rentRoom.jsp")).build();
    }
}
