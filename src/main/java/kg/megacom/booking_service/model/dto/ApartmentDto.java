package kg.megacom.booking_service.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import kg.megacom.booking_service.model.enums.ApartmentClassification;
import kg.megacom.booking_service.model.enums.BookStatus;
import lombok.Data;

@Data
public class ApartmentDto {
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long id;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer roomNumber;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Byte rooms;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private BookStatus bookStatus;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private ApartmentClassification classification;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long hotelId;
}