package kg.megacom.booking_service.controller;

import kg.megacom.booking_service.model.dto.ApartmentDto;
import kg.megacom.booking_service.service.ApartmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/apartment")
public class ApartmentController {
    private final ApartmentService apartmentService;

    public ApartmentController(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    @PostMapping("/add")//добавление номеров
    ApartmentDto addApartment(@RequestBody ApartmentDto apartmentDto){
        return  apartmentService.addApartment(apartmentDto);
    }
}
