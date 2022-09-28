package kg.megacom.booking.service;

import kg.megacom.booking.microservices.json.ApartmentServiceResponse;

import java.util.Date;

public interface ApartmentService {
    ApartmentServiceResponse[] finByName(String name);

    ApartmentServiceResponse[] filter(Byte person, Long id,Date start, Date end);
}
