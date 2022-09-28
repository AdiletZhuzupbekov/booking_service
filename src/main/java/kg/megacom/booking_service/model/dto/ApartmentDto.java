package kg.megacom.booking_service.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import kg.megacom.booking_service.model.Hotel;
import kg.megacom.booking_service.model.enums.ApartmentClassification;
import kg.megacom.booking_service.model.enums.BookStatus;
import lombok.Data;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class ApartmentDto {
    private Long id;
    private Integer roomNumber;
    private Integer person;
    private Double price;
    private String imgUrl;
    private Byte rooms;
    private BookStatus bookStatus;
    private ApartmentClassification classification;
    private Long hotelId;

}