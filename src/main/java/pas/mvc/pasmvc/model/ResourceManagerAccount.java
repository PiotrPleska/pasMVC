package pas.mvc.pasmvc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResourceManagerAccount extends Account{
    @Override
    public String getAccountType() {
        return "RESOURCE_MANAGER";
    }

    public ResourceManagerAccount(String login, String password, String personalId) {
        super(login, password, personalId);
    }


    @Override
    public String toString() {
        return "ResourceManagerAccount{" +
                super.toString() +
                '}';
    }
}
