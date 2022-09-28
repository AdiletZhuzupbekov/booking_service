package kg.megacom.booking.service.impl;

import kg.megacom.booking.microservices.HotelServiceFeign;
import kg.megacom.booking.microservices.json.ApartmentServiceResponse;
import kg.megacom.booking.service.ApartmentService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    private final HotelServiceFeign hotelServiceFeign;

    public ApartmentServiceImpl(HotelServiceFeign hotelServiceFeign) {
        this.hotelServiceFeign = hotelServiceFeign;
    }


    @Override
    public ApartmentServiceResponse[] finByName(String name) {
        return hotelServiceFeign.findByHotelName(name);
    }

    @Override
    public ApartmentServiceResponse[] filter( Byte person,Long id, Date start, Date end) {
        return hotelServiceFeign.checkAvailable(person, id,start, end);
    }
}
