package pas.mvc.pasmvc.controllers;


import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.*;
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
        ClientAccount user;
        if(!accountService.IsAccountExistByLogin(login)) {
            user = new ClientAccount(login, password, personalId);
            accountService.createAccount(user);
        } else
        {
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

        String roomId = roomService.findIdByRoomNumber(Integer.parseInt(roomNumber));
//TODO check if room is available
        Rent rent = new Rent(cal, user, roomId);
        rentService.createRent(rent);
        return "eo.jsp";
    }

    @POST
    @Path("/rent/delete")
    @Consumes("application/x-www-form-urlencoded")
    public void deleteRent(@FormParam("rentId") String rentId) {
        rentService.endRent(rentId);
    }


}
