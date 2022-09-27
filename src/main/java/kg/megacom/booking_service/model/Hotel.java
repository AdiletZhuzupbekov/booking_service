package kg.megacom.booking_service.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String stars;
    private String address;
    private String phone;
    private String city;
    private String imgUrl;
}
