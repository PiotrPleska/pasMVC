import org.junit.jupiter.api.Test;
import pas.mvc.pasmvc.model.ClientAccount;
import pas.mvc.pasmvc.model.Rent;
import pas.mvc.pasmvc.model.RentGet;
import pas.mvc.pasmvc.services.AccountService;
import pas.mvc.pasmvc.services.RentService;
import pas.mvc.pasmvc.services.RoomService;

import java.util.GregorianCalendar;

public class BaseTest {

    @Test
    public void test() {
//        AccountService accountService = new AccountService();
//        ClientAccount clientAccount = new ClientAccount("nowyLogin", "noweHaslo123", "45032103676");
//        accountService.createAccount(clientAccount);
//        System.out.println(accountService.getAccounts());
//        System.out.println(accountService.IsAccountExistByLogin("nowyLogin"));
//        System.out.println(accountService.areLoginAndPersonalIdCorrect("nowyLogin", "45032103676"));
//        RoomService roomService = new RoomService();
//        System.out.println(roomService.getRooms());
        RentService rentService = new RentService();
//        rentService.createRent(new Rent(new GregorianCalendar(), "770b0c3d-9f99-4f50-a361-b3d8f2323174", "a47e78ab-c071-40b7-be73-c72a38bbcfce"));
//        for (RentGet rent : rentService.getRents()) {
//            System.out.println(rent);
//        }
//        for (RentGet rent: rentService.getRentsByAccountId("4f13e18a-9701-4ec1-9c9f-b88773488a0d")) {
//            System.out.println(rent);
//
//        }
        rentService.endRent("cb8ae4bb-7fd7-4523-8de9-3e4a066e9747");
//        RoomService roomService = new RoomService();
//        System.out.println(roomService.findIdByRoomNumber(1));






        }
    }

