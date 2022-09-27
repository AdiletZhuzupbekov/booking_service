package kg.megacom.booking_service.service.impl;

import kg.megacom.booking_service.mapper.ApartmentMapper;
import kg.megacom.booking_service.mapper.BookingMapper;
import kg.megacom.booking_service.model.Apartment;
import kg.megacom.booking_service.model.dto.ApartmentDto;
import kg.megacom.booking_service.model.enums.ApartmentClassification;
import kg.megacom.booking_service.repository.ApartmentRepo;
import kg.megacom.booking_service.repository.BookingRepo;
import kg.megacom.booking_service.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepo bookingRepo;
    private final BookingMapper bookingMapper;
    private final ApartmentRepo apartmentRepo;
    private final ApartmentMapper apartmentMapper;

    public BookingServiceImpl(BookingRepo bookingRepo, ApartmentRepo apartmentRepo) {
        this.bookingRepo = bookingRepo;
        this.apartmentRepo = apartmentRepo;
        this.bookingMapper = BookingMapper.INSTANCE;
        this.apartmentMapper = ApartmentMapper.INSTANCE;
    }

    @Override
    public List<ApartmentDto> getInfo(Long hotelId, ApartmentClassification classification,Date startDate, Date endDate) {
        List<Apartment> availableApartment = apartmentRepo.findAvailable(startDate,endDate);
        return apartmentMapper.toDtoList(availableApartment);
    }


}
