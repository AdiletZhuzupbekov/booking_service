package kg.megacom.booking_service.service.impl;

import kg.megacom.booking_service.mapper.ApartmentMapper;
import kg.megacom.booking_service.model.Apartment;
import kg.megacom.booking_service.model.dto.ApartmentDto;
import kg.megacom.booking_service.repository.ApartmentRepo;
import kg.megacom.booking_service.repository.HotelRepo;
import kg.megacom.booking_service.service.ApartmentService;
import org.springframework.stereotype.Service;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    private final ApartmentRepo apartmentRepo;
    private final ApartmentMapper apartmentMapper;
    private final HotelRepo hotelRepo;


    public ApartmentServiceImpl(ApartmentRepo apartmentRepo, HotelRepo hotelRepo) {
        this.apartmentRepo = apartmentRepo;
        this.hotelRepo = hotelRepo;
        this.apartmentMapper = ApartmentMapper.INSTANCE;
    }

    @Override
    public ApartmentDto addApartment(ApartmentDto apartmentDto) {
        Apartment apartment = apartmentMapper.toEntity(apartmentDto);
        apartment.setHotel(hotelRepo.findById(apartmentDto.getHotelId()).orElseThrow());
        apartmentRepo.save(apartment);
        return apartmentDto;
    }
}
