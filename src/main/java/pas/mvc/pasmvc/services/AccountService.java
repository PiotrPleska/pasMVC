package pas.mvc.pasmvc.services;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.json.JSONObject;
import pas.mvc.pasmvc.model.Account;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class AccountService implements AutoCloseable {
    private static final String API_BASE_URL = "http://localhost:8080/restapp-1.0-SNAPSHOT/api/accounts/";
    private final Client client = ClientBuilder.newClient();

    public String getAccounts() {

        WebTarget target = client.target(API_BASE_URL);
        Response response = target
                .request(MediaType.APPLICATION_JSON)
                .get();
        return response.readEntity(String.class);
    }

    public void createAccount(Account account) {
        WebTarget target = client.target(API_BASE_URL).path("client/add");
        JSONObject json = new JSONObject();
        json.put("login", account.getLogin());
        json.put("password", account.getPassword());
        json.put("personalId", account.getPersonalId());
        try (Response response = target
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(json.toString()))) {
            System.out.println(response.readEntity(String.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean IsAccountExistByLogin(String login) {
        WebTarget target = client.target(API_BASE_URL).path("login/" + login);
        Response response = target
                .request(MediaType.APPLICATION_JSON)
                .get();
        System.out.println(response.readEntity(String.class));
        return response.getStatus() == 200;
    }

    public boolean areLoginAndPersonalIdCorrect(String login, String personalId) {
        WebTarget target = client.target(API_BASE_URL).path("login/" + login);
        Response response = target
                .request(MediaType.APPLICATION_JSON)
                .get();

        if (response.getStatus() == 200) {
            Map<String, Object> responseData = response.readEntity(new GenericType<Map<String, Object>>() {});

            String responsePersonalId = (String) responseData.get("personalId");

            return login.equals(responseData.get("login")) && personalId.equals(responsePersonalId);
        } else {
            System.out.println("Account not found for login: " + login);
            return false;
        }
    }


    @Override
    public void close() throws Exception {
        client.close();
    }
}
