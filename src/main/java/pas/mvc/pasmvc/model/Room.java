package pas.mvc.pasmvc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private UUID id;

    private int roomNumber;


    private int roomCapacity;


    private double basePrice;


    private int isRented = 0;

    public Room(int roomNumber, int roomCapacity, double basePrice) {
        this.roomNumber = roomNumber;
        this.roomCapacity = roomCapacity;
        this.basePrice = basePrice;
    }
}
