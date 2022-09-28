package kg.megacom.booking_service.service;

import kg.megacom.booking_service.model.dto.HotelDto;

import java.util.List;

public interface HotelService {
    HotelDto saveHotel(HotelDto hotelDto);

    List<HotelDto> findAll();

    List<HotelDto> findByCity(String city);

    HotelDto findByName(String name);
}
