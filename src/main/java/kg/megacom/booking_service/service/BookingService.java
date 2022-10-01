package kg.megacom.booking_service.service;

import kg.megacom.booking_service.model.Customer;
import kg.megacom.booking_service.model.dto.ApartmentDto;
import kg.megacom.booking_service.model.dto.BookingDto;
import kg.megacom.booking_service.model.enums.ApartmentClassification;

import java.util.Date;
import java.util.List;

public interface BookingService {
    List<ApartmentDto> getInfo(Byte person, Long hotelId, Date startDate, Date endDate);

    BookingDto reservation(Long apartId, Customer customer, Date startDate, Date endDate);
}
