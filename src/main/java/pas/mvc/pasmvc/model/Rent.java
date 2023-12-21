package pas.mvc.pasmvc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.GregorianCalendar;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rent {

    private UUID rentId;


    private GregorianCalendar rentStartDate;


    private GregorianCalendar rentEndDate;


    private ClientAccount clientAccount;


    private Room room;

    public Rent(GregorianCalendar rentStartDate, ClientAccount clientAccount, Room room) {
        this.rentStartDate = rentStartDate;
        this.clientAccount = clientAccount;
        this.room = room;
    }
}
