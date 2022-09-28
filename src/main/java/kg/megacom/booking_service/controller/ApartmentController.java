package kg.megacom.booking_service.controller;

import kg.megacom.booking_service.model.dto.ApartmentDto;
import kg.megacom.booking_service.model.dto.HotelDto;
import kg.megacom.booking_service.service.ApartmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("apartment")
public class ApartmentController {
    private final ApartmentService apartmentService;

    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @PostMapping("/add")//добавление номеров
    ApartmentDto addApartment(@RequestBody ApartmentDto apartmentDto){
        return  apartmentService.addApartment(apartmentDto);
    }
    @GetMapping("/{name}")
    List<ApartmentDto> findByHotelName(@PathVariable String name){
        return apartmentService.findByHotelName(name);
    }

}
