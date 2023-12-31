package pas.mvc.pasmvc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdminAccount extends Account{

    public AdminAccount(String login, String password, String personalId) {
        super(login, password, personalId);
    }


    @Override
    public String getAccountType() {
        return "ADMIN";
    }



    @Override
    public String toString() {
        return "AdminAccount{" +
                super.toString() +
                '}';
    }
}
