package pas.mvc.pasmvc.model;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class Account {
    private UUID id;
    @NotNull
    private String login;
    private String email;
    private String password;

    public String getAccountType() {
        return "INVALID";
    }

    public Account(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public Account() {
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getPassword() {
        return "x";
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
