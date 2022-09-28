package kg.megacom.booking.microservices.json;

import kg.megacom.booking.microservices.json.enums.ApartmentClassification;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ApartmentServiceResponse {
    public Long id;
    public Integer roomNumber;
    public Byte rooms;
    public String bookStatus;
    public ApartmentClassification classification;
    public Integer person;
    public Integer price;
    public String imgUrl;
}
