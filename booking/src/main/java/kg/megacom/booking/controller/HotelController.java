package kg.megacom.booking.controller;

import kg.megacom.booking.microservices.json.ApartmentServiceResponse;
import kg.megacom.booking.microservices.json.HotelServiceResponse;
import kg.megacom.booking.service.ApartmentService;
import kg.megacom.booking.service.HotelService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class HotelController {
    private final HotelService hotelService;
    private final ApartmentService apartmentService;

    public HotelController(HotelService hotelService, ApartmentService apartmentService) {
        this.hotelService = hotelService;
        this.apartmentService = apartmentService;
    }
    @GetMapping("/hotel/{name}")
    public String hotel(Model model, @PathVariable String name){
        model.addAttribute("title","Booking");
        HotelServiceResponse hotel = hotelService.findByName(name);
        model.addAttribute("hotel",hotel);
        ApartmentServiceResponse[] apartment = apartmentService.finByName(name);
        model.addAttribute("apart",apartment);
        return "hotel";
    }
    @GetMapping("/filter")
    public String filter(Model model, @RequestParam Byte person, @RequestParam Long id,
                         @DateTimeFormat(pattern = "yyyy-MM-dd")@RequestParam Date start,
                         @DateTimeFormat(pattern = "yyyy-MM-dd")@RequestParam Date end) {
        ApartmentServiceResponse[] apartment = apartmentService.filter(person, id, start, end);
        model.addAttribute("title","Booking");
        model.addAttribute("apart", apartment);
        return "apartment";
    }
}
