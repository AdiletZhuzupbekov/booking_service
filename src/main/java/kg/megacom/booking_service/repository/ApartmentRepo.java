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
    @Query(value = "SELECT a.* FROM apartment a  LEFT JOIN booking b ON b.apartment_id = a.id AND " +
            "b.start_date < ?2 AND b.end_date > ?1 WHERE b.id IS NULL", nativeQuery = true)
    List<Apartment> findAvailable(Date startDate, Date endDate);
}
