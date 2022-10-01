package kg.megacom.booking_service.service.impl;

import kg.megacom.booking_service.mapper.ApartmentMapper;
import kg.megacom.booking_service.mapper.BookingMapper;
import kg.megacom.booking_service.model.Apartment;
import kg.megacom.booking_service.model.Booking;
import kg.megacom.booking_service.model.Customer;
import kg.megacom.booking_service.model.Hotel;
import kg.megacom.booking_service.model.dto.ApartmentDto;
import kg.megacom.booking_service.model.dto.BookingDto;
import kg.megacom.booking_service.repository.ApartmentRepo;
import kg.megacom.booking_service.repository.BookingRepo;
import kg.megacom.booking_service.repository.HotelRepo;
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
    private final HotelRepo hotelRepo;

    public BookingServiceImpl(BookingRepo bookingRepo, ApartmentRepo apartmentRepo, HotelRepo hotelRepo) {
        this.bookingRepo = bookingRepo;
        this.apartmentRepo = apartmentRepo;
        this.hotelRepo = hotelRepo;
        this.bookingMapper = BookingMapper.INSTANCE;
        this.apartmentMapper = ApartmentMapper.INSTANCE;
    }

    @Override
    public List<ApartmentDto> getInfo(Byte person, Long hotelId, Date startDate, Date endDate) {
        Hotel hotel = hotelRepo.findById(hotelId).get();
        List<Apartment> availableApartment;
        if (person != null && startDate != null && endDate != null) {
            availableApartment = apartmentRepo.findAvailable(person, hotelId, startDate, endDate);
        }
        else {
            availableApartment = apartmentRepo.findAllByHotel_Name(hotel.getName());
            return apartmentMapper.toDtoList(availableApartment);
        }
        return apartmentMapper.toDtoList(availableApartment);
    }

    @Override
    public BookingDto reservation(Long apartId, Customer customer, Date startDate, Date endDate) {
        Booking booking = new Booking();
        booking.setApartment(apartmentRepo.findById(apartId).get());
        booking.setCustomer(customer);
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);
        booking.setHotel(hotelRepo.findById(apartmentRepo.findById(apartId).get().getHotel().getId()).get());
        bookingRepo.save(booking);
        return bookingMapper.toDto(booking);
    }


}
