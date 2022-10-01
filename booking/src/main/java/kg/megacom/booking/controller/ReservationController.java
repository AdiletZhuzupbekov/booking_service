package kg.megacom.booking.controller;

import kg.megacom.booking.microservices.json.enums.ApartmentClassification;
import kg.megacom.booking.service.BookingService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class ReservationController {
    private final BookingService bookingService;

    public ReservationController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/booking")
    public String toReservation(Model model,
                                @RequestParam Long id,
                                @RequestParam Double price,
                                @RequestParam ApartmentClassification classification,
                                @RequestParam Long days,
                                @DateTimeFormat(pattern = "yyyy-MM-dd")@RequestParam Date start,
                                @DateTimeFormat(pattern = "yyyy-MM-dd")@RequestParam Date end
                                ){
        model.addAttribute("title", "Booking");
        model.addAttribute("id", id);
        model.addAttribute("classification", classification);
        model.addAttribute("days", days);
        model.addAttribute("price", price * days);
        model.addAttribute("start", start);
        model.addAttribute("end", end);
        return "reservation";
    }
    @PostMapping("/reservation")
    public String reservation(Model model,
                              @RequestParam Long id,
                              @DateTimeFormat(pattern = "yyyy-MM-dd")@RequestParam Date start,
                              @DateTimeFormat(pattern = "yyyy-MM-dd")@RequestParam Date end,
                              @RequestParam String name,
                              @RequestParam String phone){
        model.addAttribute("title", "Booking");
        model.addAttribute("id", id);
        model.addAttribute("start", start);
        model.addAttribute("end", end);
        model.addAttribute("name", name);
        model.addAttribute("phone", phone);

        bookingService.reservation(id,start,end,name,phone);

        return "message";
    }
}
