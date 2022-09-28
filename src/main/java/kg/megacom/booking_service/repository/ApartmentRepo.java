package kg.megacom.booking_service.repository;

import kg.megacom.booking_service.model.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ApartmentRepo extends JpaRepository<Apartment,Long> {
    //поиск доступных намеров по дате
    @Query(value = "SELECT a.* FROM  apartment a  LEFT JOIN booking b ON b.apartment_id = a.id AND " +
            "b.start_date < ?4 AND b.end_date > ?3 WHERE b.id IS NULL AND  a.person >= ?1 AND a.hotel_id = ?2", nativeQuery = true)
    List<Apartment> findAvailable(Byte person, Long hotelId,Date startDate, Date endDate);

    List<Apartment> findAllByHotel_Name(String name);
}
