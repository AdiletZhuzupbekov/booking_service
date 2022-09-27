package kg.megacom.booking.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import kg.megacom.booking.microservices.FileServiceFeign;
import kg.megacom.booking.microservices.HotelServiceFeign;
import kg.megacom.booking.microservices.json.HotelServiceResponse;
import kg.megacom.booking.microservices.json.UrlResponse;
import kg.megacom.booking.service.HotelService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    private final FileServiceFeign fileServiceFeign;
    private final HotelServiceFeign hotelServiceFeign;

    public HotelServiceImpl(FileServiceFeign fileServiceFeign, HotelServiceFeign hotelServiceFeign) {
        this.fileServiceFeign = fileServiceFeign;
        this.hotelServiceFeign = hotelServiceFeign;
    }

    @Override
    public UrlResponse addPhoto(MultipartFile file) {
        return fileServiceFeign.upload(file);
    }

    @Override
    public HotelServiceResponse[] getHotels() {
        return hotelServiceFeign.getInfo();
    }

    @Override
    public HotelServiceResponse[] findByCity(String city) {
        return hotelServiceFeign.findByCity(city);
    }
}
