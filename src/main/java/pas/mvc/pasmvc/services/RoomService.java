package pas.mvc.pasmvc.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import pas.mvc.pasmvc.model.Room;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class RoomService implements AutoCloseable {

    private static final String API_BASE_URL = "http://localhost:8080/restapp-1.0-SNAPSHOT/api/rooms/";
    private final Client client = ClientBuilder.newClient();

    public List<Room> getRooms() {
        try {
            WebTarget target = client.target(API_BASE_URL);
            Response response = target
                    .request(MediaType.APPLICATION_JSON)
                    .get();

            String json = response.readEntity(String.class);
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.readValue(json, new TypeReference<List<Room>>() {});
            } catch (IOException e) {
                e.printStackTrace();
                return Collections.emptyList();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }



    }

    public String findIdByRoomNumber(int roomNumber) {
        try {
            WebTarget target = client.target(API_BASE_URL).path("roomNumber/" + roomNumber);
            Response response = target
                    .request(MediaType.APPLICATION_JSON)
                    .get();
            if (response.getStatus() == 200) {
                Map<String, Object> responseData = response.readEntity(new GenericType<Map<String, Object>>() {
                });
                return (String) responseData.get("id");
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void close() throws Exception {
        client.close();
    }
}
