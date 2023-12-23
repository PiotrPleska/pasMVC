package pas.mvc.pasmvc.controllers;

import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import pas.mvc.pasmvc.services.AccountService;
import pas.mvc.pasmvc.services.RentService;
import pas.mvc.pasmvc.services.RoomService;

@Controller
@Path("/rent")
public class RentController {
    @Inject
    private RentService rentService;

    @Inject
    private RoomService roomService;

    @Inject
    private AccountService accountService;

    @POST
    @Path("/create")
    public void createRent() {
//        rentService.createRent();
    }

}
