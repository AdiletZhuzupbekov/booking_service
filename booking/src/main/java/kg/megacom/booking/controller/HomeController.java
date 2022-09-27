package kg.megacom.booking.controller;

import kg.megacom.booking.microservices.json.HotelServiceResponse;
import kg.megacom.booking.service.HotelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

@Controller
public class HomeController {
    private final HotelService hotelService;

    public HomeController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("title","Booking");
        HotelServiceResponse[] hotels = hotelService.getHotels();
        model.addAttribute("hotels", hotels);
        return "home";
    }
    @PostMapping("/photo")
    public Long addPhoto(@RequestPart MultipartFile file){
        return hotelService.addPhoto(file);
    }
    @GetMapping("/findByCity")
    public String findByCity(Model model, @RequestParam(required = false) String city){
        HotelServiceResponse[] hotels = hotelService.findByCity(city);
        System.out.println(Arrays.toString(hotels));
        model.addAttribute("hotels", hotels);
        return "home";
    }
}
