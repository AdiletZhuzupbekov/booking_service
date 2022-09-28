package kg.megacom.booking_service.controller;

import kg.megacom.booking_service.model.Apartment;
import kg.megacom.booking_service.model.Hotel;
import kg.megacom.booking_service.model.dto.ApartmentDto;
import kg.megacom.booking_service.model.enums.ApartmentClassification;
import kg.megacom.booking_service.service.BookingService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("hotel")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/available")// проверка свободных намеров
    List<ApartmentDto> checkAvailable(

            @RequestParam Byte person,
            @RequestParam Long id,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return bookingService.getInfo(person,id,startDate, endDate);
    }
}
