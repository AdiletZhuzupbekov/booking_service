package kg.megacom.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservationController {

    @GetMapping("reservation")
    public String reservation(Model model){
        model.addAttribute("title", "Booking");
        return "reservation";
    }
}
