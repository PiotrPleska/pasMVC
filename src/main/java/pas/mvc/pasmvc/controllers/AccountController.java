package pas.mvc.pasmvc.controllers;


import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import pas.mvc.pasmvc.model.*;
import pas.mvc.pasmvc.services.AccountService;
import jakarta.ws.rs.FormParam;
import pas.mvc.pasmvc.services.RentService;
import pas.mvc.pasmvc.services.RoomService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Controller
@Path("/sth")
public class AccountController {

    @Inject
    private Models models;

    @Inject
    private AccountService accountService;

    @Inject
    private RoomService roomService;

    @Inject
    private RentService rentService;

    @POST
    @Path("/user")
    @Consumes("application/x-www-form-urlencoded")
    public String createUser(
            @FormParam("login") String login,
            @FormParam("password") String password,
            @FormParam("personalId") String personalId
    ) {

        if (login == null || login.trim().length() < 2 || login.trim().length() > 20) {
            models.put("loginError", "Login must be between 2 and 20 characters");
            return "index.jsp";
        }

        if (password == null || password.trim().length() < 2 || password.trim().length() > 20) {
            models.put("passwordError", "Password must be between 2 and 20 characters");
            return "index.jsp";
        }

        if (personalId == null || personalId.trim().length() != 11) {
            models.put("personalIdError", "Personal ID must be exactly 11 characters");
            return "index.jsp";
        }


        ClientAccount user;
        if (!accountService.IsAccountExistByLogin(login)) {
            user = new ClientAccount(login, password, personalId);
            accountService.createAccount(user);
        } else {
            user = accountService.getAccountByLogin(login);
        }
        String accountId = accountService.findIdByLogin(user.getLogin());
        models.put("user", accountId);

        List<Room> rooms = roomService.getRooms();
        models.put("rooms", rooms);

        List<RentGet> rents = rentService.getRentsByAccountId(accountId);
        models.put("rents", rents);

        return "rentRoom.jsp";
    }

    @POST
    @Path("/rent")
    @Consumes("application/x-www-form-urlencoded")
    public String createRent(@FormParam("user") String user,
                             @FormParam("rentStartDate") String rentStartDate,
                             @FormParam("roomNumber") String roomNumber
    ) throws ParseException {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date date = df.parse(rentStartDate);
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);

        models.put("user", user);

        List<Room> rooms = roomService.getRooms();
        models.put("rooms", rooms);

        String roomId = roomService.findIdByRoomNumber(Integer.parseInt(roomNumber));
        Rent rent = new Rent(cal, user, roomId);

        Response response = rentService.createRent(rent);

        if (response.getStatus() == 409)
            models.put("rentError", "Room is already rented");


        List<RentGet> rents = rentService.getRentsByAccountId(user);
        models.put("rents", rents);

        return "rentRoom.jsp";
    }

    @POST
    @Path("/rent/delete")
    @Consumes("application/x-www-form-urlencoded")
    public String deleteRent(@FormParam("rentId") String rentId,
                             @FormParam("user") String user) {
        models.put("user", user);
        List<Room> rooms = roomService.getRooms();
        models.put("rooms", rooms);
        rentService.endRent(rentId);
        List<RentGet> rents = rentService.getRentsByAccountId(user);
        models.put("rents", rents);
        return "rentRoom.jsp";
    }


}
