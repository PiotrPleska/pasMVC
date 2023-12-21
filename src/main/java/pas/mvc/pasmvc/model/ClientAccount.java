package pas.mvc.pasmvc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ClientAccount extends Account{

    @Override
    public String getAccountType() {
        return "CLIENT";
    }

    public ClientAccount(String login, String password, String personalId) {
        super(login, password, personalId);
    }


    @Override
    public String toString() {
        return "ClientAccount{" +
                 super.toString() +
                '}';
    }
}
