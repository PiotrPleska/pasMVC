package pas.mvc.pasmvc.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
public class RentGet {

    private UUID id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private GregorianCalendar rentStartDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private GregorianCalendar rentEndDate;


    private ClientAccount account;

    private Room room;


    public RentGet(GregorianCalendar rentStartDate, ClientAccount clientAccount, Room room) {
        this.rentStartDate = rentStartDate;
        this.account = clientAccount;
        this.room = room;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "rentId=" + id +
                ", rentStartDate=" + (rentStartDate != null ? rentStartDate.getTime() : null) +
                ", rentEndDate=" + (rentEndDate != null ? rentEndDate.getTime() : null) +
                ", clientAccount='" + account + '\'' +
                ", room='" + room + '\'' +
                '}';
    }





}
