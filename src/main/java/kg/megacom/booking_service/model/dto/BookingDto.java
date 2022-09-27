package kg.megacom.booking_service.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class BookingDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long hotelId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long customerId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long apartmentId;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
}
