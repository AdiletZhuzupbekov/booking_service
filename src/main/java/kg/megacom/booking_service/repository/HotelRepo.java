package kg.megacom.booking_service.repository;

import kg.megacom.booking_service.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepo extends JpaRepository<Hotel,Long> {
    List<Hotel> findAllByCity(String text);

    Hotel findByName(String name);
}
