package kg.megacom.booking_service.service.impl;

import kg.megacom.booking_service.mapper.HotelMapper;
import kg.megacom.booking_service.model.Hotel;
import kg.megacom.booking_service.model.dto.HotelDto;
import kg.megacom.booking_service.repository.HotelRepo;
import kg.megacom.booking_service.service.HotelService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    private final HotelRepo hotelRepo;
    private final HotelMapper hotelMapper;

    public HotelServiceImpl(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
        this.hotelMapper = HotelMapper.INSTANCE;
    }

    @Override
    public HotelDto saveHotel(HotelDto hotelDto) {
        Hotel hotel = hotelMapper.toEntity(hotelDto);
        hotelRepo.save(hotel);
        return hotelDto;
    }

    @Override
    public List<HotelDto> findAll() {
        List<Hotel> hotel = hotelRepo.findAll();
        return hotelMapper.toDtoList(hotel);
    }

    @Override
    public List<HotelDto> findByCity(String city) {
        List<Hotel> hotel;
        if (city !=null) {
            hotel = hotelRepo.findAllByCity(city);
        }else {
            hotel = hotelRepo.findAll();
        }
        return hotelMapper.toDtoList(hotel);
    }
}
