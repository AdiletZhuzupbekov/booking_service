package kg.megacom.booking.service;

import kg.megacom.booking.microservices.json.HotelServiceResponse;
import kg.megacom.booking.microservices.json.UrlResponse;
import org.springframework.web.multipart.MultipartFile;

public interface HotelService {
    UrlResponse addPhoto(MultipartFile file);

    HotelServiceResponse[] getHotels();

    HotelServiceResponse[] findByCity(String city);

    HotelServiceResponse findByName(String name);
}
