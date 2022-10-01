package kg.megacom.booking.service;

import java.util.Date;

public interface BookingService {
    void reservation(Long id, Date start, Date end, String name, String phone);
}
