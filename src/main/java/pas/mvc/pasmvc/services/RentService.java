package pas.mvc.pasmvc.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.json.JSONObject;
import pas.mvc.pasmvc.model.Account;
import pas.mvc.pasmvc.model.Rent;
import pas.mvc.pasmvc.model.RentGet;
import pas.mvc.pasmvc.model.Room;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class RentService implements AutoCloseable {

    private static final String API_BASE_URL = "http://localhost:8080/restapp-1.0-SNAPSHOT/api/rents/";
    private final Client client = ClientBuilder.newClient();

    public void createRent(Rent rent) {
        WebTarget target = client.target(API_BASE_URL);
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(rent.getRentStartDate().toInstant(), ZoneId.of("UTC"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
        String formattedDate = zonedDateTime.format(formatter);
        JSONObject json = new JSONObject();
        json.put("accountId", rent.getAccountId());
        json.put("roomId", rent.getRoomId());
        json.put("rentStartDate", formattedDate);
        try (Response response = target
                .request(MediaType.APPLICATION_JSON)
                .post(Entity.json(json.toString()))) {
//            System.out.println(response.readEntity(String.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<RentGet> getRents() {
        try {
            WebTarget target = client.target(API_BASE_URL);
            Response response = target
                    .request(MediaType.APPLICATION_JSON)
                    .get();

            String json = response.readEntity(String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.readValue(json, new TypeReference<List<RentGet>>() {
                });
            } catch (IOException e) {
                e.printStackTrace();
                return Collections.emptyList();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

    }

    public List<RentGet> getRentsByAccountId(String accountId) {
        try {
            WebTarget target = client.target(API_BASE_URL).path("account-id/" + accountId);
            Response response = target
                    .request(MediaType.APPLICATION_JSON)
                    .get();

            String json = response.readEntity(String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.readValue(json, new TypeReference<List<RentGet>>() {
                });
            } catch (IOException e) {
                e.printStackTrace();
                return Collections.emptyList();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

    }


    public void endRent(String rentId) {
        WebTarget target = client.target(API_BASE_URL).path(rentId);
        target
                .request(MediaType.APPLICATION_JSON)
                .delete();


    }


    public void close() {
        client.close();
    }
}
