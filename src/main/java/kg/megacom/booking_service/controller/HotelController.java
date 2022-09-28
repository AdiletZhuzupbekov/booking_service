package kg.megacom.booking_service.controller;

import kg.megacom.booking_service.model.dto.HotelDto;
import kg.megacom.booking_service.service.HotelService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hotel")
public class HotelController {
    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/add")//добавление отелей
    HotelDto addHotel(@RequestBody HotelDto hotelDto){
        return hotelService.saveHotel(hotelDto);
    }

    @GetMapping("/info")
    List<HotelDto> getInfo(){
        return hotelService.findAll();
    }
    @GetMapping("/findByCity")
    List<HotelDto> findByCity(String city){
        return hotelService.findByCity(city);
    }
    @GetMapping("/{name}")
    HotelDto findByName(@PathVariable String name){
        return hotelService.findByName(name);
    }
}
