package pas.mvc.pasmvc.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import pas.mvc.pasmvc.model.Room;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@ApplicationScoped
public class RoomService implements AutoCloseable {

    private static final String API_BASE_URL = "http://localhost:8080/restapp-1.0-SNAPSHOT/api/rooms/";
    private final Client client = ClientBuilder.newClient();

    public List<Room> getRooms() {
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
    }

    @Override
    public void close() throws Exception {
        client.close();
    }
}
