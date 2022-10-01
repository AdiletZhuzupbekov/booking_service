package kg.megacom.booking.service.impl;

import kg.megacom.booking.microservices.HotelServiceFeign;
import kg.megacom.booking.service.BookingService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BookingServiceImpl implements BookingService {
    private final HotelServiceFeign hotelServiceFeign;

    public BookingServiceImpl(HotelServiceFeign hotelServiceFeign) {
        this.hotelServiceFeign = hotelServiceFeign;
    }

    @Override
    public void reservation(Long id, Date start, Date end, String name, String phone) {
        hotelServiceFeign.reservation(id,name,phone,start,end);
    }
}
