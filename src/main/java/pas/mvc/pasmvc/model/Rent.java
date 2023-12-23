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


    private String accountId;

    private String roomId;

    @Override
    public String toString() {
        return "Rent{" +
                "rentId=" + rentId +
                ", rentStartDate=" + rentStartDate +
                ", rentEndDate=" + rentEndDate +
                ", clientAccount='" + accountId + '\'' +
                ", room='" + roomId + '\'' +
                '}';
    }



    public Rent(GregorianCalendar rentStartDate, String clientAccount, String room) {
        this.rentStartDate = rentStartDate;
        this.accountId = clientAccount;
        this.roomId = room;
    }
}
