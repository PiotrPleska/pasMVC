package pas.mvc.pasmvc.model;

public class AdminAccount extends Account{
    private String phone;

    @Override
    public String getAccountType() {
        return "ADMIN";
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public AdminAccount(String login, String email, String password, String phone) {
        super(login, email, password);
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "AdminAccount{" + super.toString() +
                ", NIP='" + phone + '\'' +
                '}';
    }
}
