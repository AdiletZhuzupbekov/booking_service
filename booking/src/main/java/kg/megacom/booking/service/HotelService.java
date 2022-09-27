package kg.megacom.booking.service;

import kg.megacom.booking.microservices.json.HotelServiceResponse;
import org.springframework.web.multipart.MultipartFile;

public interface HotelService {
    Long addPhoto(MultipartFile file);

    HotelServiceResponse[] getHotels();

    HotelServiceResponse[] findByCity(String city);
}
