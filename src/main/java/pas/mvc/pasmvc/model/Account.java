package pas.mvc.pasmvc.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Account {
    private UUID id;
    private String login;
    private String password;
    private String personalId;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", personalId='" + personalId + '\'' +
                ", active=" + active +
                '}';
    }

    boolean active = true;

    public String getAccountType() {
        return "INVALID";
    }

    public Account(String login, String password, String personalId) {
        this.id = UUID.randomUUID();
        this.login = login;
        this.password = password;
        this.personalId = personalId;
        active = true;
    }

}
