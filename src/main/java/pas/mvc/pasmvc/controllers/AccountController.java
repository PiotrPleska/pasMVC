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
import pas.mvc.pasmvc.services.RoomService;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Controller
@Path("/user")
public class AccountController {
//    @Inject
//    private HttpServletRequest request;

    @Inject
    private Models models;

    @Inject
    private AccountService accountService;

    @Inject
    private RoomService roomService;

    @POST
    @Path("/create")
    @Consumes("application/x-www-form-urlencoded")
    public String  createUser(
            @FormParam("login") String login,
            @FormParam("password") String password,
            @FormParam("personalId") String personalId
    ) {
        ClientAccount user = new ClientAccount(login, password, personalId);
        accountService.createAccount(user);
        models.put("user", user);
//        request.setAttribute("user", user);

        List<Room> rooms = roomService.getRooms();
        models.put("rooms", rooms);
//        request.setAttribute("rooms", rooms);
        return "rentRoom.jsp";
    }
}
