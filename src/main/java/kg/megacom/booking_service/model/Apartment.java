package kg.megacom.booking_service.model;

import kg.megacom.booking_service.model.enums.ApartmentClassification;
import kg.megacom.booking_service.model.enums.BookStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer roomNumber;
    private Byte person;
    private Double price;
    private String imgUrl;
    private Byte rooms;
    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;
    @Enumerated(EnumType.STRING)
    private ApartmentClassification classification;
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

}
