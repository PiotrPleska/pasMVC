import org.junit.jupiter.api.Test;
import pas.mvc.pasmvc.model.ClientAccount;
import pas.mvc.pasmvc.services.AccountService;
import pas.mvc.pasmvc.services.RoomService;

public class BaseTest {

    @Test
    public void test() {
//        AccountService accountService = new AccountService();
//        ClientAccount clientAccount = new ClientAccount("nowyLogin", "noweHaslo123", "45032103676");
//        accountService.createAccount(clientAccount);
//        System.out.println(accountService.getAccounts());
//        System.out.println(accountService.IsAccountExistByLogin("nowyLogin"));
//        System.out.println(accountService.areLoginAndPersonalIdCorrect("nowyLogin", "45032103676"));
        RoomService roomService = new RoomService();
        System.out.println(roomService.getRooms());
    }
}
