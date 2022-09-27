package kg.megacom.booking_service.service;

import kg.megacom.booking_service.model.dto.ApartmentDto;
import kg.megacom.booking_service.model.enums.ApartmentClassification;

import java.util.Date;
import java.util.List;

public interface BookingService {
    List<ApartmentDto> getInfo(Long hotelId, ApartmentClassification classification, Date startDate, Date endDate);
}
