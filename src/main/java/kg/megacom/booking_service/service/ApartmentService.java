package kg.megacom.booking_service.service;

import kg.megacom.booking_service.model.dto.ApartmentDto;

import java.util.List;

public interface ApartmentService {
    ApartmentDto addApartment(ApartmentDto apartmentDto);

    List<ApartmentDto> findByHotelName(String name);
}
