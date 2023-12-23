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

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
    public String  createUser(
            @FormParam("login") String login,
            @FormParam("password") String password,
            @FormParam("personalId") String personalId
    ) {
        ClientAccount user = new ClientAccount(login, password, personalId);
        accountService.createAccount(user);
        String accountId = accountService.findIdByLogin(user.getLogin());
        models.put("user", accountId);
        List<Room> rooms = roomService.getRooms();
        models.put("rooms", rooms);
        return "rentRoom.jsp";
    }

    @POST
    @Path("/rent")
    @Consumes("application/x-www-form-urlencoded")
    public String createRent(@FormParam("rentStartDate") String  rentStartDate,
                           @FormParam("roomId") String roomNumber,
                           @FormParam("accountId") String accountId) {


//        LocalDateTime localDateTime = LocalDateTime.now();
//        System.out.println("Current System Date/time is :- \n"
//                + localDateTime);
//
//
//        // 2. get system default zone
//        ZoneId zoneId = ZoneId.systemDefault();
//        System.out.println("\nDefault System Zone is :- \n"
//                + zoneId);
//
//
//        // 3. convert LocalDate -> ZonedDateTime -> GregorianCalendar
//        GregorianCalendar gregorianCalendar = GregorianCalendar
//                .from(localDateTime.atZone(zoneId));

            String roomId = roomService.findIdByRoomNumber(Integer.parseInt(roomNumber));

            Rent rent = new Rent(new GregorianCalendar(), "770b0c3d-9f99-4f50-a361-b3d8f2323174", "a47e78ab-c071-40b7-be73-c72a38bbcfce");
            rentService.createRent(rent);
        return "eo.jsp";
    }


}
