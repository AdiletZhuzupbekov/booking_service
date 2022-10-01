package kg.megacom.booking.microservices.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingResponse {
    public Date startDate;
    public Date endDate;
}
